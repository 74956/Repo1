package org.example.tests;

import org.example.driver.BaseTest;
import org.example.object.GamingMouseProduct;
import org.example.object.HeadsetProduct;
import org.example.object.PhoneProduct;
import org.example.service.CartPageService;
import org.example.service.ProductPageService;
import org.example.service.ResultPageService;
import org.example.service.ShoppingCartPageService;
import org.example.service.StartedPageService;
import org.example.util.ReadDataFromFile;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class CompareObjectsInTheCartTest extends BaseTest {

    private ProductPageService productPageService;
    private StartedPageService startedPageService = new StartedPageService();
    private ResultPageService resultPageService;
    private CartPageService cartPageService;
    private ShoppingCartPageService shoppingCartPageService = new ShoppingCartPageService();
    private List<String> list;

    @BeforeMethod(alwaysRun = true)
    public void searchElementAndGoToTheCart() {
        startedPageService.goToMainPage();
    }

    @Test(description = "Task3")
    public void checkPhoneDescription() {
        list = ReadDataFromFile.getDataFromProperties("3");
        PhoneProduct expectedPhone = new PhoneProduct(list);
        resultPageService = startedPageService.fillSearchField(expectedPhone.getName());
        resultPageService.clickOnSubmitButton();
        productPageService = resultPageService.clickOnElementInTheList((expectedPhone.getName()));
        cartPageService = productPageService.clickAddCartButton();
        shoppingCartPageService = cartPageService.clickOnGoToCartButton();

        assertThat("These objects are not equal", shoppingCartPageService.getActualPhoneProduct(),
                Matchers.equalTo(expectedPhone));
    }

    @Test(enabled = false, description = "Task3")
    public void checkGamingMouseDescription() {
        list = ReadDataFromFile.getDataFromProperties("3.1");
        GamingMouseProduct expectedGamingMouse = new GamingMouseProduct(list);
        resultPageService = startedPageService.fillSearchField(expectedGamingMouse.getName());
        resultPageService.clickOnSubmitButton();
        productPageService = resultPageService.clickOnElementInTheList(expectedGamingMouse.getName());
        cartPageService = productPageService.clickAddCartButton();
        shoppingCartPageService = cartPageService.clickOnGoToCartButton();
        expectedGamingMouse.setName(expectedGamingMouse.getName().substring(0, 40));

        assertThat("These objects are not equal", shoppingCartPageService.getActualGamingMouseProduct(),
                Matchers.equalTo(expectedGamingMouse));
    }

    @Test(enabled = false, description = "Task3")
    public void checkHeadsetDescription() {
        list = ReadDataFromFile.getDataFromProperties("3.2");
        HeadsetProduct expectedHeadset = new HeadsetProduct(list);
        resultPageService = startedPageService.fillSearchField(expectedHeadset.getName());
        resultPageService.clickOnSubmitButton();
        productPageService = resultPageService.clickOnElementInTheList(expectedHeadset.getName());
        cartPageService = productPageService.clickAddCartButton();
        shoppingCartPageService = cartPageService.clickOnGoToCartButton();
        expectedHeadset.setName(expectedHeadset.getName().substring(0, 40));

        assertThat("These objects are not equal", shoppingCartPageService.getActualHeadsetProduct(),
                Matchers.equalTo(expectedHeadset));
    }

    @AfterMethod(alwaysRun = true)
    public void deleteElementFromCart() {
        shoppingCartPageService.goToSoppingCartPage();
        shoppingCartPageService.clickOnDeleteButton();
    }
}
