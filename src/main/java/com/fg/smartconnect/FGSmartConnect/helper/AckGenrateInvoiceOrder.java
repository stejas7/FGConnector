package com.fg.smartconnect.FGSmartConnect.helper;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.amazon.yojaka.model.Invoice;
import com.fg.smartconnect.FGSmartConnect.model.AckOrder;
import com.fg.smartconnect.FGSmartConnect.model.OutwardOmsResponseDetail;
import com.fg.smartconnect.FGSmartConnect.service.AmazonS3ClientService;
import com.fg.smartconnect.FGSmartConnect.service.OmsAckService;
import com.fg.smartconnect.FGSmartConnect.service.OrderSerivce;
import com.fg.smartconnect.FGSmartConnect.utility.EncryptionDecrytion;
import com.fg.smartconnect.FGSmartConnect.utility.FGConstant;

// TODO: Auto-generated Javadoc
/**
 * The Class AckConfirmOrder.
 * 
 * @author Tejas Shah
 */

@Component
public class AckGenrateInvoiceOrder implements AckHelper
{
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AckGenrateInvoiceOrder.class);

	/** The order service. */
	@Autowired
	OrderSerivce orderService;

	/** The oms ack service. */
	@Autowired
	private OmsAckService omsAckService;

	/** The encryption decrytion. */
	@Autowired
	private EncryptionDecrytion encryptionDecrytion;

	/** The amazon S 3 client service. */
	@Autowired
	private AmazonS3ClientService amazonS3ClientService;

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.helper.AckHelper#callSmartConnectAPI()
	 */
	@SuppressWarnings("resource")
	@Override
	public AckOrder callSmartConnectAPI(OutwardOmsResponseDetail outwardOmsResponseDetail)
	{
		LOGGER.info("SQS Recieved Message ::> Order outward ::>  retrievePickupSlotsOutput + Genrate Invoice ::> SmartConnect ::> START");

		AckOrder ackOrder = null;
		try
		{
			// orderService.retrievePickupSlotsOutput(outwardOmsResponseDetail.getOrder_id());
			LOGGER.info("SQS Recieved Message ::> Order outward ::> retrievePickupSlotsOutput ::> END");

			Invoice invoice = orderService.genrateInvoice(outwardOmsResponseDetail.getOrder_id());
			LOGGER.info("SQS Recieved Message ::> Order outward ::>  genrateInvoice ::>  START");

			if (invoice != null)
			{
				String encryptedFile = encryptionDecrytion.decryptYojakaEncryptedData(invoice.getInvoice().getEncryptedContent().getValue(), invoice.getInvoice().getEncryptedContent().getEncryptionInfo().getContext());
				File file = new File("/tmp/" + outwardOmsResponseDetail.getOrder_id() + "_invoice.pdf");

				if (file.createNewFile())
				{
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
					bos.write(Base64.getDecoder().decode(encryptedFile));
				}
				else
				{
					throw new RuntimeException("ERROR");
				}

				URL url = amazonS3ClientService.uploadFileToS3Bucket(file, true);
				LOGGER.info("SQS Recieved Message ::> Order outward ::>  genrateInvoice ::> PUSHED ON S3 ::> " + file.getName());

				ackOrder = omsAckService.commonAckOrder(outwardOmsResponseDetail.getOrder_id(), FGConstant.SHIPPED_ACK, url.getPath());
				file.delete();
			}
			LOGGER.info("SQS Recieved Message ::> Order outward ::>  retrievePickupSlotsOutput + Genrate Invoice ::> SmartConnect ::> END");

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ackOrder;
	}
}
