package main.java.appiumdriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static final String APP_PACKAGE = "D:\\Projects\\Appium\\Appium\\app\\TheApp.apk";
    private static final String APPIUM_URL = "http://localhost:4723";
    private static final String PLATFORM_NAME_ANDROID = "Android";
    private static final String AUTOMATION_NAME_ANDROID = "UiAutomator2";
    private static final String BROWSER_NAME_ANDROID = "Chrome";

    private static final String PLATFORM_NAME_IOS = "iOS";
    private static final String AUTOMATION_NAME_IOS = "XCUITest";
    private static final String BROWSER_NAME_IOS = "Safari";

    private static final int IMPLICITLY_WAIT = 5;
    private final DriverType driverType;
    private AppiumDriver driver;

    public DriverManager(DriverType driverType){
        this.driverType = driverType;
    }

    private void createWebDriver(){
        DesiredCapabilities desiredCapabilities;
        switch (driverType){
            case ANDROID_EMULATOR_V11:
                desiredCapabilities = createDefaultCapabilitiesAndroid();
                desiredCapabilities.setCapability("deviceName", "Appium_v11");
                desiredCapabilities.setCapability("platformVersion", "11");
                try {
                    driver = new AndroidDriver(new URL(APPIUM_URL), desiredCapabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();}
                break;
            case ANDROID_EMULATOR_V10:
                desiredCapabilities = createDefaultCapabilitiesAndroid();
                desiredCapabilities.setCapability("deviceName", "Appium_v10");
                desiredCapabilities.setCapability("platformVersion", "10");
                try {
                    driver = new AndroidDriver(new URL(APPIUM_URL), desiredCapabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();}
                break;
            case IOS_EMULATOR_2:
                desiredCapabilities = createDefaultCapabilitiesIos();
                desiredCapabilities.setCapability("deviceName", "ios_emulator");
                desiredCapabilities.setCapability("platformVersion", "12.3");
                try {
                    driver = new IOSDriver(new URL(APPIUM_URL), desiredCapabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();}
        }
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
        }

        public AppiumDriver getDriver(){
        if (driver == null){
            createWebDriver();
        }
        return driver;
    }

    public void quitDriver(){
        if (driver != null){
            driver.quit();
            driver=null;
        }
    }

    private DesiredCapabilities createDefaultCapabilitiesAndroid(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", PLATFORM_NAME_ANDROID);
        desiredCapabilities.setCapability("automationName", AUTOMATION_NAME_ANDROID);
        //desiredCapabilities.setCapability("browserName", BROWSER_NAME_ANDROID);
        desiredCapabilities.setCapability("app", APP_PACKAGE);
        return desiredCapabilities;
    }
    private DesiredCapabilities createDefaultCapabilitiesIos(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", PLATFORM_NAME_IOS);
        desiredCapabilities.setCapability("automationName", AUTOMATION_NAME_IOS);
        //desiredCapabilities.setCapability("browserName", BROWSER_NAME_IOS);
        desiredCapabilities.setCapability("app", APP_PACKAGE);

        return desiredCapabilities;
    }




}
