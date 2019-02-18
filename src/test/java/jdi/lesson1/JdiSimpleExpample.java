package jdi.lesson1;

import base.jdi.lesson1.JdiSite;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JdiSimpleExpample {

   /* IndexPageJdi indexPageJdi;
    private WebDriver driver;*/

    @BeforeSuite
    public void beforeSuite() {
        /*setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        indexPageJdi = PageFactory.initElements(driver, IndexPageJdi.class);*/
        PageFactory.initElements(JdiSite.class);
    }

    @Test
    public void SimpleJdiTest() {
        //indexPageJdi.login("epam", "1234");
        JdiSite.indexPageJdi.open();
        JdiSite.indexPageJdi.login("epam","1234");
    }

    @AfterSuite
    public void afterSuite(){
        WebDriverFactory.close();
        /*driver.close();*/
    }
}
