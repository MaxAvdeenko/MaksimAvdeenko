package homeworks.hw4.ex1;

import com.codeborne.selenide.Configuration;
import homeworks.hw4.DiffElPageWithSelenide;
import homeworks.hw4.enumsWithDiffElementsData.DiffElPageData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;
import static homeworks.hw4.enumsWithDiffElementsData.DiffElPageData.*;

public class DiffElPageTestSelenidePO {
    private DiffElPageWithSelenide diffElPage;

    @BeforeMethod
    public void initTest() {
        diffElPage = page(DiffElPageWithSelenide.class);
    }

    @AfterMethod
    public void closeTest() {
        Configuration.holdBrowserOpen = true;
        close();
    }

    @Test
    public void DiffElTest() {
        //7 Open through the header menu Service -> Different Elements Page
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
        diffElPage.checkboxCorrectLog(DiffElPageData.values());
/*
        //13 Select radio
        diffElPage.selectRadio();*/
    }
}
