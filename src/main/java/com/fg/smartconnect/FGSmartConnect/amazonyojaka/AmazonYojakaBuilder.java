package com.fg.smartconnect.FGSmartConnect.amazonyojaka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazon.yojaka.AmazonYojaka;
import com.amazon.yojaka.lwa.LWAHandler;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class AmazonYojakaBuilder.
 * 
 * @author Tejas Shah
 */
public class AmazonYojakaBuilder
{

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AmazonYojakaBuilder.class);

	/** The amz yojaka builder. */
	private static AmazonYojakaBuilder amzYojakaBuilder;

	/** The amazon yojaka. */
	private AmazonYojaka amazonYojaka = null;

	/**
	 * Instantiates a new amazon yojaka builder.
	 */
	private AmazonYojakaBuilder()
	{
		try
		{
			AWSSecurityTokenService awsSecurityTokenService = AWSSecurityTokenServiceClientBuilder.standard().withRegion(Regions.EU_WEST_1).withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("AKIAXFLCUUIXNXGZFM5C", "oSvOsW542BDZpxV6fD3jVFOhwpar2geumeMtyL2a"))).build();

			STSAssumeRoleSessionCredentialsProvider stsAssumeRoleSessionCredentialsProvider = new STSAssumeRoleSessionCredentialsProvider.Builder("arn:aws:iam::089522401509:role/FutureGroupConnector-Sandbox", "AmazonConnector")
					.withStsClient(awsSecurityTokenService)
					.withRoleSessionDurationSeconds(4 * 60 * 60)
					.build();

			amazonYojaka = AmazonYojaka.builder()/*
													 * //.retryPolicy(RetryPolicyBuilder.standard()
													 * .retryOnExceptions(InternalServerErrorException.class, SocketTimeoutException.class)
													 * .retryOnStatusCodes(429, 503)
													 * .maxNumberOfRetries(10)
													 * .fixedBackoff(100)
													 * .build())
													 * .connectionConfiguration(new ConnectionConfiguration()
													 * .maxConnections(100)
													 * .connectionMaxIdleMillis(1000))
													 * .timeoutConfiguration(new TimeoutConfiguration()
													 * .httpRequestTimeout(3000)
													 * .totalExecutionTimeout(10000)
													 * .socketTimeout(2000))
													 */
					.iamCredentials(stsAssumeRoleSessionCredentialsProvider)
					.build();

		}
		catch (Exception e)
		{
			LOGGER.info("Jboss Server not Found Error-1");
		}
	}

	/**
	 * Gets the single instance of AmazonYojakaBuilder.
	 *
	 * @return single instance of AmazonYojakaBuilder
	 */
	public static synchronized AmazonYojakaBuilder getInstance()
	{
		if (amzYojakaBuilder == null)
		{
			amzYojakaBuilder = new AmazonYojakaBuilder();
		}
		return amzYojakaBuilder;
	}

	/**
	 * Gets the refresh token.
	 *
	 * @return the refresh token
	 */
	public static String getRefreshToken()
	{
		LWAHandler handler = new LWAHandler("amzn1.application-oa2-client.4178f31070b245ee8f738f67afdbfa6e", "6394b30bd56a3147a385cf00959fd32eb935ed350fc7671e35452c32bab20bd7");
		handler.registerSellerRefreshToken("A2OH1TCO2KPQAC", "Atzr|IwEBILYRsRDj8A7wLQbgQH2zC2agUXkWiS9Rz9LtYZKg9byOsPfHPS5qkK1sE67jlWUFxN2nIUumBk0kD4zDxFK3Qt68l0ttSMl9RViWqZom-CCoJ6QvV9cxofCr4c2VOgxBfRVchLZMK1E-CPjyn0_PX0yAjfnYyXbqpZ_s8pp8pUURWEiMac3tDeemJo71_muPVpAmiki0GJCB6HvxD8aXF2d_wX1W_G6jOw0MfFBf2UaAmTLYKILF-qtmZUXqhEadplKj5C7nNnDyt4mKbx--0-CcnJyXA65r1_8waPeGL81DubQL2bWw5VBMlxUqmUPmOA6TzOUCGVpe4gWOs5-W9pc3dub11WQJYLJfRcw0VKt0rEnf6aR9lesxZl3dsOF6EvNHFz23D89zjvW8j7eUYx1WuKH7UeoHOGWMjo9TGzpZNgD4NrZV8vRXMy5nbudlSUG3XX6SGRMDYnDINgPMNru2TsLjFAV635U8EPyKrU1DxL9bAL_RjRJAqR_hMfyXKe524vLe2sBCmaQ6nFt4uQ8N");
		return handler.getAccessToken("A2OH1TCO2KPQAC");
	}

	/**
	 * Gets the amazon yojaka.
	 *
	 * @return the amazon yojaka
	 */
	public AmazonYojaka getAmazonYojaka()
	{
		return amazonYojaka;
	}

	/**
	 * Shutdown.
	 */
	public void shutdown()
	{
		try
		{
			amazonYojaka.shutdown();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			amzYojakaBuilder = null;
		}
	}
}
