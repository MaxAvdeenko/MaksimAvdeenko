package homeworks.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class TextTestWithDataProvider {

    // TODO That's a bit weird, as for me.
    // TODO Basically, we put only "data" in dataProvider, rather than some kind of logic.
    @DataProvider(parallel = true)
    private Object[][] textDataProvider() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        List<WebElement> textElements = driver.findElements(By.className("benefit"));
        return new Object[][]{
                {textElements.get(0).getText(), textElements.get(0).findElement(By.cssSelector(".icons-benefit")).isDisplayed()},
                {textElements.get(1).getText(), textElements.get(1).findElement(By.cssSelector(".icons-benefit")).isDisplayed()},
                {textElements.get(2).getText(), textElements.get(2).findElement(By.cssSelector(".icons-benefit")).isDisplayed()},
                {textElements.get(3).getText(), textElements.get(3).findElement(By.cssSelector(".icons-benefit")).isDisplayed()}
        };
    }

    @Test(dataProvider = "textDataProvider")
    public void textTestWithDataProvider(String s, boolean b) {
        assertTrue(s.length() > 0 & b);
    }
}
