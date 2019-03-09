package homeworks.hw7.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import homeworks.hw7.forms.MetalsForm;
import homeworks.hw7.utils.MetalsColorsData;

import static org.testng.Assert.assertEquals;

public class MetalsAndColorsPage extends WebPage {


    @Css("[class='panel-body-list results'] li")
    public WebList resultLog;

    public MetalsForm metalsForm;

    public void checkResultLog(MetalsColorsData data) {
        int sum = Integer.parseInt(data.odd) + Integer.parseInt(data.even);
        assertEquals(resultLog.get(0).text(), "Summary: " + sum);
        String logForNature = "Elements: ";
        for (String s : data.nature) {
            logForNature = logForNature + s + ", ";
        }
        assertEquals(resultLog.get(1).text(), logForNature.substring(0, logForNature.length()-2));
        assertEquals(resultLog.get(2).text(), "Color: " + data.color);
        assertEquals(resultLog.get(3).text(), "Metal: " + data.metal);
        String logForVeges = "Vegetables: ";
        for (String vegetable : data.vegetables) {
            logForVeges = logForVeges + vegetable + ", ";
        }
        assertEquals(resultLog.get(4).text(), logForVeges.substring(0, logForVeges.length()-2));
    }
}
