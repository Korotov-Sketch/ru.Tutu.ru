package ru.Tutu.tests;


import org.testng.annotations.Test;
import ru.Tutu.WebDriverSettings;
import ru.Tutu.pages.FirstPage;

public class LoginTest extends WebDriverSettings {


    @Test
    public void LoginTest(){
        FirstPage firstPage = new FirstPage(driver);
        firstPage.open();
        firstPage.openPassportPage();
        firstPage.Loginin("olegkorotof@mail.ru", "Oleg23081999");
        firstPage.checkLogin("Личные заказы");
        firstPage.GetOutOfThere();

    }
}