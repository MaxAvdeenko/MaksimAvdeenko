package jdi.lesson1;

import base.jdi.JdiSite;
import base.jdi.entities.User;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JdiSimpleExpample {


    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JdiSite.class);
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
