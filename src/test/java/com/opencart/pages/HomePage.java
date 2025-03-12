package com.opencart.pages;

import com.opencart.constants.Browser;
import com.opencart.utility.WebElementUtil;
import org.openqa.selenium.By;

public final class HomePage extends WebElementUtil {

    private static final By MY_ACCOUNT_DROPDOWN = By.xpath("//a[@title='My Account']");
    private static final By LOGIN = By.xpath("//a[text()='Login']");

    public HomePage(Browser browserName) {
        super(browserName);
        navigateToUrl("https://awesomeqa.com/ui/index.php");
        maximizeWindow();
    }



    public LoginPage navigateToLoginPage(){
        clickOn(MY_ACCOUNT_DROPDOWN);
        clickOn(LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }

}
