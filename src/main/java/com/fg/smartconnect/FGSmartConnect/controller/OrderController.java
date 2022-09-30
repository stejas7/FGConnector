package com.fg.smartconnect.FGSmartConnect.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.amazon.yojaka.model.CreatePackagesInput;
import com.amazon.yojaka.model.Invoice;
import com.amazon.yojaka.model.Order;
import com.amazon.yojaka.model.RejectOrderInput;
import com.amazon.yojaka.model.RetrievePickupSlotsOutput;
import com.amazon.yojaka.model.ShipLabel;
import com.fg.smartconnect.FGSmartConnect.service.OrderSerivce;

// TODO: Auto-generated Javadoc
/**
 * The Class SmartConnectInventoryController.
 * 
 * @author Tejas Shah
 */
@RestController
@RequestMapping("/api/v1")
public class OrderController
{

	/** The order serivce. */
	@Autowired
	OrderSerivce orderSerivce;

	/**
	 * Gets the inventory.
	 *
	 * @param orderID the order ID
	 * @return the inventory
	 */
	@GetMapping("/order")
	public Order getOrder(@RequestParam String orderID)
	{
		Order order = orderSerivce.getOrder(orderID);
		return order;
	}

	/**
	 * Gets the order.
	 *
	 * @param locationID the location ID
	 * @param fromTimeStamp the from time stamp
	 * @param status the status
	 * @return the order
	 */
	// @GetMapping("/orders")
	public List<Order> getOrders(@RequestParam String locationID, @RequestParam String fromTimeStamp, @RequestParam String status)
	{
		List<Order> orderList = orderSerivce.listOrder(locationID, fromTimeStamp, status);
		return orderList;
	}

	/**
	 * Confirm order.
	 *
	 * @param orderID the order ID
	 */
	@PutMapping("/confirm-order")
	public void confirmOrder(@RequestParam String orderID)
	{
		orderSerivce.confirmOrder(orderID);
	}

	/**
	 * Creates the packages.
	 *
	 * @param orderID the order ID
	 * @param createPackagesInput the create packages input
	 */
	@PutMapping("/create-packages")
	public void createPackages(@RequestParam String orderID, @RequestParam CreatePackagesInput createPackagesInput)
	{
		orderSerivce.createPackage(createPackagesInput, orderID);
	}

	/**
	 * Update packages.
	 *
	 * @param orderID the order ID
	 * @param createPackagesInput the create packages input
	 */
	@PutMapping("/update-packages")
	public void updatePackages(@RequestParam String orderID, @RequestParam CreatePackagesInput createPackagesInput)
	{
		orderSerivce.updatePackage(createPackagesInput, orderID);
	}

	/**
	 * Genrate invoice.
	 *
	 * @param orderID the order ID
	 * @return the invoice
	 */
	@PutMapping("/generate-invoice")
	public Invoice genrateInvoice(@RequestParam String orderID)
	{
		Invoice invoice = orderSerivce.genrateInvoice(orderID);
		return invoice;
	}

	/**
	 * Genrate invoice.
	 *
	 * @param orderID the order ID
	 * @param packageID the package ID
	 * @return the invoice
	 */
	@PutMapping("/generate-ship-label")
	public ShipLabel genrateShiplabel(@RequestParam String orderID, @RequestParam String packageID)
	{
		ShipLabel shipLabel = orderSerivce.genrateShipLabel(orderID, packageID);
		return shipLabel;
	}

	/**
	 * Genrate invoice.
	 *
	 * @param orderID the order ID
	 * @param rejectOrderInput the reject order input
	 * @return the invoice
	 */
	@PutMapping("/reject-order")
	public void rejectOrder(@RequestParam String orderID, @RequestParam RejectOrderInput rejectOrderInput)
	{
		orderSerivce.rejectOrder(orderID, rejectOrderInput);
	}

	/**
	 * Genrate invoice.
	 *
	 * @param orderID the order ID
	 * @return the invoice
	 */
	@PutMapping("/ship-order")
	public void shipOrder(@RequestParam String orderID)
	{
		orderSerivce.shipOrder(orderID);
	}

	/**
	 * Genrate invoice.
	 *
	 * @param orderID the order ID
	 * @return the invoice
	 */
	@PutMapping("/retrieve-pickup-slots")
	public RetrievePickupSlotsOutput retrivePickUpSlots(@RequestParam String orderID)
	{
		RetrievePickupSlotsOutput slots = orderSerivce.retrievePickupSlotsOutput(orderID);
		return slots;
	}

}
