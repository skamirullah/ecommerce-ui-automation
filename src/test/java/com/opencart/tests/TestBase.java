package com.opencart.tests;

import com.opencart.constants.Browser;
import com.opencart.pages.HomePage;
import com.opencart.utility.LambdaTestUtil;
import com.opencart.utility.LoggerUtil;
import com.opencart.utility.WebElementUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;


public class TestBase {

    protected HomePage homePage;
    Logger logger = LoggerUtil.getLogger(this.getClass());
    private boolean isLambdaTest;

    @Parameters({"browser", "isLambdaTest", "isHeadless"})
    @BeforeMethod(description = "Load application homepage")
    public void setup(String browser, boolean isLambdaTest, boolean isHeadless, ITestResult result){

        /* Use if you want to run test class
            @Optional("chrome") String browser,
            @Optional("false") boolean isLambdaTest,
            @Optional("true") boolean isHeadless,
         */
        this.isLambdaTest = isLambdaTest;
        WebDriver lambdaDriver = null;
        if(isLambdaTest) {
            lambdaDriver = LambdaTestUtil.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
            homePage = new HomePage(lambdaDriver);
        } else {
            logger.info("Loading homepage of the application");
            homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
        }

    }

    public WebElementUtil getInstance(){
        return homePage;
    }

    @AfterMethod(description = "Quit the browser")
    public void tearDown(){
        if(isLambdaTest){
            LambdaTestUtil.quitSession(); //quit on remote -lambda
        } else {
            homePage.quit(); //quit local
        }
    }
}
