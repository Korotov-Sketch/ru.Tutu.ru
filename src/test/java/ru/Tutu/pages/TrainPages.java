package ru.Tutu.pages;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TrainPages {

    WebDriver driver;
    WebDriverWait wait;

    public TrainPages(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    @FindBy(className = "b-train__schedule__page_header")//Открытие окошка с датами
    private WebElement TrainFounded;

    @Step("Check That train was founded")
    public void CheckThatTrainFounded() {
        wait.until(ExpectedConditions.visibilityOf(TrainFounded));
        Assert.assertEquals("Выберите поезд, чтобы заказать билеты онлайн\n" +
                "Москва → Санкт-Петербург, 23 августа 2020, воскресенье", TrainFounded.getText());
    }
}
