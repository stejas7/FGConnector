package com.fg.smartconnect.FGSmartConnect.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// TODO: Auto-generated Javadoc
/**
 * The Class FGSmartConnectConfig.
 * 
 * @author Tejas Shah
 */
@ConfigurationProperties(prefix = "fg")
@Configuration
public class FGSmartConnectConfig
{

	/** The aws service name. */
	@Value("${fg.smartconnect.aws.service-name}")
	private String awsServiceName;

	/** The aws region name. */
	@Value("${fg.smartconnect.aws.region-name}")
	private String awsRegionName;

	/** The aws access key. */
	@Value("${fg.smartconnect.aws.kms.access-key}")
	private String awsKmsAccessKey;

	/** The aws secret access key. */
	@Value("${fg.smartconnect.aws.kms.secret-key}")
	private String awsKmsSecretAccessKey;

	/** The aws KMS key. */
	@Value("${fg.smartconnect.aws.kms.key}")
	private String awsKMSKey;

	/** The aws KMS key. */
	@Value("${fg.smartconnect.aws.kms.region}")
	private String awsKMSKeyRegion;

	/** The aws access key. */
	@Value("${cloud.aws.credentials.access-key}")
	private String awsAccessKey;

	/** The aws secret key. */
	@Value("${cloud.aws.credentials.secret-key}")
	private String awsSecretKey;

	/** The location ID. */
	@Value("${fg.smartconnect.aws.location.id}")
	private String locationID;

	/** The rest call connection timeout. */
	private Integer restCallConnectionTimeout;

	/** The rest call read timeout. */
	private Integer restCallReadTimeout;

	/** The location ID. */
	@Value("${fg.oms.postal}")
	private String postalURL;

	/** The location ID. */
	@Value("${fg.oms.slot}")
	private String slotURL;

	/**
	 * Gets the slot URL.
	 *
	 * @return the slot URL
	 */
	public String getSlotURL()
	{
		return slotURL;
	}

	public void setSlotURL(String slotURL)
	{
		this.slotURL = slotURL;
	}

	/**
	 * Gets the postal URL.
	 *
	 * @return the postal URL
	 */
	public String getPostalURL()
	{
		return postalURL;
	}

	/**
	 * Sets the postal URL.
	 *
	 * @param postalURL the new postal URL
	 */
	public void setPostalURL(String postalURL)
	{
		this.postalURL = postalURL;
	}

	/**
	 * Gets the rest call connection timeout.
	 *
	 * @return the rest call connection timeout
	 */
	public Integer getRestCallConnectionTimeout()
	{
		return restCallConnectionTimeout;
	}

	/**
	 * Sets the rest call connection timeout.
	 *
	 * @param restCallConnectionTimeout the new rest call connection timeout
	 */
	public void setRestCallConnectionTimeout(Integer restCallConnectionTimeout)
	{
		this.restCallConnectionTimeout = restCallConnectionTimeout;
	}

	/**
	 * Gets the rest call read timeout.
	 *
	 * @return the rest call read timeout
	 */
	public Integer getRestCallReadTimeout()
	{
		return restCallReadTimeout;
	}

	/**
	 * Sets the rest call read timeout.
	 *
	 * @param restCallReadTimeout the new rest call read timeout
	 */
	public void setRestCallReadTimeout(Integer restCallReadTimeout)
	{
		this.restCallReadTimeout = restCallReadTimeout;
	}

	/**
	 * Gets the location ID.
	 *
	 * @return the location ID
	 */
	public String getLocationID()
	{
		return locationID;
	}

	/**
	 * Sets the location ID.
	 *
	 * @param locationID the new location ID
	 */
	public void setLocationID(String locationID)
	{
		this.locationID = locationID;
	}

	/**
	 * Gets the aws access key.
	 *
	 * @return the aws access key
	 */
	public String getAwsAccessKey()
	{
		return awsAccessKey;
	}

	/**
	 * Sets the aws access key.
	 *
	 * @param awsAccessKey the new aws access key
	 */
	public void setAwsAccessKey(String awsAccessKey)
	{
		this.awsAccessKey = awsAccessKey;
	}

	/**
	 * Gets the aws secret key.
	 *
	 * @return the aws secret key
	 */
	public String getAwsSecretKey()
	{
		return awsSecretKey;
	}

	/**
	 * Sets the aws secret key.
	 *
	 * @param awsSecretKey the new aws secret key
	 */
	public void setAwsSecretKey(String awsSecretKey)
	{
		this.awsSecretKey = awsSecretKey;
	}

	/**
	 * Gets the aws kms access key.
	 *
	 * @return the aws kms access key
	 */
	public String getAwsKmsAccessKey()
	{
		return awsKmsAccessKey;
	}

	/**
	 * Sets the aws kms access key.
	 *
	 * @param awsKmsAccessKey the new aws kms access key
	 */
	public void setAwsKmsAccessKey(String awsKmsAccessKey)
	{
		this.awsKmsAccessKey = awsKmsAccessKey;
	}

	/**
	 * Gets the aws kms secret access key.
	 *
	 * @return the aws kms secret access key
	 */
	public String getAwsKmsSecretAccessKey()
	{
		return awsKmsSecretAccessKey;
	}

	/**
	 * Sets the aws kms secret access key.
	 *
	 * @param awsKmsSecretAccessKey the new aws kms secret access key
	 */
	public void setAwsKmsSecretAccessKey(String awsKmsSecretAccessKey)
	{
		this.awsKmsSecretAccessKey = awsKmsSecretAccessKey;
	}

	/**
	 * Gets the aws KMS key.
	 *
	 * @return the aws KMS key
	 */
	public String getAwsKMSKey()
	{
		return awsKMSKey;
	}

	/**
	 * Sets the aws KMS key.
	 *
	 * @param awsKMSKey the new aws KMS key
	 */
	public void setAwsKMSKey(String awsKMSKey)
	{
		this.awsKMSKey = awsKMSKey;
	}

	/**
	 * Gets the aws KMS key region.
	 *
	 * @return the aws KMS key region
	 */
	public String getAwsKMSKeyRegion()
	{
		return awsKMSKeyRegion;
	}

	/**
	 * Sets the aws KMS key region.
	 *
	 * @param awsKMSKeyRegion the new aws KMS key region
	 */
	public void setAwsKMSKeyRegion(String awsKMSKeyRegion)
	{
		this.awsKMSKeyRegion = awsKMSKeyRegion;
	}

	/**
	 * Gets the aws service name.
	 *
	 * @return the aws service name
	 */
	public String getAwsServiceName()
	{
		return awsServiceName;
	}

	/**
	 * Sets the aws service name.
	 *
	 * @param awsServiceName the new aws service name
	 */
	public void setAwsServiceName(String awsServiceName)
	{
		this.awsServiceName = awsServiceName;
	}

	/**
	 * Gets the aws region name.
	 *
	 * @return the aws region name
	 */
	public String getAwsRegionName()
	{
		return awsRegionName;
	}

	/**
	 * Sets the aws region name.
	 *
	 * @param awsRegionName the new aws region name
	 */
	public void setAwsRegionName(String awsRegionName)
	{
		this.awsRegionName = awsRegionName;
	}

}
