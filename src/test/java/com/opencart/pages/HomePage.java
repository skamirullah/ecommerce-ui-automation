package com.opencart.pages;

import com.opencart.constants.Browser;
import static com.opencart.constants.Env.*;
import com.opencart.constants.Env;

import static com.opencart.utility.JSONUtil.readJSON;
import static com.opencart.utility.PropertiesUtil.*;

import com.opencart.utility.JSONUtil;
import com.opencart.utility.PropertiesUtil;
import com.opencart.utility.WebElementUtil;
import org.openqa.selenium.By;

import java.util.Properties;

public final class HomePage extends WebElementUtil {

    private static final By MY_ACCOUNT_DROPDOWN = By.xpath("//a[@title='My Account']");
    private static final By LOGIN = By.xpath("//a[text()='Login']");

    public HomePage(Browser browserName) {
        super(browserName);
       // navigateToUrl(readProperty(QA, "url"));
        navigateToUrl(readJSON(QA));
        maximizeWindow();
    }



    public LoginPage navigateToLoginPage(){
        clickOn(MY_ACCOUNT_DROPDOWN);
        clickOn(LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }

}
