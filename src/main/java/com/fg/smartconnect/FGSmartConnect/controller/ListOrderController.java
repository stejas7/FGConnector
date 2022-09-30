package com.fg.smartconnect.FGSmartConnect.controller;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import com.amazon.yojaka.model.Order;
import com.fg.smartconnect.FGSmartConnect.config.FGSmartConnectConfig;
import com.fg.smartconnect.FGSmartConnect.service.OmsService;
import com.fg.smartconnect.FGSmartConnect.utility.FGConstant;

// TODO: Auto-generated Javadoc
/**
 * The Class ListOrderController.
 * 
 * @author Tejas Shah
 */
@RestController
public class ListOrderController
{

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ListOrderController.class);

	/** The order controller. */
	@Autowired
	OrderController orderController;

	/** The fg smart connect config. */
	@Autowired
	FGSmartConnectConfig fgSmartConnectConfig;

	/** The oms service. */
	@Autowired
	OmsService omsService;

	/**
	 * List order schduler.
	 */
	@Scheduled(cron = "${fg.smartconnect.aws.listorder.schedulercron}")
	public void listOrderSchduler()
	{
		LOGGER.info("ListOrderSchduler start");
		String status = "";
		String fromTimeStamp = String.valueOf(Instant.now().minus(Duration.ofMinutes(60)).toEpochMilli());

		List<Order> orderList = orderController.getOrders(fgSmartConnectConfig.getLocationID(), fromTimeStamp, status);
		LOGGER.info("ListOrderSchduler size ::> " + orderList.size());

		for (Order order : orderList)
		{
			if (order.getStatus().equals(FGConstant.AMAZON_STATUS_ACCEPTED))
				omsService.createOrder(order);
			else if (order.getStatus().equals(FGConstant.AMAZON_STATUS_CANCELLED))
				omsService.rejectOrder(order);
		}

		LOGGER.info("ListOrderSchduler End");

	}

}
