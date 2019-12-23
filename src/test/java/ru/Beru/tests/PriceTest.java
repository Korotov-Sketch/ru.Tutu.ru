package ru.Beru.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.Beru.WebDriverSettings;
import ru.Beru.pages.BacketPage;
import ru.Beru.pages.FirstPage;
import ru.Beru.pages.signinPage;
import ru.Beru.pages.ToothPage;

public class PriceTest  extends WebDriverSettings {


    @Test
    public void TestThree(){
        FirstPage firstPage = new FirstPage(driver);
        firstPage.open();
        firstPage.SearchTooth();

        ToothPage toothPage = new ToothPage(driver);
        toothPage.SetPrice();
        toothPage.CheckPrice();
        //toothPage.GetOne();
        toothPage.GTB();
        BacketPage backetPage = new BacketPage(driver);
        //backetPage.CheckThatStuff();
    }

}
