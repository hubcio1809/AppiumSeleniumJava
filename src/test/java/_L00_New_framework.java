package test.java;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import main.java.appiumdriver.DriverManager;
import main.java.appiumdriver.DriverType;
import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class _L00_New_framework {
    protected static DriverManager driverManager;
    protected AppiumDriver driver;
    //protected ICommon common;
    //protected MainView mainView; potem

    @BeforeClass
    public static void beforeSuite(){
        driverManager = new DriverManager(DriverType.ANDROID_EMULATOR_V11);
    }
    @Before
    public void beforeTest(){
        driver = driverManager.getDriver();
    }

    @After
    public void tearDown(){
        driverManager.quitDriver();
    }

    @Test
    public void FirstTC(){
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
