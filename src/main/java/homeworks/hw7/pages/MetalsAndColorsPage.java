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
        assertEquals(resultLog.get(1).text(), "Elements: " + data.nature[0] + ", " + data.nature[1]);
        assertEquals(resultLog.get(2).text(), "Color: " + data.color);
        assertEquals(resultLog.get(3).text(), "Metal: " + data.metal);
        assertEquals(resultLog.get(4).text(), "Vegetables: " + data.vegetables[0] + ", " + data.vegetables[1]);
    }
}
