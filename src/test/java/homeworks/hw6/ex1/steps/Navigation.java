package homeworks.hw6.ex1.steps;

import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;
import static homeworks.hw3.enumsWithPageData.HomePageData.INDEX_HTML_URL;

public class Navigation {
    @Given("^I open EPAM JDI site Home page$")
    public void openSite() {
        open(INDEX_HTML_URL.toString());
    }
}
