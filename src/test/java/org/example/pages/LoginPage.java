package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public WebElement getEmailField() {
        return driver.findElement(By.xpath("//input[@name='email']"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.xpath("//input[@name='password']"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.xpath("//input[@type='submit']"));
    }

    public void addEmail(String email) {
        getEmailField().clear();
        getEmailField().sendKeys(email);
    }

    public void addPassword(String password) {
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void clickOnSubmitButton() {
        getSubmitButton().click();
    }
}
