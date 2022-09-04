package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    private final String ITEM_INFORMATION_CARD = "//div[@id='sw-atc-details-single-container']";

    public WebElement getConfirmedIconAddedToCart() {
        return driver.findElement(By.xpath("//div[contains(@class,'message')]//i[@class='a-icon a-icon-alert']"));
    }

    public WebElement getGoToCartButton() {
        return driver.findElement(By.xpath("//span[@id='sw-gtc']//a[contains(@href,'gp/cart')]"));
    }

    public WebElement getMsgAboutAddedItemToCart() {
        return driver.findElement(By.xpath(ITEM_INFORMATION_CARD + "//div[contains(@class,'a-padding-none')]//span"));
    }

    public WebElement getProductImage() {
        return driver.findElement(By.xpath(ITEM_INFORMATION_CARD + "//img"));
    }

    public boolean isProductImageDisplayed() {
        return getProductImage().isDisplayed();
    }

    public String getMsgText() {
        return getMsgAboutAddedItemToCart().getText();
    }

    public String getColor() {
        return getConfirmedIconAddedToCart().getCssValue("color");
    }

    public void clickOnGoToCartButton() {
        if (getGoToCartButton().isDisplayed()) {
            getGoToCartButton().click();
        } else {
            driver.navigate().refresh();
            waiters.fluentWaitVisibilityOfElement(getGoToCartButton()).click();
        }
    }
}
