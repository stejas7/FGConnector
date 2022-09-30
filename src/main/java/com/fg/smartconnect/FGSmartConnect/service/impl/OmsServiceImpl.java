package com.fg.smartconnect.FGSmartConnect.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.amazon.yojaka.model.LineItemsElement;
import com.amazon.yojaka.model.Order;
import com.fg.smartconnect.FGSmartConnect.config.FGSmartConnectConfig;
import com.fg.smartconnect.FGSmartConnect.controller.SQSController;
import com.fg.smartconnect.FGSmartConnect.model.CancelItem;
import com.fg.smartconnect.FGSmartConnect.model.CancelOrder;
import com.fg.smartconnect.FGSmartConnect.model.CreateCancelOrder;
import com.fg.smartconnect.FGSmartConnect.model.CreateOrder;
import com.fg.smartconnect.FGSmartConnect.model.CustomerIndo;
import com.fg.smartconnect.FGSmartConnect.model.CutsomerMasterData;
import com.fg.smartconnect.FGSmartConnect.model.Item;
import com.fg.smartconnect.FGSmartConnect.model.OmsSlot;
import com.fg.smartconnect.FGSmartConnect.model.PaymentInfo;
import com.fg.smartconnect.FGSmartConnect.model.PinCode;
import com.fg.smartconnect.FGSmartConnect.model.PinCodeData;
import com.fg.smartconnect.FGSmartConnect.model.PriceInfo;
import com.fg.smartconnect.FGSmartConnect.model.ReturnInfo;
import com.fg.smartconnect.FGSmartConnect.model.ShippingAddress;
import com.fg.smartconnect.FGSmartConnect.model.SiteMst;
import com.fg.smartconnect.FGSmartConnect.model.Slot;
import com.fg.smartconnect.FGSmartConnect.model.SmartConnectPinCode;
import com.fg.smartconnect.FGSmartConnect.model.TaxDetail;
import com.fg.smartconnect.FGSmartConnect.model.TaxInfo;
import com.fg.smartconnect.FGSmartConnect.service.OmsService;
import com.fg.smartconnect.FGSmartConnect.utility.CommonService;
import com.fg.smartconnect.FGSmartConnect.utility.EncryptionDecrytion;
import com.fg.smartconnect.FGSmartConnect.utility.FGConstant;

// TODO: Auto-generated Javadoc
/**
 * The Class OmsServiceImpl.
 * 
 * @author Tejas Shah
 */
@Service
public class OmsServiceImpl implements OmsService
{
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(OmsServiceImpl.class);

	/** The rest template. */
	@Autowired
	private RestTemplate restTemplate;

	/** The fg smart connect config. */
	@Autowired
	FGSmartConnectConfig fgSmartConnectConfig;

	/** The common service. */
	@Autowired
	CommonService commonService;

	/** The sqs create order. */
	@Autowired
	SQSController<CreateCancelOrder<CreateOrder>> sqsCreateOrder;

	/** The sqs cancel order. */
	@Autowired
	SQSController<CreateCancelOrder<CancelOrder>> sqsCancelOrder;

	/** The encryption decrytion. */
	@Autowired
	EncryptionDecrytion encryptionDecrytion;

	/** The service. */
	@Autowired
	SiteServiceImpl siteService;

	/** The service. */
	@Autowired
	CustomerServiceImpl customerService;

	/** The map. */
	public static HashMap<Object, Object> pincodeMap = new HashMap<>();

