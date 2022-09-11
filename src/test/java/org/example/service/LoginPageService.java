package org.example.service;

import org.example.object.User;
import org.example.pages.LoginPage;

import java.util.logging.Logger;

public class LoginPageService extends BasePageService {

    public static final Logger log = Logger.getLogger(LoginPageService.class.getName());
    private LoginPage loginPage = new LoginPage();

    public void addEmail(String email) {
        log.info("Add email");
        loginPage.addEmail(email);
    }

    public void addPassword(String password) {
        log.info("Add password");
        loginPage.addPassword(password);
    }

    public StartedPageService logIn(User user) {
        addEmail(user.getEmail());
        clickOnSubmitButton();
        addPassword(user.getPassword());
        clickOnSubmitButton();
        return new StartedPageService();
    }

    public void clickOnSubmitButton() {
        log.info("Click on submit button");
        loginPage.clickOnSubmitButton();
    }
}
