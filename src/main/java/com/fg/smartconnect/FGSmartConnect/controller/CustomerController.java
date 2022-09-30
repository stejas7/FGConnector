package com.fg.smartconnect.FGSmartConnect.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fg.smartconnect.FGSmartConnect.model.CutsomerMasterData;
import com.fg.smartconnect.FGSmartConnect.service.impl.CustomerServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class MemberCreation.
 * 
 * @author Tejas Shah
 */
@RestController
@RequestMapping("/api/v1/db")
public class CustomerController
{

	/** The service. */
	@Autowired
	private CustomerServiceImpl service;

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	@GetMapping("/customers")
	public List<CutsomerMasterData> getAll()
	{
		return service.getAllCustomerDetail();

	}

	/**
	 * Creates the member.
	 *
	 * @param customer the member
	 * @return the member
	 */
	@PostMapping("/addCustomer")
	public CutsomerMasterData createMember(@Valid @RequestBody CutsomerMasterData customer)
	{
		return service.saveCustomer(customer);
	}
}
