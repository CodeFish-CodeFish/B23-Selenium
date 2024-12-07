package com.qaFox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

public class QaFoxDesktopPage {

    public QaFoxDesktopPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#input-sort")
    WebElement sortByDropdown;

    @FindBy(css = "#input-limit")
    WebElement showDropdown;

    public void selectAtoZAndShowAllRecords(){
        BrowserUtils.selectBy(this.sortByDropdown, "Model (A - Z)", "visibleText");
        BrowserUtils.selectBy(this.showDropdown, "4", "byIndex");
    }



}
