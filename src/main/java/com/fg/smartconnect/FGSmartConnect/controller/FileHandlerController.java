package com.fg.smartconnect.FGSmartConnect.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.services.s3.model.S3Object;
import com.fg.smartconnect.FGSmartConnect.service.AmazonS3ClientService;

// TODO: Auto-generated Javadoc
/**
 * The Class FileHandlerController.
 */
@RestController
@RequestMapping("/api/v1/files")
public class FileHandlerController
{

	/** The amazon S 3 client service. */
	@Autowired
	private AmazonS3ClientService amazonS3ClientService;

	/**
	 * Upload file.
	 *
	 * @param file the file
	 * @return the put object result
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@PostMapping("/push")
	public URL uploadFile(@RequestPart(value = "file") MultipartFile multipartFile) throws IOException
	{
		String fileName = multipartFile.getOriginalFilename();

		File file = new File(fileName);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(multipartFile.getBytes());
		fos.close();
		URL response = this.amazonS3ClientService.uploadFileToS3Bucket(file, true);
		return response;
	}

	/**
	 * Download file.
	 *
	 * @param fileName the file name
	 * @return the s 3 object
	 */
	@GetMapping
	public S3Object downloadFile(@RequestParam("file_name") String fileName)
	{
		S3Object amS3 = amazonS3ClientService.downloadFileFromS3Bucket(fileName);

		Map<String, String> response = new HashMap<>();
		response.put("message", "file [" + fileName + "] downlaoded successfully.");

		return amS3;
	}

	/**
	 * Delete file.
	 *
	 * @param fileName the file name
	 * @return the map
	 */
	@DeleteMapping
	public Map<String, String> deleteFile(@RequestParam("file_name") String fileName)
	{
		this.amazonS3ClientService.deleteFileFromS3Bucket(fileName);

		Map<String, String> response = new HashMap<>();
		response.put("message", "file [" + fileName + "] removing request submitted successfully.");

		return response;
	}
}
