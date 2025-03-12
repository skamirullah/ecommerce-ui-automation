package com.opencart.pages;

import com.opencart.utility.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends WebElementUtil {

    private static final By MY_ACCOUNT_TEXT = By.xpath("//h2[text()='My Account']");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getMyAccountText() {
        return getElementText(MY_ACCOUNT_TEXT);
    }


}
