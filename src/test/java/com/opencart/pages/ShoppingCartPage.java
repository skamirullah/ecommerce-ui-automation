package com.opencart.pages;

import com.opencart.utility.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends WebElementUtil {

    BasePage basePage;

    private static final By LINK_NAME = By.xpath("//a[contains(text(),'${couponCode}')]");
    private static final By COUPON_CODE_FIELD = By.id("input-coupon");
    private static final By APPLY_COUPON_BUTTON = By.id("button-coupon");
    private static final By GET_QUOTES = By.id("button-quote");
    private static final By SELECT_FLAT_RATE = By.xpath("//input[@name='shipping_method']");
    private static final By APPLY_SHIPPING_BUTTON = By.id("button-shipping");
    private static final By GIFT_CERTIFICATE_FIELD = By.id("input-voucher");
    private static final By APPLY_GIFT_CERTIFICATE_BUTTON = By.id("button-voucher");
    private static final By CHECKOUT_BUTTON = By.xpath("//a[text()='Checkout']");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        basePage = new BasePage(getDriver());
    }

    public boolean addCouponCode(String coupon) {
        clickOn(getDynamicLocator(LINK_NAME, "Coupon Code"));
        enterText(COUPON_CODE_FIELD, coupon);
        clickOn(APPLY_COUPON_BUTTON);
        return basePage.isErrorMessageDisplayed();
    }

    public boolean getEstimateShippingTax() {
        clickOn(getDynamicLocator(LINK_NAME, "Estimate Shipping"));
        clickOn(GET_QUOTES);
        clickOn(SELECT_FLAT_RATE);
        clickOn(APPLY_SHIPPING_BUTTON);
        return basePage.isSuccessToastDisplayed();
    }

    public boolean useGiftCertificate(String giftVoucherCode) {
        clickOn(getDynamicLocator(LINK_NAME, "Gift Certificate"));
        enterText(GIFT_CERTIFICATE_FIELD, giftVoucherCode);
        clickOn(APPLY_GIFT_CERTIFICATE_BUTTON);
        return basePage.isErrorMessageDisplayed();
    }

    public CheckoutPage navigateToCheckoutPage() {
        clickOn(CHECKOUT_BUTTON);
        return new CheckoutPage(getDriver());
    }
}
