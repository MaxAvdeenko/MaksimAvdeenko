package homeworks.hw4.ex2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw3.enumsWithPageData.HomePageData;
import homeworks.hw3.enumsWithPageData.Users;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static homeworks.hw4.ex2.DatesPageData.LEFT_SLIDER;
import static homeworks.hw4.ex2.DatesPageData.RIGHT_SLIDER;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// TODO You should not store every elements on one page !
// TODO You already have IndexPage, why don't you use it ?
public class DatesPageWithSelenide {
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

    @FindBy(css = ".ui-slider-handle.ui-state-default.ui-corner-all")
    private List<SelenideElement> sliders;

    @FindBy(css = ".panel-body-list.logs li")
    private ElementsCollection log;

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

    public void openDatesPage(DatesPageData title) {
        serviceButton.click();
        // TODO But anyway, you should not find elements in PO methods...
        serviceMenu.$$("li").get(1).click();
        assertEquals(getWebDriver().getTitle(), title.toString());
    }

    public void checkSliders(int leftSlider, int rightSlider) {
        // TODO Take a look here https://selenide.gitbooks.io/user-guide/content/en/selenide-api/elements-collection.html
        // TODO You should not use testNg assertions in this task, take a look on Selenide approach.
        assertTrue(log.get(0).getText().contains(("(" + RIGHT_SLIDER.value + "):" + rightSlider)));
        assertTrue(log.get(1).getText().contains(("(" + LEFT_SLIDER.value + "):" + leftSlider)));
    }

    public void checkSlidersReverse(int leftSlider, int rightSlider) {
        assertTrue(log.get(0).getText().contains(("(" + LEFT_SLIDER.value + "):" + rightSlider)));
        assertTrue(log.get(1).getText().contains(("(" + RIGHT_SLIDER.value + "):" + leftSlider)));
    }

    public void removeSlidersToRight() {
        actions().dragAndDropBy(sliders.get(1), 1000, 0).build().perform();
        actions().dragAndDropBy(sliders.get(0), 1000, 0).build().perform();
    }

    public void removeSlidersCustom() {
        actions().dragAndDropBy(sliders.get(0), -1000, 0).build().perform();
        double oneStep = (sliders.get(1).getLocation().getX() - sliders.get(0).getLocation().getX()) / 100.0;
        int leftPosition = (int) Math.round(oneStep * 30) - 1;
        actions().dragAndDropBy(sliders.get(0), leftPosition, 0).build().perform();
        actions().dragAndDropBy(sliders.get(1), -leftPosition - 2, 0).build().perform();
    }

    // TODO What do you mean "remove" sliders ?
    public void removeSliders(int left, int right) {
        left = left == 0 ? -1000 : 1000;
        right = right == 0 ? -1000 : 1000;
        actions().dragAndDropBy(sliders.get(0), left, 0).build().perform();
        actions().dragAndDropBy(sliders.get(1), right, 0).build().perform();
    }
}
