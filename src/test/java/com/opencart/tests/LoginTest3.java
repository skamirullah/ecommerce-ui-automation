package com.opencart.tests;

import com.opencart.pages.HomePage;

import static com.opencart.constants.Browser.CHROME;

public class LoginTest3 {

    public static void main(String[] args) {

        HomePage homePage = new HomePage(CHROME);
        String myAccountText = homePage.navigateToLoginPage()
                .loginToApplication("bedofe8332@easipro.com", "password")
                .getMyAccountText();
        System.out.println("My Account text is : " + myAccountText);









    }
}
