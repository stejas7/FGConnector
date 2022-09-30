package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class CancelOrder.
 * 
 * @author Tejas Shah
 */
public class CancelOrder implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The client. */
	private String client;

	/** The order id. */
	private String order_id;

	/** The portal id. */
	private String portal_id;

	/** The items. */
	private List<CancelItem> items;

	/**
	 * Gets the client.
	 *
	 * @return the client
	 */
	public String getClient()
	{
		return client;
	}

	/**
	 * Sets the client.
	 *
	 * @param client the new client
	 */
	public void setClient(String client)
	{
		this.client = client;
	}

	/**
	 * Gets the order id.
	 *
	 * @return the order id
	 */
	public String getOrder_id()
	{
		return order_id;
	}

	/**
	 * Sets the order id.
	 *
	 * @param order_id the new order id
	 */
	public void setOrder_id(String order_id)
	{
		this.order_id = order_id;
	}

	/**
	 * Gets the portal id.
	 *
	 * @return the portal id
	 */
	public String getPortal_id()
	{
		return portal_id;
	}

	/**
	 * Sets the portal id.
	 *
	 * @param portal_id the new portal id
	 */
	public void setPortal_id(String portal_id)
	{
		this.portal_id = portal_id;
	}

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public List<CancelItem> getItems()
	{
		return items;
	}

	/**
	 * Sets the items.
	 *
	 * @param items the new items
	 */
	public void setItems(List<CancelItem> items)
	{
		this.items = items;
	}

}
