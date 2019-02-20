package homeworks.hw6.ex1;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw4.ex1.enumsWithDiffElementsData.Colors;
import homeworks.hw4.ex1.enumsWithDiffElementsData.Metals;
import homeworks.hw4.ex1.enumsWithDiffElementsData.NatureElements;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class DiffElPagePO {
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

    /*public void checkDiffElPage(DiffElPageData title) {
        serviceButton.click();
        serviceMenuList.get(6).click();
        assertEquals(getWebDriver().getTitle(), title.toString());

    }*/

    public void checkDiffElPageInterface() {
        //assertEquals(natureElementsCollection.size(), 4);
        natureElementsCollection.shouldBe(CollectionCondition.size(4));
        checkboxes.should(visible);
        radios.should(visible);
        //assertEquals(metalsCollection.size(), 4);
        metalsCollection.shouldBe(CollectionCondition.size(4));
        colorsDropdown.should(visible);
        defaultButton.should(visible);
        button.should(visible);
    }

    public void checkForRightSection() {
        rightSection.should(visible);
    }

    public void checkForLeftSection() {
        leftSection.should(visible);
    }

   /* public void checkNatureElementsLog(NatureElements wind, NatureElements water) {
        listLog.get(0).shouldHave(text(wind.toString()));
        listLog.get(1).shouldHave(text(water.toString()));
    }*/

    public void checkMetalsLog(Metals selen) {
        listLog.get(0).shouldHave(text(selen.toString()));
    }

    public void checkColorsLog(Colors yellow) {
        listLog.get(0).shouldHave(text(yellow.toString()));
    }

   /* public void checkLog(NatureElements wind, NatureElements water) {
        listLog.get(1).shouldHave(text(wind.toString()));
        listLog.get(0).shouldHave(text(water.toString()));
        listLog.get(0).shouldHave(text("false"));
        listLog.get(1).shouldHave(text("false"));
    }*/

   /* public void clickOnNatureElement(NatureElements water, NatureElements wind) {
        natureElementsCollection.findBy(text(water.toString())).click();
        natureElementsCollection.findBy(text(wind.toString())).click();
    }*/

    public void selectMetal(Metals metal) {
        metalsCollection.findBy(text(metal.toString())).click();
    }

    public void selectColor(Colors color) {
        colorsCollection.findBy(text(color.toString())).click();
    }

    public void clickOnColorsDropdown() {
        colorsDropdown.click();
    }

    public void selectNatureEl(List<NatureElements> elements) {
        for (NatureElements element : elements) {
            natureElementsCollection.findBy(text(element.toString())).click();
        }
    }

    public void logCheck(List<NatureElements> elements) {
        int k=0;
        for(int i=elements.size()-1; i>0; i--){
            listLog.get(i).shouldHave(text(elements.get(k).toString()));
            listLog.get(i).shouldHave(text("true"));
            k++;
        }
    }
    public void logUnselecttCheck(List<NatureElements> elements){
        int k=0;
        for(int i=elements.size()-1; i>0; i--){
            listLog.get(i).shouldHave(text(elements.get(k).toString()));
            listLog.get(i).shouldHave(text("false"));
            k++;
        }
    }
}
