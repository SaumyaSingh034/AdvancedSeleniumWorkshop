package beginner;

import com.pages.FormAuthenticationPage;
import com.pages.LandingPage;
import com.pages.LoggedInPage;
import com.test.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class NegativeTestCase extends BaseTest {
    WebDriver driver;
    LandingPage landingPage;
    FormAuthenticationPage formAuthenticationPage;
    LoggedInPage loggedInPage;

    @Parameters({ "username", "password", "expectedMessage" })
    @Test(priority = 1)
    public void negativeTest(String username, String password, String expectedErrorMessage) {
        log.info("Starting negativeTest");

        // open main page

        log.info("Main page is opened.");
        landingPage = new LandingPage(driver);
        formAuthenticationPage = landingPage.clickOnFormAuthentication();
        loggedInPage = formAuthenticationPage.getLogin(username,password);

        // Verification
        String actualErrorMessage = loggedInPage.getMessage();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
                        + expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
    }

}
