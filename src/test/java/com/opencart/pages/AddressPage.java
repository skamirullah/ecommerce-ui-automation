package com.opencart.pages;

import com.opencart.pojo.Address;
import com.opencart.utility.LoggerUtil;
import com.opencart.utility.WebElementUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddressPage extends WebElementUtil {

    BasePage basePage;
    Logger logger = LoggerUtil.getLogger(this.getClass());

    private static final By NEW_ADDRESS_BUTTON = By.xpath("//a[contains(@class,'btn-primary')]");
    private static final By FIRST_NAME_FIELD = By.id("input-firstname");
    private static final By LAST_NAME_FIELD = By.id("input-lastname");
    private static final By COMPANY_FIELD = By.id("input-company");
    private static final By ADDRESS_ONE_FIELD = By.id("input-address-1");
    private static final By ADDRESS_TWO_FIELD = By.id("input-address-2");
    private static final By CITY_FIELD = By.id("input-city");
    private static final By POST_CODE_FIELD = By.id("input-postcode");
    private static final By COUNTRY_DROPDOWN = By.id("input-country");
    private static final By STATE_DROPDOWN = By.id("input-zone");
    private static final By CONTINUE_BUTTON = By.xpath("//input[@value='Continue']");
    private static final By DELETE_ADDRESS_BUTTON = By.xpath("//a[@data-original-title='Delete']");

    public AddressPage(WebDriver driver) {
        super(driver);
        basePage = new BasePage(getDriver());
    }

    public AddressPage clickOnNewAddressButton() {
        deleteExistingAddress();
        clickOn(NEW_ADDRESS_BUTTON);
        return new AddressPage(getDriver());
    }

    public String saveAddress(Address address) {
        enterText(FIRST_NAME_FIELD, address.getFirstName());
        enterText(LAST_NAME_FIELD, address.getLastName());
        enterText(COMPANY_FIELD, address.getCompany());
        enterText(ADDRESS_ONE_FIELD, address.getAddress1());
        enterText(ADDRESS_TWO_FIELD, address.getAddress2());
        enterText(CITY_FIELD, address.getCity());
        enterText(POST_CODE_FIELD, address.getPostCode());
        selectFromDropdown(COUNTRY_DROPDOWN, address.getCounty());
        selectFromDropdown(STATE_DROPDOWN, address.getState());
        clickOn(CONTINUE_BUTTON);
        return addressPageSuccessToast();
    }

    public String addressPageSuccessToast() {
        return basePage.getSuccessToastMessage();
    }

    public AddressPage deleteExistingAddress() {
        if (isElementDisplayed(DELETE_ADDRESS_BUTTON)) {
            List<WebElement> allDeleteAddressButton = getWebElements(DELETE_ADDRESS_BUTTON);
            if (allDeleteAddressButton.size() <= 1) {
                logger.info("There is only one address. Don't delete");
            }
            for (int i = 1; i < allDeleteAddressButton.size(); i++) {
                try {
                    allDeleteAddressButton.get(i).click();
                    logger.info("Deleted row index: {}", i + 1); // Logging tr[x] for clarity
                    manageAlert("accept");
                } catch (Exception e) {
                    logger.error("Error deleting row index {}: {}", i, e.getMessage());
                }
                allDeleteAddressButton = getWebElements(DELETE_ADDRESS_BUTTON);
            }
        }
        return new AddressPage(getDriver());
    }
}
