package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class PriceInfo.
 * 
 * @author Tejas Shah
 */
public class PriceInfo implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The mrp. */
	private double mrp;

	/** The price. */
	private double price;

	/** The price spl. */
	private int price_spl;

	/** The gift charges. */
	private int gift_charges;

	/** The shipping charges. */
	private int shipping_charges;

	/** The item shipping charges. */
	private int item_shipping_charges;

	/** The offer discount. */
	private int offer_discount;

	/** The payment discount. */
	private int payment_discount;

	/** The cashback discount. */
	private int cashback_discount;

	/** The coupon discount. */
	private int coupon_discount;

	/**
	 * Gets the mrp.
	 *
	 * @return the mrp
	 */
	public double getMrp()
	{
		return mrp;
	}

	/**
	 * Sets the mrp.
	 *
	 * @param mrp the new mrp
	 */
	public void setMrp(double mrp)
	{
		this.mrp = mrp;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice()
	{
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}

	/**
	 * Gets the price spl.
	 *
	 * @return the price spl
	 */
	public int getPrice_spl()
	{
		return price_spl;
	}

	/**
	 * Sets the price spl.
	 *
	 * @param price_spl the new price spl
	 */
	public void setPrice_spl(int price_spl)
	{
		this.price_spl = price_spl;
	}

	/**
	 * Gets the gift charges.
	 *
	 * @return the gift charges
	 */
	public int getGift_charges()
	{
		return gift_charges;
	}

	/**
	 * Sets the gift charges.
	 *
	 * @param gift_charges the new gift charges
	 */
	public void setGift_charges(int gift_charges)
	{
		this.gift_charges = gift_charges;
	}

	/**
	 * Gets the shipping charges.
	 *
	 * @return the shipping charges
	 */
	public int getShipping_charges()
	{
		return shipping_charges;
	}

	/**
	 * Sets the shipping charges.
	 *
	 * @param shipping_charges the new shipping charges
	 */
	public void setShipping_charges(int shipping_charges)
	{
		this.shipping_charges = shipping_charges;
	}

	/**
	 * Gets the item shipping charges.
	 *
	 * @return the item shipping charges
	 */
	public int getItem_shipping_charges()
	{
		return item_shipping_charges;
	}

	/**
	 * Sets the item shipping charges.
	 *
	 * @param item_shipping_charges the new item shipping charges
	 */
	public void setItem_shipping_charges(int item_shipping_charges)
	{
		this.item_shipping_charges = item_shipping_charges;
	}

	/**
	 * Gets the offer discount.
	 *
	 * @return the offer discount
	 */
	public int getOffer_discount()
	{
		return offer_discount;
	}

	/**
	 * Sets the offer discount.
	 *
	 * @param offer_discount the new offer discount
	 */
	public void setOffer_discount(int offer_discount)
	{
		this.offer_discount = offer_discount;
	}

	/**
	 * Gets the payment discount.
	 *
	 * @return the payment discount
	 */
	public int getPayment_discount()
	{
		return payment_discount;
	}

	/**
	 * Sets the payment discount.
	 *
	 * @param payment_discount the new payment discount
	 */
	public void setPayment_discount(int payment_discount)
	{
		this.payment_discount = payment_discount;
	}

	/**
	 * Gets the cashback discount.
	 *
	 * @return the cashback discount
	 */
	public int getCashback_discount()
	{
		return cashback_discount;
	}

	/**
	 * Sets the cashback discount.
	 *
	 * @param cashback_discount the new cashback discount
	 */
	public void setCashback_discount(int cashback_discount)
	{
		this.cashback_discount = cashback_discount;
	}

	/**
	 * Gets the coupon discount.
	 *
	 * @return the coupon discount
	 */
	public int getCoupon_discount()
	{
		return coupon_discount;
	}

	/**
	 * Sets the coupon discount.
	 *
	 * @param coupon_discount the new coupon discount
	 */
	public void setCoupon_discount(int coupon_discount)
	{
		this.coupon_discount = coupon_discount;
	}

}
