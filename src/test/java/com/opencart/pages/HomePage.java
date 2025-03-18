package com.opencart.pages;

import com.opencart.constants.Browser;
import com.opencart.utility.ExcelReaderUtil;
import com.opencart.utility.LoggerUtil;
import com.opencart.utility.PropertiesUtil;
import com.opencart.utility.WebElementUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.opencart.constants.Env.QA;
import static com.opencart.utility.JSONUtil.readJSON;

public final class HomePage extends WebElementUtil {

    Logger logger = LoggerUtil.getLogger(this.getClass());

    private static final By MY_ACCOUNT_DROPDOWN = By.xpath("//a[@title='My Account']");
    private static final By LOGIN = By.xpath("//a[text()='Login']");

    public HomePage(Browser browserName, boolean isHeadless) {
        super(browserName, isHeadless);
        //navigateToUrl(readJSON(QA).getUrl());
        navigateToUrl(PropertiesUtil.readProperty(QA, "url") );
    }

    public HomePage(WebDriver driver) {
        super(driver);
        //navigateToUrl(readJSON(QA).getUrl());
        navigateToUrl(PropertiesUtil.readProperty(QA, "url"));
    }

    public LoginPage navigateToLoginPage() {
        logger.info("Trying to perform click to go to login page");
        clickOn(MY_ACCOUNT_DROPDOWN);
        clickOn(LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }
}
