package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class ReturnInfo.
 * 
 * @author Tejas Shah
 */
public class ReturnInfo implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The is returnable. */
	private boolean is_returnable;

	/** The no of days. */
	private int no_of_days;

	/**
	 * Checks if is checks if is returnable.
	 *
	 * @return true, if is checks if is returnable
	 */
	public boolean isIs_returnable()
	{
		return is_returnable;
	}

	/**
	 * Sets the checks if is returnable.
	 *
	 * @param is_returnable the new checks if is returnable
	 */
	public void setIs_returnable(boolean is_returnable)
	{
		this.is_returnable = is_returnable;
	}

	/**
	 * Gets the no of days.
	 *
	 * @return the no of days
	 */
	public int getNo_of_days()
	{
		return no_of_days;
	}

	/**
	 * Sets the no of days.
	 *
	 * @param i the new no of days
	 */
	public void setNo_of_days(int i)
	{
		this.no_of_days = i;
	}

}
