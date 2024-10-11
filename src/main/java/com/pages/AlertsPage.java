package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    public WebDriver driver;
    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By jsAlert = By.xpath("//button[@onclick='jsAlert()']");
    private By jsConfirm = By.xpath("//button[@onclick='jsConfirm()']");
    private By jsPrompt = By.xpath("//button[@onclick='jsPrompt()']");

    public String clickOnjsAlert(){
        driver.findElement(jsAlert).click();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        return text;
    }

    public void clickOnJsConfirm(){
        driver.findElement(jsConfirm).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String clickOnJsPrompt(){
        driver.findElement(jsConfirm).click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Hi I am Saumya");
        alert.accept();
        return driver.findElement(By.id("result")).getText();

    }

}
