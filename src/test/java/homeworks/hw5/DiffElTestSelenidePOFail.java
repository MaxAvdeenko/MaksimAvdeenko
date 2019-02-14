package homeworks.hw5;

import base.SelenideBase;
import homeworks.hw3.enumsWithPageData.Users;
import homeworks.hw4.ex1.enumsWithDiffElementsData.NatureElements;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static homeworks.hw3.enumsWithPageData.HomePageData.HOME_PAGE_TITLE;
import static homeworks.hw3.enumsWithPageData.HomePageData.INDEX_HTML_URL;
import static homeworks.hw4.ex1.enumsWithDiffElementsData.Colors.RED;
import static homeworks.hw4.ex1.enumsWithDiffElementsData.Colors.YELLOW;
import static homeworks.hw4.ex1.enumsWithDiffElementsData.DiffElPageData.DIFFEL_PAGE_TITLE;
import static homeworks.hw4.ex1.enumsWithDiffElementsData.Metals.SELEN;
import static homeworks.hw4.ex1.enumsWithDiffElementsData.NatureElements.WATER;
import static homeworks.hw4.ex1.enumsWithDiffElementsData.NatureElements.WIND;

public class DiffElTestSelenidePOFail extends SelenideBase {

    private IndexPageAllure indexPage;
    private DiffElPageAllure diffElPage;

    @BeforeMethod
    public void initTest() {
        //1 Open test site by URL
        open(INDEX_HTML_URL.toString());
        indexPage = page(IndexPageAllure.class);

        diffElPage = page(DiffElPageAllure.class);
    }

    @AfterMethod
    public void closeTest() {
        close();
    }

    @Test
    public void DifferentElementsPageTest() {

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
        diffElPage.checkDiffElPage(DIFFEL_PAGE_TITLE);

        //8 Check interface on Different elements page, it contains all needed elements
        diffElPage.checkDiffElPageInterface();

        //9 Assert that there is Right Section
        diffElPage.checkForRightSection();

        //10 Assert that there is Left Section
        diffElPage.checkForLeftSection();

        //11 Select checkboxes
        diffElPage.clickOnNatureElement(WIND);
        diffElPage.clickOnNatureElement(WATER);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        diffElPage.checkNatureElementsLog(WIND, NatureElements.WATER);

        //13 Select radio
        diffElPage.selectMetal(SELEN);


        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        diffElPage.checkMetalsLog(SELEN);

        //15 Select in dropdown
        diffElPage.selectColor(YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        diffElPage.checkColorsLog(RED);

        //17 Unselect and assert checkboxes
        diffElPage.clickOnNatureElement(WIND);
        diffElPage.clickOnNatureElement(WATER);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        diffElPage.checkLog(WIND, NatureElements.WATER);
    }
}
