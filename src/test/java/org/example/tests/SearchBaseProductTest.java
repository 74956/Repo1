package org.example.tests;

import org.example.driver.BaseTest;
import org.example.service.ResultPageService;
import org.example.service.StartedPageService;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchBaseProductTest extends BaseTest {

    private StartedPageService startedPageService;
    private ResultPageService resultPageService;

    @Test(description = "1.2")
    public void checkSearch() {
        startedPageService = new StartedPageService();
        resultPageService = startedPageService.fillSearchField("iPhone");
        resultPageService.clickOnSearchButton();
        assertThat("List of items is empty", !resultPageService.isListEmpty());
    }
}
