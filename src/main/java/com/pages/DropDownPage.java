package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {
    public WebDriver driver;
    public DropDownPage(WebDriver driver) {
        this.driver = driver;
    }
    private By dropdown = By.id("dropdown");

    public void selectDropDown(String value){
        Select select = new Select(driver.findElement(dropdown));
        //select.selectByIndex();

        select.selectByValue(value);

       // select.selectByVisibleText();
    }

    public String getSelectedDropDown(){
        Select sc = new Select(driver.findElement(dropdown));
        return sc.getFirstSelectedOption().getText();
    }
}
