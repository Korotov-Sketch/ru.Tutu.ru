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

public class BacketPage {
    WebDriver driver;
    WebDriverWait wait;

    public BacketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(css = "[data-apiary-widget-name=\"@marketplace/CartDeliveryThreshold\"]")
    private WebElement Delivery;


    @Step("пока а !=п т.к. при бесплатной доставке  будет фраза поздравляем")
    public void CheckThatStuff() {
        wait.until(ExpectedConditions.visibilityOf(Delivery));

        String a =(Delivery.getText());
        a = a.substring(0, 1);

        while(a!="П") {//пока а !=п т.к. при бесплатной доставке  будет фраза поздравляем
            a = a.substring(0, 1);
            Delivery = driver.findElement(By.cssSelector("[class=\"_4qhIn2-ESi _2sJs248D-A _18c2gUxCdP _3hWhO4rvmA\"]"));
            Delivery.click();
            driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-apiary-widget-name=\"@marketplace/CartDeliveryThreshold\"]")));
            Delivery =driver.findElement(By.cssSelector("[class=\"_3e5zCA3HUO\"]"));
            a =(Delivery.getText());
            a = a.substring(0, 1);
    }

    //проверка надписи о бесплатной доставке

    }

}
