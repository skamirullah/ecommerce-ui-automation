package com.opencart.utility;

import com.opencart.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.opencart.constants.Env.QA;

public abstract class WebElementUtil {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    WebDriverWait wait;
    Actions actions;
    Logger logger = LoggerUtil.getLogger(this.getClass());

    public WebDriver getDriver() {
        return driver.get();
    }

    public WebElementUtil(WebDriver driver) {
        this.driver.set(driver);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(JSONUtil.readJSON(QA).getEXPLICIT_WAIT()));
        actions = new Actions(getDriver());
    }

    public WebElementUtil(String browserName) {
        logger.info("Launching " + browserName + " browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
            maximizeWindow();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver.set(new FirefoxDriver());
            maximizeWindow();
        } else {
            logger.error("Please provide correct browser name !!");
            System.err.println("Please provide correct browser name !!");
        }
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(JSONUtil.readJSON(QA).getIMPLICIT_WAIT()));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(JSONUtil.readJSON(QA).getEXPLICIT_WAIT()));
        actions = new Actions(getDriver());
    }

    public WebElementUtil(Browser browserName) {
        logger.info("Launching " + browserName + " browser");
        if (browserName == Browser.CHROME) {
            driver.set(new ChromeDriver());
        } else if (browserName == Browser.FIREFOX) {
            driver.set(new FirefoxDriver());
        } else {
            System.out.println("Please provide correct browser name !!");
        }
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(JSONUtil.readJSON(QA).getEXPLICIT_WAIT()));
        actions = new Actions(getDriver());
    }

    public WebElementUtil(Browser browserName, boolean isHeadless) {
        logger.info("Launching " + browserName + " browser");
        if (browserName == Browser.CHROME) {
            if (isHeadless) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless"); //headless mode
                options.addArguments("window-size=1920,1080");
                driver.set(new ChromeDriver(options));
            } else {
                driver.set(new ChromeDriver());
                maximizeWindow();
            }
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } else if (browserName == Browser.FIREFOX) {
            if (isHeadless) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless=old"); //headless mode
                options.addArguments("window-size=1920,1080");
                options.addArguments("disable-gpu");
                driver.set(new FirefoxDriver(options));
            } else {
                driver.set(new FirefoxDriver());
                maximizeWindow();
            }
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } else {
            System.out.println("Please provide correct browser name !!");
        }
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(JSONUtil.readJSON(QA).getEXPLICIT_WAIT()));
        actions = new Actions(getDriver());
    }

    public void navigateToUrl(String url) {
        logger.info("Visiting the website " + url);
        driver.get().get(url);
    }

    public void maximizeWindow() {
        logger.info("Maximizing the browser window");
        driver.get().manage().window().maximize();
    }

    public WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> waitForAllElementsToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public List<WebElement> waitForAllElementsToBeVisible(List<WebElement> elements) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Alert waitForVisibilityOfAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public Boolean waitForInvisibilityOfAlert() {
        return wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
    }

    public WebElement getWebElement(By locator) {
        waitForElementToBeVisible(locator);
        return driver.get().findElement(locator);
    }

    public List<WebElement> getWebElements(By locator) {
        waitForAllElementsToBeVisible(locator);
        return driver.get().findElements(locator);
    }

    public void moveToElement(By locator) {
        actions.moveToElement(getWebElement(locator));
    }

    public void clickOn(By locator) {
        waitForElementToBeClickable(locator);
        moveToElement(locator);
        getWebElement(locator).click();
    }

    public void clickOn(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    public void enterText(By locator, String text) {
        waitForElementToBeClickable(locator);
        getWebElement(locator).sendKeys(text);
    }

    public void enterKeyboardKey(By locator, Keys keyToEnter) {
        waitForElementToBeClickable(locator);
        getWebElement(locator).sendKeys(keyToEnter);
    }

    public String getElementText(By locator) {
        waitForElementToBeVisible(locator);
        return getWebElement(locator).getText();
    }

    public String getElementText(WebElement element) {
        waitForElementToBeVisible(element);
        return element.getText();
    }

    public List<String> getAllElementsText(By locator) {
        waitForAllElementsToBeVisible(locator);
        List<WebElement> elementsList = getWebElements(locator);
        List<String> textList = new ArrayList<>();
        for (WebElement element : elementsList) {
            textList.add(getElementText(element));
        }
        return textList;
    }

    public String captureScreenshot(String name) {
        WebDriver driverInstance = driver.get();
        if (driverInstance == null) {
            throw new RuntimeException("WebDriver instance is null! Cannot capture screenshot.");
        }
        TakesScreenshot screenshot = (TakesScreenshot) driverInstance;
        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = simpleDateFormat.format(date);
        String path = "./screenshots/" + name + " - " + timeStamp + ".png";
        File screenshotFile = new File(path);
        try {
            FileUtils.copyFile(screenshotData, screenshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }

    public void selectFromDropdown(By locator, String visibleText) {
        waitForElementToBeClickable(locator);
        WebElement element = getWebElement(locator);
        Select select = new Select(element);
        logger.info("Selecting the option {}", visibleText);
        select.selectByVisibleText(visibleText);
    }

    public boolean isElementDisplayed(By locator) {
        try {
            WebElement element = waitForElementToBeVisible(locator);
            return element.isDisplayed();
        } catch (TimeoutException e) {
            return false; // Element is not visible within the wait time, return false instead of failing
        } catch (NoSuchElementException e) {
            return false; // Element is not found, return false
        } catch (Exception e) {
            return false; // Any other unexpected exception, return false
        }
    }

    public void manageAlert(String action) {
        waitForVisibilityOfAlert();
        Alert alert = driver.get().switchTo().alert();
        if (action.equalsIgnoreCase("accept")) {
            alert.accept();
        } else if (action.equalsIgnoreCase("dismiss")) {
            alert.dismiss();
        } else if (action.equalsIgnoreCase("getText")) {
            alert.getText();
        } else {
            logger.error("Please provide a correct action type for alert");
        }
        waitForInvisibilityOfAlert();
    }

    public By getDynamicLocator(By initialLocator, String replacement) {
        logger.info("Initial locator: {} | Replacement: {}", initialLocator, replacement);

        // Extract locator strategy and value
        String locatorString = initialLocator.toString();
        int separatorIndex = locatorString.indexOf(": ");

        if (separatorIndex == -1) {
            throw new IllegalArgumentException("Invalid locator format: " + locatorString);
        }

        String strategy = locatorString.substring(0, separatorIndex);
        String value = locatorString.substring(separatorIndex + 2).replaceFirst("\\$\\{.+?}", replacement);

        return switch (strategy) {
            case "By.xpath" -> By.xpath(value);
            case "By.id" -> By.id(value);
            case "By.cssSelector" -> By.cssSelector(value);
            case "By.name" -> By.name(value);
            case "By.className" -> By.className(value);
            case "By.linkText" -> By.linkText(value);
            case "By.partialLinkText" -> By.partialLinkText(value);
            case "By.tagName" -> By.tagName(value);
            default -> throw new IllegalArgumentException("Unsupported locator type: " + strategy);
        };
    }

    public void quit() {
        if (driver.get() != null) {
            driver.get().quit();
        }
    }
}
