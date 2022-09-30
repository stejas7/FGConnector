package com.fg.smartconnect.FGSmartConnect.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;

// TODO: Auto-generated Javadoc
/**
 * The Class S3Config.
 */
@Configuration
public class S3Config
{

	/** The region. */
	@Value("${cloud.aws.region.static}")
	private String region;

	/** The aws access key. */
	@Value("${cloud.aws.credentials.access-key}")
	private String awsAccessKey;

	/** The aws secret key. */
	@Value("${cloud.aws.credentials.secret-key}")
	private String awsSecretKey;

	/** The aws S 3 audio bucket. */
	@Value("${cloud.aws.s3.audio.bucket}")
	private String awsS3AudioBucket;

	/**
	 * Gets the AWS key id.
	 *
	 * @return the AWS key id
	 */
	@Bean(name = "awsKeyId")
	public String getAWSKeyId()
	{
		return awsAccessKey;
	}

	/**
	 * Gets the AWS key secret.
	 *
	 * @return the AWS key secret
	 */
	@Bean(name = "awsKeySecret")
	public String getAWSKeySecret()
	{
		return awsSecretKey;
	}

	/**
	 * Gets the AWS polly region.
	 *
	 * @return the AWS polly region
	 */
	@Bean(name = "awsRegion")
	public Region getAWSPollyRegion()
	{
		return Region.getRegion(Regions.fromName(region));
	}

	/**
	 * Gets the AWS credentials.
	 *
	 * @return the AWS credentials
	 */
	@Bean(name = "awsCredentialsProvider")
	public AWSCredentialsProvider getAWSCredentials()
	{
		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(this.awsAccessKey, this.awsSecretKey);
		return new AWSStaticCredentialsProvider(awsCredentials);
	}

	/**
	 * Gets the AWSS 3 audio bucket.
	 *
	 * @return the AWSS 3 audio bucket
	 */
	@Bean(name = "awsS3AudioBucket")
	public String getAWSS3AudioBucket()
	{
		return awsS3AudioBucket;
	}
}
