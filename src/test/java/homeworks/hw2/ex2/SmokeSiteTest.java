package homeworks.hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeSiteTest {

    @Test(groups = {"Smoke"})

    public void homeSiteSmokeTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String handle = driver.getWindowHandle();
        driver.switchTo().window(handle);

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        assertEquals(driver.getCurrentUrl(), "https://epam.github.io/JDI/index.html");


        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();


        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement element = driver.findElement(By.id("user-name"));
        assertTrue(element.isDisplayed());
        assertEquals(element.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement itemHome = driver.findElement(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 li a[href='index.html']"));
        assertTrue(itemHome.isDisplayed());
        assertEquals(itemHome.getText(), "HOME");
        WebElement itemContact = driver.findElement(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 li a[href='contacts.html']"));
        assertTrue(itemContact.isDisplayed());
        assertEquals(itemContact.getText(), "CONTACT FORM");
        WebElement itemService = driver.findElement(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 li a[data-toggle='dropdown']"));
        assertTrue(itemService.isDisplayed());
        assertEquals(itemService.getText(), "SERVICE");
        WebElement itemMetals = driver.findElement(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 li a[href='metals-colors.html']"));
        assertTrue(itemMetals.isDisplayed());
        assertEquals(itemMetals.getText(), "METALS & COLORS");


        //7 Assert that there are 4 images on the Index Page and they are displayed
        WebElement img1 = driver.findElement(By.cssSelector(".icons-benefit.icon-practise"));
        assertTrue(img1.isDisplayed());
        WebElement img2 = driver.findElement(By.cssSelector(".icons-benefit.icon-custom"));
        assertTrue(img2.isDisplayed());
        WebElement img3 = driver.findElement(By.cssSelector(".icons-benefit.icon-multi"));
        assertTrue(img3.isDisplayed());
        WebElement img4 = driver.findElement(By.cssSelector(".icons-benefit.icon-base"));
        assertTrue(img4.isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textElements = driver.findElements(By.className("benefit-txt"));
        assertEquals(textElements.size(), 4);
        assertEquals(textElements.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        assertEquals(textElements.get(1).getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(textElements.get(2).getText(), "To be multiplatform");
        assertEquals(textElements.get(3).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main headers
        WebElement mainTitle1 = driver.findElement(By.cssSelector(".main-title.text-center"));
        assertTrue(mainTitle1.isDisplayed());
        assertEquals(mainTitle1.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement mainText1 = driver.findElement(By.cssSelector(".main-txt.text-center"));
        assertTrue(mainText1.isDisplayed());
        assertEquals(mainText1.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert that there is the iframe in the center of page
        WebElement iFrame = driver.findElement(By.cssSelector("[id='iframe']"));
        assertTrue(iFrame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        WebElement epamLogo = driver.findElement(By.cssSelector("[id='epam_logo']"));
        assertTrue(epamLogo.isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector(".uui-main-container a[target='_blank']"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.cssSelector(".uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar"));
        assertTrue(leftSection.isDisplayed());

        //16
        WebElement footer = driver.findElement(By.className("footer-bg"));
        assertTrue(footer.isDisplayed());

        //17 Close Browser
        driver.close();
    }
    @Test(groups = {"Smoke"})
    public void homeSiteSmokeTest1() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String handle = driver.getWindowHandle();
        driver.switchTo().window(handle);

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        assertEquals(driver.getCurrentUrl(), "https://epam.github.io/JDI/index.html");


        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();


        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement element = driver.findElement(By.id("user-name"));
        assertTrue(element.isDisplayed());
        assertEquals(element.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement itemHome = driver.findElement(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 li a[href='index.html']"));
        assertTrue(itemHome.isDisplayed());
        assertEquals(itemHome.getText(), "HOME");
        WebElement itemContact = driver.findElement(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 li a[href='contacts.html']"));
        assertTrue(itemContact.isDisplayed());
        assertEquals(itemContact.getText(), "CONTACT FORM");
        WebElement itemService = driver.findElement(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 li a[data-toggle='dropdown']"));
        assertTrue(itemService.isDisplayed());
        assertEquals(itemService.getText(), "SERVICE");
        WebElement itemMetals = driver.findElement(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 li a[href='metals-colors.html']"));
        assertTrue(itemMetals.isDisplayed());
        assertEquals(itemMetals.getText(), "METALS & COLORS");


        //7 Assert that there are 4 images on the Index Page and they are displayed
        WebElement img1 = driver.findElement(By.cssSelector(".icons-benefit.icon-practise"));
        assertTrue(img1.isDisplayed());
        WebElement img2 = driver.findElement(By.cssSelector(".icons-benefit.icon-custom"));
        assertTrue(img2.isDisplayed());
        WebElement img3 = driver.findElement(By.cssSelector(".icons-benefit.icon-multi"));
        assertTrue(img3.isDisplayed());
        WebElement img4 = driver.findElement(By.cssSelector(".icons-benefit.icon-base"));
        assertTrue(img4.isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textElements = driver.findElements(By.className("benefit-txt"));
        assertEquals(textElements.size(), 4);
        assertEquals(textElements.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        assertEquals(textElements.get(1).getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(textElements.get(2).getText(), "To be multiplatform");
        assertEquals(textElements.get(3).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main headers
        WebElement mainTitle1 = driver.findElement(By.cssSelector(".main-title.text-center"));
        assertTrue(mainTitle1.isDisplayed());
        assertEquals(mainTitle1.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement mainText1 = driver.findElement(By.cssSelector(".main-txt.text-center"));
        assertTrue(mainText1.isDisplayed());
        assertEquals(mainText1.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert that there is the iframe in the center of page
        WebElement iFrame = driver.findElement(By.cssSelector("[id='iframe']"));
        assertTrue(iFrame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        WebElement epamLogo = driver.findElement(By.cssSelector("[id='epam_logo']"));
        assertTrue(epamLogo.isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector(".uui-main-container a[target='_blank']"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.cssSelector(".uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar"));
        assertTrue(leftSection.isDisplayed());

        //16
        WebElement footer = driver.findElement(By.className("footer-bg"));
        assertTrue(footer.isDisplayed());

        //17 Close Browser
        driver.close();
    }
    @Test(groups = {"Smoke"})
    public void homeSiteSmokeTest2() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String handle = driver.getWindowHandle();
        driver.switchTo().window(handle);

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        assertEquals(driver.getCurrentUrl(), "https://epam.github.io/JDI/index.html");


        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();


        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement element = driver.findElement(By.id("user-name"));
        assertTrue(element.isDisplayed());
        assertEquals(element.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement itemHome = driver.findElement(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 li a[href='index.html']"));
        assertTrue(itemHome.isDisplayed());
        assertEquals(itemHome.getText(), "HOME");
        WebElement itemContact = driver.findElement(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 li a[href='contacts.html']"));
        assertTrue(itemContact.isDisplayed());
        assertEquals(itemContact.getText(), "CONTACT FORM");
        WebElement itemService = driver.findElement(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 li a[data-toggle='dropdown']"));
        assertTrue(itemService.isDisplayed());
        assertEquals(itemService.getText(), "SERVICE");
        WebElement itemMetals = driver.findElement(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 li a[href='metals-colors.html']"));
        assertTrue(itemMetals.isDisplayed());
        assertEquals(itemMetals.getText(), "METALS & COLORS");


        //7 Assert that there are 4 images on the Index Page and they are displayed
        WebElement img1 = driver.findElement(By.cssSelector(".icons-benefit.icon-practise"));
        assertTrue(img1.isDisplayed());
        WebElement img2 = driver.findElement(By.cssSelector(".icons-benefit.icon-custom"));
        assertTrue(img2.isDisplayed());
        WebElement img3 = driver.findElement(By.cssSelector(".icons-benefit.icon-multi"));
        assertTrue(img3.isDisplayed());
        WebElement img4 = driver.findElement(By.cssSelector(".icons-benefit.icon-base"));
        assertTrue(img4.isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textElements = driver.findElements(By.className("benefit-txt"));
        assertEquals(textElements.size(), 4);
        assertEquals(textElements.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        assertEquals(textElements.get(1).getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(textElements.get(2).getText(), "To be multiplatform");
        assertEquals(textElements.get(3).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main headers
        WebElement mainTitle1 = driver.findElement(By.cssSelector(".main-title.text-center"));
        assertTrue(mainTitle1.isDisplayed());
        assertEquals(mainTitle1.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement mainText1 = driver.findElement(By.cssSelector(".main-txt.text-center"));
        assertTrue(mainText1.isDisplayed());
        assertEquals(mainText1.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert that there is the iframe in the center of page
        WebElement iFrame = driver.findElement(By.cssSelector("[id='iframe']"));
        assertTrue(iFrame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        WebElement epamLogo = driver.findElement(By.cssSelector("[id='epam_logo']"));
        assertTrue(epamLogo.isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector(".uui-main-container a[target='_blank']"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.cssSelector(".uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar"));
        assertTrue(leftSection.isDisplayed());

        //16
        WebElement footer = driver.findElement(By.className("footer-bg"));
        assertTrue(footer.isDisplayed());

        //17 Close Browser
        driver.close();
    }
}
