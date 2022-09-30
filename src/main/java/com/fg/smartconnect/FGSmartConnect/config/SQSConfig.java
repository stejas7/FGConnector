package com.fg.smartconnect.FGSmartConnect.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.config.QueueMessageHandlerFactory;
import org.springframework.cloud.aws.messaging.config.SimpleMessageListenerContainerFactory;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.QueueMessageHandler;
import org.springframework.cloud.aws.messaging.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.PayloadArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class SQSConfig.
 * 
 * @author Tejas Shah
 */
@Configuration
public class SQSConfig
{

	/** The region. */
	@Value("${cloud.aws.region.static}")
	private String region;

	/** The aws access key. */
	@Value("${cloud.aws.credentials.access-key}")
	private String awsAccessKey;

	/** The aws secret key. */
	@Value("${cloud.aws.credentials.secret-key}")
	private String awsSecretKey;

	/**
	 * Queue messaging template.
	 *
	 * @return the queue messaging template
	 */
	@Bean
	public QueueMessagingTemplate queueMessagingTemplate()
	{
		return new QueueMessagingTemplate(amazonSQSAsync());
	}

	/**
	 * Amazon SQS async.
	 *
	 * @return the amazon SQS async
	 */
	@Bean(name = "amazonSQS")
	public AmazonSQSAsync amazonSQSAsync()
	{
		return AmazonSQSAsyncClientBuilder.standard().withRegion(Regions.AP_SOUTH_1).withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey))).build();
	}

	/**
	 * Simple message listener container.
	 *
	 * @return the simple message listener container
	 */
	@Bean
	public SimpleMessageListenerContainer simpleMessageListenerContainer()
	{
		SimpleMessageListenerContainer msgListenerContainer = simpleMessageListenerContainerFactory()
				.createSimpleMessageListenerContainer();

		msgListenerContainer.setMessageHandler(queueMessageHandler());

		return msgListenerContainer;
	}

	/**
	 * Simple message listener container factory.
	 *
	 * @return the simple message listener container factory
	 */
	@Bean
	public SimpleMessageListenerContainerFactory simpleMessageListenerContainerFactory()
	{
		SimpleMessageListenerContainerFactory msgListenerContainerFactory = new SimpleMessageListenerContainerFactory();
		msgListenerContainerFactory.setAmazonSqs(amazonSQSAsync());
		return msgListenerContainerFactory;
	}

	/**
	 * Queue message handler.
	 *
	 * @return the queue message handler
	 */
	@Bean
	public QueueMessageHandler queueMessageHandler()
	{
		QueueMessageHandlerFactory queueMsgHandlerFactory = new QueueMessageHandlerFactory();
		queueMsgHandlerFactory.setAmazonSqs(amazonSQSAsync());

		QueueMessageHandler queueMessageHandler = queueMsgHandlerFactory.createQueueMessageHandler();

		List<HandlerMethodArgumentResolver> list = new ArrayList<>();

		HandlerMethodArgumentResolver resolver = new PayloadArgumentResolver(new MappingJackson2MessageConverter());

		list.add(resolver);

		queueMessageHandler.setArgumentResolvers(list);
		return queueMessageHandler;
	}
}
