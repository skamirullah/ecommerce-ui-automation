package com.opencart.listeners;

import com.aventstack.extentreports.Status;
import com.opencart.tests.TestBase;
import com.opencart.utility.ExtentReportUtil;
import com.opencart.utility.LoggerUtil;
import com.opencart.utility.WebElementUtil;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {

    Logger logger = LoggerUtil.getLogger(this.getClass());

    @Override
    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        ExtentReportUtil.createExtentTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("{} PASSED", result.getMethod().getMethodName());
        ExtentReportUtil.getTest().log(Status.PASS, result.getMethod().getMethodName() + " PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("{} FAILED", result.getMethod().getMethodName());
        logger.error(result.getThrowable().getMessage());
        ExtentReportUtil.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " FAILED");
        ExtentReportUtil.getTest().log(Status.FAIL, result.getThrowable().getMessage());
        Object testClass = result.getInstance();
        TestBase baseTest = (TestBase) testClass;
        WebElementUtil webElementUtil = baseTest.getInstance();
        logger.info("Capturing screenshot for the failed tests");
        String screenshotPath = webElementUtil.captureScreenshot(result.getMethod().getMethodName());
        logger.info("Attaching the screenshot to the html report file");
        ExtentReportUtil.getTest().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("{} SKIPPED", result.getMethod().getMethodName());
        ExtentReportUtil.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " SKIPPED");
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");
        ExtentReportUtil.setupSparkReporter("report.html");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed");
        ExtentReportUtil.flushReport();
    }
}
