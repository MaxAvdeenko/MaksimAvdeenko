package homeworks.hw5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw3.enumsWithPageData.HomePageData;
import homeworks.hw3.enumsWithPageData.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPageAllure {
    @FindBy(css = "[id='user-icon']")
    private SelenideElement loginIcon;

    @FindBy(css = "[id='name']")
    private SelenideElement userField;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordField;

    @FindBy(css = "[id='user-name']")
    private SelenideElement usernameField;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 li a[data-toggle='dropdown']")
    private SelenideElement serviceButton;

    @FindBy(css = "[class='dropdown-menu']")
    private SelenideElement serviceMenu;

    @FindBy(css = "#mCSB_1_container > ul > li:nth-child(3) > a")
    private SelenideElement serviceButtonLeft;

    @FindBy(css = "ul > li.menu-title > a > span")
    private SelenideElement serviceMenuLeft;

    @Step("Check browser title")
    public void checkTitle(HomePageData title) {
        assertEquals(getWebDriver().getTitle(), title.toString());
    }

    @Step("Enter login and password {user.login}")
    public void login(Users user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
    }

    @Step("Check login")
    public void checkUserIsLoggined(Users user) {
        usernameField.should(Condition.visible);
        usernameField.shouldHave(text(user.name));
    }

    @Step("Check Service dropdown")
    public void checkServiceDropDown() {
        serviceButton.click();
        SelenideElement[] options = serviceMenu.$$("li").toArray(new SelenideElement[0]);
        for (SelenideElement option : options) {
            assertTrue(option.isDisplayed());
        }
    }

    @Step("Check Service left section")
    public void checkServiceLeftSection() {
        serviceButtonLeft.click();
        SelenideElement[] options = serviceMenuLeft.$$("li").toArray(new SelenideElement[0]);
        for (SelenideElement option : options) {
            option.should(Condition.visible);
        }
    }
}
