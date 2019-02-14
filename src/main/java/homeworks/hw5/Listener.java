package homeworks.hw5;

import org.testng.TestListenerAdapter;

public class Listener extends TestListenerAdapter {
   /* @Attachment(value = "Attachment: {0}", type = "image/png")
    public byte[] makeScreenshot() {
        byte[] array = {1};
        try {
            return ((TakesScreenshot) getWebDriver().getScreenshotAs(OutputType.BYTES));
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return array;
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        makeScreenshot();
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        makeScreenshot();
    }*/

}
