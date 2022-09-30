package com.fg.smartconnect.FGSmartConnect.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fg.smartconnect.FGSmartConnect.helper.AckConfirmOrder;
import com.fg.smartconnect.FGSmartConnect.helper.AckGenrateInvoiceOrder;
import com.fg.smartconnect.FGSmartConnect.helper.AckCreatePackageOrder;
import com.fg.smartconnect.FGSmartConnect.helper.AckRejectOrder;
import com.fg.smartconnect.FGSmartConnect.helper.AckGenrateShipLabelOrder;
import com.fg.smartconnect.FGSmartConnect.helper.AckShippedOrder;
import com.fg.smartconnect.FGSmartConnect.model.AckOrder;
import com.fg.smartconnect.FGSmartConnect.model.OutwardOmsResponseDetail;
import com.fg.smartconnect.FGSmartConnect.service.AckFromOMSService;
import com.fg.smartconnect.FGSmartConnect.utility.FGConstant;

/**
 * The Class AckFromOMSServiceImpl.
 * 
 * @author Tejas Shah
 */
@Service
public class AckFromOMSServiceImpl implements AckFromOMSService
{

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AckFromOMSServiceImpl.class);

	/** The ack invoice order. */
	@Autowired
	AckGenrateInvoiceOrder ackInvoiceOrder;

	/** The ack ship label order. */
	@Autowired
	AckGenrateShipLabelOrder ackShipLabelOrder;

	/** The ack shipped order. */
	@Autowired
	AckShippedOrder ackShippedOrder;

	/** The ack pack order. */
	@Autowired
	AckCreatePackageOrder ackPackOrder;

	/** The ack reject order. */
	@Autowired
	AckRejectOrder ackRejectOrder;

	/** The ack confirm order. */
	@Autowired
	AckConfirmOrder ackConfirmOrder;

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.AckFromOMSService#ackOMS(java.lang.String)
	 */
	@Override
	public AckOrder ackOMS(OutwardOmsResponseDetail outwardOmsResponseDetail)
	{
		String status = outwardOmsResponseDetail.getStatus();
		// AckHelper ackRejectOrder = null;

		AckOrder ackOrder = new AckOrder();
		if (status.equals(FGConstant.CONFIRMED))
		{
			ackOrder = ackConfirmOrder.callSmartConnectAPI(outwardOmsResponseDetail);
		}
		else if (status.equals(FGConstant.CANCELLED))
		{
			ackOrder = ackRejectOrder.callSmartConnectAPI(outwardOmsResponseDetail);
		}
		else if (status.equals(FGConstant.REJECTED))
		{
			ackOrder = ackRejectOrder.callSmartConnectAPI(outwardOmsResponseDetail);
		}
		else if (status.equals(FGConstant.PACKED))
		{
			ackOrder = ackPackOrder.callSmartConnectAPI(outwardOmsResponseDetail);
		}
		else if (status.equals(FGConstant.GENERATE_SHIP_LABEL))
		{
			ackOrder = ackShipLabelOrder.callSmartConnectAPI(outwardOmsResponseDetail);
		}
		else if (status.equals(FGConstant.GENERATE_INVOICE))
		{
			ackOrder = ackInvoiceOrder.callSmartConnectAPI(outwardOmsResponseDetail);
		}
		else if (status.equals(FGConstant.SHIPPED))
		{
			ackOrder = ackShippedOrder.callSmartConnectAPI(outwardOmsResponseDetail);
		}
		return ackOrder;
	}
}
