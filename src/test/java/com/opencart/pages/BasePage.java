package com.opencart.pages;

import com.opencart.utility.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public final class BasePage extends WebElementUtil {

    private static final By SEARCH_BOX = By.xpath("//input[@name='search']");
    private static final By ERROR_MESSAGE = By.xpath("//div[contains(@class,'alert-danger')]");
    private static final By SUCCESS_TOAST_MESSAGE = By.xpath("//div[contains(@class,'alert-success')]");

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage productSearch(String productName) {
        enterText(SEARCH_BOX, productName);
        enterKeyboardKey(SEARCH_BOX, Keys.ENTER);
        SearchResultPage searchResultPage = new SearchResultPage(getDriver());
        return searchResultPage;

    }

    public boolean isErrorMessageDisplayed() {
        return isElementDisplayed(ERROR_MESSAGE);
    }

    public boolean isSuccessToastDisplayed() {
        return isElementDisplayed(SUCCESS_TOAST_MESSAGE);
    }


    public String getErrorMessage() {
        return getElementText(ERROR_MESSAGE).trim();
    }

    public String getSuccessToastMessage() {
        return getElementText(SUCCESS_TOAST_MESSAGE).trim();
    }
}
