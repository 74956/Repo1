package org.example.tests;

import org.example.driver.BaseTest;
import org.example.service.ProductPageService;
import org.example.service.ResultPageService;
import org.example.service.StartedPageService;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckBaseProductQuantityInTheCartTest extends BaseTest {

    private ProductPageService productPageService;
    private StartedPageService startedPageService = new StartedPageService();
    private ResultPageService resultPageService = new ResultPageService();

    @BeforeMethod
    public void searchElement() {
        startedPageService.goToMainPage();
        resultPageService = startedPageService.fillSearchField("iPhone");
        resultPageService.clickOnSubmitButton();
        productPageService = resultPageService.clickOnFirstElementInListOfItems();
    }

    @Test(description = "1.3")
    public void cartIsEmpty() {
        int quantity = productPageService.getQuantityOfItemsInTheCart();
        assertThat("Cart is not empty by default", quantity, Matchers.equalTo(0));
    }

    @Test(description = "1.3")
    public void isCartButtonDisplayed() {
        assertThat("'Add to cart button is not displayed'", productPageService.isAddToCartButtonDisplayed());
    }
}
