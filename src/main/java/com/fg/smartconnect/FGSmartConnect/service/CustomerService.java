package com.fg.smartconnect.FGSmartConnect.service;

import java.util.List;
import com.fg.smartconnect.FGSmartConnect.model.CutsomerMasterData;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiteService.
 */
public interface CustomerService
{
	/**
	 * Gets the all sites.
	 *
	 * @return the all sites
	 */
	List<CutsomerMasterData> getAllCustomerDetail();

	/**
	 * Save customer.
	 *
	 * @param member the member
	 * @return the cutsomer master data
	 */
	CutsomerMasterData saveCustomer(CutsomerMasterData member);

}
