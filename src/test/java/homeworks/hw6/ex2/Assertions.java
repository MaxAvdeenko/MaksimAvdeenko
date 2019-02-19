package homeworks.hw6.ex2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class Assertions {
    private UserTablePO userTablePO = page(UserTablePO.class);

    @Then("^User Table page is opened$")
    public void checkUserTablePageTitle() {
        userTablePO.checkTitle();
    }

    @And("^(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void numbertypeDropdownsAreDisplayedOnUsersTableOnUserTablePage(int count) {
        userTablePO.checkNumperType(count);
    }

    @And("^(\\d+) User names are displayed on Users Table on User Table Page$")
    public void userNamesAreDisplayedOnUsersTableOnUserTablePage(int count) {
        userTablePO.checkUsernamesCount(count);
    }

    @And("^(\\d+) Description images are displayed on Users Table on User Table Page$")
    public void descriptionImagesAreDisplayedOnUsersTableOnUserTablePage(int count) {
        userTablePO.checkImagesCount(count);
    }

    @And("^(\\d+) Description texts under images are displayed on Users Table on User Table Page$")
    public void descriptionTextsUnderImagesAreDisplayedOnUsersTableOnUserTablePage(int count) {
        userTablePO.checkDescrTexts(count);
    }

    @And("^(\\d+) checkboxes are displayed on Users Table on User Table Page$")
    public void checkboxesAreDisplayedOnUsersTableOnUserTablePage(int count) {
        userTablePO.checkCheckboxesCount(count);
    }

    @And("^User table contains following values:$")
    public void userTableContainsFollowingValues(List<ComicsHero> heroes) {
        userTablePO.checkUserTableValues(heroes);
    }

    @Then("^(\\d+) log row has '(.+)' text in log section$")
    public void logRowHasTextInLogSection(int row, String value) {
        userTablePO.checkLog(row, value);
    }

    @Then("^droplist contains values$")
    public void droplistContainsValues(List<String> values) {
        userTablePO.checkDropdownValues(values);
    }
}
