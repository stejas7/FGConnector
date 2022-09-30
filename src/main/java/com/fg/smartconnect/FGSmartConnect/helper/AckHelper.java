package com.fg.smartconnect.FGSmartConnect.helper;

import com.fg.smartconnect.FGSmartConnect.model.AckOrder;
import com.fg.smartconnect.FGSmartConnect.model.OutwardOmsResponseDetail;

// TODO: Auto-generated Javadoc
/**
 * The Interface AckHelper.
 * 
 * @author Tejas Shah
 */
public interface AckHelper
{

	/**
	 * Call smart connect API.
	 *
	 * @return the ack order
	 */
	AckOrder callSmartConnectAPI(OutwardOmsResponseDetail outwardOmsResponseDetail);
}
