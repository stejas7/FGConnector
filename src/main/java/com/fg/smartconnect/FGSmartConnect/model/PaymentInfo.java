package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class PaymentInfo.
 * 
 * @author Tejas Shah
 */
public class PaymentInfo implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The name. */
	private String name;

	/** The pg code. */
	private String pg_code;

	/** The amount. */
	private Double amount;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Gets the pg code.
	 *
	 * @return the pg code
	 */
	public String getPg_code()
	{
		return pg_code;
	}

	/**
	 * Sets the pg code.
	 *
	 * @param pg_code the new pg code
	 */
	public void setPg_code(String pg_code)
	{
		this.pg_code = pg_code;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public Double getAmount()
	{
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(Double amount)
	{
		this.amount = amount;
	}

}
