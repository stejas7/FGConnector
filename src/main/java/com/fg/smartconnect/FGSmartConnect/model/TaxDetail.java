package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class TaxDetail.
 * 
 * @author Tejas Shah
 */
public class TaxDetail implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The type. */
	private String type;

	/** The percentage. */
	private Double percentage;

	/** The amount. */
	private Double amount;

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * Gets the percentage.
	 *
	 * @return the percentage
	 */
	public Double getPercentage()
	{
		return percentage;
	}

	/**
	 * Sets the percentage.
	 *
	 * @param percentage the new percentage
	 */
	public void setPercentage(Double percentage)
	{
		this.percentage = percentage;
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

	//
}
