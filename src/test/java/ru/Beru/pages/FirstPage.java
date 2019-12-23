package ru.Beru.pages;

import io.qameta.allure.Step;
import org.testng.Assert;
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

public class FirstPage  {
    WebDriver driver;
    WebDriverWait wait;

    public FirstPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(css = "[data-auto=\"header-cart\"]")//корзина
    private WebElement basket;

    @FindBy(css = "[class=\"_1gW7l4dN8P _4qhIn2-ESi qAmx3n7Iqk THqSbzx07u _39B7yXQbvm\"]")//кнопка поиска
    private WebElement searchB;

    @FindBy(className = "mvd1wAJzjc")//строка поиска
    private WebElement searchL;

    @FindBy(className = "_3odNv2Dw2n")//профиль
    private WebElement profile;

    @FindBy(css = "[class=\"pFhTbV17qj\"]")//профиль в который зашли
    private WebElement profilep;

    @FindBy(className = "[href=\"/my/settings?track=menu\"]")//настройки профиля
    private WebElement settings;

    @FindBy(css = "[data-auto=\"region-form-opener\"]")//кнопка города
    private WebElement region;

    @FindBy(css = "div[data-auto=region-popup] input")//строка поиска города
    private WebElement regionstr;

    @FindBy(className = "_3iUhSNWm9l")//кнопака удаления текста
    private WebElement dltcty;

    @FindBy(className = "_229JDbp_Z8")//наш город
    private WebElement targetregion;

    @FindBy(css = "[class=\"_4qhIn2-ESi Pjv3h3YbYr THqSbzx07u\"]")//наш город
    private WebElement okcity;


    @Step("Open beru.ru")
    public void open() {
        driver.manage().window().maximize();
        driver.get("https://beru.ru/");
    }

    @Step("Check profile")
    public void checkProfile(String word) {
        wait.until(ExpectedConditions.visibilityOf(profilep));
        Assert.assertEquals(word, profilep.getText());
    }


    @Step("Open sign-in page")
    public void openPassportPage() {
        wait.until(ExpectedConditions.elementToBeClickable(profile));
        profile.click();
    }

    @Step("Проверить что город - Хвалынск")
    public void checkCity(String cityName) {
        wait.until(ExpectedConditions.visibilityOf(region));
        Assert.assertEquals(cityName, region.getText().substring(8, region.getText().length()));
    }

    @Step("Замена города на Хвалынск")
    public void ChangeCity(String cty){
        wait.until(ExpectedConditions.elementToBeClickable(region));
        region.click();
        regionstr.sendKeys("x");
        regionstr.click();
        wait.until(ExpectedConditions.elementToBeClickable(dltcty));
        dltcty.click();
        regionstr.sendKeys(cty.substring(0,cty.length()-1));
        wait.until(ExpectedConditions.elementToBeClickable(targetregion));
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        regionstr.sendKeys(cty.substring(cty.length()-1,cty.length()));
        wait.until(ExpectedConditions.elementToBeClickable(targetregion));
        targetregion.click();
        wait.until(ExpectedConditions.elementToBeClickable(okcity));
        okcity.click();
    }

    @Step("открыть настройки")
    public void opensettings() {
        wait.until(ExpectedConditions.visibilityOf(profile));
        profile.click();
        wait.until(ExpectedConditions.visibilityOf(settings));
        settings.click();
    }

    @Step ("Поиск зубных щёток")
    public void SearchTooth(){
        searchL.sendKeys("Электрические зубные щётки");
        searchB.click();
    }



}
