package homeworks.hw6.ex1.steps;

import cucumber.api.java.en.When;
import homeworks.hw3.enumsWithPageData.Users;
import homeworks.hw4.ex1.enumsWithDiffElementsData.Colors;
import homeworks.hw4.ex1.enumsWithDiffElementsData.Metals;
import homeworks.hw4.ex1.enumsWithDiffElementsData.NatureElements;
import homeworks.hw6.ex1.DiffElPagePO;
import homeworks.hw6.ex1.IndexPagePO;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class Actions {
    private IndexPagePO indexPagePO = page(IndexPagePO.class);
    private DiffElPagePO diffElPage = page(DiffElPagePO.class);

    @When("^I login as '(.+)'$")
    public void login(Users user) {
        indexPagePO.login(user);
    }

    @When("^I click on Service in the header$")
    public void clickOnService() {
        indexPagePO.clickService();
    }

    @When("^I click on Service in the left section$")
    public void clickOnServiceAtTheLeft() {
        indexPagePO.clickLeftService();
    }

    @When("^I open '(.+)' Page$")
    public void openAnySevicePage(String title) {
        indexPagePO.openAnyServicePage(title);
    }

   /* @When("^I click on checkboxes '(.+)' and '(.+)'$")
    public void iClickOnCheckboxesWATERAndWIND(NatureElements water, NatureElements wind) {
        diffElPage.clickOnNatureElement(water, wind);
    }*/

    @When("^I click on radio '(.+)'$")
    public void iClickOnRadioSELEN(Metals metal) {
        diffElPage.selectMetal(metal);
    }

    @When("^I click on colors dropdown$")
    public void iClickOnColorsDropdown() {
        diffElPage.clickOnColorsDropdown();
    }

    @When("^I select '(.+)' color$")
    public void iSelectYELLOWColor(Colors color) {
        diffElPage.selectColor(color);
    }

    /*@When("^I unselect checkboxes '(.+)' and '(.+)'$")
    public void iUnselectCheckboxesWATERAndWIND(NatureElements element, NatureElements element2) {
        diffElPage.clickOnNatureElement(element, element2);
    }*/

    @When("^I select necessary checkboxes$")
    public void iSelectNecessaryCheckboxes(List<NatureElements> elements) {
        diffElPage.selectNatureEl(elements);
    }

    @When("^I unselect checkboxes necessary checkboxes$")
    public void iUnselectCheckboxesNecessaryCheckboxes(List<NatureElements> elements) {
        diffElPage.selectNatureEl(elements);
    }
}
