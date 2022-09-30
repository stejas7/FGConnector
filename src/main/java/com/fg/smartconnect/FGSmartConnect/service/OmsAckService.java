package com.fg.smartconnect.FGSmartConnect.service;

import com.fg.smartconnect.FGSmartConnect.model.AckOrder;

// TODO: Auto-generated Javadoc
/**
 * The Interface OmsAckService.
 * 
 * @author Tejas Shah
 */
public interface OmsAckService
{

	/**
	 * Common ack order.
	 *
	 * @param order_id the order id
	 * @param status the status
	 * @param url the url
	 * @return the ack order
	 */

	AckOrder commonAckOrder(String order_id, String status, String url);
}
