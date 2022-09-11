package org.example.pages;

import org.example.driver.Driver;
import org.example.util.Waiters;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    Waiters waiters = new Waiters();

    public BasePage() {
        this.driver = Driver.getDriver();
    }
}
