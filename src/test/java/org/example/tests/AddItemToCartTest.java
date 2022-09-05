package org.example.tests;

import org.example.driver.BaseTest;
import org.example.service.CartPageService;
import org.example.service.ProductPageService;
import org.example.service.ResultPageService;
import org.example.service.ShoppingCartPageService;
import org.example.service.StartedPageService;
import org.example.util.GetProperties;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class AddItemToCartTest extends BaseTest {

    private ProductPageService productPageService;
    private StartedPageService startedPageService = new StartedPageService();
    private ResultPageService resultPageService;
    private CartPageService cartPageService;
    private ShoppingCartPageService shoppingCartPageService = new ShoppingCartPageService();

    @BeforeMethod(alwaysRun = true)
    public void searchElement() {
        startedPageService.goToMainPage();
        resultPageService = startedPageService.fillSearchField("iPhone");
        resultPageService.clickOnSubmitButton();
        productPageService = resultPageService.clickOnFirstElementInListOfItems();
        cartPageService = productPageService.clickAddCartButton();
    }

    @Test(description = "1.3")
    public void isProductImageDisplayed() {
        int quantity = productPageService.getQuantityOfItemsInTheCart();
        assertThat("The image of added item is displayed", cartPageService.isProductImageDisplayed());
        assertThat("Check added msg", cartPageService.getMsgText(), Matchers.equalTo("Added to Cart"));
        assertThat("Color is not green", cartPageService.getColor(), Matchers.equalTo(GetProperties.getProperties("config", "greenColor")));
        assertThat("Cart is empty or has more than 1 item", quantity, Matchers.equalTo(1));
        cartPageService.clickOnGoToCartButton();
        assertThat("Shopping cart isn`t displayed", shoppingCartPageService.isShoppingCartDisplayed("Shopping Cart"));
        assertThat("Shopping cart is empty", !shoppingCartPageService.isListOfElementsInTheShoppingCartEmpty());
    }

    @AfterMethod(alwaysRun = true)
    public void deleteElementFromCart() {
        startedPageService.clickOnCartButton();
        shoppingCartPageService.clickOnDeleteButton();
    }
}
