package homeworks.hw8;

import base.jdi.entities.User;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import homeworks.hw8.utils.MetalsColorsPOJO;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import static homeworks.hw8.utils.MetalsAndColorsData.METALS_TEXT;
import static homeworks.hw8.utils.MetalsAndColorsData.METALS_TITLE;


public class MetalsAndColorsJsonTest {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JdiSite.class);
        //1. Open index page
        JdiSite.jdiIndexPage.open();

        //2. Log in as Piter Chailovskii
        JdiSite.jdiIndexPage.login(User.PITER);

        //3. Check that Piter Chailovskii is loggined
        JdiSite.jdiIndexPage.checkUserIsLoggined(User.PITER);
    }

    @DataProvider
    public Object[][] provider() throws FileNotFoundException {
        JsonObject jsons = new JsonParser()
                .parse(new FileReader("src/test/resources/JDI_ex8_metalsColorsDataSet.json"))
                .getAsJsonObject();
        Object[][] result = new Object[jsons.size()][1];
        int i = 0;
        for (Map.Entry<String, JsonElement> entry : jsons.entrySet()) {
            result[i++][0] = new Gson()
                    .fromJson(entry.getValue(), MetalsColorsPOJO.class);
        }
        return result;
    }

    @Test(dataProvider = "provider")
    public void MetalsAndColorsTest(MetalsColorsPOJO data) {

        //4. Open Metals&Colors Page by header menu
        JdiSite.jdiIndexPage.goToMetalsAndColors(METALS_TEXT);

        //5. Assert that Metals&Colors page is opened
        JdiSite.jdiIndexPage.checkTittle(WebDriverFactory.getDriver().getTitle(), METALS_TITLE);

        //6. Fill all elements
        JdiSite.metalsAndColorsPage.metalsForm.submit(data);

        //7. Assert that all necessary elements are displayed in result log
        JdiSite.metalsAndColorsPage.checkResultLog(data);

    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }
}
