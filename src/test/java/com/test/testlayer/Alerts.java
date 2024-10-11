package com.test.testlayer;

import com.pages.AlertsPage;
import com.pages.LandingPage;
import com.test.base.NewBaseTest;
import org.testng.annotations.Test;

public class Alerts extends NewBaseTest {
    LandingPage lp;
    AlertsPage ap;

    @Test
    public void alertPractice(){
        lp = new LandingPage(driver);
        ap = lp.clickOnJavaScriptAlerts();
        String alertText = ap.clickOnjsAlert();
        System.out.println(alertText);
        ap.clickOnJsConfirm();
        String text = ap.clickOnJsPrompt();
        System.out.println(text);

    }
}
