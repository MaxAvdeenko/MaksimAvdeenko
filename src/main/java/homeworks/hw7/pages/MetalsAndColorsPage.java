package homeworks.hw7.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import homeworks.hw7.enums.*;
import homeworks.hw7.forms.MetalsForm;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MetalsAndColorsPage extends WebPage {


    @Css("[class='panel-body-list results'] li")
    public WebList resultLog;

    @Css("[class='panel-body-list logs'] li")
    public WebList listLog;

    MetalsForm metalsForm;

    public void selectOdd(Odd odd) {
        metalsForm.odds.select(odd.toString());
    }

    public void selectEven(Even even1) {
        metalsForm.even.select(even1.toString());
    }

    public void selectNatureElements(NatureElements element1, NatureElements element2) {
        metalsForm.natureElements.select(element1.toString());
        metalsForm.natureElements.select(element2.toString());
    }

    public void selectColor(Colors color) {
        metalsForm.colors.select(color.toString());
    }

    public void selectMetal(Metals metal) {
        metalsForm.metals.select(metal.toString());
    }

    public void selectVegetables(Vegetables vegetable1, Vegetables vegetable2) {
        metalsForm.vegetables.select(vegetable1.toString());
        metalsForm.vegetables.select(vegetable2.toString());
        metalsForm.vegetables.select(Vegetables.VEGETABLES.toString());
    }

    public void clickSubmit() {
        metalsForm.submit.click();
    }

    public void checkResultLog(Odd odd, Even even1, NatureElements element1, NatureElements element2, Colors color,
                               Metals metal, Vegetables vegetable1, Vegetables vegetable2) {
        int sum = Integer.parseInt(odd.toString()) + Integer.parseInt(even1.toString());
        assertEquals(resultLog.get(0).text(), "Summary: " + sum);
        assertEquals(resultLog.get(1).text(), "Elements: " + element1.toString() + ", " + element2.toString());
        assertEquals(resultLog.get(2).text(), "Color: " + color.toString());
        assertEquals(resultLog.get(3).text(), "Metal: " + metal.toString());
        assertEquals(resultLog.get(4).text(), "Vegetables: " + vegetable1.toString()
                + ", " + vegetable2.toString());
    }

    public void checkOddLog(Odd odd) {
        assertTrue(listLog.get(0).text().contains("Summary (Odd): value changed to " + odd.toString()));
    }

    public void checkEvenLog(Even even1) {
        listLog.refresh();
        assertTrue(listLog.get(0).text().contains("Summary (Even): value changed to " + even1.toString()));
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

    public void checkMetalsLog(Metals metal) {
        listLog.refresh();
        assertTrue(listLog.get(0).text().contains("Metals: value changed to " + metal.toString()));
    }

    public void checkSubmitIsClicked() {
        listLog.refresh();
        assertTrue(listLog.get(0).text().contains("submit-button:button clicked"));
    }
}
