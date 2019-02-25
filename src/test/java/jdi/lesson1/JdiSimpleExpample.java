package jdi.lesson1;

import base.jdi.JdiSite;
import base.jdi.entities.User;
import com.epam.jdi.light.actions.ActionHelper;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JdiSimpleExpample {


    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JdiSite.class);
        WebSettings.SEARCH_CONDITION = e ->{
            return e.isDisplayed();
        };

        ActionHelper.BEFORE_JDI_ACTION = jp -> {

        };
        ActionHelper.AFTER_JDI_ACTION = (jp, o) -> {
            return ActionHelper.AFTER_STEP_ACTION.execute(jp, o);
        };

    }

    @Test
    public void SimpleJdiTest() {
        //indexPageJdi.login("epam", "1234");
        JdiSite.indexPageJdi.open();
        JdiSite.indexPageJdi.login(User.PITER);
    }

    @AfterSuite
    public void afterSuite(){
        WebDriverFactory.close();
        /*driver.close();*/
    }
}
