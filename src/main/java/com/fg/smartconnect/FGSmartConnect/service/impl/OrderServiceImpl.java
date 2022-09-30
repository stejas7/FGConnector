package com.fg.smartconnect.FGSmartConnect.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amazon.yojaka.model.AmazonYojakaException;
import com.amazon.yojaka.model.ConfirmOrderRequest;
import com.amazon.yojaka.model.ConfirmOrderResult;
import com.amazon.yojaka.model.CreatePackagesInput;
import com.amazon.yojaka.model.CreatePackagesRequest;
import com.amazon.yojaka.model.CreatePackagesResult;
import com.amazon.yojaka.model.GetInvoiceRequest;
import com.amazon.yojaka.model.GetInvoiceResult;
import com.amazon.yojaka.model.GetOrderRequest;
import com.amazon.yojaka.model.GetOrderResult;
import com.amazon.yojaka.model.GetShipLabelRequest;
import com.amazon.yojaka.model.GetShipLabelResult;
import com.amazon.yojaka.model.Invoice;
import com.amazon.yojaka.model.ListOrdersRequest;
import com.amazon.yojaka.model.ListOrdersResult;
import com.amazon.yojaka.model.Order;
import com.amazon.yojaka.model.RejectOrderInput;
import com.amazon.yojaka.model.RejectOrderRequest;
import com.amazon.yojaka.model.RejectOrderResult;
import com.amazon.yojaka.model.RetrievePickupSlotsOutput;
import com.amazon.yojaka.model.RetrievePickupSlotsRequest;
import com.amazon.yojaka.model.RetrievePickupSlotsResult;
import com.amazon.yojaka.model.ShipLabel;
import com.amazon.yojaka.model.ShipOrderRequest;
import com.amazon.yojaka.model.ShipOrderResult;
import com.amazon.yojaka.model.UpdatePackagesRequest;
import com.amazon.yojaka.model.UpdatePackagesResult;
import com.fg.smartconnect.FGSmartConnect.amazonyojaka.AmazonYojakaBuilder;
import com.fg.smartconnect.FGSmartConnect.service.OrderSerivce;
import com.fg.smartconnect.FGSmartConnect.utility.CommonService;

// TODO: Auto-generated Javadoc
/**
 * The Class OrderServiceImpl.
 * 
 * @author Tejas Shah
 */
@Service
public class OrderServiceImpl implements OrderSerivce
{
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

