package test.java;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;
import java.time.Duration;

import io.appium.java_client.AppiumDriver;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class L06_WebTests {

    private static final String APPIUM = "http://localhost:4723";
    private AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("platformVersion", "11");
        cap.setCapability("browserName", "Chrome");

        driver = new AppiumDriver(new URL(APPIUM), cap);

        System.out.println("Emulator is ON");
    }

    @Test
    public void AppiumTestL06() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://id.heroku.com/login");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#onetrust-accept-btn-handler"))).click();

    }
}
