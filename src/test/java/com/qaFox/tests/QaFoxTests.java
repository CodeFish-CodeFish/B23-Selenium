package com.qaFox.tests;

import com.qaFox.pages.QaFoxDesktopPage;
import com.qaFox.pages.QaFoxMainPage;
import org.junit.Before;
import org.junit.Test;
import testBase.TestBase;

public class QaFoxTests extends TestBase {

    @Test
    public void TC_100() throws InterruptedException {

        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
        QaFoxMainPage mainPage = new QaFoxMainPage(driver);
        mainPage.clickOnAllDesktopLink(driver);

        QaFoxDesktopPage desktopPage = new QaFoxDesktopPage(driver);
        desktopPage.selectAtoZAndShowAllRecords();

    }

}
