package test.java;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class L04_GetPageSourceReadLocator {

    private static final String APP = "D:\\Projects\\Appium\\Appium\\app\\TheApp.apk";
    //private static final String APP = "https://github.com/cloudgrey-io/the-app/releases/download/v1.9.0/TheApp-v1.9.0.apk";
    private static final String APPIUM = "http://localhost:4723";
    private static AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("platformVersion", "11");
        cap.setCapability("app", APP);

        driver = new AppiumDriver(new URL(APPIUM), cap);

        System.out.println("Emulator is ON");
    }

    @Test
    public void AppiumTestL04() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement screen = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Login Screen")));
        screen.click();

        try { Thread.sleep(1000); } catch (Exception ign) {}
        System.out.println(driver.getPageSource());


    }
}
