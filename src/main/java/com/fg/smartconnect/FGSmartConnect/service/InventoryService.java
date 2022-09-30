package com.fg.smartconnect.FGSmartConnect.service;

import com.amazon.yojaka.model.InventoryDetails;

// TODO: Auto-generated Javadoc
/**
 * The Interface InvnetoryService.
 * 
 * @author Tejas Shah
 */
public interface InventoryService
{

	/**
	 * Update inventory.
	 *
	 * @param locationID the location ID
	 * @param qty the qty
	 * @param articleID the article ID
	 */
	void updateInventory(String locationID, String qty, String articleID);

	/**
	 * Gets the inventory.
	 *
	 * @param locationID the location ID
	 * @param articleID the article ID
	 * @return the inventory
	 */
	InventoryDetails getInventory(String locationID, String articleID);

}
