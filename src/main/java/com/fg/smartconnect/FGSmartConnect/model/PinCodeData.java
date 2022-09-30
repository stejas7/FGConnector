package com.fg.smartconnect.FGSmartConnect.model;

import java.io.Serializable;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class PinCodeData.
 * 
 * @author Tejas Shah
 */
public class PinCodeData implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The data. */
	private List<PinCode> data;

	/** The success. */
	private boolean success;

	/** The errors. */
	private String errors;

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public List<PinCode> getData()
	{
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(List<PinCode> data)
	{
		this.data = data;
	}

	/**
	 * Checks if is success.
	 *
	 * @return true, if is success
	 */
	public boolean isSuccess()
	{
		return success;
	}

	/**
	 * Sets the success.
	 *
	 * @param success the new success
	 */
	public void setSuccess(boolean success)
	{
		this.success = success;
	}

	/**
	 * Gets the errors.
	 *
	 * @return the errors
	 */
	public String getErrors()
	{
		return errors;
	}

	/**
	 * Sets the errors.
	 *
	 * @param errors the new errors
	 */
	public void setErrors(String errors)
	{
		this.errors = errors;
	}

}
