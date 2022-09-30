package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class PackageItem.
 * 
 * @author Tejas Shah
 */
public class PackageItem implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The line id. */
	private String line_id;

	/** The sku. */
	private String sku;

	/** The qty. */
	private String qty;

	/**
	 * Gets the line id.
	 *
	 * @return the line id
	 */
	public String getLine_id()
	{
		return line_id;
	}

	/**
	 * Sets the line id.
	 *
	 * @param line_id the new line id
	 */
	public void setLine_id(String line_id)
	{
		this.line_id = line_id;
	}

	/**
	 * Gets the sku.
	 *
	 * @return the sku
	 */
	public String getSku()
	{
		return sku;
	}

	/**
	 * Sets the sku.
	 *
	 * @param sku the new sku
	 */
	public void setSku(String sku)
	{
		this.sku = sku;
	}

	/**
	 * Gets the qty.
	 *
	 * @return the qty
	 */
	public String getQty()
	{
		return qty;
	}

	/**
	 * Sets the qty.
	 *
	 * @param qty the new qty
	 */
	public void setQty(String qty)
	{
		this.qty = qty;
	}

}