	/**
	 * Creates the order.
	 *
	 * @param order the order
	 */
	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.OmsService#createOrder(com.amazon.yojaka.model.Order)
	 */
	@Override
	public void createOrder(Order order)
	{
		SiteMst siteMst = getSiteDetails(order);
		LOGGER.info("ListOrder ::> create order ::> Order ID ::> " + order.getId());
		CreateOrder createOrder = new CreateOrder();
		createOrder.setClient(FGConstant.CLIENT);
		createOrder.setPortal_id(siteMst.getPortalid());
		createOrder.setOrder_id(order.getId());
		createOrder.setOrder_type(FGConstant.MARKETPLACE);

		Slot s = restCallForSloatId();

		List<Slot> slot = new ArrayList<>();
		slot.add(s);
		createOrder.setSlot(slot);
		createOrder.setStore_scode(siteMst.getSiteid()); // DB

		List<Item> items = new ArrayList<Item>();
		List<LineItemsElement> lineItemElement = order.getLineItems();

		for (LineItemsElement lineItems : lineItemElement)
		{
			Item item = new Item();
			item.setLine_id(lineItems.getId());
			item.setSku(lineItems.getMerchantSku());
			item.setQty(String.valueOf(lineItems.getNumberOfUnits()));
			item.setIs_cancellable(true);
			item.setDelivery_store_scode(siteMst.getSiteid());

			PriceInfo priceInfo = new PriceInfo();
			priceInfo.setMrp(commonService.paisaConverter(lineItems.getCharges().get(0).getAmount().getValue()));
			priceInfo.setPrice(priceInfo.getMrp());
			priceInfo.setPrice_spl(FGConstant.DEFAULT_PRICE_INFO_VALUE);
			priceInfo.setGift_charges(FGConstant.DEFAULT_PRICE_INFO_VALUE);
			priceInfo.setShipping_charges(FGConstant.DEFAULT_PRICE_INFO_VALUE);
			priceInfo.setItem_shipping_charges(FGConstant.DEFAULT_PRICE_INFO_VALUE);
			priceInfo.setOffer_discount(FGConstant.DEFAULT_PRICE_INFO_VALUE);

			item.setPrice_info(priceInfo);

			ReturnInfo returnInfo = new ReturnInfo();
			returnInfo.setIs_returnable(FGConstant.DEFAULT_RETURN_INFO);
			returnInfo.setNo_of_days(FGConstant.DEFAULT_RETURN_INFO_DAY);

			item.setReturn_info(returnInfo);

			TaxInfo tax_info = new TaxInfo();

			List<TaxDetail> tax_item = new ArrayList<TaxDetail>();

			TaxDetail taxDetail = new TaxDetail();
			taxDetail.setType(FGConstant.DEFAULT_TAX_TYPE);
			taxDetail.setPercentage(FGConstant.DEFAULT_TAX_TYPE_PERCENTAGE);
			taxDetail.setAmount(commonService.paisaConverter(lineItems.getCharges().get(0).getTax().getAmount().getValue()));

			tax_item.add(taxDetail);
			item.setTax_info(tax_info);

			TaxDetail item_shipping = new TaxDetail();
			item_shipping.setType(FGConstant.DEFAULT_TAX_TYPE);
			item_shipping.setPercentage(FGConstant.DEFAULT_TAX_TYPE_PERCENTAGE);
			item_shipping.setAmount(commonService.paisaConverter(lineItems.getCharges().get(0).getTax().getAmount().getValue()));

			List<TaxDetail> tax_item_shipping = new ArrayList<TaxDetail>();
			tax_item_shipping.add(item_shipping);

			List<TaxDetail> gift_list = new ArrayList<TaxDetail>();

			TaxDetail gift = new TaxDetail();
			gift.setType(FGConstant.DEFAULT_TAX_TYPE);
			gift.setPercentage(FGConstant.DEFAULT_TAX_TYPE_PERCENTAGE);
			gift.setAmount(lineItems.getCharges().get(0).getTax().getAmount().getValue() * 100);

			gift_list.add(gift);

			tax_info.setItem_shipping(tax_item_shipping);
			tax_info.setItem(tax_item);
			tax_info.setGift(gift_list);

			item.setTax_info(tax_info);

			items.add(item);
		}
		createOrder.setItems(items);

		// EncryptionDecrytion encryptionDecrytion = new EncryptionDecrytion();

		LOGGER.info("ListOrder ::> create order ::> Pin Code Decryption ::>  START");
		String jsonPinCode = encryptionDecrytion.decryptYojakaEncryptedData(order.getShippingInfo().getShipToAddress().getValue(), order.getShippingInfo().getShipToAddress().getEncryptionInfo().getContext());
		LOGGER.info("ListOrder ::> create order ::> Pin Code DecryptionL ::>  END");

		ShippingAddress shippingAddress = setShippingAndBillingAddress(jsonPinCode);

		createOrder.setShipping_address(shippingAddress);
		createOrder.setBilling_address(shippingAddress);

		int customerID = getCustomerId(shippingAddress);
		CustomerIndo custmerInfo = new CustomerIndo();
		custmerInfo.setId(customerID);
		custmerInfo.setMobile(FGConstant.DFAULT_CUSTOMER_MOBILE_NUM);
		custmerInfo.setFirst_name(FGConstant.CLIENT);
		custmerInfo.setEmail(FGConstant.DFAULT_CUSTOMER_EMAIL_IS);

		createOrder.setCustomer_info(custmerInfo);

		PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.setAmount(commonService.paisaConverter(order.getMetadata().getCharge().getTotalAmount().getValue()));
		paymentInfo.setName(FGConstant.CLIENT);
		paymentInfo.setPg_code(FGConstant.DEFAULT_PG_CODE);

		createOrder.setPayment_info(paymentInfo);

		CreateCancelOrder<CreateOrder> createCancelOrder = new CreateCancelOrder<>();
		createCancelOrder.setMessage(FGConstant.CREATE_ORDER);
		createCancelOrder.setData(createOrder);

		LOGGER.info("ListOrder ::> create order ::> Send Queue START ::> Order ID ::> " + order.getId());
		// LOGGER.info("Json" + commonService.getJson(createCancelOrder));

		sqsCreateOrder.sendOrderInwardQueue(createCancelOrder);
		LOGGER.info("ListOrder ::> create order ::> Send Queue END ::>  Order ID ::> " + order.getId());

	}

