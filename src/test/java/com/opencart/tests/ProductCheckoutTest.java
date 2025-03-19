package com.opencart.tests;

import com.opencart.pages.CheckoutPage;
import com.opencart.pages.SearchResultPage;
import com.opencart.pages.ShoppingCartPage;
import com.opencart.pojo.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductCheckoutTest extends TestBase {

    private static final String SEARCH_TERM = "HP";

    private SearchResultPage searchResultPage;
    private ShoppingCartPage shoppingCartPage;
    private CheckoutPage checkoutPage;

    @BeforeMethod(description = "user logs in to the application and searches for a product")
    public void setup() {
        searchResultPage = homePage.navigateToLoginPage().loginToApplication(
                        "daref44118@erapk.com", "TestPassword123@")
                .searchForAProduct(SEARCH_TERM);
    }

    @Test(description = "verify if logged in user is able to buy a product", groups = {"e2e, smoke, sanity"},
            retryAnalyzer = com.opencart.listeners.MyRetryAnalyzer.class)
    public void verifyProductOrder() {
        shoppingCartPage = searchResultPage.clickOnTheProductAt(0).addProductToCart();
        assertTrue(shoppingCartPage.addCouponCode("VALID_COUPON"), "Coupon was not added successfully");
        assertTrue(shoppingCartPage.getEstimateShippingTax(), "Estimate shipping tax was not calculated");
        assertTrue(shoppingCartPage.useGiftCertificate("3dg4ftc6lkf3"),
                "Gift voucher is not applied");
        checkoutPage = shoppingCartPage.navigateToCheckoutPage();
        String orderStatusMessage = checkoutPage.confirmBillingAddress().confirmDeliveryDetails()
                .confirmDeliveryMethod("Delivery Comment")
                .confirmPaymentMethod("Payment Comment")
                .confirmOrder();
        System.out.println(orderStatusMessage);
        assertEquals(orderStatusMessage, "Your order has been placed!");
    }

    @Test(description = "verifies the retries and screenshot for the failed test",
            groups = {"screenshot, retries"},
            retryAnalyzer = com.opencart.listeners.MyRetryAnalyzer.class)
    public void verifyRetriesAndScreenshot(User user) {
        assertEquals(homePage.navigateToLoginPage()
                .loginToApplication(user.getEmail(), user.getPassword())
                .getMyAccountText(), "Invalid Text");
    }
}
