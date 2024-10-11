package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInPage {
    public WebDriver driver;
    private By flash = By.id("flash");

    public LoggedInPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMessage(){
        return driver.findElement(flash).getText();
    }
}
