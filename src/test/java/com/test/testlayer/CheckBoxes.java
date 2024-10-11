package com.test.testlayer;

import com.pages.CheckBoxesPage;
import com.pages.LandingPage;
import com.test.base.BaseTest;
import com.test.base.NewBaseTest;
import org.testng.annotations.Test;

public class CheckBoxes extends NewBaseTest {
    LandingPage landingPage;
    CheckBoxesPage checkBoxesPage;

    @Test
    public void selectCheckBoxes(){
        landingPage = new LandingPage(driver);
        checkBoxesPage = landingPage.clickOnCheckBoxes();
        checkBoxesPage.selectBothCheckBoxes();
        checkBoxesPage.unCheckBothCheckBoxes();
        checkBoxesPage.clickOnCheckBox1();
        checkBoxesPage.clickOnCheckBox2();

    }
}
