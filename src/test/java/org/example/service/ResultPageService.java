package org.example.service;

import org.example.pages.ResultPage;

import java.util.List;
import java.util.logging.Logger;

public class ResultPageService extends BasePageService {

    public static final Logger log = Logger.getLogger(ResultPageService.class.getName());
    private ResultPage resultPage = new ResultPage();

    public boolean isListEmpty() {
        boolean result = resultPage.getListOfItemsNamesText().isEmpty();
        log.info("List is empty " + result);
        return result;
    }

    public ProductPageService clickOnFirstElementInListOfItems() {
        log.info("Click on the first element of list");
        resultPage.clickOnFirstElementInListOfItems();
        return new ProductPageService();
    }

    public ProductPageService clickOnElementInTheList(String element) {
        log.info("Click on the element in list");
        resultPage.clickOnElement(element);
        return new ProductPageService();
    }

    public void clickOnSearchButton() {
        log.info("Click on Search button");
        resultPage.clickOnSearchButton();
    }

    public void clickOnFilterInput(String inputName) {
        log.info("Click on filter with field name - " + inputName);
        resultPage.clickOnFilterInput(inputName);
    }

    public void clickOnDropdownWithFilter(String fieldText) {
        log.info("Click on dropdown with field name - " + fieldText);
        resultPage.clickOnDropdownWithFilter(fieldText);
    }

    public List<Integer> listOfProductPrice() {
        List<Integer> listOfProductPrices = resultPage.getListOfProductPrices();
        log.info("List of prices - " + listOfProductPrices);
        return listOfProductPrices;
    }

    public List<String> getListOfOptionsNameFromFilter() {
        List<String> listOfOptionsNameFromFilter = resultPage.getListOfOptionsNameFromFilter();
        log.info("List of options name from filter - " + listOfOptionsNameFromFilter);
        return listOfOptionsNameFromFilter;
    }

    public void clickOnRandomColor() {
        log.info("Click on random color");
        resultPage.clickOnRandomColor();
    }

    public boolean isButtonDisplayedInTheYearFilter(String str) {
        boolean result = resultPage.isButtonDisplayedInTheYearFilter(str);
        log.info(str + " button is displayed - " + result);
        return result;
    }

    public List<String> getListOfItemsNames() {
        List<String> listOfItemsName = resultPage.getListOfItemsNames();
        log.info("List of items name - " + listOfItemsName);
        return listOfItemsName;
    }

    public void clickOnPriceSortingFilter() {
        log.info("Click on price sorting filter");
        resultPage.clickOnDropdownPriceFilter();
    }
}
