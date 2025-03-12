//package com.ui.tests;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class LoginTests {
//
//    public static void main(String[] args) {
//
//        WebDriver driver = new ChromeDriver();
//        //WebElementUtil webElementUtil = new WebElementUtil(driver);
//        webElementUtil.navigateToUrl("https://awesomeqa.com/ui/");
//        webElementUtil.maximizeWindow();
//        By myAccountDropdownLocator = By.xpath("//a[@title='My Account']");
//        WebElement myAccountDropdownWebElement = driver.findElement(myAccountDropdownLocator);
//        myAccountDropdownWebElement.click();
//
//
//        By loginLocator = By.xpath("//a[text()='Login']");
//        webElementUtil.clickOn(loginLocator);
//
//        By emailFieldLocator = By.id("input-email");
//        webElementUtil.enterText(emailFieldLocator, "bedofe8332@easipro.com");
//
//        By passwordFieldLocator = By.id("input-password");
//        webElementUtil.enterText(passwordFieldLocator, "password");
//
//        By loginButtonLocator = By.xpath("//input[@value='Login']");
//        webElementUtil.clickOn(loginButtonLocator);
//
//
//
//
//
//
//
//
//
//
//
//
//
//    }
//}
