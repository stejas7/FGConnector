package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class OutwardOmsResponse.
 * 
 * @author Tejas Shah
 */
public class OutwardOmsResponse implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The message. */
	private String message;

	/** The data. */
	private OutwardOmsResponseDetail data;

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
	public OutwardOmsResponseDetail getData()
	{
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(OutwardOmsResponseDetail data)
	{
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "OutwardOmsResponse [message=" + message + ", data=" + data + ", getMessage()=" + getMessage() + ", getData()=" + getData() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
