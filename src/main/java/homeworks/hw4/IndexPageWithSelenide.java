package homeworks.hw4;

import com.codeborne.selenide.SelenideElement;
import homeworks.hw3.enumsWithPageData.HomePageData;
import homeworks.hw3.enumsWithPageData.Users;
import homeworks.hw4.enumsWithDiffElementsData.CheckboxEnum;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPageWithSelenide {
    @FindBy(css = "[id='user-icon']")
    private SelenideElement loginIcon;

    @FindBy(css = "[id='name']")
    private SelenideElement userField;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordField;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 li a[data-toggle='dropdown']")
    private SelenideElement serviceButton;

    @FindBy(css = "[class='dropdown-menu']")
    private SelenideElement serviceMenu;

    @FindBy(css = "ul > li:nth-child(3) > a")
    private SelenideElement serviceButtonLeft;

    @FindBy(css = "ul > li.menu-title > a > span")
    private SelenideElement serviceMenuLeft;

    @FindBy(css = "body > div > div.uui-main-container.page-inside > main > div.main-content > div > div:nth-child(2)")
    private SelenideElement checkboxes;

    @FindBy(css = "body > div > div.uui-main-container.page-inside > main > div.main-content > div > div:nth-child(3)")
    private SelenideElement radios;

    @FindBy(css = "body > div > div.uui-main-container.page-inside > main > div.main-content > div > div.colors > select")
    private SelenideElement dropdown;

    @FindBy(css = "body > div > div.uui-main-container.page-inside > main > div.main-content > div > button")
    private SelenideElement button1;

    @FindBy(css = "body > div > div.uui-main-container.page-inside > main > div.main-content > div > input")
    private SelenideElement button2;

    public void checkTitle(HomePageData title) {
        assertEquals(getWebDriver().getTitle(), title.toString());
    }

    public void login(Users user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
    }

    public void checkUserIsLoggined(Users user) {
        $("#user-name").shouldHave(text(user.name));
    }

    public void checkServiceDropDown() {
        serviceButton.click();
        SelenideElement[] options = serviceMenu.$$("li").toArray(new SelenideElement[0]);
        for (SelenideElement option : options) {
            assertTrue(option.isDisplayed());
        }
    }

    public void checkServiceLeftSection() {
        serviceButtonLeft.click();
        SelenideElement[] options = serviceMenuLeft.$$("li").toArray(new SelenideElement[0]);
        for (SelenideElement option : options) {
            assertTrue(option.isDisplayed());
        }
    }

    public void checkDiffElPage() {
        serviceButton.click();
        SelenideElement[] options = serviceMenu.$$("li").toArray(new SelenideElement[0]);
        options[6].click();
        assertEquals(getWebDriver().getTitle(), "Different Elements");

    }

    public void checkDiffElPageInterface() {
        SelenideElement[] checkboxesArr = checkboxes.$$(".label-checkbox").toArray(new SelenideElement[0]);
        for (SelenideElement option : checkboxesArr) {
            assertTrue(option.isDisplayed());
        }

        SelenideElement[] radiosArr = radios.$$(".label-radio").toArray(new SelenideElement[0]);
        for (SelenideElement option : radiosArr) {
            assertTrue(option.isDisplayed());
        }

        $(dropdown).isDisplayed();
        $(button1).isDisplayed();
        $(button2).isDisplayed();
    }

    public void checkForRightSection() {
        $(".uui-side-bar.right-fix-panel.mCustomScrollbar._mCS_2.mCS_no_scrollbar").isDisplayed();
    }

    public void checkForLeftSection() {
        $(".uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar").isDisplayed();
    }

    public void selectCheckboxes(CheckboxEnum waterSelector, CheckboxEnum windSelector) {
        checkboxes.$(waterSelector.toString()).click();
        checkboxes.$(windSelector.toString()).click();
    }

    public void checkboxCorrectLog(CheckboxEnum[] values) {
        for (CheckboxEnum value : values) {
            System.out.println($("#mCSB_2_container > section:nth-child(1) > " +
                    "div.info-panel-body.info-panel-body-log > div > ul > li:nth-child(1)").getText());
        }
    }

    public void selectRadio() {
        radios.$("label:nth-child(4)").click();

    }
}
