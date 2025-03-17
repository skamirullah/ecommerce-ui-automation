package com.opencart.tests;

import com.opencart.pages.MyAccountPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners({com.opencart.listeners.TestListener.class})
public class SearchProductTest extends TestBase {

    private static final String SEARCH_TERM = "ipod";
    private MyAccountPage myAccountPage;

    @BeforeMethod(description = "valid user logs into the application")
    public void setup() {
        myAccountPage = homePage.navigateToLoginPage().loginToApplication(
                "daref44118@erapk.com", "TestPassword123@");
    }

    @Test(description = "verify logged in user is able to search for a product and get the correct products displayed",
            groups = {"e2e, smoke, sanity"})
    public void verifyProductSearchTest() {
        assertEquals(myAccountPage.searchForAProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM), true);

    }
}
