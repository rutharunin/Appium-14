package io.codefishStore.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TestWithBaks {
    AndroidDriver<AndroidElement> driver;
    @Before
    public void setup() throws MalformedURLException {
        File file=new File("src/test/resources/Codefish-Store.apk");
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setPlatform(Platform.ANDROID);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 API 28");
        caps.setCapability(MobileCapabilityType.APP,file.getAbsolutePath());
        URL serverUrl=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver<AndroidElement>(serverUrl,caps);
    }
    @Test
    public void selectAustralia() throws InterruptedException {

        Thread.sleep(3000);
        AndroidElement selectCountryDropdown=
                driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
        selectCountryDropdown.click();
        AndroidElement australia=
                driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))");
        australia.click();
    }
}
