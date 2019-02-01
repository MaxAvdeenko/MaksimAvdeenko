package homeworks.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TextTestWithDataProvider {

    @DataProvider(parallel = true)
    private Object[][] textDataProvider() {
        return new Object[][]{
                {0, "To include good practices\n" + "and ideas from successful\n" + "EPAM project"},
                {1, "To be flexible and\n" + "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"}
        };
    }

    @Test(dataProvider = "textDataProvider")
    public void textTestWithDataProvider(int numberOfIcon, String textUnderIcon) {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        driver.manage().window().maximize();
        List<WebElement> textsUnderIcons = driver.findElements(By.cssSelector("[class='benefit-txt']"));
        assertTrue(textsUnderIcons.get(numberOfIcon).isDisplayed());
        assertEquals(textsUnderIcons.get(numberOfIcon).getText(), textUnderIcon);
        driver.close();
    }
}
