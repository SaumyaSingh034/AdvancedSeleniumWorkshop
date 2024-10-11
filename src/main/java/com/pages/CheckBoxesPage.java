package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxesPage {
    WebDriver driver;

    public CheckBoxesPage(WebDriver driver){
        this.driver = driver;

    }

    private By checkboxes = By.xpath("//form[@id='checkboxes']/input");

    public void clickOnCheckBox1(){
        driver.findElement(checkboxes).click();
    }

    public void clickOnCheckBox2(){
        driver.findElements(checkboxes).get(1).click();
    }

    public void selectBothCheckBoxes(){
        List<WebElement> boxes =  driver.findElements(checkboxes);
        for(WebElement w : boxes){
            if(!w.isSelected())
                w.click();
        }
    }

    public void unCheckBothCheckBoxes(){
        List<WebElement> boxes =  driver.findElements(checkboxes);
        for(WebElement w : boxes){
            if(w.isSelected())
                w.click();
        }
    }
}
