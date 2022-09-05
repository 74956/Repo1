package org.example.tests;

import org.example.driver.BaseTest;
import org.example.service.ProductPageService;
import org.example.service.ResultPageService;
import org.example.service.StartedPageService;
import org.example.util.CommonMethodsForList;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckFilterWorkTest extends BaseTest {

    private StartedPageService startedPageService = new StartedPageService();
    private ResultPageService resultPageService;
    private ProductPageService productPageService;

    @BeforeMethod(alwaysRun = true)
    public void searchElement() {
        startedPageService.goToMainPage();
        resultPageService = startedPageService.fillSearchField("iPhone");
        resultPageService.clickOnSearchButton();
    }

    @Test(description = "1.2")
    public void checkSearch() {
        assertThat("List of items is empty", !resultPageService.isListEmpty());
    }

    @Test(description = "1.3")
    public void cartIsEmpty() {
        productPageService = resultPageService.clickOnFirstElementInListOfItems();
        int quantity = productPageService.getQuantityOfItemsInTheCart();
        assertThat("Cart is not empty by default", quantity, Matchers.equalTo(0));
        assertThat("'Add to cart button is not displayed'", productPageService.isAddToCartButtonDisplayed());
    }

    @Test(description = "4")
    public void isPriceSortedFromMaxToMinTest() {
        resultPageService.clickOnDropdownWithFilter("Price: High to Low");
        List<Integer> actualResultProductList = resultPageService.listOfProductPrice();
        List<Integer> newList = new ArrayList<>(actualResultProductList);
        List<Integer> sortedNaturalOrderList = newList.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        List<Integer> expectedResultProductList = sortedNaturalOrderList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        assertThat("Price is sorted wrong", actualResultProductList, Matchers.equalTo(expectedResultProductList));
    }

    @Test(description = "4")
    public void isSeeMoreButtonDisplayedTest() {
        assertThat("The 'See more' button isn`t displayed", resultPageService.isButtonDisplayedInTheYearFilter("See more"));
    }

    @DataProvider(name = "modelYears")
    public static Object[][] createData() {
        return new Object[][]{
                {"2022"},
                {"2018"}
        };
    }

    @Test(description = "4", dataProvider = "modelYears")
    public void isSeeMoreButtonDisplayedAfterUsingFilterTest(String year) {
        resultPageService.clickOnFilterInput(year);
        resultPageService.clickOnRandomColor();
        assertThat("'See more' button is displayed ", !resultPageService.isButtonDisplayedInTheYearFilter("See more"));
    }

    @Test(description = "4")
    public void isOptionsNameDisplayedTest() {
        List<String> actualListOfOptionsNames = resultPageService.getListOfOptionsNameFromFilter();
        List<String> expectedListOfOptionsNames = Arrays.asList("Condition", "Climate Pledge Friendly", "Department",
                "Customer Reviews", "Brand", "Cell Phone Price", "Cell Phone Carrier", "Electronics Device Model Year",
                "Phone Color", "Cell Phone Internal Storage Memory", "Cell Phone Display Size", "Cell Phone Aspect Ratio",
                "Cellular Technology", "Cell Phone Operating System", "Cellular Phone Form Factor", "Cellular Phone SIM Card Size",
                "Cell Phone Connectivity Technology", "Cell Phone Features", "Cell Phone Display Type", "Cell Phone Camera Resolution",
                "Cell Phone Shooting Modes", "Cellular Phone Biometric Security Feature", "Cell Phone Human Interface Input",
                "Cellular Phone SIM Card Slot Count", "Cell Phone Connector Type", "Cell Phone Resolution", "Water Resistance Level", "Availability");

        assertThat("Check the names of filter options ", actualListOfOptionsNames, Matchers.equalTo(expectedListOfOptionsNames));
    }

    @Test(description = "4")
    public void checkFilterWorkTest() {
        resultPageService.clickOnFilterInput("iOS");
        List<String> listOfResult = resultPageService.getListOfItemsNames();
        assertThat("List of items not contain iOS product", CommonMethodsForList.isListContainsString(listOfResult, "iPhone"));
    }
}
