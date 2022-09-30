package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class PinCode.
 * 
 * @author Tejas Shah
 */
public class PinCode implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pincode. */
	private String pincode;

	/** The city id. */
	private int city_id;

	/** The city. */
	private String city;

	/** The state id. */
	private int state_id;

	/** The state. */
	private String state;

	/** The country id. */
	private int country_id;

	/** The country. */
	private String country;

	/**
	 * Gets the pincode.
	 *
	 * @return the pincode
	 */
	public String getPincode()
	{
		return pincode;
	}

	/**
	 * Sets the pincode.
	 *
	 * @param pincode the new pincode
	 */
	public void setPincode(String pincode)
	{
		this.pincode = pincode;
	}

	/**
	 * Gets the city id.
	 *
	 * @return the city id
	 */
	public int getCity_id()
	{
		return city_id;
	}

	/**
	 * Sets the city id.
	 *
	 * @param city_id the new city id
	 */
	public void setCity_id(int city_id)
	{
		this.city_id = city_id;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity()
	{
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city)
	{
		this.city = city;
	}

	/**
	 * Gets the state id.
	 *
	 * @return the state id
	 */
	public int getState_id()
	{
		return state_id;
	}

	/**
	 * Sets the state id.
	 *
	 * @param state_id the new state id
	 */
	public void setState_id(int state_id)
	{
		this.state_id = state_id;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState()
	{
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state)
	{
		this.state = state;
	}

	/**
	 * Gets the country id.
	 *
	 * @return the country id
	 */
	public int getCountry_id()
	{
		return country_id;
	}

	/**
	 * Sets the country id.
	 *
	 * @param country_id the new country id
	 */
	public void setCountry_id(int country_id)
	{
		this.country_id = country_id;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry()
	{
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country)
	{
		this.country = country;
	}

}
