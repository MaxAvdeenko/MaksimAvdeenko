package homeworks.hw4.ex1;

import com.codeborne.selenide.Configuration;
import homeworks.hw3.enumsWithPageData.Users;
import homeworks.hw4.IndexPageWithSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static homeworks.hw3.enumsWithPageData.HomePageData.HOME_PAGE_TITLE;

public class IndexPageTestSelenidePO {

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
    }
}
