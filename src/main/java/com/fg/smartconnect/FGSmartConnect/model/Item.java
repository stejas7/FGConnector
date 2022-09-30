package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Item.
 * 
 * @author Tejas Shah
 */
public class Item implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The line id. */
	private String line_id;

	/** The sku. */
	private String sku;

	/** The qty. */
	private String qty;

	/** The is cancellable. */
	private boolean is_cancellable;;

	/** The delivery store scode. */
	private String delivery_store_scode;

	/** The price info. */
	private PriceInfo price_info;

	/** The return info. */
	private ReturnInfo return_info;

	/** The tax info. */
	private TaxInfo tax_info;

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

	/**
	 * Checks if is checks if is cancellable.
	 *
	 * @return true, if is checks if is cancellable
	 */
	public boolean isIs_cancellable()
	{
		return is_cancellable;
	}

	/**
	 * Sets the checks if is cancellable.
	 *
	 * @param is_cancellable the new checks if is cancellable
	 */
	public void setIs_cancellable(boolean is_cancellable)
	{
		this.is_cancellable = is_cancellable;
	}

	/**
	 * Gets the delivery store scode.
	 *
	 * @return the delivery store scode
	 */
	public String getDelivery_store_scode()
	{
		return delivery_store_scode;
	}

	/**
	 * Sets the delivery store scode.
	 *
	 * @param delivery_store_scode the new delivery store scode
	 */
	public void setDelivery_store_scode(String delivery_store_scode)
	{
		this.delivery_store_scode = delivery_store_scode;
	}

	/**
	 * Gets the price info.
	 *
	 * @return the price info
	 */
	public PriceInfo getPrice_info()
	{
		return price_info;
	}

	/**
	 * Sets the price info.
	 *
	 * @param price_info the new price info
	 */
	public void setPrice_info(PriceInfo price_info)
	{
		this.price_info = price_info;
	}

	/**
	 * Gets the return info.
	 *
	 * @return the return info
	 */
	public ReturnInfo getReturn_info()
	{
		return return_info;
	}

	/**
	 * Sets the return info.
	 *
	 * @param return_info the new return info
	 */
	public void setReturn_info(ReturnInfo return_info)
	{
		this.return_info = return_info;
	}

	/**
	 * Gets the tax info.
	 *
	 * @return the tax info
	 */
	public TaxInfo getTax_info()
	{
		return tax_info;
	}

	/**
	 * Sets the tax info.
	 *
	 * @param tax_info the new tax info
	 */
	public void setTax_info(TaxInfo tax_info)
	{
		this.tax_info = tax_info;
	}

}
