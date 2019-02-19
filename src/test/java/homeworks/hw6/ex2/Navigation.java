package homeworks.hw6.ex2;

import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;
import static homeworks.hw3.enumsWithPageData.HomePageData.INDEX_HTML_URL;

public class Navigation {
    @Given("^I am on Home Page$")
    public void openSite() {
        open(INDEX_HTML_URL.toString());
    }
}
