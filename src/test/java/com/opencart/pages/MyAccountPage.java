package com.opencart.pages;

import com.opencart.utility.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends WebElementUtil {

    BasePage basePage;

    private static final By MY_ACCOUNT_TEXT = By.xpath("//h2[contains(text(),'My Account')]");
    private static final By ADDRESS_BOOK = By.xpath("//a[text()='Address Book']");

    public MyAccountPage(WebDriver driver) {
        super(driver);
        basePage = new BasePage(driver);
    }

    public String getMyAccountText() {
        return getElementText(MY_ACCOUNT_TEXT);
    }

    public SearchResultPage searchForAProduct(String productName) {
        return basePage.productSearch(productName);
    }

    public AddressPage navigateToAddressPage() {
        clickOn(ADDRESS_BOOK);
        AddressPage addressPage = new AddressPage(getDriver());
        return addressPage;
    }
}
