package homeworks.hw7;

import base.jdi.entities.User;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static homeworks.hw7.utils.DefaultDataForMetalsColors.DEFAULT_DATA_FOR_METALS_AND_COLORS;
import static homeworks.hw7.utils.MetalsAndColorsData.METALS_TEXT;
import static homeworks.hw7.utils.MetalsAndColorsData.METALS_TITLE;


public class MetalsAndColorsPageTest {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JdiSite.class);
    }

    @Test
    public void MetalsAndColorsTest() {

        //1. Open index page
        JdiSite.jdiIndexPage.open();

        //2. Log in as Piter Chailovskii
        JdiSite.jdiIndexPage.login(User.PITER);

        //3. Check that Piter Chailovskii is loggined
        JdiSite.jdiIndexPage.checkUserIsLoggined(User.PITER);

        //4. Open Metals&Colors Page by header menu
        JdiSite.jdiIndexPage.goToMetalsAndColors(METALS_TEXT);

        //5. Assert that Metals&Colors page is opened
        JdiSite.jdiIndexPage.checkTittle(WebDriverFactory.getDriver().getTitle(), METALS_TITLE);

        //6. Fill all elements
        JdiSite.metalsAndColorsPage.metalsForm.submit(DEFAULT_DATA_FOR_METALS_AND_COLORS);

        //7. Assert that all necessary elements are displayed in result log
        JdiSite.metalsAndColorsPage.checkResultLog(DEFAULT_DATA_FOR_METALS_AND_COLORS);

    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }
}
