package com.fg.smartconnect.FGSmartConnect.service;

import com.amazon.yojaka.model.Order;

// TODO: Auto-generated Javadoc
/**
 * The Interface OmsService.
 * 
 * @author Tejas Shah
 */
public interface OmsService
{

	/**
	 * Creates the order.
	 *
	 * @param order the order
	 */
	void createOrder(Order order);

	/**
	 * Reject order.
	 *
	 * @param order the order
	 */
	void rejectOrder(Order order);
}
