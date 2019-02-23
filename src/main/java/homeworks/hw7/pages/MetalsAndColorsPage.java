package homeworks.hw7.pages;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import homeworks.hw7.enums.Colors;
import homeworks.hw7.enums.Metals;
import homeworks.hw7.enums.NatureElements;
import homeworks.hw7.enums.Vegetables;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MetalsAndColorsPage extends WebPage {

    @FindBy(css = "#odds-selector p")
    public RadioButtons odds;

    @FindBy(css = "#even-selector p")
    public RadioButtons even;

    @JDropdown(root = "div[ui=combobox]", value = "input",
            list = "li", expand = ".caret")
    public Droplist metals;

    @JDropdown(root = "div[ui=dropdown]", value = ".filter-option",
            list = "li", expand = ".caret")
    public Droplist colors;

    @JDropdown(root = "div[ui=droplist]", value = "input:checked",
            list = "li", expand = ".caret")
    public Droplist vegetables;

    /*@JCheckList(value = @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(css = ".vertical-group"),
            isSelected = @com.epam.jdi.light.elements.pageobjects.annotations.FindBy(css = "label:before"))
    public Checklist nature;*/

    @Css(".vertical-group p")
    public WebList natureElements;

    @FindBy(css = "#submit-button")
    public Button submit;

    @Css("[class='panel-body-list results'] li")
    public WebList resultLog;

    @Css("[class='panel-body-list logs'] li")
    public WebList listLog;

    public void selectOdd(String value) {
        odds.select(value);
    }

    public void selectEven(String value) {
        even.select(value);
    }

    public void selectNatureElements(NatureElements element1, NatureElements element2) {
        natureElements.select(element1.toString());
        natureElements.select(element2.toString());
    }

    public void selectColor(Colors color){
        colors.select(color.toString());
    }

    public void selectMetal(Metals metal){
        metals.select(metal.toString());
    }
    public void selectVegetables(Vegetables vegetable1, Vegetables vegetable2){
        vegetables.select(vegetable1.toString());
        vegetables.select(vegetable2.toString());
        vegetables.select(Vegetables.VEGETABLES.toString());
    }

    public void clickSubmit(){
        submit.click();
    }

    public void checkResultLog(int sum, NatureElements element1, NatureElements element2, Colors color,
                               Metals metal, Vegetables vegetable1, Vegetables vegetable2){
        assertEquals(resultLog.get(0).text(), "Summary: " + sum);
        assertEquals(resultLog.get(1).text(), "Elements: " + element1.toString() + ", " + element2.toString());
        assertEquals(resultLog.get(2).text(), "Color: " + color.toString());
        assertEquals(resultLog.get(3).text(),"Metal: " + metal.toString());
        assertEquals(resultLog.get(4).text(),"Vegetables: " + vegetable1.toString()
                + ", " + vegetable2.toString());
    }

    public void checkOddLog(String odd) {
        assertTrue(listLog.get(0).text().contains("Summary (Odd): value changed to " + odd));
    }

    public void checkEvenLog(String even){
        listLog.refresh();
        assertTrue(listLog.get(0).text().contains("Summary (Even): value changed to " + even));
    }

    public void checkNatElLog(NatureElements element1, NatureElements element2) {
        listLog.refresh();
        assertTrue(listLog.get(1).text().contains(element1.toString() + ": condition changed to true"));
        listLog.refresh();
        assertTrue(listLog.get(0).text().contains(element2.toString() + ": condition changed to true"));
    }

    public void checkColorsLog(Colors color) {
        listLog.refresh();
        assertTrue(listLog.get(0).text().contains("Colors: value changed to " + color.toString()));
    }

    public void checkMetalsLog(Metals metal){
        listLog.refresh();
        assertTrue(listLog.get(0).text().contains("Metals: value changed to " + metal.toString()));
    }

    public void checkSubmitIsClicked() {
        listLog.refresh();
        assertTrue(listLog.get(0).text().contains("submit-button:button clicked"));
    }
}
