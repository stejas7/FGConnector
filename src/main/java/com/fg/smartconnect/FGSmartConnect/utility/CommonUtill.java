package com.fg.smartconnect.FGSmartConnect.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class CommonUtill.
 */
@Component
public class CommonUtill
{

	/**
	 * Unique num.
	 *
	 * @return the string
	 */
	public String uniqueNum()
	{
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
		String datetime = ft.format(dNow);
		return datetime;
	}
}
