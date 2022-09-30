package com.fg.smartconnect.FGSmartConnect.service;

import java.util.List;
import com.amazon.yojaka.model.ConfirmOrderResult;
import com.amazon.yojaka.model.CreatePackagesInput;
import com.amazon.yojaka.model.CreatePackagesResult;
import com.amazon.yojaka.model.Invoice;
import com.amazon.yojaka.model.Order;
import com.amazon.yojaka.model.RejectOrderInput;
import com.amazon.yojaka.model.RejectOrderResult;
import com.amazon.yojaka.model.RetrievePickupSlotsOutput;
import com.amazon.yojaka.model.ShipLabel;
import com.amazon.yojaka.model.ShipOrderResult;
import com.amazon.yojaka.model.UpdatePackagesResult;

// TODO: Auto-generated Javadoc
/**
 * The Interface OrderSerivce.
 * 
 * @author Tejas Shah
 */
public interface OrderSerivce
{

	/**
	 * Gets the order.
	 *
	 * @param orderID the order ID
	 * @return the order
	 */
	Order getOrder(String orderID);

	/**
	 * List order.
	 *
	 * @param locationID the location ID
	 * @param fromTimeStamp the from time stamp
	 * @param status the status
	 * @return the list
	 */
	List<Order> listOrder(String locationID, String fromTimeStamp, String status);

	/**
	 * Confirm order.
	 *
	 * @param orderID the order ID
	 * @return
	 */
	ConfirmOrderResult confirmOrder(String orderID);

	/**
	 * Ship order.
	 *
	 * @param orderID the order ID
	 * @return
	 */
	ShipOrderResult shipOrder(String orderID);

	/**
	 * Genrate invoice.
	 *
	 * @param orderID the order ID
	 * @return the invoice
	 */
	Invoice genrateInvoice(String orderID);

	/**
	 * Retrieve pickup slots output.
	 *
	 * @param orderID the order ID
	 * @return the retrieve pickup slots output
	 */
	RetrievePickupSlotsOutput retrievePickupSlotsOutput(String orderID);

	/**
	 * Update package.
	 *
	 * @param createPackagesInput the create packages input
	 * @param id the id
	 * @return
	 */
	UpdatePackagesResult updatePackage(CreatePackagesInput createPackagesInput, String id);

	/**
	 * Creates the package.
	 *
	 * @param createPackagesInput the create packages input
	 * @param orderID the order ID
	 * @return the int
	 */
	CreatePackagesResult createPackage(CreatePackagesInput createPackagesInput, String orderID);

	/**
	 * Genrate ship label.
	 *
	 * @param orderID the order ID
	 * @param packageId the package id
	 * @return the ship label
	 */
	ShipLabel genrateShipLabel(String orderID, String packageId);

	/**
	 * Reject order.
	 *
	 * @param orderID the order ID
	 * @param rejectOrderInput the reject order input
	 * @return
	 */
	RejectOrderResult rejectOrder(String orderID, RejectOrderInput rejectOrderInput);

}