	/**
	 * Gets the customer id.
	 *
	 * @param shippingAddress the shipping address
	 * @return the customer id
	 */
	public int getCustomerId(ShippingAddress shippingAddress)
	{
		List<CutsomerMasterData> list = customerService.getAllCustomerDetail();
		int customerID = FGConstant.DFAULT_CUSTOMER_ID;
		for (CutsomerMasterData cutsomerMasterData : list)
		{
			if (Integer.parseInt(cutsomerMasterData.getRegionId()) == shippingAddress.getState_id())
			{
				customerID = Integer.parseInt(cutsomerMasterData.getCustomerId());
			}
		}
		return customerID;
	}

	/**
	 * Gets the site details.
	 *
	 * @param order the order
	 * @return the site details
	 */
	public SiteMst getSiteDetails(Order order)
	{
		List<SiteMst> sites = siteService.getAllSites();
		SiteMst siteMst = new SiteMst();
		for (SiteMst site : sites)
		{
			if (site.getLocationid().equals(order.getLocationId()))
			{
				siteMst = site;
			}
		}
		return siteMst;
	}

	/**
	 * Rest call for sloat id.
	 *
	 * @return the slot
	 */
	public Slot restCallForSloatId()
	{
		LOGGER.info("ListOrder ::> create order ::> Slot API CALL ::>  START");

		OmsSlot omsSlot = getSlot();

		Slot s = new Slot();
		if (omsSlot != null)
		{
			s.setSlot_id(omsSlot.getData().get(0).getDelivery_slots().get(0).getSlot_id()); // API
		}
		else
		{
			s.setSlot_id("123");
		}
		LOGGER.info("ListOrder ::> create order ::> Slot API CALL ::>  END");

		return s;
	}

	/**
	 * Sets the shipping and billing address.
	 *
	 * @param pinCode the pin code
	 * @return the shipping address
	 */
	private ShippingAddress setShippingAndBillingAddress(String pinCode)
	{
		SmartConnectPinCode smartConnectPinCode = commonService.getPinCodeObject(pinCode);
		PinCode code = filledPinCodeCache(smartConnectPinCode.getPostalCode());
		ShippingAddress shippingAddress = new ShippingAddress();
		shippingAddress.setStreet0(FGConstant.DUMMY_ADDRESS_STREET_0);
		shippingAddress.setCity(code.getCity());
		shippingAddress.setCity_id(code.getCity_id());
		shippingAddress.setState(code.getState());
		shippingAddress.setState_id(code.getState_id());
		shippingAddress.setPincode(code.getPincode());
		shippingAddress.setCountry(code.getCountry());
		shippingAddress.setCountry_id(code.getCountry_id());
		shippingAddress.setKind(FGConstant.DUMMY_SHIIPING_KIND);
		shippingAddress.setName(FGConstant.CLIENT);
		shippingAddress.setMobile(FGConstant.DFAULT_CUSTOMER_MOBILE_NUM);
		return shippingAddress;
	}

