package base.jdi.lesson1.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.common.TextField;
import org.openqa.selenium.support.FindBy;

public class IndexPageJdi extends WebPage {
    @FindBy(css = "[id='user-icon']")
    private Icon loginIcon;

    @FindBy(css = "[id='name']")
    private TextField userField;

    @FindBy(css = "[id='password']")
    private TextField passwordField;

    @FindBy(css = "[id='login-button']")
    private Button submitButton;

    public void login(String name, String password) {
        loginIcon.click();
        userField.sendKeys(name);
        passwordField.sendKeys(password);
        submitButton.click();
    }
}
