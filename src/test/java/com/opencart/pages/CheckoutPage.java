package com.opencart.pages;

import com.opencart.utility.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends WebElementUtil {

    private static final By CONTINUE_BUTTON = By.id("${buttonName}");
    private static final By ADD_COMMENT = By.xpath("//textarea[@name='comment']");
    private static final By CHECK_TERMS = By.name("agree");
    private static final By CONFIRM_ORDER = By.id("button-confirm");
    private static final By ORDER_STATUS_BREADCRUMB = By.xpath("//ul[@class='breadcrumb']//li[4]");
    private static final By ORDER_SUCCESS_MESSAGE = By.xpath("//div[@id='content']//h1");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage confirmBillingAddress() {
        clickOn(getDynamicLocator(CONTINUE_BUTTON, "button-payment-address"));
        return new CheckoutPage(getDriver());
    }

    public CheckoutPage confirmDeliveryDetails() {
        clickOn(getDynamicLocator(CONTINUE_BUTTON, "button-shipping-address"));
        return new CheckoutPage(getDriver());
    }

    public CheckoutPage confirmDeliveryMethod(String deliveryComment) {
        enterText(ADD_COMMENT, deliveryComment);
        clickOn(getDynamicLocator(CONTINUE_BUTTON, "button-shipping-method"));
        return new CheckoutPage(getDriver());
    }

    public CheckoutPage confirmPaymentMethod(String paymentComment) {
        enterText(ADD_COMMENT, paymentComment);
        clickOn(CHECK_TERMS);
        clickOn(getDynamicLocator(CONTINUE_BUTTON, "button-payment-method"));
        return new CheckoutPage(getDriver());
    }

    public String confirmOrder() {
        clickOn(CONFIRM_ORDER);
        waitForElementToBeVisible(ORDER_STATUS_BREADCRUMB);
        return getElementText(ORDER_SUCCESS_MESSAGE);
    }
}
