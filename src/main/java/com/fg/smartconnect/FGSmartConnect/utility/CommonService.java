package com.fg.smartconnect.FGSmartConnect.utility;

import java.io.IOException;
import java.nio.charset.Charset;
import org.springframework.stereotype.Component;
import com.amazon.yojaka.model.AmazonYojakaException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fg.smartconnect.FGSmartConnect.model.OutwardOmsResponseDetail;
import com.fg.smartconnect.FGSmartConnect.model.SmartConnectPinCode;

// TODO: Auto-generated Javadoc
/**
 * The Class StringToJsonCoventer.
 */
@Component
public class CommonService
{

	/**
	 * Paisa converter.
	 *
	 * @param value the value
	 * @return the double
	 */
	public double paisaConverter(double value)
	{
		return value * 100;
	}

	/**
	 * Gets the json.
	 *
	 * @param object the object
	 * @return the json
	 */
	public String getJson(Object object)
	{
		ObjectMapper mapper = new ObjectMapper();
		// Converting the Object to JSONString
		String jsonString = null;
		try
		{
			jsonString = mapper.writeValueAsString(object);
		}
		catch (JsonProcessingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;
	}

	/**
	 * Response content.
	 *
	 * @param e the e
	 * @return the string
	 */
	public String responseContent(AmazonYojakaException e)
	{
		Charset charset = Charset.forName("ISO-8859-1");
		String responseContent = charset.decode(e.sdkHttpMetadata().responseContent()).toString();
		return responseContent;
	}

	/**
	 * Gets the json.
	 *
	 * @param jsonString the json string
	 * @return the json
	 */
	public OutwardOmsResponseDetail getJson(String jsonString)
	{
		ObjectMapper mapper = new ObjectMapper();
		OutwardOmsResponseDetail outwardOmsResponseDetail = null;
		try
		{
			outwardOmsResponseDetail = mapper.readValue(jsonString, OutwardOmsResponseDetail.class);
		}
		catch (JsonGenerationException e)
		{
			e.printStackTrace();
		}
		catch (JsonMappingException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return outwardOmsResponseDetail;
	}

	/**
	 * Gets the pin code object.
	 *
	 * @param jsonString the json string
	 * @return the pin code object
	 */
	public SmartConnectPinCode getPinCodeObject(String jsonString)
	{
		ObjectMapper mapper = new ObjectMapper();
		SmartConnectPinCode smartConnectPinCode = null;
		try
		{
			smartConnectPinCode = mapper.readValue(jsonString, SmartConnectPinCode.class);
		}
		catch (JsonGenerationException e)
		{
			e.printStackTrace();
		}
		catch (JsonMappingException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return smartConnectPinCode;
	}

}
