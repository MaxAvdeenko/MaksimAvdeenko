package homeworks.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw3.enumsWithPageData.HomePageData;
import homeworks.hw3.enumsWithPageData.Users;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
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
        userField.should(Condition.visible);
        userField.shouldHave(text(user.name));
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
            option.should(Condition.visible);
        }
      /*  for (int i=0; i<options.length; i++){
            options[i].should();
        }*/
    }
}
