package com.opencart.tests;

import com.opencart.pojo.User;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.testng.Assert.assertEquals;

/*
 * How to write Good Test?
 * Test method should have Small test scripts
 * Test method should not have conditional statement, loops, try catch
 * Test scri pts should only follow Test Steps
 * Reduce the use of local variable
 * At least one assertion!
 */

@Listeners({com.opencart.listeners.TestListener.class})
public class LoginTest extends TestBase {

    static int randomNumber = ThreadLocalRandom.current()
            .nextInt(1, 100000001); // Between 1 and 1,00,00,000
    private static final String INVALID_EMAIL = "test" + randomNumber + "@invalid.com";
    private static final String INVALID_PASSWORD = "invalidPass";

    @Test(description = "verifies valid login with json",
            groups = {"e2e, sanity, smoke"},
            dataProviderClass = com.opencart.dataprovider.LoginDataProvider.class,
            dataProvider = "LoginTestJSONDataProvider")
    public void verifyValidLoginTestWithJSON(User user) {
        assertEquals(homePage.navigateToLoginPage()
                .loginToApplication(user.getEmail(), user.getPassword())
                .getMyAccountText(), "My Account");
    }

    @Test(description = "verifies invalid login and error message",
            groups = {"e2e, sanity, smoke"})
    public void verifyInvalidLoginTest() {
        assertEquals(homePage.navigateToLoginPage()
                .loginToApplicationWithInvalidCredentials(INVALID_EMAIL, INVALID_PASSWORD)
                .getLoginErrorMessage(), "Warning: No match for E-Mail Address and/or Password.");
    }

    @Test(description = "verifies valid login with csv",
            groups = {"e2e, sanity"},
            dataProviderClass = com.opencart.dataprovider.LoginDataProvider.class,
            dataProvider = "LoginTestCSVDataProvider",
            retryAnalyzer = com.opencart.listeners.MyRetryAnalyzer.class)
    public void verifyValidLoginTestsWithCSV(User user) {
        assertEquals(homePage.navigateToLoginPage()
                .loginToApplication(user.getEmail(), user.getPassword())
                .getMyAccountText(), "My Account");
    }

    @Test(description = "verifies valid login with excel",
            groups = {"e2e, sanity"},
            dataProviderClass = com.opencart.dataprovider.LoginDataProvider.class,
            dataProvider = "LoginTestExcelDataProvider",
            retryAnalyzer = com.opencart.listeners.MyRetryAnalyzer.class)
    public void verifyValidLoginTestsWithExcel(User user) {
        assertEquals(homePage.navigateToLoginPage()
                .loginToApplication(user.getEmail(), user.getPassword())
                .getMyAccountText(), "My Account");
    }

    @Test(description = "verifies the retries and screenshot for the failed test",
            groups = {"e2e, smoke"},
            dataProviderClass = com.opencart.dataprovider.LoginDataProvider.class,
            dataProvider = "LoginTestJSONDataProvider",
            retryAnalyzer = com.opencart.listeners.MyRetryAnalyzer.class)
    public void verifyRetriesAndScreenshot(User user) {
        assertEquals(homePage.navigateToLoginPage()
                .loginToApplication(user.getEmail(), user.getPassword())
                .getMyAccountText(), "Invalid Text");
    }

}
