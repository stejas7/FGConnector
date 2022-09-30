package com.fg.smartconnect.FGSmartConnect.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fg.smartconnect.FGSmartConnect.doa.CustomerRepositary;
import com.fg.smartconnect.FGSmartConnect.model.CutsomerMasterData;
import com.fg.smartconnect.FGSmartConnect.service.CustomerService;

// TODO: Auto-generated Javadoc
/**
 * The Class MemberService.
 * 
 * @author Tejas Shah
 */
@Service
public class CustomerServiceImpl implements CustomerService
{
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

	/** The repo. */
	@Autowired
	private CustomerRepositary repo;

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.CustomerService#saveSite(com.fg.smartconnect.FGSmartConnect.model.CutsomerMasterData)
	 */
	@Override
	public CutsomerMasterData saveCustomer(CutsomerMasterData member)
	{
		// TODO Auto-generated method stub
		return repo.save(member);
	}

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.CustomerService#getAllCustomerDetail()
	 */
	@Override
	public List<CutsomerMasterData> getAllCustomerDetail()
	{
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
