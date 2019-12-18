package ru.Beru.pages;


import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ToothPage {
    WebDriver driver;
    WebDriverWait wait;

    public ToothPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }


    @FindBy(xpath = "//div[@data-auto=\"filter-range-glprice\"]//span[@data-auto=\"filter-range-min\"]//input") //999
    private WebElement LowPrice;

    @FindBy(xpath = "//div[@data-auto=\"filter-range-glprice\"]//span[@data-auto=\"filter-range-max\"]//input") //1999
    private WebElement MaxPrice;

    @FindBy(css = "[class=\"_3GNV1gy3cc\"]")
    private WebElement PriceRange;

    @FindBy(xpath = "//div[@class=\"_1uhsh_io8o\"]//div[@class=\"_3rWYRsam78\"][last()]/div[last()]//div[@class=\"_1RjY7YIluf _1zYszmgEzn\"][last()-1]//span[@class=\"_2w0qPDYwej\"]")
    private WebElement brush;

    @FindBy(css = "[data-auto=\"header-cart\"]")
    private WebElement basket;


    @Step("Low To Max")
    public void SetPrice() {
        wait.until(ExpectedConditions.visibilityOf(LowPrice));
        LowPrice.sendKeys("999");
        MaxPrice.sendKeys("1999");
    }

    @Step("CheckPrice")
    public void CheckPrice() {
        wait.until(ExpectedConditions.visibilityOf(PriceRange));
        String priceRange = "999" + " — " + "1999" + " ₽";
        Assert.assertEquals(priceRange, PriceRange.getText());
    }

    @Step("Add one")
    public void GetOne() {

            wait = new WebDriverWait(driver, 5);
            wait.withTimeout(10, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.elementToBeClickable(brush));
            brush.click();
            wait.until(ExpectedConditions.elementToBeClickable(brush));
    }

    @Step("Add one")
    public void GTB() {//go to basket
        wait.until(ExpectedConditions.elementToBeClickable(basket));
        basket.click();

    }
}


