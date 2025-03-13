package com.opencart.pages;

import com.opencart.utility.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends WebElementUtil {

    private static final By EMAIL_FIELD = By.id("input-email");
    private static final By PASSWORD_FIELD = By.id("input-password");
    private static final By LOGIN_BUTTON = By.xpath("//input[@value='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage loginToApplication(String email, String password) throws InterruptedException {
       enterText(EMAIL_FIELD, email);
       enterText(PASSWORD_FIELD, password);
       clickOn(LOGIN_BUTTON);
       Thread.sleep(1000);
       MyAccountPage myAccountPage = new MyAccountPage(getDriver());
       return myAccountPage;
    }


}
