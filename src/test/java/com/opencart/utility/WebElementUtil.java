package com.opencart.utility;

import com.opencart.constants.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class WebElementUtil {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public WebElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    public WebElementUtil(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Please provide correct browser name !!");
        }
    }

    public WebElementUtil(Browser browserName){
        if(browserName == Browser.CHROME){
            driver = new ChromeDriver();
        } else if (browserName == Browser.FIREFOX) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Please provide correct browser name !!");
        }
    }

    public void navigateToUrl(String url){
        driver.get(url);
    }

    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public void clickOn(By locator){
        WebElement webElement = driver.findElement(locator);
        webElement.click();
    }

    public void enterText(By locator, String text){
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }
    public String getElementText(By locator){
        WebElement element = driver.findElement(locator);
        return element.getText();
    }
}
