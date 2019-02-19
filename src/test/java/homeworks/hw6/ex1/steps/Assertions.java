package homeworks.hw6.ex1.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import homeworks.hw3.enumsWithPageData.HomePageData;
import homeworks.hw3.enumsWithPageData.Users;
import homeworks.hw4.ex1.enumsWithDiffElementsData.Colors;
import homeworks.hw4.ex1.enumsWithDiffElementsData.Metals;
import homeworks.hw4.ex1.enumsWithDiffElementsData.NatureElements;
import homeworks.hw6.enums.ServiceData;
import homeworks.hw6.ex1.DiffElPagePO;
import homeworks.hw6.ex1.IndexPagePO;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class Assertions {
    private IndexPagePO indexPagePO = page(IndexPagePO.class);
    private DiffElPagePO diffElPage = page(DiffElPagePO.class);

    @Then("^Title should be '(.+)'$")
    public void checkTitle(HomePageData title) {
        indexPagePO.checkTitle(title);
    }

    @Then("^Username should be as for '(.+)'$")
    public void checkUsername(Users user) {
        indexPagePO.checkUserIsLoggined(user);
    }

    @And("^There are 4 images, texts, headline and description$")
    public void checkElements() {
        indexPagePO.checkAllElements();
    }

    @Then("^Service dropdown menu contains all options:$")
    public void checkAllOptions(List<ServiceData> options) {
        indexPagePO.checkService(options);
    }

    @Then("^Left Service dropdown menu contains all same options like in the header Service$")
    public void checkLeftServiceMenu() {
        indexPagePO.checkServiceLeftSection();
    }

    @Then("^I check that Different Elements page contains all need elements$")
    public void checkDiffElPage() {
        diffElPage.checkDiffElPageInterface();
    }

    @Then("^I check that Right section is displayed$")
    public void checkRightSection() {
        diffElPage.checkForRightSection();
    }

    @Then("^I check that Left section is displayed$")
    public void checkLeftSection() {
        diffElPage.checkForLeftSection();
    }

    @Then("^I check that there is a log for '(.+)' and '(.+)' checkboxes$")
    public void iCheckThatThereIsALogForSelectedCheckboxes(NatureElements water, NatureElements wind) {
        diffElPage.checkNatureElementsLog(wind, water);
    }

    @Then("^I check that there is a log for '(.+)' radio$")
    public void iCheckThatThereIsALogForSELEN(Metals metal) {
        diffElPage.checkMetalsLog(metal);
    }

    @Then("^I check that there is a log for '(.+)' color$")
    public void iCheckThatThereIsALogForYELLOWColor(Colors color) {
        diffElPage.checkColorsLog(color);
    }

    @Then("^I check that there is a log for '(.+)' and '(.+)' and they are unselected$")
    public void iCheckThatThereIsALogForWATERAndWINDAndTheyAreUnselected(NatureElements element,
                                                                         NatureElements element2) {
        diffElPage.checkLog(element, element2);
    }
}
