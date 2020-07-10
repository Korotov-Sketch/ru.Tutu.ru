package ru.Tutu.tests;

import org.testng.annotations.Test;
import ru.Tutu.WebDriverSettings;
import ru.Tutu.pages.FirstPage;

public class PriceTest  extends WebDriverSettings {


    @Test
    public void TestThree(){
        String login = "olegkorotof@mail.ru";
        String password ="Oleg23081999";

        FirstPage firstPage = new FirstPage(driver);
        firstPage.open();
        //firstPage.openPassportPage();
        //firstPage.Loginin(login, password);
        firstPage.inputData("Москва","Санкт-Петербург","23.08.2020");
    }

}
