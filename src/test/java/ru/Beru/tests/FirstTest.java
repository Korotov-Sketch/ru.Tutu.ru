package ru.Beru.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.Beru.tests.PriceTest;
import ru.Beru.tests.CityTest;
import ru.Beru.tests.LoginTest;

import java.util.concurrent.TimeUnit;

public class FirstTest {
public  ChromeDriver driver;

    @Before
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Test
    public void firstTest() {

        driver.manage().window().maximize();

        driver.get("https://beru.ru/");

        WebElement signin = driver.findElement(By.className("_3odNv2Dw2n"));
        signin.click();

        WebDriverWait wat = new WebDriverWait(driver,10);
        wat.until(ExpectedConditions.visibilityOfElementLocated(By.id("passp-field-login")));

        WebElement writer = driver.findElement(By.id("passp-field-login"));
        writer.sendKeys("olegkorotov1999@yandex.ru");
        signin = driver.findElementByClassName("passp-sign-in-button");
        signin.click();

        wat.until(ExpectedConditions.visibilityOfElementLocated(By.id("passp-field-passwd")));

        writer = driver.findElement(By.id("passp-field-passwd"));
        writer.sendKeys("Oleg23081999");
        signin = driver.findElementByClassName("passp-form-button");
        signin.click();

        wat.until(ExpectedConditions.visibilityOfElementLocated(By.className("pFhTbV17qj")));

        writer = driver.findElement(By.className("pFhTbV17qj"));
        System.out.println(writer.getText());
    }
    @Test
    public void secondTest() {

        driver.manage().window().maximize();
        WebDriverWait wat = new WebDriverWait(driver,10);
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        driver.get("https://beru.ru/");

        WebElement signin = driver.findElement(By.cssSelector("[data-auto=\"region-form-opener\"]"));
        signin.click();//переход в окно с городами
        wat.until(ExpectedConditions.visibilityOfElementLocated(By.className("_8iW7gwBP58")));


        WebElement writer = driver.findElement(By.cssSelector("div[data-auto=region-popup] input"));
        writer.sendKeys("Х");//вводим х для удаления
        writer.click();//_3iUhSNWm9l
        signin = driver.findElement(By.className("_3iUhSNWm9l"));
        signin.click();//Удалить весь текст в поле

        writer.sendKeys("хвалынс");//вводим хвалынс
        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
        writer.sendKeys("к");//вводим к
        writer.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_229JDbp_Z8")));//Ждём пока не появится хвалынск

        signin = driver.findElement(By.className("_229JDbp_Z8"));//выбраем хвалынск
        signin.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"_4qhIn2-ESi Pjv3h3YbYr THqSbzx07u\"]")));
        signin = driver.findElement(By.cssSelector("[class=\"_4qhIn2-ESi Pjv3h3YbYr THqSbzx07u\"]"));//кнопка подтверждения
        signin.click();

        firstTest();//вызываем первый тест что бы залогиниться

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-apiary-widget-name=\"@marketplace/Auth\"]")));
        signin = driver.findElement(By.cssSelector("[data-apiary-widget-name=\"@marketplace/Auth\"]"));//кнопка профиля
        signin.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href=\"/my/settings?track=menu\"]")));
        signin = driver.findElement(By.cssSelector("[href=\"/my/settings?track=menu\"]"));//кнопка настройки
        signin.click();

        signin = driver.findElement(By.cssSelector("[class=\"_3l-uEDOaBN tdrs43E7Xn _3HJsMt3YC_\"]"));//Город
        System.out.println(signin.getText());

        //wat.until(ExpectedConditions.visibilityOfElementLocated(By.id("abrakadabra")));
    }

    @Test
    public void thirdTest() {
        WebDriverWait wait = new WebDriverWait(driver,20);

        driver.manage().window().maximize();
        driver.get("https://beru.ru/");
        WebElement signin = driver.findElement(By.className("mvd1wAJzjc"));
        signin.sendKeys("электрические зубные щётки");
        signin = driver.findElement(By.cssSelector("[class=\"_1gW7l4dN8P _4qhIn2-ESi qAmx3n7Iqk THqSbzx07u _39B7yXQbvm\"]"));
        signin.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-auto=\"filter-range-glprice\"]//span[@data-auto=\"filter-range-min\"]//input")));

        signin = driver.findElement(By.xpath("//div[@data-auto=\"filter-range-glprice\"]//span[@data-auto=\"filter-range-min\"]//input"));
        signin.sendKeys("999");

        signin = driver.findElement(By.xpath("//div[@data-auto=\"filter-range-glprice\"]//span[@data-auto=\"filter-range-max\"]//input"));
        signin.sendKeys("1999");

        signin = driver.findElement(By.cssSelector("[class=\"_1pTV0mQZJz _29G9cgzIkc _3LMhEMfZeH\"]"));
        System.out.println(signin.getText());


        //добавление предпоследнего эл-та (почему-то странно работает(не работает))
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"_1uhsh_io8o\"]//div[@class=\"_3rWYRsam78\"][last()]/div[last()]//div[@class=\"_1RjY7YIluf _1zYszmgEzn\"][last()-1]//span[@class=\"_2w0qPDYwej\"]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"_1uhsh_io8o\"]//div[@class=\"_3rWYRsam78\"][last()]/div[last()]//div[@class=\"_1RjY7YIluf _1zYszmgEzn\"][last()-1]//span[@class=\"_2w0qPDYwej\"]")));
        signin = driver.findElement(By.xpath("//div[@class=\"_1uhsh_io8o\"]//div[@class=\"_3rWYRsam78\"][last()]/div[last()]//div[@class=\"_1RjY7YIluf _1zYszmgEzn\"][last()-1]//span[@class=\"_2w0qPDYwej\"]"));
        signin.click();

        //переход в корзину
        signin = driver.findElement(By.cssSelector("[data-auto=\"header-cart\"]"));
        signin.click();

        //проверка надписи о бесплатной доставке
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-apiary-widget-name=\"@marketplace/CartDeliveryThreshold\"]")));
        signin = driver.findElement(By.cssSelector("[class=\"_3e5zCA3HUO\"]"));

        String a =(signin.getText());
        a = a.substring(0, 1);

        while(a!="П") {//пока а !=п т.к. при бесплатной доставке  будет фраза поздравляем
            a = a.substring(0, 1);
            signin = driver.findElement(By.cssSelector("[class=\"_4qhIn2-ESi _2sJs248D-A _18c2gUxCdP _3hWhO4rvmA\"]"));
            signin.click();
            driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-apiary-widget-name=\"@marketplace/CartDeliveryThreshold\"]")));
            signin =driver.findElement(By.cssSelector("[class=\"_3e5zCA3HUO\"]"));
            a =(signin.getText());
            a = a.substring(0, 1);
        }
        System.out.println(a);







        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("abrakadabrabobra")));

    }

    @After
    public void Leave(){
        driver.quit();
    }

}
