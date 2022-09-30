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
import com.amazon.yojaka.model.ShipLabel;
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
public class AckGenrateShipLabelOrder implements AckHelper
{
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AckGenrateShipLabelOrder.class);

	/** The order service. */
	@Autowired
	private OrderSerivce orderService;

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
		AckOrder ackOrder = null;
		try
		{
			LOGGER.info("SQS Recieved Message ::> Order outward ::>  genrateShipLabel ::> SmartConnect ::> START");
			ShipLabel label = orderService.genrateShipLabel(outwardOmsResponseDetail.getOrder_id(), "1");

			if (label != null)
			{
				String encryptedFile = encryptionDecrytion.decryptYojakaEncryptedData(label.getShipLabel().getEncryptedContent().getValue(), label.getShipLabel().getEncryptedContent().getEncryptionInfo().getContext());
				LOGGER.info("SQS Recieved Message ::> Order outward ::>  Decrypted Invoice");

				File file = new File("/tmp/" + outwardOmsResponseDetail.getOrder_id() + "_shiplabel.zpl");

				if (file.createNewFile())
				{
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
					bos.write(Base64.getDecoder().decode(encryptedFile));
					LOGGER.info("SQS Recieved Message ::> Order outward ::>  genrateShipLabel ::> File Genrated");

				}
				else
				{
					throw new RuntimeException("ERROR");
				}
				URL url = amazonS3ClientService.uploadFileToS3Bucket(file, true);
				LOGGER.info("SQS Recieved Message ::> Order outward ::>  genrateShipLabel ::> PUSHED on S3 ::> File Name ::> " + file.getName());

				ackOrder = omsAckService.commonAckOrder(outwardOmsResponseDetail.getOrder_id(), FGConstant.SHIP_LABEL_GENERATED, url.getPath());
				LOGGER.info("SQS Recieved Message ::> Order outward ::>  retrievePickupSlotsOutput ::> SmartConnect ::> START");

				file.delete();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		LOGGER.info("SQS Recieved Message ::> Order outward ::>  genrateShipLabel ::> SmartConnect ::> END");

		return ackOrder;
	}
}
