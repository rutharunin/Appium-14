package io.temp;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.temp.pages.Homepage2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Gesture3 {
    AndroidDriver<AndroidElement> driver;

    @Before
    public void setup() throws MalformedURLException {
        File file=new File("src/test/resources/ApiDemos-debug-newVersion.apk");
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setPlatform(Platform.ANDROID);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 API 28");
        caps.setCapability(MobileCapabilityType.APP,file.getAbsolutePath());
        URL serverUrl=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver<AndroidElement>(serverUrl,caps);
    }

    @Test
    public void scrollDownTest(){

        AndroidElement animationButton=
                driver.findElementByAndroidUIAutomator("text(\"Animation\")");
        Assert.assertEquals("Animation",animationButton.getText());

//        AndroidElement viewButton=driver.findElementByAndroidUIAutomator("text(\"Views\")");
        AndroidElement viewButton=driver.findElementByAndroidUIAutomator("text(\"Views\")");
        viewButton.click();

        AndroidElement tabsButton=
                driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tabs\"))");
        Assert.assertTrue(tabsButton.isDisplayed());

    }
    @Test
    public void tapTest(){

        AndroidElement viewButton=driver.findElementByAndroidUIAutomator("text(\"Views\")");
        TouchAction touchAction=new TouchAction<>(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(viewButton))).perform();

    }
    @Test
    public void longPressTest(){

        AndroidElement viewButton=driver.findElementByAndroidUIAutomator("text(\"Views\")");
        TouchAction touchAction=new TouchAction<>(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(viewButton))).perform();
        AndroidElement expandableList=driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(expandableList))).perform();
        AndroidElement customAdapter=driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(customAdapter))).perform();
        AndroidElement peopleName=driver.findElementByAndroidUIAutomator("text(\"People Names\")");

        touchAction.longPress(LongPressOptions.longPressOptions()
                .withElement(ElementOption.element(peopleName))
                .withDuration(Duration.ofSeconds(2))).perform();

    }
    @Test
    public void pagesTest(){

        Homepage2 homepage2=new Homepage2(driver);
        homepage2.animationButton.click();
    }
}
