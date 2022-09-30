package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class Member.
 * 
 * @author Tejas Shah
 */
/**
 * @author 461901
 */
@Entity
@Data
public class CutsomerMasterData implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** The name. */
	private String customerId;

	/** The portalid. */
	private String postalCode;

	/** The siteid. */
	private String regionId;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public String getCustomerId()
	{
		return customerId;
	}

	/**
	 * Sets the customer id.
	 *
	 * @param customerId the new customer id
	 */
	public void setCustomerId(String customerId)
	{
		this.customerId = customerId;
	}

	/**
	 * Gets the postal code.
	 *
	 * @return the postal code
	 */
	public String getPostalCode()
	{
		return postalCode;
	}

	/**
	 * Sets the postal code.
	 *
	 * @param postalCode the new postal code
	 */
	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	/**
	 * Gets the region id.
	 *
	 * @return the region id
	 */
	public String getRegionId()
	{
		return regionId;
	}

	/**
	 * Sets the region id.
	 *
	 * @param regionId the new region id
	 */
	public void setRegionId(String regionId)
	{
		this.regionId = regionId;
	}

}
