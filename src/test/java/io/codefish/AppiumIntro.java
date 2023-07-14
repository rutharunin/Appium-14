package io.codefish;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class AppiumIntro {

    @Test
    public void appiumConnectionTest() throws MalformedURLException {

        File apkFile=new File("src/test/resources/ApiDemos-debug-newVersion.apk");

        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","Pixel 2 API 28");
        desiredCapabilities.setCapability("platformName","android");
        desiredCapabilities.setCapability("app",apkFile.getAbsolutePath());

        // 0.0.0.0 ==localhost
        URL serverUrl=new URL("http://localhost:4723/wd/hub");
        AndroidDriver<AndroidElement> driver=new AndroidDriver<>(serverUrl,desiredCapabilities);

        AndroidElement animationButton=
                driver.findElement(By.xpath("//android.widget.TextView[@text='Animation']"));
        animationButton.click();

        AndroidElement loadingButton=
                driver.findElementByAccessibilityId("Loading");
        loadingButton.click();

        AndroidElement runButton=
                driver.findElement(By.id("io.appium.android.apis:id/startButton"));
        TouchAction touchAction=new TouchAction<>(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(runButton))).perform();
        Assert.assertTrue(runButton.isDisplayed());
    }

    @Test
    public void multipleElementsTest() throws MalformedURLException {

        File apkFile=new File("src/test/resources/ApiDemos-debug-newVersion.apk");

        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","Pixel 2 API 28");
        desiredCapabilities.setCapability("platformName","android");
        desiredCapabilities.setCapability("app",apkFile.getAbsolutePath());

        URL serverUrl=new URL("http://localhost:4723/wd/hub");

        AndroidDriver<AndroidElement>driver=new AndroidDriver<>(serverUrl,desiredCapabilities);

        List<AndroidElement> links=driver.findElements(By.id("android:id/text1"));

        Assert.assertEquals(12,links.size());


    }
}
