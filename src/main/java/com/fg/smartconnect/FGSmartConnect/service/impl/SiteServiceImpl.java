package com.fg.smartconnect.FGSmartConnect.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fg.smartconnect.FGSmartConnect.doa.SiteRepository;
import com.fg.smartconnect.FGSmartConnect.model.SiteMst;
import com.fg.smartconnect.FGSmartConnect.service.SiteService;

// TODO: Auto-generated Javadoc
/**
 * The Class MemberService.
 * 
 * @author Tejas Shah
 */
@Service
public class SiteServiceImpl implements SiteService
{
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(SiteService.class);

	/** The repo. */
	@Autowired
	private SiteRepository repo;

	/**
	 * Save member.
	 *
	 * @param site the member
	 * @return the member
	 */
	@Override
	public SiteMst saveSite(SiteMst site)
	{
		return repo.save(site);
	}

	/**
	 * Gets the all member.
	 *
	 * @return the all member
	 */
	@Override
	public List<SiteMst> getAllSites()
	{
		return repo.findAll();
	}

}
