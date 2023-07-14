package io.codefish.key_events;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class KeyPressEvents {
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
    public void keyPressTest() throws InterruptedException {

        AndroidElement viewButton=driver.findElementByAccessibilityId("Views");
        viewButton.click();

        Thread.sleep(3000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));

        ScreenOrientation orientation=driver.getOrientation();
        System.out.println(orientation);
        System.out.println(driver.isDeviceLocked());
        System.out.println(driver.getBatteryInfo().getState());


    }
}
