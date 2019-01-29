package homeworks.hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class HomeworkSoftTest {

    @Test
    public void homeSoftSiteTest() {
        SoftAssert softAssert = new SoftAssert();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String handle = driver.getWindowHandle();
        driver.switchTo().window(handle);

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        softAssert.assertEquals(driver.getCurrentUrl(), "https://epam.github.io/JDI/index.html");


        //2 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();


        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement element = driver.findElement(By.id("user-name"));
        softAssert.assertTrue(element.isDisplayed());
        softAssert.assertEquals(element.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement itemHome = driver.findElement(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 li a[href='index.html']"));
        softAssert.assertTrue(itemHome.isDisplayed());
        softAssert.assertEquals(itemHome.getText(), "HOME");
        WebElement itemContact = driver.findElement(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 li a[href='contacts.html']"));
        softAssert.assertTrue(itemContact.isDisplayed());
        softAssert.assertEquals(itemContact.getText(), "CONTACT FORM");
        WebElement itemService = driver.findElement(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 li a[data-toggle='dropdown']"));
        softAssert.assertTrue(itemService.isDisplayed());
        softAssert.assertEquals(itemService.getText(), "SERVICE");
        WebElement itemMetals = driver.findElement(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 li a[href='metals-colors.html']"));
        softAssert.assertTrue(itemMetals.isDisplayed());
        softAssert.assertEquals(itemMetals.getText(), "METALS & COLORS");


        //7 Assert that there are 4 images on the Index Page and they are displayed
        WebElement img1 = driver.findElement(By.cssSelector(".icons-benefit.icon-practise"));
        softAssert.assertTrue(img1.isDisplayed());
        WebElement img2 = driver.findElement(By.cssSelector(".icons-benefit.icon-custom"));
        softAssert.assertTrue(img2.isDisplayed());
        WebElement img3 = driver.findElement(By.cssSelector(".icons-benefit.icon-multi"));
        softAssert.assertTrue(img3.isDisplayed());
        WebElement img4 = driver.findElement(By.cssSelector(".icons-benefit.icon-base"));
        softAssert.assertTrue(img4.isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textElements = driver.findElements(By.className("benefit-txt"));
        softAssert.assertEquals(textElements.size(), 4);
        softAssert.assertEquals(textElements.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        softAssert.assertEquals(textElements.get(1).getText(), "To be flexible and\n" +
                "customizable");
        softAssert.assertEquals(textElements.get(2).getText(), "To be multiplatform");
        softAssert.assertEquals(textElements.get(3).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main headers
        WebElement mainTitle1 = driver.findElement(By.cssSelector(".main-title.text-center"));
        softAssert.assertTrue(mainTitle1.isDisplayed());
        softAssert.assertEquals(mainTitle1.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement mainText1 = driver.findElement(By.cssSelector(".main-txt.text-center"));
        softAssert.assertTrue(mainText1.isDisplayed());
        softAssert.assertEquals(mainText1.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert that there is the iframe in the center of page
        WebElement iFrame = driver.findElement(By.cssSelector("[id='iframe']"));
        softAssert.assertTrue(iFrame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        WebElement epamLogo = driver.findElement(By.cssSelector("[id='epam_logo']"));
        softAssert.assertTrue(epamLogo.isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector(".uui-main-container a[target='_blank']"));
        softAssert.assertTrue(subHeader.isDisplayed());
        softAssert.assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.cssSelector(".uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar"));
        softAssert.assertTrue(leftSection.isDisplayed());

        //16
        WebElement footer = driver.findElement(By.className("footer-bg"));
        softAssert.assertTrue(!footer.isDisplayed());

        //17 Close Browser
        driver.close();
        softAssert.assertAll();
    }

}
