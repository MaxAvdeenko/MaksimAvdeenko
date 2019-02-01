package homeworks.hw3;

import homeworks.hw3.enumsWithPageData.HeaderItemsData;
import homeworks.hw3.enumsWithPageData.HomePageData;
import homeworks.hw3.enumsWithPageData.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {

    @FindBy(css = "[id='user-icon']")
    private WebElement loginIcon;

    @FindBy(css = "[id='name']")
    private WebElement userField;

    @FindBy(css = "[id='password']")
    private WebElement passwordField;

    @FindBy(css = "[id='login-button']")
    private WebElement submitButton;

    @FindBy(css = "[id='user-name']")
    private WebElement userName;

    @FindBy(css = "[class='uui-navigation nav navbar-nav m-l8']")
    private WebElement headerItems;

    @FindBy(css = ".icons-benefit.icon-practise")
    private WebElement practiceIcon;

    @FindBy(css = ".icons-benefit.icon-custom")
    private WebElement customIcon;

    @FindBy(css = ".icons-benefit.icon-multi")
    private WebElement multiIcon;

    @FindBy(css = ".icons-benefit.icon-base")
    private WebElement baseIcon;

    @FindBy(xpath = "//span[contains(text(),'To include good practices')]")
    private WebElement practiceText;

    @FindBy(xpath = "//span[contains(text(),'To be flexible')]")
    private WebElement customText;

    @FindBy(xpath = "//span[contains(text(),'To be multiplatform')]")
    private WebElement multiText;

    @FindBy(xpath = "//span[contains(text(),'Already have good base')]")
    private WebElement baseText;

    @FindBy(css = ".main-title.text-center")
    private WebElement headerTitle;
    
    @FindBy(css = ".main-txt.text-center")
    private WebElement headerText;
    
    @FindBy(css = "[id='iframe']")
    private WebElement iframe;
    
    @FindBy(css = ".uui-main-container a[target='_blank']")
    private WebElement subHeader;

    @FindBy(css = ".uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar")
    private WebElement leftSection;

    @FindBy(css = "[class='footer-bg']")
    private WebElement footer;

    private WebDriver driver;

    public IndexPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(HomePageData url) {
        driver.get(url.toString());
    }

    public void checkTitle(HomePageData title) {
        assertEquals(driver.getTitle(), title.toString());
    }

    public void login(Users user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
    }

    public void checkUserIsLoggined(Users user) {
        assertEquals(userName.getText(), user.name);
    }

    public void checkHeaderItems(HeaderItemsData[] itemsText) {
        assertTrue(headerItems.isDisplayed());
        for (HeaderItemsData item : itemsText) {
            assertTrue(headerItems.getText().contains(item.toString()));
        }
    }

    public void checkImages() {
        assertTrue(practiceIcon.isDisplayed());
        assertTrue(customIcon.isDisplayed());
        assertTrue(multiIcon.isDisplayed());
        assertTrue(baseIcon.isDisplayed());
    }

    public void checkTextsUnderIcons() {
        assertTrue(practiceText.isDisplayed());
        assertTrue(customText.isDisplayed());
        assertTrue(multiText.isDisplayed());
        assertTrue(baseText.isDisplayed());
    }

    public void checkMainHeaderTexts() {
        assertTrue(headerText.isDisplayed());
        assertTrue(headerTitle.isDisplayed());
    }

    public void checkForIframe() {
        assertTrue(iframe.isDisplayed());
    }

    public void switchToIframeAndLogoCheck() {
        driver.switchTo().frame(iframe);
        assertTrue(driver.findElement(By.cssSelector("[id='epam_logo']")).isDisplayed());
    }

    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }

    public void checkSubHeaderText(HomePageData sub) {
        assertEquals(subHeader.getText(), sub.toString());
    }

    public void checkSubHeaderLink(HomePageData link) {
        assertEquals(subHeader.getAttribute("href"), link.toString());
    }

    public void checkForLeftSection() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkForFooter() {
        assertTrue(footer.isDisplayed());
    }
}
