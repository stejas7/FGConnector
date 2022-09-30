package com.fg.smartconnect.FGSmartConnect.service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import com.amazonaws.services.s3.model.S3Object;

// TODO: Auto-generated Javadoc
/**
 * The Interface AmazonS3ClientService.
 */
public interface AmazonS3ClientService
{

	/**
	 * Upload file to S 3 bucket.
	 *
	 * @param file the multipart file
	 * @param enablePublicReadAccess the enable public read access
	 * @return the put object result
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	URL uploadFileToS3Bucket(File file, boolean enablePublicReadAccess) throws IOException;

	/**
	 * Delete file from S 3 bucket.
	 *
	 * @param fileName the file name
	 */
	void deleteFileFromS3Bucket(String fileName);

	/**
	 * Download file from S 3 bucket.
	 *
	 * @param fileName the file name
	 * @return the s 3 object
	 */
	S3Object downloadFileFromS3Bucket(String fileName);

}
