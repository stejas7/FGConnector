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
public class SiteMst implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** The name. */
	private String locationid;

	/** The portalid. */
	private String portalid;

	/** The siteid. */
	private String siteid;

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
	 * Gets the locationid.
	 *
	 * @return the locationid
	 */
	public String getLocationid()
	{
		return locationid;
	}

	/**
	 * Sets the locationid.
	 *
	 * @param locationid the new locationid
	 */
	public void setLocationid(String locationid)
	{
		this.locationid = locationid;
	}

	/**
	 * Gets the portalid.
	 *
	 * @return the portalid
	 */
	public String getPortalid()
	{
		return portalid;
	}

	/**
	 * Sets the portalid.
	 *
	 * @param portalid the new portalid
	 */
	public void setPortalid(String portalid)
	{
		this.portalid = portalid;
	}

	/**
	 * Gets the siteid.
	 *
	 * @return the siteid
	 */
	public String getSiteid()
	{
		return siteid;
	}

	/**
	 * Sets the siteid.
	 *
	 * @param siteid the new siteid
	 */
	public void setSiteid(String siteid)
	{
		this.siteid = siteid;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		// TODO Auto-generated method stub
		return super.clone();
	}

}
