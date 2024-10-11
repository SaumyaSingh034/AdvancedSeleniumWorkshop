package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormAuthenticationPage {
    WebDriver driver;
    WebDriverWait wait;
    public FormAuthenticationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    private By username = By.id("username");
    private By password = By.id("password");
    private By LoginBtn = By.xpath("//button[@type='submit']");

    public LoggedInPage getLogin(String userName, String pass){
        driver.findElement(username).sendKeys(userName);
        driver.findElement(password).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(LoginBtn)).click();
        return new LoggedInPage(driver);
    }

}
