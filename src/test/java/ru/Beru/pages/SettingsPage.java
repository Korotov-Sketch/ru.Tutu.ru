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

public class SettingsPage {
    WebDriver driver;
    WebDriverWait wait;

    public SettingsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    @FindBy(css = "[class=\"_3l-uEDOaBN tdrs43E7Xn _3HJsMt3YC_\"]") //город в настройках
    private WebElement city;

    @FindBy(css = "[data-auto=\"region-form-opener\"]")//кнопка города
    private WebElement region;

    @Step("check city")
    public void check() {
        wait.until(ExpectedConditions.visibilityOf(city));
        Assert.assertEquals(city.getText(), region.getText().substring(8,region.getText().length()));
    }
}

