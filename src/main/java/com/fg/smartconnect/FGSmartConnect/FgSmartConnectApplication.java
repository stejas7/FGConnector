package com.fg.smartconnect.FGSmartConnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import com.fg.smartconnect.FGSmartConnect.config.FGSmartConnectConfig;
import com.fg.smartconnect.FGSmartConnect.config.SQSConfig;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// TODO: Auto-generated Javadoc
/**
 * The Class FgSmartConnectApplication.
 * 
 * @author Tejas Shah
 */
@SpringBootApplication
@EnableScheduling
@EnableSwagger2
public class FgSmartConnectApplication
{

	/** The fg smart connect config. */
	@Autowired
	FGSmartConnectConfig fgSmartConnectConfig;

	/** The config. */
	@Autowired
	SQSConfig config;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args)
	{
		SpringApplication.run(FgSmartConnectApplication.class, args);
	}

	/**
	 * Rest template.
	 *
	 * @param builder the builder
	 * @return the rest template
	 */
	@SuppressWarnings("deprecation")
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder)
	{
		RestTemplateBuilder newBuilder = builder.setConnectTimeout(fgSmartConnectConfig.getRestCallConnectionTimeout());
		newBuilder = newBuilder.setReadTimeout(fgSmartConnectConfig.getRestCallReadTimeout());

		return newBuilder.build();
	}

	/**
	 * Product api.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket productApi()
	{
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.fg.smartconnect.FGSmartConnect")).build();
	}
}
