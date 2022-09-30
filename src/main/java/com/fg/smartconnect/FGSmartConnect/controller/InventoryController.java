package com.fg.smartconnect.FGSmartConnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.amazon.yojaka.model.InventoryDetails;
import com.fg.smartconnect.FGSmartConnect.service.InventoryService;

// TODO: Auto-generated Javadoc
/**
 * The Class SmartConnectInventoryController.
 * 
 * @author Tejas Shah
 */
@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController
{

	/** The inventory service. */
	@Autowired
	InventoryService inventoryService;

	/**
	 * Gets the inventory.
	 *
	 * @param locationID the location ID
	 * @param articleID the article ID
	 * @return the inventory
	 */
	@GetMapping
	public InventoryDetails getInventory(@RequestParam String locationID, String articleID)
	{
		InventoryDetails inventoryDetails = inventoryService.getInventory(locationID, articleID);
		return inventoryDetails;
	}

	/**
	 * Gets the inventory.
	 *
	 * @param locationID the location ID
	 * @param qty the qty
	 * @param articleID the article ID
	 * @return the inventory
	 */
	@PutMapping
	public ResponseEntity<?> updateInventory(@RequestParam String locationID, @RequestParam String qty, @RequestParam String articleID)
	{
		inventoryService.updateInventory(locationID, qty, articleID);
		return ResponseEntity.ok().build();
	}

}
