package org.example.tests;

import org.example.driver.BaseTest;
import org.example.service.StartedPageService;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class AuthorizationTest extends BaseTest {

    private StartedPageService startedPageService = new StartedPageService();

    @Test(description = "1.1")
    public void getTitle() {
        String getTitleText = startedPageService.getAccountGreetingText();
        assertThat(getTitleText, Matchers.equalTo("Hello, Amili"));
    }
}
