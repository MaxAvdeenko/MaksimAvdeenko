package homeworks.hw7.pages;

import base.jdi.entities.User;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.common.TextField;
import com.epam.jdi.light.ui.html.complex.Menu;
import homeworks.hw7.forms.LoginForm;
import homeworks.hw7.utils.MetalsAndColorsData;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class JdiIndexPage extends WebPage {
    @FindBy(css = "[id='user-icon']")
    private Icon loginIcon;

    @FindBy(css = "[id='user-name']")
    private TextField username;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8")
    public Menu navigation;

    LoginForm loginForm;

    public void login(User user) {
        loginIcon.click();
        loginForm.login(user);
    }

    public void checkUserIsLoggined(User user) {
        Assert.assertEquals(username.getText(), user.fullname);
    }

    public void goToMetalsAndColors(MetalsAndColorsData metalsText) {
        navigation.select(metalsText.toString());
    }

    public void checkTittle(String title, MetalsAndColorsData metalsText) {
        Assert.assertEquals(title, metalsText.toString());
    }

}
