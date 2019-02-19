package homeworks.hw6.ex1;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw3.enumsWithPageData.HomePageData;
import homeworks.hw3.enumsWithPageData.Users;
import homeworks.hw6.enums.ServiceData;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class IndexPagePO {
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

    @FindBy(css = "[class='dropdown-menu'] li")
    private ElementsCollection serviceMenu;

    @FindBy(css = "#mCSB_1_container > ul > li:nth-child(3) > a")
    private SelenideElement serviceButtonLeft;

    @FindBy(css = "ul > li.menu-title > a > span")
    private SelenideElement serviceMenuLeft;

    @FindBy(css = "[class='benefit-icon']")
    private ElementsCollection images;

    @FindBy(css = "[class='benefit-txt']")
    private ElementsCollection textsUnderImages;

    @FindBy(css = "[class='main-title text-center']")
    private SelenideElement headline;

    @FindBy(css = "[class='main-txt text-center']")
    private SelenideElement description;

    @FindBy(css = "li.dropdown.open > ul > li:nth-child(5) > a")
    private SelenideElement userTableButton;

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
        usernameField.should(Condition.visible);
        usernameField.shouldHave(text(user.name));
    }

    public void checkServiceLeftSection() {
        SelenideElement[] options = serviceMenuLeft.$$("li").toArray(new SelenideElement[0]);
        for (SelenideElement option : options) {
            option.should(Condition.visible);
        }
    }

    public void checkAllElements() {
        images.shouldHave(CollectionCondition.size(4));
        for (SelenideElement picture : images) {
            picture.should(visible);
        }
        textsUnderImages.shouldHave(CollectionCondition.size(4));
        for (SelenideElement pictureText : textsUnderImages) {
            pictureText.should(visible);
        }
        headline.should(visible);
        description.should(visible);
    }

    public void clickService() {
        serviceButton.click();
    }

    public void checkService(List<ServiceData> options) {
        serviceMenu.shouldHaveSize(options.size());
        List<String> expectedTexts = options.stream().map(ServiceData::toString).collect(Collectors.toList());
        serviceMenu.shouldHave(texts(expectedTexts));
    }

    public void clickLeftService() {
        serviceButtonLeft.click();
    }

    public void userTableClick() {
        userTableButton.click();
    }
}
