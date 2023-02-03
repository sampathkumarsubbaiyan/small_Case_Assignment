package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Capabilities {

    public static AndroidDriver driver;
    public static AndroidDriver appCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("deviceName","Emulator1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "in.smallcase.gateway.sample");
        capabilities.setCapability("appActivity", "in.smallcase.gateway.sample.MainActivity");
        try {
            driver=new AndroidDriver(new URL("http://127.0.0.1:4725/wd/hub"),capabilities);
        }
        catch (MalformedURLException e){
            System.out.println("Exception thrown for URL");
        }
        return driver;
    }

}
