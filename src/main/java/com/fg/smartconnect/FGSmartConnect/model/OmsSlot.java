package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class OmsSlot.
 */
public class OmsSlot implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The data. */
	List<OmsSlotDetail> data;

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public List<OmsSlotDetail> getData()
	{
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(List<OmsSlotDetail> data)
	{
		this.data = data;
	}

}
