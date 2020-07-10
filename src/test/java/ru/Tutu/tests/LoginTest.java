package ru.Tutu.tests;


import org.testng.annotations.Test;
import ru.Tutu.WebDriverSettings;
import ru.Tutu.pages.FirstPage;

public class LoginTest extends WebDriverSettings {


    @Test
    public void TestOne(){
        String login = "olegkorotof@mail.ru";
        String password ="Oleg23081999";

        FirstPage firstPage = new FirstPage(driver);
        firstPage.open();
        firstPage.openPassportPage();
        firstPage.Loginin(login, password);
        firstPage.checkLogin("Личные заказы");

       // driver.close();
    }
}
