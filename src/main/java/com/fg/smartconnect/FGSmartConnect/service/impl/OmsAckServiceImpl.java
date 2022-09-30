package com.fg.smartconnect.FGSmartConnect.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fg.smartconnect.FGSmartConnect.model.AckDataPayload;
import com.fg.smartconnect.FGSmartConnect.model.AckOrder;
import com.fg.smartconnect.FGSmartConnect.service.OmsAckService;
import com.fg.smartconnect.FGSmartConnect.utility.CommonService;

/**
 * The Class OmsAckServiceImpl.
 * 
 * @author Tejas Shah
 */
@Service
public class OmsAckServiceImpl implements OmsAckService
{
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(OmsAckServiceImpl.class);

	/** The json conventer. */
	@Autowired
	CommonService jsonConventer;

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.OmsAckService#commonAckOrder(com.amazon.yojaka.model.Order)
	 */
	@Override
	public AckOrder commonAckOrder(String order_id, String status, String url)
	{
		AckOrder ackOrder = new AckOrder();
		ackOrder.setMessage(status);

		AckDataPayload ackDataPayload = new AckDataPayload();
		ackDataPayload.setOrder_id(order_id);
		ackDataPayload.setUrl(url);

		ackOrder.setData(ackDataPayload);
		return ackOrder;
	}

}
