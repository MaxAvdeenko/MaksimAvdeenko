package homeworks.hw4.ex1;

import com.codeborne.selenide.Configuration;
import homeworks.hw3.enumsWithPageData.Users;
import homeworks.hw4.DiffElPageWithSelenide;
import homeworks.hw4.IndexPageWithSelenide;
import homeworks.hw4.enumsWithDiffElementsData.CheckboxData;
import homeworks.hw4.enumsWithDiffElementsData.ColorsData;
import homeworks.hw4.enumsWithDiffElementsData.RadioData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static homeworks.hw3.enumsWithPageData.HomePageData.HOME_PAGE_TITLE;
import static homeworks.hw4.enumsWithDiffElementsData.CheckboxSelectors.*;
import static homeworks.hw4.enumsWithDiffElementsData.ColorsSelectors.YELLOW_SELECTOR;
import static homeworks.hw4.enumsWithDiffElementsData.DiffElPageData.DIFFEL_PAGE_TITLE;
import static homeworks.hw4.enumsWithDiffElementsData.RadioSelectors.SELEN_SELECTOR;

public class DiffElTestSelenidePO {

    private IndexPageWithSelenide indexPage;
    private DiffElPageWithSelenide diffElPage;

    @BeforeMethod
    public void initTest() {
        //1 Open test site by URL
        open("https://epam.github.io/JDI/index.html");
        indexPage = page(IndexPageWithSelenide.class);
    }

    @AfterMethod
    public void closeTest() {
        Configuration.holdBrowserOpen = true;
        close();
    }

    @Test
    public void SimTest() {

        //2 Assert Browser title
        indexPage.checkTitle(HOME_PAGE_TITLE);

        //3 Perform login
        indexPage.login(Users.PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUserIsLoggined(Users.PITER);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        indexPage.checkServiceDropDown();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        indexPage.checkServiceLeftSection();

        //7 Open through the header menu Service -> Different Elements Page
        diffElPage = page(DiffElPageWithSelenide.class);
        diffElPage.checkDiffElPage(DIFFEL_PAGE_TITLE);

        //8 Check interface on Different elements page, it contains all needed elements
        diffElPage.checkDiffElPageInterface();

        //9 Assert that there is Right Section
        diffElPage.checkForRightSection();

        //10 Assert that there is Left Section
        diffElPage.checkForLeftSection();

        //11 Select checkboxes
        diffElPage.selectCheckboxes(WATER_SELECTOR, WIND_SELECTOR);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        diffElPage.checkboxCorrectLog(CheckboxData.values());

        //13 Select radio
        diffElPage.selectRadio(SELEN_SELECTOR);

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        diffElPage.radiosCorectLog(RadioData.values());

        //15 Select in dropdown
        diffElPage.selectColor(YELLOW_SELECTOR);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        diffElPage.colorsCorrectLog(ColorsData.values());

        //17 Unselect and assert checkboxes
        diffElPage.unselectCheckboxes(EARTH_SELECTOR, FIRE_SELECTOR);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        diffElPage.checkLog();
    }
}
