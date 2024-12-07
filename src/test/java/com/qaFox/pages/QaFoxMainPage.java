package com.qaFox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QaFoxMainPage {

    public QaFoxMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[.='Desktops']")
    WebElement desktopTab;

    @FindBy(xpath = "//a[.='Show AllDesktops']")
    WebElement allDesktopLink;

    public void clickOnAllDesktopLink(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(this.desktopTab).build().perform();
        Thread.sleep(3000);
        this.allDesktopLink.click();
    }





}
