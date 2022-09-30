package com.fg.smartconnect.FGSmartConnect.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.core.SqsMessageHeaders;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fg.smartconnect.FGSmartConnect.model.OutwardOmsResponse;
import com.fg.smartconnect.FGSmartConnect.service.impl.AckFromOMSServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class SQSController.
 *
 * @author Tejas Shah
 * @param <T> the generic type
 */
@RestController
@RequestMapping("/api/v1/sqs")
public class SQSController<T>
{

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(SQSController.class);

	/** The queue messaging template. */
	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;

	/** The service. */
	@Autowired
	private AckFromOMSServiceImpl service;

	/** The order inward url. */
	@Value("${cloud.aws.OrderInward.uri}")
	private String orderInwardUrl;

	/** The order outward url. */
	@Value("${cloud.aws.OrderOutward.uri}")
	private String orderOutwardUrl;

	/** The inventory outward url. */
	@Value("${cloud.aws.InventoryOutward.uri}")
	private String inventoryOutwardUrl;

	/**
	 * Sendorder inward message.
	 *
	 * @param member the member
	 */
	// @PostMapping("/orderInward")
	public void sendOrderInwardQueue(@RequestBody T member)
	{
		Map<String, Object> headers = new HashMap<>();
		headers.put(SqsMessageHeaders.SQS_GROUP_ID_HEADER, "orderInward");
		headers.put(SqsMessageHeaders.SQS_DEDUPLICATION_ID_HEADER, UUID.randomUUID().toString());
		queueMessagingTemplate.convertAndSend(orderInwardUrl, member, headers);

	}

	/**
	 * Sendorder outward message.
	 *
	 * @param member the member
	 */
	@PostMapping("/orderOutward")
	public void sendorderOutwardMessage(@RequestBody OutwardOmsResponse member)
	{
		Map<String, Object> headers = new HashMap<>();
		headers.put(SqsMessageHeaders.SQS_GROUP_ID_HEADER, "orderOutward");
		headers.put(SqsMessageHeaders.SQS_DEDUPLICATION_ID_HEADER, UUID.randomUUID().toString());
		queueMessagingTemplate.convertAndSend(orderOutwardUrl, member, headers);

	}

	/*	*//**
			 * Sendinventory outward message.
			 *
			 * @param message the message
			 * @return the order inward message
			 *//*
			 * @PostMapping("/inventoryOutward")
			 * public void sendinventoryOutwardMessage(@RequestBody InventoryCon site)
			 * {
			 * Map<String, Object> headers = new HashMap<>();
			 * headers.put(SqsMessageHeaders.SQS_GROUP_ID_HEADER, "orderOutward");
			 * headers.put(SqsMessageHeaders.SQS_DEDUPLICATION_ID_HEADER, UUID.randomUUID().toString());
			 * queueMessagingTemplate.convertAndSend(inventoryOutwardUrl, member, headers);
			 * }
			 */

	/**
	 * Gets the order inward message.
	 *
	 * @param message the message
	 * @return the order inward message
	 */
	// @SqsListener("Queue-SFS-Project-OrderInward.fifo")
	// public void getOrderInwardMessage(String message)
	// {
	// LOGGER.info("Message from OrderInward SQS Queue - " + message.toString());
	// }

	/**
	 * Gets the order outward message.
	 *
	 * @param message the message
	 * @return the order outward message
	 */
	@SqsListener("Queue-SFS-Project-OrderOutward.fifo")
	public void getOrderOutwardMessage(OutwardOmsResponse message)
	{
		LOGGER.info("SQS Recieved Message ::> Order outward ::> START");
		LOGGER.info("SQS Recieved Message ::> Order outward ::> Order ID ::>" + message.getData().getOrder_id());
		LOGGER.info("SQS Recieved Message ::> Order outward ::> Order Status ::>" + message.getData().getStatus());

		if (message != null)
		{
			@SuppressWarnings("unchecked")
			T ackOrder = (T) service.ackOMS(message.getData());
			if (ackOrder != null)
			{
				sendOrderInwardQueue(ackOrder);
			}
		}
		LOGGER.info("SQS Recieved Message ::> Order outward ::>  END");

		/*	*//**
				 * Gets the inventory outward message.
				 *
				 * @param message the message
				 * @return the inventory outward message
				 *//*
				 * @SqsListener("Queue-SFS-Project-InventoryOutward.fifo")
				 * public void getInventoryOutwardMessage(String message)
				 * {
				 * LOGGER.info("Message from InventoryOutward SQS Queue - " + message);
				 * }
				 */

	}
}
