package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class OutwardOmsResponseDetail.
 * 
 * @author Tejas Shah
 */
public class OutwardOmsResponseDetail implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The order id. */
	private String order_id;

	/** The status. */
	private String status;

	/** The reference ID. */
	private String referenceID;

	/** The items. */
	private List<OmsItem> items;

	/** The consignment. */
	private List<Consignment> consignment;

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
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}

	/**
	 * Gets the reference ID.
	 *
	 * @return the reference ID
	 */
	public String getReferenceID()
	{
		return referenceID;
	}

	/**
	 * Sets the reference ID.
	 *
	 * @param referenceID the new reference ID
	 */
	public void setReferenceID(String referenceID)
	{
		this.referenceID = referenceID;
	}

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public List<OmsItem> getItems()
	{
		return items;
	}

	/**
	 * Sets the items.
	 *
	 * @param items the new items
	 */
	public void setItems(List<OmsItem> items)
	{
		this.items = items;
	}

	/**
	 * Gets the consignment.
	 *
	 * @return the consignment
	 */
	public List<Consignment> getConsignment()
	{
		return consignment;
	}

	/**
	 * Sets the consignment.
	 *
	 * @param consignment the new consignment
	 */
	public void setConsignment(List<Consignment> consignment)
	{
		this.consignment = consignment;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "OutwardOmsResponseDetail [order_id=" + order_id + ", status=" + status + ", referenceID=" + referenceID + ", items=" + items + ", consignment=" + consignment + ", getOrder_id()=" + getOrder_id() + ", getStatus()=" + getStatus() + ", getReferenceID()=" + getReferenceID() + ", getItems()=" + getItems() + ", getConsignment()=" + getConsignment() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
