package lesson2;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class SimpleTestWithDataProvider extends SeleniumBase {

    @DataProvider
    private Object[][] simpleProvider() {
        return new Object[][]{
                {0, "Ivan"},
                {1, "Roman"},
                {2, "dima"}
        };
    }

    @Test(dataProvider = "simpleProvider")
    public void simpleTest(int i, String s) {
        System.out.println("int = " + i + "\n" + "String = " + s);


    }
}
