package homeworks.hw7;

import base.jdi.entities.User;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import homeworks.hw7.enums.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static homeworks.hw7.enums.MetalsAndColorsData.METALS_TEXT;
import static homeworks.hw7.enums.MetalsAndColorsData.METALS_TITLE;
import static homeworks.hw7.enums.NatureElements.FIRE;
import static homeworks.hw7.enums.NatureElements.WATER;


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

        //6. Select 3 from odd
        JdiSite.metalsAndColorsPage.selectOdd(Odd.TREE);

        //7. Assert that 3 is selected
        JdiSite.metalsAndColorsPage.checkOddLog(Odd.TREE);

        //8. Select 8 from even
        JdiSite.metalsAndColorsPage.selectEven(Even.EIGHT);

        //9. Assert that 8 is selected
        JdiSite.metalsAndColorsPage.checkEvenLog(Even.EIGHT);

        //10. Select Water and Fire from Elements
        JdiSite.metalsAndColorsPage.selectNatureElements(WATER, FIRE);

        //11. Assert that Water and Fire are selected
        JdiSite.metalsAndColorsPage.checkNatElLog(WATER, FIRE);

        //12. Select Red from colors
        JdiSite.metalsAndColorsPage.selectColor(Colors.RED);

        //13. Assert that Red color is selected
        JdiSite.metalsAndColorsPage.checkColorsLog(Colors.RED);

        //14. Select Selen from Metals
        JdiSite.metalsAndColorsPage.selectMetal(Metals.SELEN);

        //15. Assert that Selen is selected
        JdiSite.metalsAndColorsPage.checkMetalsLog(Metals.SELEN);

        //16. Select Cucumber and Tomato from vegetables
        JdiSite.metalsAndColorsPage.selectVegetables(Vegetables.CUCUMBER, Vegetables.TOMATO);

        //17. Click on submit button
        JdiSite.metalsAndColorsPage.clickSubmit();

        //18. Assert that submit button is clicked
        JdiSite.metalsAndColorsPage.checkSubmitIsClicked();

        //19. Assert that all necessary elements are displayed in result log
        JdiSite.metalsAndColorsPage.checkResultLog(Odd.TREE, Even.EIGHT, WATER, FIRE, Colors.RED, Metals.SELEN,
                Vegetables.CUCUMBER, Vegetables.TOMATO);

    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }
}
