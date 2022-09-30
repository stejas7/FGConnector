package com.fg.smartconnect.FGSmartConnect.service;

import com.fg.smartconnect.FGSmartConnect.model.AckOrder;
import com.fg.smartconnect.FGSmartConnect.model.OutwardOmsResponseDetail;

// TODO: Auto-generated Javadoc
/**
 * The Interface AckFromOMSService.
 *
 * @author Tejas Shah
 */
public interface AckFromOMSService
{

	/**
	 * Ack OMS.
	 *
	 * @param outwardOmsResponseDetail the outward oms response detail
	 * @return
	 */
	AckOrder ackOMS(OutwardOmsResponseDetail outwardOmsResponseDetail);
}
