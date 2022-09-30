package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Consignment.
 * 
 * @author Tejas Shah
 */
public class Consignment implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private String id;

	/** The length. */
	private Measure length;

	/** The width. */
	private Measure width;

	/** The height. */
	private Measure height;

	/** The weight. */
	private Measure weight;

	/** The items. */
	private List<PackageItem> items;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/**
	 * Gets the length.
	 *
	 * @return the length
	 */
	public Measure getLength()
	{
		return length;
	}

	/**
	 * Sets the length.
	 *
	 * @param length the new length
	 */
	public void setLength(Measure length)
	{
		this.length = length;
	}

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public Measure getWidth()
	{
		return width;
	}

	/**
	 * Sets the width.
	 *
	 * @param width the new width
	 */
	public void setWidth(Measure width)
	{
		this.width = width;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public Measure getHeight()
	{
		return height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(Measure height)
	{
		this.height = height;
	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public Measure getWeight()
	{
		return weight;
	}

	/**
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(Measure weight)
	{
		this.weight = weight;
	}

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public List<PackageItem> getItems()
	{
		return items;
	}

	/**
	 * Sets the items.
	 *
	 * @param items the new items
	 */
	public void setItems(List<PackageItem> items)
	{
		this.items = items;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Consignment [id=" + id + ", length=" + length + ", width=" + width + ", height=" + height + ", weight=" + weight + ", items=" + items + ", getId()=" + getId() + ", getLength()=" + getLength() + ", getWidth()=" + getWidth() + ", getHeight()=" + getHeight() + ", getWeight()=" + getWeight() + ", getItems()=" + getItems() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
