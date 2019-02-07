package homeworks.hw4.ex1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw4.ex1.enumsWithDiffElementsData.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class DiffElPageWithSelenide {
    // TODO You can create locator that will provide you with whole menu items
    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 li a[data-toggle='dropdown']")
    private SelenideElement serviceButton;

    @FindBy(css = "[class='dropdown-menu']")
    private SelenideElement serviceMenu;

    @FindBy(css = "ul > li:nth-child(3) > a")
    private SelenideElement serviceButtonLeft;

    @FindBy(css = "ul > li.menu-title > a > span")
    private SelenideElement serviceMenuLeft;

    // TODO This locator can be improved
    @FindBy(css = "body > div > div.uui-main-container.page-inside > main > div.main-content > div > div:nth-child(2)")
    private SelenideElement checkboxes;

    // TODO This locator can be improved
    @FindBy(css = "body > div > div.uui-main-container.page-inside > main > div.main-content > div > div:nth-child(3)")
    private SelenideElement radios;

    @FindBy(css = ".colors")
    private SelenideElement colorsDropdown;

    // TODO This locator can be improved
    @FindBy(css = "body > div > div.uui-main-container.page-inside > main > div.main-content > div > button")
    private SelenideElement button1;

    // TODO This locator can be improved
    @FindBy(css = "body > div > div.uui-main-container.page-inside > main > div.main-content > div > input")
    private SelenideElement button2;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = "#mCSB_1_container")
    private SelenideElement leftSection;

    @FindBy(css = ".panel-body-list.logs li")
    private List<SelenideElement> listLog;

    public void checkDiffElPage(DiffElPageData title) {
        serviceButton.click();
        // TODO Take a look on comment from line 15
        SelenideElement[] options = serviceMenu.$$("li").toArray(new SelenideElement[0]);
        options[6].click();
        assertEquals(getWebDriver().getTitle(), title.toString());

    }

    public void checkDiffElPageInterface() {
        SelenideElement[] checkboxesArr = checkboxes.$$(".label-checkbox").toArray(new SelenideElement[0]);
        for (SelenideElement checkbox : checkboxesArr) {
            checkbox.should(Condition.visible);
        }
        assertEquals(checkboxesArr.length, 4);

        SelenideElement[] radiosArr = radios.$$(".label-radio").toArray(new SelenideElement[0]);
        for (SelenideElement radios : radiosArr) {
            radios.should(Condition.visible);
        }
        assertEquals(radiosArr.length, 4);
        colorsDropdown.should(Condition.visible);
        button1.should(Condition.visible);
        button2.should(Condition.visible);
    }

    public void checkForRightSection() {
        rightSection.should(Condition.visible);
    }

    public void checkForLeftSection() {
        leftSection.should(Condition.visible);
    }

    public void selectCheckboxes(CheckboxSelectors waterSelector, CheckboxSelectors windSelector) {
        checkboxes.$(waterSelector.toString()).click();
        checkboxes.$(windSelector.toString()).click();
    }

    public void checkboxCorrectLog(CheckboxData[] values) {
        for (CheckboxSelectors selector : CheckboxSelectors.values()) {
            checkboxes.$(selector.toString()).click();
        }
        for (int i = 0; i < values.length; i++) {
            listLog.get(i).shouldHave(text(values[values.length - i - 1].toString()));
        }
        //This loop is necessary for elements "water" and "wind" remained selected(step 17,18)
        for (CheckboxSelectors selector : CheckboxSelectors.values()) {
            checkboxes.$(selector.toString()).click();
        }
    }

    public void selectRadio(RadioSelectors selenSelector) {
        radios.$(selenSelector.toString()).click();
    }

    public void radiosCorectLog(RadioData[] values) {
        for (RadioSelectors selector : RadioSelectors.values()) {
            radios.$(selector.toString()).click();
        }
        for (int i = 0; i < values.length; i++) {
            listLog.get(i).shouldHave(text(values[values.length - i - 1].toString()));
        }
    }

    public void selectColor(ColorsSelectors yellowSelector) {
        colorsDropdown.click();
        colorsDropdown.$(yellowSelector.toString()).click();
    }

    public void colorsCorrectLog(ColorsData[] values) {
        for (ColorsSelectors selector : ColorsSelectors.values()) {
            colorsDropdown.$(selector.toString()).click();
        }
        colorsDropdown.click();
        for (int i = 0; i < values.length; i++) {
            listLog.get(i).shouldHave(text(values[values.length - i - 1].toString()));
        }
    }

    public void unselectCheckboxes(CheckboxSelectors waterSelector, CheckboxSelectors windSelector) {
        checkboxes.$(waterSelector.toString()).click();
        checkboxes.$(windSelector.toString()).click();
    }

    public void checkLog() {
        listLog.get(0).shouldHave(text("false"));
        listLog.get(1).shouldHave(text("false"));
    }
}
