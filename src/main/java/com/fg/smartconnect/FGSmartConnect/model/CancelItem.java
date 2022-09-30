package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class CancelItem.
 * 
 * @author Tejas Shah
 */
public class CancelItem implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The line id. */
	private String line_id;

	/** The sku. */
	private String sku;

	/** The qty. */
	private Double qty;

	/** The cancel reason id. */
	private String cancel_reason_id;

	/** The cancel reason comment. */
	private String cancel_reason_comment;

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
	public Double getQty()
	{
		return qty;
	}

	/**
	 * Sets the qty.
	 *
	 * @param double1 the new qty
	 */
	public void setQty(Double double1)
	{
		this.qty = double1;
	}

	/**
	 * Gets the cancel reason id.
	 *
	 * @return the cancel reason id
	 */
	public String getCancel_reason_id()
	{
		return cancel_reason_id;
	}

	/**
	 * Sets the cancel reason id.
	 *
	 * @param cancel_reason_id the new cancel reason id
	 */
	public void setCancel_reason_id(String cancel_reason_id)
	{
		this.cancel_reason_id = cancel_reason_id;
	}

	/**
	 * Gets the cancel reason comment.
	 *
	 * @return the cancel reason comment
	 */
	public String getCancel_reason_comment()
	{
		return cancel_reason_comment;
	}

	/**
	 * Sets the cancel reason comment.
	 *
	 * @param cancel_reason_comment the new cancel reason comment
	 */
	public void setCancel_reason_comment(String cancel_reason_comment)
	{
		this.cancel_reason_comment = cancel_reason_comment;
	}

}
