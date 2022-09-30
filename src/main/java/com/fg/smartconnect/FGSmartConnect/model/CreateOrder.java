package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateOrder.
 * 
 * @author Tejas Shah
 */
public class CreateOrder implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The client. */
	private String client;

	/** The portal id. */
	private String portal_id;

	/** The order id. */
	private String order_id;

	/** The order type. */
	private String order_type;

	/** The slot. */
	private List<Slot> slot;

	/** The store scode. */
	private String store_scode;

	/** The items. */
	private List<Item> items;

	/** The customer info. */
	private CustomerIndo customer_info;

	/** The billing address. */
	private ShippingAddress billing_address;

	/** The payment info. */
	private PaymentInfo payment_info;

	/** The shipping address. */
	private ShippingAddress shipping_address;

	/**
	 * Gets the client.
	 *
	 * @return the client
	 */
	public String getClient()
	{
		return client;
	}

	/**
	 * Sets the client.
	 *
	 * @param client the new client
	 */
	public void setClient(String client)
	{
		this.client = client;
	}

	/**
	 * Gets the portal id.
	 *
	 * @return the portal id
	 */
	public String getPortal_id()
	{
		return portal_id;
	}

	/**
	 * Sets the portal id.
	 *
	 * @param portal_id the new portal id
	 */
	public void setPortal_id(String portal_id)
	{
		this.portal_id = portal_id;
	}

	/**
	 * Gets the order id.
	 *
	 * @return the order id
	 */
	public String getOrder_id()
	{
		return order_id;
	}

	/**
	 * Sets the order id.
	 *
	 * @param order_id the new order id
	 */
	public void setOrder_id(String order_id)
	{
		this.order_id = order_id;
	}

	/**
	 * Gets the order type.
	 *
	 * @return the order type
	 */
	public String getOrder_type()
	{
		return order_type;
	}

	/**
	 * Sets the order type.
	 *
	 * @param order_type the new order type
	 */
	public void setOrder_type(String order_type)
	{
		this.order_type = order_type;
	}

	/**
	 * Gets the slot.
	 *
	 * @return the slot
	 */
	public List<Slot> getSlot()
	{
		return slot;
	}

	/**
	 * Sets the slot.
	 *
	 * @param slot the new slot
	 */
	public void setSlot(List<Slot> slot)
	{
		this.slot = slot;
	}

	/**
	 * Gets the store scode.
	 *
	 * @return the store scode
	 */
	public String getStore_scode()
	{
		return store_scode;
	}

	/**
	 * Sets the store scode.
	 *
	 * @param store_scode the new store scode
	 */
	public void setStore_scode(String store_scode)
	{
		this.store_scode = store_scode;
	}

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public List<Item> getItems()
	{
		return items;
	}

	/**
	 * Sets the items.
	 *
	 * @param items the new items
	 */
	public void setItems(List<Item> items)
	{
		this.items = items;
	}

	/**
	 * Gets the customer info.
	 *
	 * @return the customer info
	 */
	public CustomerIndo getCustomer_info()
	{
		return customer_info;
	}

	/**
	 * Sets the customer info.
	 *
	 * @param customer_info the new customer info
	 */
	public void setCustomer_info(CustomerIndo customer_info)
	{
		this.customer_info = customer_info;
	}

	/**
	 * Gets the billing address.
	 *
	 * @return the billing address
	 */
	public ShippingAddress getBilling_address()
	{
		return billing_address;
	}

	/**
	 * Sets the billing address.
	 *
	 * @param billing_address the new billing address
	 */
	public void setBilling_address(ShippingAddress billing_address)
	{
		this.billing_address = billing_address;
	}

	/**
	 * Gets the payment info.
	 *
	 * @return the payment info
	 */
	public PaymentInfo getPayment_info()
	{
		return payment_info;
	}

	/**
	 * Sets the payment info.
	 *
	 * @param payment_info the new payment info
	 */
	public void setPayment_info(PaymentInfo payment_info)
	{
		this.payment_info = payment_info;
	}

	/**
	 * Gets the shipping address.
	 *
	 * @return the shipping address
	 */
	public ShippingAddress getShipping_address()
	{
		return shipping_address;
	}

	/**
	 * Sets the shipping address.
	 *
	 * @param shipping_address the new shipping address
	 */
	public void setShipping_address(ShippingAddress shipping_address)
	{
		this.shipping_address = shipping_address;
	}

}
