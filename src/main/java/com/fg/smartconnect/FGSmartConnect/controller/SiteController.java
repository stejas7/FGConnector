package com.fg.smartconnect.FGSmartConnect.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fg.smartconnect.FGSmartConnect.model.SiteMst;
import com.fg.smartconnect.FGSmartConnect.service.impl.SiteServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class MemberCreation.
 * 
 * @author Tejas Shah
 */
@RestController
@RequestMapping("/api/v1/db")
public class SiteController
{

	/** The service. */
	@Autowired
	private SiteServiceImpl service;

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	@GetMapping("/sites")
	public List<SiteMst> getAll()
	{
		return service.getAllSites();

	}

	/**
	 * Creates the member.
	 *
	 * @param member the member
	 * @return the member
	 */
	@PostMapping("/addSite")
	public SiteMst createMember(@Valid @RequestBody SiteMst member)
	{
		return service.saveSite(member);
	}
}
