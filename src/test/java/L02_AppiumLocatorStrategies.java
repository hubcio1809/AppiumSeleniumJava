package test.java;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class L02_AppiumLocatorStrategies {

    private static final String APP = "D:\\Projects\\Appium\\Appium\\app\\TheApp.apk";
    //private static final String APP = "https://github.com/cloudgrey-io/the-app/releases/download/v1.9.0/TheApp-v1.9.0.apk";
    private static final String APPIUM = "http://localhost:4723";
    private static AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName","Android");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("platformVersion","11");
        cap.setCapability("app",APP);

        driver = new AppiumDriver(new URL(APPIUM), cap);

        System.out.println("Emulator is ON");
    }
    @Test
    public void AppiumTestL02() {
        driver.findElement(AppiumBy.accessibilityId("Login Screen"));
        List<WebElement> elementList = driver.findElements(AppiumBy.accessibilityId("xx Screen"));
        System.out.println(elementList.size());
        System.out.println("Here's our test!");
        /*
        Znajdowanie listy elementow i wydrukowanie dlługości listy, tutaj jak nic nie znajdzie to nie da błędu

        List<WebElement> elements = driver.findElements(MobileBy.AccessibilityId("Login Screen"));
        System.out.println(elements.size());
         */
    }



    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }}

