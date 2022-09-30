package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class AckDataPayload.
 * 
 * @author Tejas Shah
 */
public class AckDataPayload implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The order id. */
	private String order_id;

	/** The url. */
	private String url;

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
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}

}
