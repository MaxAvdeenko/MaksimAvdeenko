package homeworks.hw6.ex2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import homeworks.hw3.enumsWithPageData.Users;
import homeworks.hw6.ex1.IndexPagePO;

import static com.codeborne.selenide.Selenide.page;

public class Actions {

    private IndexPagePO indexPagePO = page(IndexPagePO.class);
    private UserTablePO userTablePO = page(UserTablePO.class);

    @And("^I login as user '(.+)'$")
    public void login(Users user) {
        indexPagePO.login(user);
    }

    @When("^I click on Service button in Header$")
    public void clickService() {
        indexPagePO.clickService();
    }

    @And("^I click on User Table button in Service dropdown$")
    public void clickUserTable() {
        indexPagePO.userTableClick();
    }

    @When("^I select 'vip' checkbox for '(.+)'$")
    public void iSelectVipCheckboxFor(String user) {
        userTablePO.selectVip(user);
    }

    @When("^I click on dropdown in column Type for user '(.+)'$")
    public void iClickOnDropdownInColumnTypeForUserRoman(String user) {
        userTablePO.clickOnType(user);
    }
}
