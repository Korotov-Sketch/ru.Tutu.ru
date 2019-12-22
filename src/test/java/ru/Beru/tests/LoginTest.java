package ru.Beru.tests;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.Beru.pages.FirstPage;
import ru.Beru.pages.signinPage;

public class LoginTest {

    public ChromeDriver driver;

    @BeforeTest
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void TestOne(){
        String login = "olegkorotov1999@yandex.ru";
        String password ="Oleg23081999";

        FirstPage firstPage = new FirstPage(driver);
        firstPage.open();
        firstPage.openPassportPage();

        signinPage signin = new signinPage(driver);
        signin.LogIn(login);
        signin.PasswordIn(password);
        firstPage.checkProfile("Мой профиль");
        driver.close();
    }
}
