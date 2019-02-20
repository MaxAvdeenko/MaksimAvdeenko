package homeworks.hw6.ex2;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static homeworks.hw6.enums.UserTablePageData.USER_TABLE_PAGE_TITLE;
import static java.util.stream.Collectors.*;
import static org.testng.Assert.assertEquals;

public class UserTablePO {

    @FindBy(css = "td:nth-child(2) > select")
    private ElementsCollection typeDropdowns;

    @FindBy(css = "td:nth-child(3) > a")
    private ElementsCollection usernames;

    @FindBy(css = "td img")
    private ElementsCollection images;

    @FindBy(css = "[class='user-descr']")
    private ElementsCollection descrTexts;

    @FindBy(css = "[type='checkbox']")
    private ElementsCollection checkboxes;

    @FindBy(css = "tr > td:first-child")
    private ElementsCollection userNumbers;

    @FindBy(css = "[class='panel-body-list logs']")
    private ElementsCollection log;

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), USER_TABLE_PAGE_TITLE.toString());
    }

    public void checkNumperType(int count) {
        typeDropdowns.shouldBe(size(count));
        for (SelenideElement numberTypeDropdown : typeDropdowns) {
            numberTypeDropdown.should(visible);
        }
    }

    public void checkUsernamesCount(int count) {
        usernames.shouldBe(size(count));
        for (SelenideElement username : usernames) {
            username.should(visible);
        }
    }

    public void checkImagesCount(int count) {
        images.shouldBe(size(count));
        for (SelenideElement image : images) {
            image.should(visible);
        }
    }

    public void checkDescrTexts(int count) {
        descrTexts.shouldBe(size(count));
        for (SelenideElement descrText : descrTexts) {
            descrText.should(visible);
        }
    }

    public void checkCheckboxesCount(int count) {
        checkboxes.shouldBe(size(count));
        for (SelenideElement checkbox : checkboxes) {
            checkbox.should(visible);
        }
    }

    public void checkUserTableValues(List<ComicsHero> heroes) {
        List<String> numbers = heroes.stream().map(ComicsHero::getNumber).collect(toList());
        List<String> users = heroes.stream().map(ComicsHero::getUser).collect(toList());
        List<String> descriptions = heroes.stream().map(ComicsHero::getDescription).collect(toList());

        userNumbers.shouldHave(size(numbers.size())).shouldHave(texts(numbers));
        usernames.shouldHave(size(users.size())).shouldHave(texts(users));
        descrTexts.shouldHave(size(descriptions.size())).shouldHave(texts(descriptions));
    }

    public void selectVip(String user) {
        List<String> usernamesList = usernames.stream().map(SelenideElement::getText).collect(toList());
        checkboxes.get(usernamesList.indexOf(user)).click();
    }

    public void checkLog(int row, String value) {
        log.get(row - 1).shouldHave(text(value));
    }

    public void clickOnType(String user) {
        List<String> usernamesList = usernames.stream().map(SelenideElement::getText).collect(toList());
        typeDropdowns.get(usernamesList.indexOf(user)).click();
    }

    public void checkDropdownValues(List<String> values) {
        typeDropdowns.get(0).$$("option").shouldHave(texts(values));
    }
}
