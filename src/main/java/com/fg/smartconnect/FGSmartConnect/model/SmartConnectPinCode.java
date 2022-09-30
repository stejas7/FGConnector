package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class SmartConnectPinCode.
 * 
 * @author Tejas Shah
 */
public class SmartConnectPinCode implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The postal code. */
	private String postalCode;

	/**
	 * Gets the postal code.
	 *
	 * @return the postal code
	 */
	public String getPostalCode()
	{
		return postalCode;
	}

	/**
	 * Sets the postal code.
	 *
	 * @param postalCode the new postal code
	 */
	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

}
