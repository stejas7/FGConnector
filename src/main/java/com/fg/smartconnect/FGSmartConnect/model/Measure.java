package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Measure.
 * 
 * @author Tejas Shah
 */
public class Measure implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The value. */
	private String value;

	/** The uom. */
	private String uom;

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value)
	{
		this.value = value;
	}

	/**
	 * Gets the uom.
	 *
	 * @return the uom
	 */
	public String getUom()
	{
		return uom;
	}

	/**
	 * Sets the uom.
	 *
	 * @param uom the new uom
	 */
	public void setUom(String uom)
	{
		this.uom = uom;
	}

}
