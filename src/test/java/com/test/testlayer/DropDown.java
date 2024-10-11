package com.test.testlayer;

import com.pages.DropDownPage;
import com.pages.LandingPage;
import com.test.base.NewBaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DropDown extends NewBaseTest {
    LandingPage lp;
    DropDownPage dp;

    @Test
    public void selectDropDown(){
        lp = new LandingPage(driver);
        dp = lp.clickOnDropdown();
        dp.selectDropDown("2");
        String expectedmsg = dp.getSelectedDropDown();
        System.out.println(expectedmsg);
    }
}
