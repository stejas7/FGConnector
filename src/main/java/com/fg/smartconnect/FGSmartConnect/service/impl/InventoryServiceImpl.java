package com.fg.smartconnect.FGSmartConnect.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amazon.yojaka.model.GetInventoryRequest;
import com.amazon.yojaka.model.GetInventoryResult;
import com.amazon.yojaka.model.InventoryDetails;
import com.amazon.yojaka.model.UpdateInventoryRequest;
import com.amazonaws.SdkBaseException;
import com.fg.smartconnect.FGSmartConnect.amazonyojaka.AmazonYojakaBuilder;
import com.fg.smartconnect.FGSmartConnect.service.InventoryService;
import com.fg.smartconnect.FGSmartConnect.utility.CommonUtill;

// TODO: Auto-generated Javadoc
/**
 * The Class InvnetoryServiceImpl.
 * 
 * @author Tejas Shah
 */
@Service
public class InventoryServiceImpl implements InventoryService
{

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(InventoryServiceImpl.class);

	/** The commonutill. */
	@Autowired
	CommonUtill commonUtill;

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.InventoryService#getInventory(java.lang.String, java.lang.String)
	 */
	@Override
	public InventoryDetails getInventory(String locationID, String articleID)
	{
		GetInventoryResult updateInventoryResult = null;
		InventoryDetails inventoryDetails = null;
		try
		{
			AmazonYojakaBuilder.getInstance();
			GetInventoryRequest getInventoryRequest = new GetInventoryRequest()
					.amzAccessToken(AmazonYojakaBuilder.getRefreshToken())
					.locationId(locationID)
					.skuId(articleID);

			updateInventoryResult = AmazonYojakaBuilder.getInstance().getAmazonYojaka().getInventory(getInventoryRequest);
			inventoryDetails = updateInventoryResult.getInventoryDetails();
		}
		catch (SdkBaseException e)
		{
			e.printStackTrace();
		}
		return inventoryDetails;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.InventoryService#updateInventory(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void updateInventory(String locationID, String qty, String articleID)
	{
		UpdateInventoryRequest updateInventoryRequest = null;
		try
		{
			String datetime = commonUtill.uniqueNum();

			AmazonYojakaBuilder.getInstance();
			updateInventoryRequest = new UpdateInventoryRequest()
					.amzAccessToken(AmazonYojakaBuilder.getRefreshToken())
					.inventoryUpdateSequence(datetime)
					.locationId(locationID)
					.quantity(qty)
					.skuId(articleID);

			AmazonYojakaBuilder.getInstance().getAmazonYojaka().updateInventory(updateInventoryRequest);
		}
		catch (SdkBaseException e)
		{
			e.printStackTrace();
		}
	}

}
