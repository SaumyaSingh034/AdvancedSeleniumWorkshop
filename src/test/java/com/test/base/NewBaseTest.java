package com.test.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class NewBaseTest {
    protected WebDriver driver;
    protected Logger log;

    @BeforeMethod
    public void setUpBrowser(){
        BrowserDriverFactory driverFactory = new BrowserDriverFactory("chrome");
        driver = driverFactory.createDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://the-internet.herokuapp.com/");

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}