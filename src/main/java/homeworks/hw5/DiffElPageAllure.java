package homeworks.hw5;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw4.ex1.enumsWithDiffElementsData.Colors;
import homeworks.hw4.ex1.enumsWithDiffElementsData.DiffElPageData;
import homeworks.hw4.ex1.enumsWithDiffElementsData.Metals;
import homeworks.hw4.ex1.enumsWithDiffElementsData.NatureElements;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class DiffElPageAllure {
    @FindBy(css = "li.dropdown.open li")
    private List<SelenideElement> serviceMenuList;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 li a[data-toggle='dropdown']")
    private SelenideElement serviceButton;

    @FindBy(css = "ul > li:nth-child(3) > a")
    private SelenideElement serviceButtonLeft;

    @FindBy(css = "ul > li.menu-title > a > span")
    private SelenideElement serviceMenuLeft;

    @FindBy(css = "div.main-content div:nth-child(2)")
    private SelenideElement checkboxes;

    @FindBy(css = "div.main-content div:nth-child(3)")
    private SelenideElement radios;

    @FindBy(css = "div.main-content div:nth-child(3) label")
    private ElementsCollection metalsCollection;

    @FindBy(css = ".colors option")
    private ElementsCollection colorsCollection;

    @FindBy(css = "[name='Default Button']")
    private SelenideElement defaultButton;

    @FindBy(css = "[type='button']")
    private SelenideElement button;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = "#mCSB_1_container")
    private SelenideElement leftSection;

    @FindBy(css = ".panel-body-list.logs li")
    private List<SelenideElement> listLog;

    @FindBy(css = "div.main-content div:nth-child(2) label")
    private ElementsCollection natureElementsCollection;

    @FindBy(css = ".colors")
    private SelenideElement colorsDropdown;

    @Step("Assert browser title")
    public void checkDiffElPage(DiffElPageData title) {
        serviceButton.click();
        serviceMenuList.get(6).click();
        assertEquals(getWebDriver().getTitle(), title.toString());

    }

    @Step("Assert different elements existed on page")
    public void checkDiffElPageInterface() {
        assertEquals(natureElementsCollection.size(), 4);
        checkboxes.should(visible);
        radios.should(visible);
        assertEquals(metalsCollection.size(), 4);
        colorsDropdown.should(visible);
        defaultButton.should(visible);
        button.should(visible);
    }

    @Step("Assert that there is Right Section")
    public void checkForRightSection() {
        rightSection.should(visible);
    }

    @Step("Assert that there is Left Section")
    public void checkForLeftSection() {
        leftSection.should(visible);
    }

    @Step("Assert that for each checkbox there is an individual log row")
    public void checkNatureElementsLog(NatureElements wind, NatureElements water) {
        listLog.get(1).shouldHave(text(wind.toString()));
        listLog.get(0).shouldHave(text(water.toString()));
    }

    @Step("Assert that for radiobutton there is a log row")
    public void checkMetalsLog(Metals selen) {
        listLog.get(0).shouldHave(text(selen.toString()));
    }

    @Step("Assert that for dropdown there is a log row")
    public void checkColorsLog(Colors yellow) {
        listLog.get(0).shouldHave(text(yellow.toString()));
    }

    @Step("Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox")
    public void checkLog(NatureElements wind, NatureElements water) {
        listLog.get(1).shouldHave(text(wind.toString()));
        listLog.get(0).shouldHave(text(water.toString()));
        listLog.get(0).shouldHave(text("false"));
        listLog.get(1).shouldHave(text("false"));
    }

    @Step("Select checkboxes")
    public void clickOnNatureElement(NatureElements natureElement) {
        natureElementsCollection.findBy(text(natureElement.toString())).click();
    }

    @Step("Select radio")
    public void selectMetal(Metals metal) {
        metalsCollection.findBy(text(metal.toString())).click();
    }

    @Step("Select in dropdown")
    public void selectColor(Colors color) {
        colorsCollection.findBy(text(color.toString())).click();
    }
}
