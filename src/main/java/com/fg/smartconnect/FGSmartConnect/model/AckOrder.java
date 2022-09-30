package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class AckOrder.
 * 
 * @author Tejas Shah
 */
public class AckOrder implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The message. */
	private String message;

	/** The data. */
	private AckDataPayload data;

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public AckDataPayload getData()
	{
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(AckDataPayload data)
	{
		this.data = data;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */

}
