package org.example.BasePage;

import io.appium.java_client.android.AndroidDriver;
import org.example.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicFunctions {

//    AndroidDriver driver = Capabilities.appCapabilities();
    public boolean isVisible(WebElement element){
        return element.isDisplayed();
    }

    public void explicitWait(AndroidDriver driver , WebElement element,int time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickByText(AndroidDriver driver,String text){
        driver.findElementByXPath("(//*[contains(@text,'" + text + "')])").click();
    }
}
