package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

public class SauceHomePage {

    public SauceHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "select[class='product_sort_container']")
    WebElement sortDropdown;

    @FindBy(css = "#add-to-cart-sauce-labs-bike-light")
    WebElement bikeLightItem;


    // Action method related to your WebElements
    public void priceLowToHighAndChooseProduct() throws InterruptedException {
        BrowserUtils.selectBy(this.sortDropdown, "lohi", "byValue");
        Thread.sleep(2000);
        this.bikeLightItem.click();
    }




}
