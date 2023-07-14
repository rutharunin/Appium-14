package io.temp.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Homepage2 {
    public  Homepage2(AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(25)),this);
    }
    //    public HomePage(AppiumDriver driver) {
//        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(25)),this);
//    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Animation\"]")
    public AndroidElement animationButton;
}
