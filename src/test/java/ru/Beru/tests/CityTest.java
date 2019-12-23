package ru.Beru.tests;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.Beru.WebDriverSettings;
import ru.Beru.pages.FirstPage;
import ru.Beru.pages.SettingsPage;
import ru.Beru.pages.signinPage;
public class CityTest extends WebDriverSettings {



    @Test
    public void TestTwo(){

        String login = "olegkorotov1999@yandex.ru";
        String password ="Oleg23081999";//

        FirstPage firstPage = new FirstPage(driver);
        firstPage.open();
        firstPage.ChangeCity("Хвалынск");

        firstPage.checkCity("Хвалынск");//раскомментить

        firstPage.openPassportPage();

        signinPage signin = new signinPage(driver);
        signin.LogIn(login);
        signin.PasswordIn(password);

        //firstPage.opensettings();//раскомментить (доработать)

        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.check();
    }
}
