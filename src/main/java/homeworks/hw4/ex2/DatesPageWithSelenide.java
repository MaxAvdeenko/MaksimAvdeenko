package homeworks.hw4.ex2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

// TODO You should not store every elements on one page !
// TODO You already have IndexPage, why don't you use it ?
public class DatesPageWithSelenide {


    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 li a[data-toggle='dropdown']")
    private SelenideElement serviceButton;

    @FindBy(css = "[class='dropdown-menu']")
    private SelenideElement serviceMenu;

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection sliders;

    @FindBy(css = ".panel-body-list.logs li")
    private ElementsCollection log;

    @FindBy(css = "[class='dropdown-menu'] li")
    private ElementsCollection serviceMenuList;

    public void openDatesPage(DatesPageData title) {
        serviceButton.click();
        // TODO But anyway, you should not find elements in PO methods...
        serviceMenuList.get(1).click();
        assertEquals(getWebDriver().getTitle(), title.toString());
    }

    public void checkLogs(Integer leftSlider, Integer rightSlider) {
        // TODO Take a look here https://selenide.gitbooks.io/user-guide/content/en/selenide-api/elements-collection.html
        // TODO You should not use testNg assertions in this task, take a look on Selenide approach.

        log.get(1).shouldHave(Condition.text(leftSlider.toString()));
        log.get(0).shouldHave(Condition.text(rightSlider.toString()));
    }

    // TODO What do you mean "remove" sliders ?
    /*public void replaceSliders(int left, int right) {
        left = left == 0 ? -1000 : 1000;
        right = right == 0 ? -1000 : 1000;
        actions().dragAndDropBy(sliders.get(0), left, 0).build().perform();
        actions().dragAndDropBy(sliders.get(1), right, 0).build().perform();
    }*/

    public void setSliderPosition(int left, int right) {
        if (left == 0) {
            replaceSliderToLeft(sliders.get(0));
        } else if (left == 100) {
            replaceSliderToRight(sliders.get(0));
        }
        if (right == 0) {
            replaceSliderToLeft(sliders.get(1));
        } else if (right == 100) {
            replaceSliderToRight(sliders.get(1));
        }
        if ((left > 0 && left < 100) | (right > 0 && right < 100)) replaceSlidersCustom(left, right);
    }

    private void replaceSliderToLeft(SelenideElement slider) {
        actions().dragAndDropBy(slider, -1000, 0).build().perform();

    }

    private void replaceSliderToRight(SelenideElement slider) {
        actions().dragAndDropBy(slider, 1000, 0).build().perform();
    }

    private void replaceSlidersCustom(int left, int right) {
        actions().dragAndDropBy(sliders.get(0), -1000, 0).build().perform();
        int length = sliders.get(1).getLocation().getX() - sliders.get(0).getLocation().getX();
        double oneStep = length / 100.0;
        int leftPosition = (int) Math.round(oneStep * left) - 1;
        int rightPosition = length - (int) Math.round(((oneStep * right))-oneStep);
        actions().dragAndDropBy(sliders.get(0), leftPosition, 0).build().perform();
        actions().dragAndDropBy(sliders.get(1), -rightPosition, 0).build().perform();
    }
}
