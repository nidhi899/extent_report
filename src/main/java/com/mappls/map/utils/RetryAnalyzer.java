package com.mappls.map.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int counter = 0;
	int retryLimit = 2;

	@Override
	public boolean retry(ITestResult result) {
		if(result.getThrowable() instanceof AssertionError) {
			return false;
		}
		if(counter < retryLimit) {
			counter ++;
			return true;
		}
		return false;
	}
}
