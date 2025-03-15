package com.opencart.pages;

import com.opencart.constants.Browser;
import static com.opencart.constants.Env.*;
import com.opencart.constants.Env;

import static com.opencart.utility.JSONUtil.readJSON;
import static com.opencart.utility.PropertiesUtil.*;

import com.opencart.utility.JSONUtil;
import com.opencart.utility.LoggerUtil;
import com.opencart.utility.PropertiesUtil;
import com.opencart.utility.WebElementUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public final class HomePage extends WebElementUtil {

    private static final By MY_ACCOUNT_DROPDOWN = By.xpath("//a[@title='My Account']");
    private static final By LOGIN = By.xpath("//a[text()='Login']");
    Logger logger = LoggerUtil.getLogger(this.getClass());

    public HomePage(Browser browserName, boolean isHeadless) {
        super(browserName, isHeadless);
       // navigateToUrl(readProperty(QA, "url"));
        navigateToUrl(readJSON(QA).getUrl());
        maximizeWindow();
    }

    public HomePage(WebDriver driver) {
        super(driver);
        // navigateToUrl(readProperty(QA, "url"));
        navigateToUrl(readJSON(QA).getUrl());
        maximizeWindow();
    }



    public LoginPage navigateToLoginPage(){
        logger.info("Trying to perform click to go to login page");
        clickOn(MY_ACCOUNT_DROPDOWN);
        clickOn(LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }

}
