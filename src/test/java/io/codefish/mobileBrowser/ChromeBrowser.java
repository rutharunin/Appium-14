package io.codefish.mobileBrowser;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeBrowser {
    AndroidDriver<AndroidElement> driver;
    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setPlatform(Platform.ANDROID);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 API 28");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
        URL serverUrl=new URL("http://localhost:4723/wd/hub");

        driver=new AndroidDriver<AndroidElement>(serverUrl,caps);


    }
//    @Test
//    public void chromeTest(){
//        driver.get("https://www.facebook.com");
//    }
}
