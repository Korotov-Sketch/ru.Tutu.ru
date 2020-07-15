package ru.Tutu.tests;

import org.testng.annotations.Test;
import ru.Tutu.WebDriverSettings;
import ru.Tutu.pages.FirstPage;
import ru.Tutu.pages.TrainPages;

public class TrainCheckTest extends WebDriverSettings {


    @Test
    public void TrainCheckTest(){
        FirstPage firstPage = new FirstPage(driver);
        TrainPages trainPage = new TrainPages(driver);
        firstPage.open();
        firstPage.inputData("Москва","Санкт-Петербург","23.08.2020");
        trainPage.CheckThatTrainFounded();
    }

}