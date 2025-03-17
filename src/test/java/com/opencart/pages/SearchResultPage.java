package com.opencart.pages;

import com.opencart.utility.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class SearchResultPage extends WebElementUtil {

    private static final By PRODUCT_LISTING_TITLE = By.xpath("//div[@id='product-search']//h1");
    private static final By ALL_PRODUCT_LISTS_NAME = By.xpath("//div[@class='product-thumb']//h4//a");


    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getProductListingTitle() {
        return getElementText(PRODUCT_LISTING_TITLE);
    }

    public boolean isSearchTermPresentInProductList(String searchTerm) {
        List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));
        List<String> productNamesList = getAllElementsText(ALL_PRODUCT_LISTS_NAME);
        return productNamesList.stream()
                .anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));
    }

    public ProductDetailPage clickOnTheProductAt(int index) {
        clickOn(getWebElements(ALL_PRODUCT_LISTS_NAME).get(index));
        ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
        return productDetailPage;
    }
}
