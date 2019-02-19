package homeworks.hw6;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.close;

@CucumberOptions(features = {"src/test/resources/hw6/ex1", "src/test/resources/hw6/ex2"},
        glue = {"classpath:homeworks.hw6.ex1.steps", "classpath:homeworks.hw6.ex2"})
public class Runner extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void beforeSuite() {
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
        Configuration.startMaximized = true;
    }

    @AfterMethod
    public void closeBrowser() {
        close();
    }
}
