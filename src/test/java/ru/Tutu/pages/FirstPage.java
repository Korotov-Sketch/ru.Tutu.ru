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

public class FirstPage  {
    WebDriver driver;
    WebDriverWait wait;

    public FirstPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }



    @FindBy(className = "j-link-login")//профиль
    private WebElement profile;


    @FindBy(className = "mail_wrapper")//для ввода логина
    private WebElement login;

    @FindBy(className = "password_wrapper")//для ввода пароля
    private WebElement password;

    @FindBy(css = "[class=\"b-button__standart j-button\"]")//для входа
    private WebElement inbutton;

    @FindBy(css = "[class=\"orders_link g-link\"]")//для проверки вошли в аккаунт/не вошли
    private WebElement OrderAfterLogin;

    @FindBy(className = "j-station_input_from")//кнопка поезда
    private WebElement FromField;

    @FindBy(className = "j-station_input_to")//кнопка поезда
    private WebElement ToField;

    @FindBy(className = "ui-corner-all")//Следующий месяц для выблора месяца
    private WebElement NextMounth;

    @FindBy(className = "j-date_to")//Открытие окошка с датами
    private WebElement DataWindow;

    @FindBy(css = "[class=\"b-button__arrow__button j-button j-button-submit _title j-submit_button _blue\"]")// кнопка "найти билеты"
    private WebElement FindThatTickets;


    @Step("Open tutu.ru")
    public void open() {
        driver.manage().window().maximize();
        driver.get("https://www.tutu.ru/");
    }

    @Step("Login")
    public void Loginin(String loginmail, String passwordword) {
        wait.until(ExpectedConditions.elementToBeClickable(login));
        login.click();
        login.findElement(By.className("b-input__standart")).sendKeys(loginmail);//b-input__standart
        password.click();
        password.findElement(By.className("b-input__standart")).sendKeys(passwordword);

        inbutton.click();

    }

    @Step("Check profile")
    public void checkLogin(String word) {
        wait.until(ExpectedConditions.visibilityOf(OrderAfterLogin));
        Assert.assertEquals(word, OrderAfterLogin.getText());
    }


    @Step("Open sign-in page")
    public void openPassportPage() {
        wait.until(ExpectedConditions.elementToBeClickable(profile));
        profile.click();
    }

    @Step("Set data for ticket's")
    public void inputData(String outcity, String incity, String outData) {
        wait.until(ExpectedConditions.visibilityOf(FromField));
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

        FromField.click();
        FromField.sendKeys(outcity);

        ToField.click();
        ToField.sendKeys(incity);

        wait.until(ExpectedConditions.elementToBeClickable(DataWindow));
        DataWindow.click();
        DataWindow.sendKeys(outData);

        wait.until(ExpectedConditions.elementToBeClickable(FindThatTickets));
        FindThatTickets.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("b-train__schedule__train_card")));
    }
}
