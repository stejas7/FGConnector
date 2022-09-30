package com.fg.smartconnect.FGSmartConnect.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.amazon.yojaka.model.CreatePackagesInput;
import com.amazon.yojaka.model.CreatePackagesResult;
import com.amazon.yojaka.model.Dimension;
import com.amazon.yojaka.model.DimensionUnit;
import com.amazon.yojaka.model.LineItem;
import com.amazon.yojaka.model.Package;
import com.amazon.yojaka.model.PackagedLineItemsElement;
import com.amazon.yojaka.model.Weight;
import com.amazon.yojaka.model.WeightUnit;
import com.fg.smartconnect.FGSmartConnect.model.AckOrder;
import com.fg.smartconnect.FGSmartConnect.model.Consignment;
import com.fg.smartconnect.FGSmartConnect.model.OutwardOmsResponseDetail;
import com.fg.smartconnect.FGSmartConnect.model.PackageItem;
import com.fg.smartconnect.FGSmartConnect.service.OmsAckService;
import com.fg.smartconnect.FGSmartConnect.service.OrderSerivce;
import com.fg.smartconnect.FGSmartConnect.utility.CommonService;
import com.fg.smartconnect.FGSmartConnect.utility.FGConstant;

// TODO: Auto-generated Javadoc
/**
 * The Class AckConfirmOrder.
 * 
 * @author Tejas Shah
 */
@Component
public class AckCreatePackageOrder implements AckHelper
{
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AckCreatePackageOrder.class);

	/** The common service. */
	@Autowired
	public CommonService commonService;

	/** The order service. */
	@Autowired
	public OrderSerivce orderService;

	/** The oms ack service. */
	@Autowired
	public OmsAckService omsAckService;

	/*
	 * (non-Javadoc)
	 * @see com.fg.smartconnect.FGSmartConnect.helper.AckHelper#callSmartConnectAPI()
	 */
	@Override
	public AckOrder callSmartConnectAPI(OutwardOmsResponseDetail outwardOmsResponseDetail)
	{
		LOGGER.info("SQS Recieved Message ::> Order outward ::>  CreatePackages ::> START");

		AckOrder ackOrder = null;
		try
		{
			LOGGER.info("SQS Recieved Message ::> Order outward ::>  CreatePackages ::> Prepare Ack Response");

			CreatePackagesInput createPackagesInput = createPackage(outwardOmsResponseDetail);
			LOGGER.info("SQS Recieved Message ::> Order outward ::>  CreatePackages ::> START");
			CreatePackagesResult createPackagesResult = orderService.createPackage(createPackagesInput, outwardOmsResponseDetail.getOrder_id());
			LOGGER.info("SQS Recieved Message ::> Order outward ::>  CreatePackages ::> STATUS ::> " + createPackagesResult.sdkResponseMetadata().httpStatusCode());

			if (createPackagesResult.sdkResponseMetadata().httpStatusCode() == HttpStatus.SC_NO_CONTENT)
			{
				ackOrder = omsAckService.commonAckOrder(outwardOmsResponseDetail.getOrder_id(), FGConstant.PACKED_ACK, "");
				LOGGER.info("SQS Recieved Message ::> Order outward ::>  CreatePackages ::> Prepare Ack Response");

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		LOGGER.info("SQS Recieved Message ::> Order outward ::>  CreatePackages ::> END");

		return ackOrder;
	}

	/**
	 * Creates the package.
	 *
	 * @param outwardOmsResponseDetail the outward oms response detail
	 * @return the creates the packages input
	 */
	private CreatePackagesInput createPackage(OutwardOmsResponseDetail outwardOmsResponseDetail)
	{
		List<Consignment> consignments = outwardOmsResponseDetail.getConsignment();
		List<com.amazon.yojaka.model.Package> packages = new ArrayList<Package>();
		for (Consignment consignment : consignments)
		{
			com.amazon.yojaka.model.Package amazonPackage = new com.amazon.yojaka.model.Package();
			amazonPackage.id(consignment.getId());

			Dimension length = new Dimension();
			length.value(Double.valueOf(consignment.getLength().getValue()));
			length.dimensionUnit(DimensionUnit.MM);

			amazonPackage.length(length);

			Dimension width = new Dimension();
			width.value(Double.valueOf(consignment.getWidth().getValue()));
			width.dimensionUnit(DimensionUnit.MM);

			amazonPackage.width(width);

			Dimension height = new Dimension();
			height.value(Double.valueOf(consignment.getWidth().getValue()));
			height.dimensionUnit(DimensionUnit.MM);

			amazonPackage.height(height);

			Weight weight = new Weight();
			weight.value(Double.valueOf(consignment.getWeight().getValue()));
			weight.weightUnit(WeightUnit.GM);

			amazonPackage.weight(weight);

			Collection<PackagedLineItemsElement> packagedLineItems = new ArrayList<PackagedLineItemsElement>();

			for (PackageItem packageItem : consignment.getItems())
			{

				LineItem lineItem = new LineItem();
				lineItem.id(packageItem.getLine_id());

				PackagedLineItemsElement element = new PackagedLineItemsElement();
				element.lineItem(lineItem);
				element.quantity(Integer.parseInt(packageItem.getQty()));

				packagedLineItems.add(element);
			}
			amazonPackage.packagedLineItems(packagedLineItems);
			packages.add(amazonPackage);
		}
		CreatePackagesInput createPackagesInput = new CreatePackagesInput();
		createPackagesInput.packages(packages);
		return createPackagesInput;
	}
}
