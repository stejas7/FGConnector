package com.fg.smartconnect.FGSmartConnect.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.fg.smartconnect.FGSmartConnect.service.AmazonS3ClientService;

// TODO: Auto-generated Javadoc
/**
 * The Class AmazonS3ClientServiceImpl.
 */
@Service
public class AmazonS3ClientServiceImpl implements AmazonS3ClientService
{

	/** The aws S 3 audio bucket. */
	private String awsS3AudioBucket;

	/** The amazon S 3. */
	private AmazonS3 amazonS3;

	/**
	 * Instantiates a new amazon S 3 client service impl.
	 *
	 * @param awsRegion the aws region
	 * @param awsCredentialsProvider the aws credentials provider
	 * @param awsS3AudioBucket the aws S 3 audio bucket
	 */
	@Autowired
	public AmazonS3ClientServiceImpl(Region awsRegion, AWSCredentialsProvider awsCredentialsProvider, String awsS3AudioBucket)
	{
		this.amazonS3 = AmazonS3ClientBuilder.standard()
				.withCredentials(awsCredentialsProvider)
				.withRegion(awsRegion.getName()).build();
		this.awsS3AudioBucket = awsS3AudioBucket;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.AmazonS3ClientService#uploadFileToS3Bucket(org.springframework.web.multipart.MultipartFile, boolean)
	 */
	@Override
	@Async
	public URL uploadFileToS3Bucket(File multipartFile, boolean enablePublicReadAccess) throws IOException, AmazonServiceException
	{
		String fileName = multipartFile.getName();

		PutObjectRequest putObjectRequest = new PutObjectRequest(this.awsS3AudioBucket, fileName, multipartFile);
		PutObjectResult response = new PutObjectResult();
		response = this.amazonS3.putObject(putObjectRequest);
		URL s3Url = this.amazonS3.getUrl(this.awsS3AudioBucket, fileName);

		multipartFile.delete();

		return s3Url;

	}

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.AmazonS3ClientService#downloadFileFromS3Bucket(java.lang.String)
	 */
	@Override
	@Async
	public S3Object downloadFileFromS3Bucket(String fileName) throws AmazonServiceException
	{
		// log.info("File Name :: " + fileName);
		S3Object amS3 = amazonS3.getObject(awsS3AudioBucket, fileName);
		return amS3;

	}

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.AmazonS3ClientService#deleteFileFromS3Bucket(java.lang.String)
	 */
	@Override
	@Async
	public void deleteFileFromS3Bucket(String fileName)
	{
		try
		{
			// log.info("File Name :: " + fileName);
			amazonS3.deleteObject(new DeleteObjectRequest(awsS3AudioBucket, fileName));
		}
		catch (AmazonServiceException ex)
		{
			// log.error("error [" + ex.getMessage() + "] occurred while removing [" + fileName + "] ");
		}
	}
}
