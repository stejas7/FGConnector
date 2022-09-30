package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class DelieverySlot.
 */
public class DelieverySlot implements Serializable
{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The slot id. */
	private String slot_id;

	/** The slot rule id. */
	private String slot_rule_id;

	/** The capacity. */
	private String capacity;

	/** The consumed capacity. */
	private String consumed_capacity;

	/** The available capacity. */
	private String available_capacity;

	/** The start time. */
	private String start_time;

	/** The end time. */
	private String end_time;

	/**
	 * Gets the slot id.
	 *
	 * @return the slot id
	 */
	public String getSlot_id()
	{
		return slot_id;
	}

	/**
	 * Sets the slot id.
	 *
	 * @param slot_id the new slot id
	 */
	public void setSlot_id(String slot_id)
	{
		this.slot_id = slot_id;
	}

	/**
	 * Gets the slot rule id.
	 *
	 * @return the slot rule id
	 */
	public String getSlot_rule_id()
	{
		return slot_rule_id;
	}

	/**
	 * Sets the slot rule id.
	 *
	 * @param slot_rule_id the new slot rule id
	 */
	public void setSlot_rule_id(String slot_rule_id)
	{
		this.slot_rule_id = slot_rule_id;
	}

	/**
	 * Gets the capacity.
	 *
	 * @return the capacity
	 */
	public String getCapacity()
	{
		return capacity;
	}

	/**
	 * Sets the capacity.
	 *
	 * @param capacity the new capacity
	 */
	public void setCapacity(String capacity)
	{
		this.capacity = capacity;
	}

	/**
	 * Gets the consumed capacity.
	 *
	 * @return the consumed capacity
	 */
	public String getConsumed_capacity()
	{
		return consumed_capacity;
	}

	/**
	 * Sets the consumed capacity.
	 *
	 * @param consumed_capacity the new consumed capacity
	 */
	public void setConsumed_capacity(String consumed_capacity)
	{
		this.consumed_capacity = consumed_capacity;
	}

	/**
	 * Gets the available capacity.
	 *
	 * @return the available capacity
	 */
	public String getAvailable_capacity()
	{
		return available_capacity;
	}

	/**
	 * Sets the available capacity.
	 *
	 * @param available_capacity the new available capacity
	 */
	public void setAvailable_capacity(String available_capacity)
	{
		this.available_capacity = available_capacity;
	}

	/**
	 * Gets the start time.
	 *
	 * @return the start time
	 */
	public String getStart_time()
	{
		return start_time;
	}

	/**
	 * Sets the start time.
	 *
	 * @param start_time the new start time
	 */
	public void setStart_time(String start_time)
	{
		this.start_time = start_time;
	}

	/**
	 * Gets the end time.
	 *
	 * @return the end time
	 */
	public String getEnd_time()
	{
		return end_time;
	}

	/**
	 * Sets the end time.
	 *
	 * @param end_time the new end time
	 */
	public void setEnd_time(String end_time)
	{
		this.end_time = end_time;
	}

}
