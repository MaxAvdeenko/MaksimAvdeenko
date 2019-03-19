package homeworks.hw8.pages;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.google.common.base.Joiner;
import homeworks.hw8.forms.MetalsForm;
import homeworks.hw8.utils.MetalsColorsPOJO;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class MetalsAndColorsPage extends WebPage {
    @Css("[class='panel-body-list results'] li")
    public WebList resultLog;

    public MetalsForm metalsForm;

    public void checkResultLog(MetalsColorsPOJO data) {
        List<String> actual = new ArrayList<>();
        int sum = Integer.parseInt(data.summary[0].toString()) + Integer.parseInt(data.summary[1].toString());
        actual.add(0, "Summary: " + sum);
        String logForNature = "Elements: " + Joiner.on(", ").join(data.elements);
        actual.add(1, logForNature);
        actual.add(2, "Color: " + data.color);
        actual.add(3, "Metal: " + data.metals);
        String logForVeges = "Vegetables: " + Joiner.on(", ").join(data.vegetables);
        actual.add(4, logForVeges);
        List<String> expected = new ArrayList<>();
        for (UIElement uiElement : resultLog) {
            expected.add(uiElement.text());
        }
        assertEquals(actual, expected);
    }
}
