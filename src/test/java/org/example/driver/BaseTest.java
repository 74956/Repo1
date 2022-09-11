package org.example.driver;

import org.example.object.User;
import org.example.service.LoginPageService;
import org.example.service.StartedPageService;
import org.example.service.UserService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    private static WebDriver driver;
    private StartedPageService startedPageService = new StartedPageService();
    private LoginPageService loginPageService;


    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        driver = Driver.getDriver();
        Driver.openURL();
        registration();
        Driver.waiters();
    }

    @AfterSuite(alwaysRun = true)
    public void stopBrowser() {
        Driver.closeBrowser();
    }

    private void registration() {
        User user = UserService.credentials();
        loginPageService = startedPageService.clickOnSignInMenu();
        startedPageService = loginPageService.logIn(user);
    }
}
