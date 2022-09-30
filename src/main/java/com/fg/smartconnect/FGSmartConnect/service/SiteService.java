package com.fg.smartconnect.FGSmartConnect.service;

import java.util.List;
import com.fg.smartconnect.FGSmartConnect.model.SiteMst;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiteService.
 */
public interface SiteService
{

	/**
	 * Save site.
	 *
	 * @param member the member
	 * @return the site mst
	 */
	SiteMst saveSite(SiteMst member);

	/**
	 * Gets the all sites.
	 *
	 * @return the all sites
	 */
	List<SiteMst> getAllSites();

}
