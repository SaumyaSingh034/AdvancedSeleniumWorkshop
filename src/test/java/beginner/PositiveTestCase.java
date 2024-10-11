package beginner;

import com.pages.FormAuthenticationPage;
import com.pages.LandingPage;
import com.pages.LoggedInPage;
import com.test.base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PositiveTestCase extends BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    LandingPage landingPage;
    FormAuthenticationPage formAuthenticationPage;
    LoggedInPage loggedInPage;

    @Test
    public void logInTest(){
        landingPage = new LandingPage(driver);
        formAuthenticationPage = landingPage.clickOnFormAuthentication();
        loggedInPage = formAuthenticationPage.getLogin("tomsmith","SuperSecretPassword!");
        String expectedUrl = "https://the-internet.herokuapp.com/secure";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);

        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = loggedInPage.getMessage();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);



    }
}
