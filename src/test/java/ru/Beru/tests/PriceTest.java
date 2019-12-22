package ru.Beru.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.Beru.pages.BacketPage;
import ru.Beru.pages.FirstPage;
import ru.Beru.pages.signinPage;
import ru.Beru.pages.ToothPage;

public class PriceTest {
    public ChromeDriver driver;

    @Before
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver = new ChromeDriver();
    }

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
