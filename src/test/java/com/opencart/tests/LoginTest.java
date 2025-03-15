package com.opencart.tests;

import com.opencart.pojo.User;
import com.opencart.utility.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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
public class LoginTest extends TestBase{

    @Test(description = "verifies valid login",
            groups = {"e2e, sanity"},
            dataProviderClass = com.opencart.dataprovider.LoginDataProvider.class,
            dataProvider = "LoginTestDataProvider")
    public void validLoginTests(User user) throws InterruptedException {
        assertEquals(homePage.navigateToLoginPage()
                .loginToApplication(user.getEmail(), user.getPassword())
                .getMyAccountText(), "My Account");
    }

    @Test(description = "verifies valid login with csv",
            groups = {"e2e, sanity"},
            dataProviderClass = com.opencart.dataprovider.LoginDataProvider.class,
            dataProvider = "LoginTestCSVDataProvider")
    public void validLoginTestsWithCSV(User user) throws InterruptedException {

        assertEquals(homePage.navigateToLoginPage()
                .loginToApplication(user.getEmail(), user.getPassword())
                .getMyAccountText(), "My Account");
    }

    @Test(description = "verifies valid login with csv",
            groups = {"e2e, sanity"},
            dataProviderClass = com.opencart.dataprovider.LoginDataProvider.class,
            dataProvider = "LoginTestExcelDataProvider",
            retryAnalyzer = com.opencart.listeners.MyRetryAnalyzer.class)
    public void validLoginTestsWithExcel(User user) throws InterruptedException {
        assertEquals(homePage.navigateToLoginPage()
                .loginToApplication(user.getEmail(), user.getPassword())
                .getMyAccountText(), "My Account");;
    }



}
