package com.opencart.pages;

import com.opencart.constants.Browser;
import static com.opencart.constants.Env.*;

import static com.opencart.utility.JSONUtil.readJSON;

import com.opencart.utility.LoggerUtil;
import com.opencart.utility.WebElementUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public final class HomePage extends WebElementUtil {

    private static final By MY_ACCOUNT_DROPDOWN = By.xpath("//a[@title='My Account']");
    private static final By LOGIN = By.xpath("//a[text()='Login']");
    Logger logger = LoggerUtil.getLogger(this.getClass());

    public HomePage(Browser browserName, boolean isHeadless) {
        super(browserName, isHeadless);
        navigateToUrl(readJSON(QA).getUrl());
    }

    public HomePage(WebDriver driver) {
        super(driver);
        navigateToUrl(readJSON(QA).getUrl());
    }

    public LoginPage navigateToLoginPage(){
        logger.info("Trying to perform click to go to login page");
        clickOn(MY_ACCOUNT_DROPDOWN);
        clickOn(LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }
}
