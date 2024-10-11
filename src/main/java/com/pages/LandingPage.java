package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LandingPage {
    public WebDriver driver;
    public WebDriverWait wait;
    public LandingPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }
    private By formAuthentication = By.linkText("Form Authentication");
    private By checkBoxes = By.linkText("Checkboxes");
    private By dropDown = By.linkText("Dropdown");
    private By alerts = By.linkText("JavaScript Alerts");


    public FormAuthenticationPage clickOnFormAuthentication(){
        driver.findElement(formAuthentication).click();
        return new FormAuthenticationPage(driver);
    }

    public CheckBoxesPage clickOnCheckBoxes(){
        driver.findElement(checkBoxes).click();
        return new CheckBoxesPage(driver);
    }

    public DropDownPage clickOnDropdown(){
        driver.findElement(dropDown).click();
        return new DropDownPage(driver);
    }

    public AlertsPage clickOnJavaScriptAlerts(){
        driver.findElement(alerts).click();
        return new AlertsPage(driver);
    }
}
