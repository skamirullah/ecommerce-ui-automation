package com.opencart.tests;

import com.opencart.pages.HomePage;
import com.opencart.utility.LoggerUtil;
import com.opencart.utility.WebElementUtil;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import static com.opencart.constants.Browser.CHROME;

public class TestBase {

    protected HomePage homePage;
    Logger logger = LoggerUtil.getLogger(this.getClass());


    @BeforeMethod(description = "Load application homepage")
    public void setup(){
        logger.info("Loading homepage of the application");
        homePage = new HomePage(CHROME);
    }

    public WebElementUtil getInstance(){
        return homePage;
    }
}
