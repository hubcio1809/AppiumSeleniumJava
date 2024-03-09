package test.java;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class L01_AppiumSession {
    private static final String APP = "D:\\Projects\\Appium\\Appium\\app\\TheApp.apk";
    //private static final String APP = "https://github.com/cloudgrey-io/the-app/releases/download/v1.9.0/TheApp-v1.9.0.apk";
    private static final String APPIUM = "http://localhost:4723";
    private static AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName","Android");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("platformVersion","11");
        cap.setCapability("app",APP);

        driver = new AndroidDriver(new URL(APPIUM), cap);

        //driver = new AppiumDriver(url, cap);

        System.out.println("Emulator is ON");
    }

    @Test
    public void AppiumTestL01() {
            System.out.println("Here's our test!");
        }



    @After
    public void tearDown() {
        System.out.println("xd");
    }}
