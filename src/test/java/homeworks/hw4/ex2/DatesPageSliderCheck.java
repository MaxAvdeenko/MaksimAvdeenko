package homeworks.hw4.ex2;

import base.SelenideBase;
import homeworks.hw3.enumsWithPageData.Users;
import homeworks.hw4.ex1.IndexPageWithSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static homeworks.hw3.enumsWithPageData.HomePageData.HOME_PAGE_TITLE;
import static homeworks.hw3.enumsWithPageData.HomePageData.INDEX_HTML_URL;
import static homeworks.hw4.ex2.DatesPageData.DATES_PAGE_TITLE;

public class DatesPageSliderCheck extends SelenideBase {
    private DatesPageWithSelenide datesPage;
    private IndexPageWithSelenide indexPage;

    @BeforeMethod
    public void initTest() {
        //1 Open test site by URL
        open(INDEX_HTML_URL.toString());
        datesPage = page(DatesPageWithSelenide.class);
        indexPage = page(IndexPageWithSelenide.class);
    }

    @AfterMethod
    public void closeTest() {
        close();
    }

    @Test
    public void DatesPageTest() {
        //2 Assert Browser title
        indexPage.checkTitle(HOME_PAGE_TITLE);

        //3 Perform login
        indexPage.login(Users.PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUserIsLoggined(Users.PITER);

        //5 Open through the header menu Service -> Dates Page
        datesPage.openDatesPage(DATES_PAGE_TITLE);

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPage.setSliderPosition(0, 100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogs(0, 100);

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPage.setSliderPosition(0, 0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogs(0, 0);

        //10 Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        datesPage.setSliderPosition(100, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogs(100, 100);

        //12 Using drag-and-drop set Range sliders. From = 30, To = 70
        datesPage.setSliderPosition(30, 70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogs(30, 70);
    }

}
