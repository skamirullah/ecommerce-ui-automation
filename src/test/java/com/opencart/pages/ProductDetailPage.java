package com.opencart.pages;

import com.opencart.utility.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends WebElementUtil {

    private static final By ADD_TO_CART_BUTTON = By.id("button-cart");
    private static final By SHOPPING_CART_LINK = By.xpath("//a[text()='shopping cart']");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartPage addProductToCart() {
        clickOn(ADD_TO_CART_BUTTON);
        clickOn(SHOPPING_CART_LINK);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());
        return shoppingCartPage;
    }
}
