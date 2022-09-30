package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class TaxInfo.
 * 
 * @author Tejas Shah
 */
public class TaxInfo implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The item. */
	private List<TaxDetail> item;

	/** The item shipping. */
	private List<TaxDetail> item_shipping;

	/** The gift. */
	private List<TaxDetail> gift;

	/**
	 * Gets the item.
	 *
	 * @return the item
	 */
	public List<TaxDetail> getItem()
	{
		return item;
	}

	/**
	 * Sets the item.
	 *
	 * @param item the new item
	 */
	public void setItem(List<TaxDetail> item)
	{
		this.item = item;
	}

	/**
	 * Gets the item shipping.
	 *
	 * @return the item shipping
	 */
	public List<TaxDetail> getItem_shipping()
	{
		return item_shipping;
	}

	/**
	 * Sets the item shipping.
	 *
	 * @param item_shipping the new item shipping
	 */
	public void setItem_shipping(List<TaxDetail> item_shipping)
	{
		this.item_shipping = item_shipping;
	}

	/**
	 * Gets the gift.
	 *
	 * @return the gift
	 */
	public List<TaxDetail> getGift()
	{
		return gift;
	}

	/**
	 * Sets the gift.
	 *
	 * @param gift the new gift
	 */
	public void setGift(List<TaxDetail> gift)
	{
		this.gift = gift;
	}

}
