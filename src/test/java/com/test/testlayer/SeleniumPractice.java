package com.test.testlayer;

import com.test.base.NewBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class SeleniumPractice extends NewBaseTest {

    @Test
    public void multipleWindows(){
        driver.findElement(By.linkText("Multiple Windows")).click();
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(parent);
        String text = driver.findElement(By.tagName("h3")).getText();
        System.out.println(text);
    }

}
