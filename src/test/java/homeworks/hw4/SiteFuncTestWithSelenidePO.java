package homeworks.hw4;

import com.codeborne.selenide.Configuration;
import homeworks.hw3.enumsWithPageData.Users;
import homeworks.hw4.enumsWithDiffElementsData.CheckboxEnum;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static homeworks.hw3.enumsWithPageData.HomePageData.HOME_PAGE_TITLE;
import static homeworks.hw4.enumsWithDiffElementsData.CheckboxEnum.WATER_SELECTOR;
import static homeworks.hw4.enumsWithDiffElementsData.CheckboxEnum.WIND_SELECTOR;

public class SiteFuncTestWithSelenidePO {

    private IndexPageWithSelenide indexPage;

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
        indexPage.checkDiffElPage();

        //8 Check interface on Different elements page, it contains all needed elements
        indexPage.checkDiffElPageInterface();

        //9 Assert that there is Right Section
        indexPage.checkForRightSection();

        //10 Assert that there is Left Section
        indexPage.checkForLeftSection();

        //11 Select checkboxes
        indexPage.selectCheckboxes(WATER_SELECTOR, WIND_SELECTOR);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        indexPage.checkboxCorrectLog(CheckboxEnum.values());
/*
        //13 Select radio
        indexPage.selectRadio();*/

    }
}
