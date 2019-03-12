package homeworks.hw8.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import homeworks.hw8.forms.MetalsForm;
import homeworks.hw8.utils.MetalsColorsPOJO;

import static org.testng.Assert.assertEquals;

public class MetalsAndColorsPage extends WebPage {
    @Css("[class='panel-body-list results'] li")
    public WebList resultLog;

    public MetalsForm metalsForm;

    public void checkResultLog(MetalsColorsPOJO data) {
        // TODO It will be better to transform MetalsColorsPOJO to List<String>
        // TODO and compare it with List of the log's strings
        int sum = Integer.parseInt(data.summary[0].toString()) + Integer.parseInt(data.summary[1].toString());
        assertEquals(resultLog.get(0).text(), "Summary: " + sum);
        String logForNature = "Elements: ";
        for (String s : data.elements) {
            // TODO Take a look on IDEA warning. It will be better with String::join.
            logForNature = logForNature + s + ", ";
        }
        assertEquals(resultLog.get(1).text(), logForNature.substring(0, logForNature.length() - 2));
        assertEquals(resultLog.get(2).text(), "Color: " + data.color);
        assertEquals(resultLog.get(3).text(), "Metal: " + data.metals);
        String logForVeges = "Vegetables: ";
        for (String vegetable : data.vegetables) {
            logForVeges = logForVeges + vegetable + ", ";
        }
        assertEquals(resultLog.get(4).text(), logForVeges.substring(0, logForVeges.length() - 2));
    }
}
