package com.fg.smartconnect.FGSmartConnect.amazonyojaka;

import com.amazonaws.retry.v2.RetryPolicy;
import com.amazonaws.retry.v2.RetryPolicyContext;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomRetryPolicy.
 * 
 * @author Tejas Shah
 */
public class CustomRetryPolicy implements RetryPolicy
{

	/*
	 * (non-Javadoc)
	 * @see com.amazonaws.retry.v2.BackoffStrategy#computeDelayBeforeNextRetry(com.amazonaws.retry.v2.RetryPolicyContext)
	 */
	@Override
	public long computeDelayBeforeNextRetry(RetryPolicyContext context)
	{
		return 100;
	}

	/*
	 * (non-Javadoc)
	 * @see com.amazonaws.retry.v2.RetryCondition#shouldRetry(com.amazonaws.retry.v2.RetryPolicyContext)
	 */
	@Override
	public boolean shouldRetry(RetryPolicyContext context)
	{
		return context.retriesAttempted() < 3;
	}
}
