package com.opencart.listeners;

import com.opencart.utility.JSONUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static com.opencart.constants.Env.QA;

public class MyRetryAnalyzer implements IRetryAnalyzer {

    //private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperty(Env.QA, "MAX_NUMBER_OF_ATTEMPTS"));
    private static final int MAX_NUMBER_OF_ATTEMPTS = JSONUtil.readJSON(QA).getMAX_NUMBER_OF_ATTEMPTS();
    private static int currentAttempt = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(currentAttempt <= MAX_NUMBER_OF_ATTEMPTS){
            currentAttempt++;
            return true;
        }
        return false;
    }
}
