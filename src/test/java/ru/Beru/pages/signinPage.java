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

public class signinPage {
    WebDriver driver;
    WebDriverWait wait;

    public signinPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(id = "passp-field-login")
    private WebElement fieldLogin;

    @FindBy(id = "passp-field-passwd")
    private WebElement fieldPassword;

    @FindBy(css = "[class=\"passp-button passp-sign-in-button\"]")
    private WebElement button;

    @Step("Fill login field {login}")
    public void LogIn(String login) {
        wait.until(ExpectedConditions.visibilityOf(fieldLogin));
        fieldLogin.sendKeys(login);
        button.click();
    }

    @Step("Fill passport field {password}")
    public void PasswordIn(String password) {
        wait.until(ExpectedConditions.visibilityOf(fieldPassword));
        fieldPassword.sendKeys(password);
        button.click();
    }
}
