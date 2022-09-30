package com.fg.smartconnect.FGSmartConnect.helper;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.amazon.yojaka.model.LineItem;
import com.amazon.yojaka.model.Reason;
import com.amazon.yojaka.model.RejectOrderInput;
import com.amazon.yojaka.model.RejectOrderResult;
import com.amazon.yojaka.model.RejectedLineItemsElement;
import com.fg.smartconnect.FGSmartConnect.model.AckOrder;
import com.fg.smartconnect.FGSmartConnect.model.OmsItem;
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
public class AckRejectOrder implements AckHelper
{

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AckRejectOrder.class);

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
			LOGGER.info("SQS Recieved Message ::> Order outward ::>  RejectOrder ::> START");

			RejectOrderInput rejectOrderInput = rejectOrder(outwardOmsResponseDetail);

			RejectOrderResult rejectOrderResult = orderService.rejectOrder(outwardOmsResponseDetail.getOrder_id(), rejectOrderInput);
			LOGGER.info("SQS Recieved Message ::> Order outward ::>  RejectOrder ::> STATUS ::> " + rejectOrderResult.sdkResponseMetadata().httpStatusCode());

			if (rejectOrderResult.sdkResponseMetadata().httpStatusCode() == HttpStatus.SC_NO_CONTENT)
			{
				ackOrder = omsAckService.commonAckOrder(outwardOmsResponseDetail.getOrder_id(), FGConstant.CANCELLED_ACK, "");
				LOGGER.info("SQS Recieved Message ::> Order outward ::>  RejectOrder ::> Prepare Ack Response");

			}
		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.info("SQS Recieved Message ::> Order outward ::>  RejectOrder ::> START");

		return ackOrder;
	}

	/**
	 * Reject order.
	 *
	 * @param outwardOmsResponseDetail the outward oms response detail
	 * @return the reject order input
	 */
	private RejectOrderInput rejectOrder(OutwardOmsResponseDetail outwardOmsResponseDetail)
	{
		RejectOrderInput rejectOrderInput = new RejectOrderInput();
		rejectOrderInput.setReferenceId(outwardOmsResponseDetail.getReferenceID());

		List<OmsItem> items = outwardOmsResponseDetail.getItems();
		List<RejectedLineItemsElement> lineItemsElement = new ArrayList<>();

		for (OmsItem item : items)
		{
			RejectedLineItemsElement element = new RejectedLineItemsElement();

			LineItem lineItem = new LineItem();
			lineItem.setId(item.getLine_id());
			element.lineItem(lineItem);
			element.reason(Reason.OUT_OF_STOCK);
			element.quantity(1);
			lineItemsElement.add(element);
		}

		rejectOrderInput.setRejectedLineItems(lineItemsElement);
		return rejectOrderInput;
	}
}
