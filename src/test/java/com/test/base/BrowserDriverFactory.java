package com.test.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.logging.Logger;

public class BrowserDriverFactory {

    private WebDriver driver;
    private String browser;
    private Logger log;

    public BrowserDriverFactory(String browser) {
        this.browser = browser;
    }

    public WebDriver createDriver() {
        //log.info("Creating Driver : "+browser);
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            return driver;

        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            return driver;
        }

        return null;
    }
}
