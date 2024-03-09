package main.java.view;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseView {
    protected final AppiumDriver driver;
    public BaseView(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