	/** The common service. */
	@Autowired
	private CommonService commonService;

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.OrderSerivce#getOrder(java.lang.String)
	 */
	@Override
	public Order getOrder(String orderID)
	{
		GetOrderRequest getOrderRequest = null;
		Order order = null;
		try
		{
			AmazonYojakaBuilder.getInstance();
			getOrderRequest = new GetOrderRequest().amzAccessToken(AmazonYojakaBuilder.getRefreshToken())
					.id(orderID);// @formatter:off

			GetOrderResult getOrderResult = AmazonYojakaBuilder.getInstance().getAmazonYojaka().getOrder(getOrderRequest);
			order = getOrderResult.getOrder();

		}
		catch (AmazonYojakaException e)
		{
			LOGGER.info("StatusCode = " + e.sdkHttpMetadata().httpStatusCode());
			LOGGER.info("responseContent = " + commonService.responseContent(e));
			e.printStackTrace();
		}
		finally
		{
			AmazonYojakaBuilder.getInstance().shutdown();
		}
		return order;

	}

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.OrderSerivce#getOrder(java.lang.String)
	 */
	@Override
	public RejectOrderResult rejectOrder(String orderID, RejectOrderInput rejectOrderInput)
	{
		RejectOrderRequest rejectOrderRequest = null;
		RejectOrderResult rejectOrderResult = null;

		try
		{
			rejectOrderInput = new RejectOrderInput();

			AmazonYojakaBuilder.getInstance();
			rejectOrderRequest = new RejectOrderRequest()
					.amzAccessToken(AmazonYojakaBuilder.getRefreshToken())
					.id(orderID)
					.rejectOrderInput(rejectOrderInput);// @formatter:off

			rejectOrderResult = AmazonYojakaBuilder.getInstance().getAmazonYojaka().rejectOrder(rejectOrderRequest);

		}
		catch (AmazonYojakaException e)
		{
			LOGGER.info("StatusCode = " + e.sdkHttpMetadata().httpStatusCode());
			LOGGER.info("responseContent = " + commonService.responseContent(e));
			e.printStackTrace();
		}
		finally
		{
			AmazonYojakaBuilder.getInstance().shutdown();
		}
		return rejectOrderResult;

	}

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.OrderSerivce#listOrder()
	 */
	@Override
	public List<Order> listOrder(String locationID, String fromTimeStamp, String status)
	{
		ListOrdersRequest listOrdersRequest = null;
		// InventoryDetails inventoryDetails = null;
		List<Order> orders = null;
		try
		{
			listOrdersRequest = new ListOrdersRequest()
					.amzAccessToken(AmazonYojakaBuilder.getInstance().getRefreshToken())
					// .toTimestamp(String.valueOf(Instant.now().minus(Duration.ofMinutes(60)).toEpochMilli()))
					.fromTimestamp(fromTimeStamp)
					.locationId(locationID)
					.maxResults(String.valueOf(100));
			// .status(status);

			ListOrdersResult listOrdersResult = AmazonYojakaBuilder.getInstance().getAmazonYojaka().listOrders(listOrdersRequest);
			orders = listOrdersResult.getListOrdersOutput().getOrders();

		}
		catch (AmazonYojakaException e)
		{
			LOGGER.info("StatusCode = " + e.sdkHttpMetadata().httpStatusCode());
			LOGGER.info("responseContent = " + commonService.responseContent(e));
			e.printStackTrace();
		}
		finally
		{
			AmazonYojakaBuilder.getInstance().shutdown();
		}
		return orders;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.OrderSerivce#confirmOrder(java.lang.String)
	 */
	@Override
	public ConfirmOrderResult confirmOrder(String orderID)
	{
		ConfirmOrderRequest confirmOrderRequest = null;
		ConfirmOrderResult confirmOrderResult = null;
		try
		{
			AmazonYojakaBuilder.getInstance();
			confirmOrderRequest = new ConfirmOrderRequest().amzAccessToken(AmazonYojakaBuilder.getRefreshToken()).id(orderID);
			confirmOrderResult = AmazonYojakaBuilder.getInstance().getAmazonYojaka().confirmOrder(confirmOrderRequest);
		}
		catch (AmazonYojakaException e)
		{
			LOGGER.info("StatusCode = " + e.sdkHttpMetadata().httpStatusCode());
			LOGGER.info("responseContent = " + commonService.responseContent(e));
			e.printStackTrace();
		}
		finally
		{
			AmazonYojakaBuilder.getInstance().shutdown();
		}
		return confirmOrderResult;

	}

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.OrderSerivce#confirmOrder(java.lang.String)
	 */
	@Override
	public ShipOrderResult shipOrder(String orderID)
	{
		ShipOrderRequest shipOrderRequest = null;
		ShipOrderResult shipOrderResult = null;
		try
		{

			AmazonYojakaBuilder.getInstance();
			shipOrderRequest = new ShipOrderRequest()
					.amzAccessToken(AmazonYojakaBuilder.getRefreshToken())
					.id(orderID);// @formatter:off

			shipOrderResult = AmazonYojakaBuilder.getInstance().getAmazonYojaka().shipOrder(shipOrderRequest);
		}
		catch (AmazonYojakaException e)
		{
			LOGGER.info("StatusCode = " + e.sdkHttpMetadata().httpStatusCode());
			LOGGER.info("responseContent = " + commonService.responseContent(e));
			e.printStackTrace();
		}
		finally
		{
			AmazonYojakaBuilder.getInstance().shutdown();
		}
		return shipOrderResult;

	}

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.OrderSerivce#genrateInvoice(java.lang.String)
	 */
	@Override
	public Invoice genrateInvoice(String orderID)
	{
		GetInvoiceRequest getInvoiceRequest = null;
		Invoice invoice = null;
		try
		{
			AmazonYojakaBuilder.getInstance();
			getInvoiceRequest = new GetInvoiceRequest()
					.amzAccessToken(AmazonYojakaBuilder.getRefreshToken())
					.id(orderID);// @formatter:off

			GetInvoiceResult getInvoiceResult = AmazonYojakaBuilder.getInstance().getAmazonYojaka().getInvoice(getInvoiceRequest);
			invoice = getInvoiceResult.getInvoice();
		}
		catch (AmazonYojakaException e)
		{
			LOGGER.info("StatusCode = " + e.sdkHttpMetadata().httpStatusCode());
			LOGGER.info("responseContent = " + commonService.responseContent(e));
			e.printStackTrace();
		}
		finally
		{
			AmazonYojakaBuilder.getInstance().shutdown();
		}
		return invoice;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.OrderSerivce#genrateInvoice(java.lang.String)
	 */
	@Override
	public ShipLabel genrateShipLabel(String orderID, String packageId)
	{
		GetShipLabelRequest getShipLabelRequest = null;
		ShipLabel invoice = null;
		try
		{
			AmazonYojakaBuilder.getInstance();
			getShipLabelRequest = new GetShipLabelRequest().packageId(packageId)
					.amzAccessToken(AmazonYojakaBuilder.getRefreshToken())
					.id(orderID);// @formatter:off

			GetShipLabelResult getShipLabelResult = AmazonYojakaBuilder.getInstance().getAmazonYojaka().getShipLabel(getShipLabelRequest);
			invoice = getShipLabelResult.getShipLabel();
		}
		catch (AmazonYojakaException e)
		{
			LOGGER.info("StatusCode = " + e.sdkHttpMetadata().httpStatusCode());
			LOGGER.info("responseContent = " + commonService.responseContent(e));
			e.printStackTrace();
		}
		finally
		{
			AmazonYojakaBuilder.getInstance().shutdown();
		}
		return invoice;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.OrderSerivce#retrievePickupSlotsOutput(java.lang.String)
	 */
	@Override
	public RetrievePickupSlotsOutput retrievePickupSlotsOutput(String orderID)
	{
		RetrievePickupSlotsRequest retrievePickupSlotsRequest = null;
		RetrievePickupSlotsOutput retrievePickupSlotsOutput = null;
		try
		{
			AmazonYojakaBuilder.getInstance();
			retrievePickupSlotsRequest = new RetrievePickupSlotsRequest()
					.amzAccessToken(AmazonYojakaBuilder.getRefreshToken())
					.id(orderID);// @formatter:off

			RetrievePickupSlotsResult retrievePickupSlotsResult = AmazonYojakaBuilder.getInstance().getAmazonYojaka().retrievePickupSlots(retrievePickupSlotsRequest);
			retrievePickupSlotsOutput = retrievePickupSlotsResult.getRetrievePickupSlotsOutput();
		}
		catch (AmazonYojakaException e)
		{
			LOGGER.info("StatusCode = " + e.sdkHttpMetadata().httpStatusCode());
			LOGGER.info("responseContent = " + commonService.responseContent(e));
			e.printStackTrace();
		}
		finally
		{
			AmazonYojakaBuilder.getInstance().shutdown();
		}
		return retrievePickupSlotsOutput;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.OrderSerivce#updatePackage(com.amazon.yojaka.model.CreatePackagesInput, java.lang.String)
	 */
	@Override
	public UpdatePackagesResult updatePackage(CreatePackagesInput createPackagesInput, String orderID)
	{
		UpdatePackagesRequest updatePackagesRequest = null;
		UpdatePackagesResult updatePackagesResult = null;
		try
		{
			AmazonYojakaBuilder.getInstance();
			updatePackagesRequest = new UpdatePackagesRequest()
					.amzAccessToken(AmazonYojakaBuilder.getRefreshToken())
					.createPackagesInput(createPackagesInput).id(orderID);// @formatter:off

			updatePackagesResult = AmazonYojakaBuilder.getInstance().getAmazonYojaka().updatePackages(updatePackagesRequest);
		}
		catch (AmazonYojakaException e)
		{
			LOGGER.info("StatusCode = " + e.sdkHttpMetadata().httpStatusCode());
			LOGGER.info("responseContent = " + commonService.responseContent(e));
			e.printStackTrace();
		}
		finally
		{
			AmazonYojakaBuilder.getInstance().shutdown();
		}
		return updatePackagesResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.service.OrderSerivce#createPackage(com.amazon.yojaka.model.CreatePackagesInput, java.lang.String)
	 */
	@Override
	public CreatePackagesResult createPackage(CreatePackagesInput createPackagesInput, String orderID)
	{
		CreatePackagesRequest createPackagesRequest = null;
		CreatePackagesResult createPackagesResult = null;
		try
		{
			AmazonYojakaBuilder.getInstance();
			createPackagesRequest = new CreatePackagesRequest()
					.amzAccessToken(AmazonYojakaBuilder.getRefreshToken())
					.createPackagesInput(createPackagesInput).id(orderID);// @formatter:off

			createPackagesResult = AmazonYojakaBuilder.getInstance().getAmazonYojaka().createPackages(createPackagesRequest);
		}
		catch (AmazonYojakaException e)
		{
			LOGGER.info("StatusCode = " + e.sdkHttpMetadata().httpStatusCode());
			LOGGER.info("responseContent = " + commonService.responseContent(e));
			e.printStackTrace();
		}
		finally
		{
			AmazonYojakaBuilder.getInstance().shutdown();
		}
		return createPackagesResult;
	}

}
