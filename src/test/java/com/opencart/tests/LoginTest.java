package com.opencart.tests;

import com.opencart.pages.HomePage;

import com.opencart.pojo.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.opencart.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

public class LoginTest {

    HomePage homePage;

    @BeforeMethod(description = "Load application homepage")
    public void setup(){
        homePage = new HomePage(CHROME);
    }


    @Test(description = "verifies valid login",
            groups = {"e2e, sanity"},
            dataProviderClass = com.opencart.dataprovider.LoginDataProvider.class,
            dataProvider = "LoginTestDataProvider")
    public void validLoginTests(User user) throws InterruptedException {
        /*
        * How to write Good Test?
        * Test method should have Small test scripts
        * Test method should not have conditional statement, loops, try catch
        * Test scri pts should only follow Test Steps
        * Reduce the use of local variable
        * At least one assertion!
         */
        assertEquals(homePage.navigateToLoginPage()
                .loginToApplication(user.getEmail(), user.getPassword())
                .getMyAccountText(), "My Account");









    }
}
