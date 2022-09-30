package com.fg.smartconnect.FGSmartConnect.helper;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.amazon.yojaka.model.ConfirmOrderResult;
import com.fg.smartconnect.FGSmartConnect.model.AckOrder;
import com.fg.smartconnect.FGSmartConnect.model.OutwardOmsResponseDetail;
import com.fg.smartconnect.FGSmartConnect.service.OmsAckService;
import com.fg.smartconnect.FGSmartConnect.service.OrderSerivce;
import com.fg.smartconnect.FGSmartConnect.utility.CommonService;
import com.fg.smartconnect.FGSmartConnect.utility.FGConstant;

// TODO: Auto-generated Javadoc
/**
 * The Class AckConfirmOrder.
 * 
 * @author Tejas Shah
 */
@Component
public class AckConfirmOrder implements AckHelper
{

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AckConfirmOrder.class);

	/** The common service. */
	@Autowired
	public CommonService commonService;

	/** The order service. */
	@Autowired
	public OrderSerivce orderService;

	/** The oms ack service. */
	@Autowired
	public OmsAckService omsAckService;

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.helper.AckHelper#callSmartConnectAPI()
	 */
	@Override
	public AckOrder callSmartConnectAPI(OutwardOmsResponseDetail outwardOmsResponseDetail)
	{
		AckOrder ackOrder = null;
		try
		{
			LOGGER.info("SQS Recieved Message ::> Order outward ::>  confirmOrder ::> SmartConnect ::> START");
			ConfirmOrderResult confirmOrderResult = orderService.confirmOrder(outwardOmsResponseDetail.getOrder_id());
			LOGGER.info("SQS Recieved Message ::> Order outward ::>  confirmOrder ::> SmartConnect ::> STATUS ::> " + confirmOrderResult.sdkResponseMetadata().httpStatusCode());

			if (confirmOrderResult.sdkResponseMetadata().httpStatusCode() == HttpStatus.SC_NO_CONTENT)
			{
				ackOrder = omsAckService.commonAckOrder(outwardOmsResponseDetail.getOrder_id(), FGConstant.CONFIRMED_ACK, "");
			}
		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
		return ackOrder;
	}
}