	/**
	 * Filled pin code cache.
	 *
	 * @param pinCode the pin code
	 * @return the pin code
	 */
	public PinCode filledPinCodeCache(String pinCode)
	{
		LOGGER.info("ListOrder ::> create order ::> Pin Code API CALL ::>  START");

		PinCode code = null;

		if (pincodeMap.size() > 0 && pincodeMap.get(pinCode) != null)
		{
			code = (PinCode) pincodeMap.get(pinCode);
			LOGGER.info("ListOrder ::> create order ::> Pin Code Filled From Cache");

		}
		else
		{
			String Url = fgSmartConnectConfig.getPostalURL() + pinCode;
			ResponseEntity<PinCodeData> responsePinCode = restTemplate.getForEntity(Url, PinCodeData.class);

			PinCodeData codeData = responsePinCode.getBody();
			code = codeData.getData().get(0);
			pincodeMap.put(code.getPincode(), code);
		}
		LOGGER.info("ListOrder ::> create order ::> Pin Code ::>" + code.getPincode() + " ::>  END ");

		return code;
	}

	/**
	 * Gets the slot.
	 *
	 * @return the slot
	 */
	public OmsSlot getSlot()
	{
		String Url = fgSmartConnectConfig.getSlotURL() + "1";
		ResponseEntity<OmsSlot> responsePinCode = restTemplate.getForEntity(Url, OmsSlot.class);
		OmsSlot codeData = responsePinCode.getBody();
		return codeData;
	}

	/**
	 * Reject order.
	 *
	 * @param order the order
	 */
	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.OmsService#rejectOrder(com.amazon.yojaka.model.Order)
	 */
	@Override
	public void rejectOrder(Order order)
	{
		SiteMst siteMst = getSiteDetails(order);

		LOGGER.info("ListOrder ::> reject order ::> START ::> Order ID ::> " + order.getId());

		CreateCancelOrder<CancelOrder> createOrder = new CreateCancelOrder<>();
		createOrder.setMessage(FGConstant.CANCEL_ORDER);

		@SuppressWarnings("unused")
		CancelItem cancelItem = new CancelItem();

		CancelOrder cancelOrder = new CancelOrder();
		cancelOrder.setClient(FGConstant.CLIENT);
		cancelOrder.setOrder_id(order.getId());
		cancelOrder.setPortal_id(siteMst.getPortalid());

		List<CancelItem> items = new ArrayList<CancelItem>();

		for (LineItemsElement lineItemsElement : order.getLineItems())
		{
			CancelItem cancelLineItem = new CancelItem();
			cancelLineItem.setLine_id(lineItemsElement.getId());
			cancelLineItem.setQty(lineItemsElement.getNumberOfUnits());
			cancelLineItem.setSku(lineItemsElement.getMerchantSku());
			cancelLineItem.setCancel_reason_id(lineItemsElement.getId());
			cancelLineItem.setCancel_reason_comment(FGConstant.OUT_OF_STOCK);
			items.add(cancelLineItem);
		}
		cancelOrder.setItems(items);
		createOrder.setData(cancelOrder);
		// LOGGER.info("Json" + commonService.getJson(createOrder));

		LOGGER.info("ListOrder ::> reject order ::> SEND QUEUE ::>  START");
		sqsCancelOrder.sendOrderInwardQueue(createOrder);
		LOGGER.info("ListOrder ::> reject order ::> SEND QUEUE ::>  END");
		LOGGER.info("ListOrder ::> reject order ::>  END");

	}

}
