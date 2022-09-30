package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author 461901
 */
public class OmsSlotDetail implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	String portal_id;
	String store_scode;
	String delivery_type;
	String slot_date;
	List<DelieverySlot> delivery_slots;

	public String getPortal_id()
	{
		return portal_id;
	}

	public void setPortal_id(String portal_id)
	{
		this.portal_id = portal_id;
	}

	public String getStore_scode()
	{
		return store_scode;
	}

	public void setStore_scode(String store_scode)
	{
		this.store_scode = store_scode;
	}

	public String getDelivery_type()
	{
		return delivery_type;
	}

	public void setDelivery_type(String delivery_type)
	{
		this.delivery_type = delivery_type;
	}

	public String getSlot_date()
	{
		return slot_date;
	}

	public void setSlot_date(String slot_date)
	{
		this.slot_date = slot_date;
	}

	public List<DelieverySlot> getDelivery_slots()
	{
		return delivery_slots;
	}

	public void setDelivery_slots(List<DelieverySlot> delivery_slots)
	{
		this.delivery_slots = delivery_slots;
	}

}
