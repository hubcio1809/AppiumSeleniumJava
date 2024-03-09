package test.java;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class L03_WaitingForElements {


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
    public void AppiumTestL03() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginScreen = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.accessibilityId("Login Screen")));
        loginScreen.click();
        WebElement username = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.accessibilityId("username")));
        username.sendKeys("alice");
        WebElement password = driver.findElement(AppiumBy.accessibilityId("password"));
        password.sendKeys("mypassword");
        WebElement loginButton = driver.findElement(AppiumBy.accessibilityId("loginBtn"));
        loginButton.click();
        WebElement loginText = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[contains(@text, \"You are logged in as\")]")));

        assert(loginText.getText().contains("alice"));


    }
}
