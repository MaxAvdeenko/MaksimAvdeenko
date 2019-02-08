package homeworks.hw4.ex1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw4.ex1.enumsWithDiffElementsData.CheckboxData;
import homeworks.hw4.ex1.enumsWithDiffElementsData.ColorsData;
import homeworks.hw4.ex1.enumsWithDiffElementsData.DiffElPageData;
import homeworks.hw4.ex1.enumsWithDiffElementsData.RadioData;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class DiffElPageWithSelenide {
    // TODO You can create locator that will provide you with whole menu items
    @FindBy(css = "li.dropdown.open li")
    private List<SelenideElement> serviceMenuList;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 li a[data-toggle='dropdown']")
    private SelenideElement serviceButton;

    @FindBy(css = "ul > li:nth-child(3) > a")
    private SelenideElement serviceButtonLeft;

    @FindBy(css = "ul > li.menu-title > a > span")
    private SelenideElement serviceMenuLeft;

    // TODO This locator can be improved
    @FindBy(css = "div.main-content div:nth-child(2)")
    private SelenideElement checkboxes;

    // TODO This locator can be improved
    @FindBy(css = "div.main-content div:nth-child(3) label")
    private List<SelenideElement> radiosList;

    @FindBy(css = ".colors option")
    private List<SelenideElement> colorsList;

    // TODO This locator can be improved
    @FindBy(css = "[name='Default Button']")
    private SelenideElement button1;

    // TODO This locator can be improved
    @FindBy(css = "[type='button']")
    private SelenideElement button2;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = "#mCSB_1_container")
    private SelenideElement leftSection;

    @FindBy(css = ".panel-body-list.logs li")
    private List<SelenideElement> listLog;

    @FindBy(css = "div.main-content div:nth-child(2) label")
    private List<SelenideElement> boxList;

    public void checkDiffElPage(DiffElPageData title) {
        serviceButton.click();
        // TODO Take a look on comment from line 15
        serviceMenuList.get(6).click();
        assertEquals(getWebDriver().getTitle(), title.toString());

    }

    public void checkDiffElPageInterface() {
        assertEquals(boxList.size(), 4);
        for (SelenideElement checkbox : boxList) {
            checkbox.shouldHave(Condition.visible);
        }

        for (SelenideElement radio : radiosList) {
            radio.shouldHave(Condition.visible);
        }
        assertEquals(radiosList.size(), 4);
        $(".colors").should(Condition.visible);
        button1.should(Condition.visible);
        button2.should(Condition.visible);
    }

    public void checkForRightSection() {
        rightSection.should(Condition.visible);
    }

    public void checkForLeftSection() {
        leftSection.should(Condition.visible);
    }

    public void selectCheckboxes() {
        boxList.get(0).click();
        boxList.get(2).click();
    }

    public void checkboxCorrectLog(CheckboxData wind, CheckboxData water) {
        listLog.get(0).shouldHave(text(wind.toString()));
        listLog.get(1).shouldHave(text(water.toString()));
    }

    public void selectRadio() {
        radiosList.get(3).click();
    }

    public void radiosCorectLog(RadioData selen) {
        listLog.get(0).shouldHave(text(selen.toString()));
    }

    public void selectColor() {
        $(".colors").click();
        colorsList.get(3).click();
    }

    public void colorsCorrectLog(ColorsData yellow) {
        listLog.get(0).shouldHave(text(yellow.toString()));
    }

    public void unselectCheckboxes() {
        boxList.get(0).click();
        boxList.get(2).click();
    }

    public void checkLog(CheckboxData wind, CheckboxData water) {
        listLog.get(0).shouldHave(text(wind.toString()));
        listLog.get(1).shouldHave(text(water.toString()));
        listLog.get(0).shouldHave(text("false"));
        listLog.get(1).shouldHave(text("false"));
    }
}
