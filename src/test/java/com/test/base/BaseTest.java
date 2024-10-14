package com.test.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected Logger log;
    String browser = "chrome";

    /*@Parameters({"browser"})*/
    @BeforeMethod(alwaysRun = true)
    public void setUpData(String browser){
//        String testName = context.getCurrentXmlTest().getName();
//        log = LogManager.getLogger(testName);
        BrowserDriverFactory driverFactory = new BrowserDriverFactory(browser);
        driver = driverFactory.createDriver();

      /*  WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();*/
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://the-internet.herokuapp.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
