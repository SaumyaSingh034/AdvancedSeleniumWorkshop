package com.test.testlayer;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CheckLinks {
    WebDriver driver;

    @Test
    public void testAmazonLinks(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        List<WebElement> links =  driver.findElements(By.tagName("a"));
        System.out.println("No. of Links are : "+links.size());

        for(WebElement e : links){
            String url = e.getAttribute("href");
            checkBrokenLink(url);
        }

        driver.quit();
    }

    private void checkBrokenLink(String urlLink) {
        try {
            URL url = new URL(urlLink);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            if(connection.getResponseCode() >=400){
                System.out.println(urlLink+" ---------> "+connection.getResponseMessage()+" is broken");
            } else {
                System.out.println(urlLink+" ---------> "+connection.getResponseMessage()+" is wokring fine");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
