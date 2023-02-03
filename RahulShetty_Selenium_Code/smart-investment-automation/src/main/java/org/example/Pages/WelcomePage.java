package org.example.Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.BasePage.BasicFunctions;
import org.example.Properties.DataProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.CookieManager;
import java.util.List;
import java.util.Set;


public class WelcomePage extends BasicFunctions {
    AndroidDriver driver;

    public WelcomePage(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id="smartinvesting_welcome")
    WebElement homeText;

    @FindBy(id = "main_id_name_tv")
    WebElement idbox;

    @FindBy(id = "main_id_submit_bt")
    WebElement submitButton;

    @FindBy(id = "prodRadioItem")
    WebElement prodOption;

    @FindBy(id = "leprechaunSwitch")
    WebElement clickToggle;

    @FindBy(id = "customBrokerSwitch")
    WebElement customBrokerToggle;

    @FindBy(id = "setupBt")
    WebElement setupButton;

    @FindBy(id = "android:id/button2")
    WebElement okButton;

    @FindBy(id = "in.smallcase.gateway.sample:id/sst")
    WebElement sstButton;

    @FindBy(id = "in.smallcase.gateway.sample:id/search_button")
    WebElement searchicon;

    @FindBy(id = "in.smallcase.gateway.sample:id/search_src_text")
    WebElement searchBar;

    @FindBy(id = "in.smallcase.gateway.sample:id/smallcase_securities_list_row_title_tv")
    List<WebElement> searchSuggestions;

    @FindBy(id = "in.smallcase.gateway.sample:id/transaction_qty_et")
    WebElement quantity;
    
    @FindBy(id = "in.smallcase.gateway.sample:id/transaction_add_bt")
    WebElement add;

    @FindBy(id = "in.smallcase.gateway.sample:id/transaction_order_bt")
    WebElement placeOrderBtn;

    @FindBy(xpath ="//span[@class='btnText__3Y2KJ flex text-13 text-normal font-medium']")
    WebElement moreButton;

    @FindBy(xpath="//img[@src='https://assets.smallcase.com/smallcase/assets/brokerLogo/small/motilal.svg']")
    WebElement motilalIcon;

    @FindBy(xpath="//input[@class='Leprechaun__leprechaun__JuqfW br-4 text-15 mb24']")
    WebElement leprechaunIdBox;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary-blue']")
    WebElement loginButton;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary-blue']")
    WebElement reviewButton;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary-green']")
    WebElement placeOrderButton;

    @FindBy(xpath = "//button[@class='OrderModalFooterWidgetJSX__confirm-button__1mBmW btn btn-lg btn-fw btn-primary-blue mt16']")
    WebElement confirmOrderButton;

    public boolean welcomePageText(){
        return (isVisible(homeText));
    }

    public void clickIdBox(){
        idbox.click();
    }

    public void enterId(){
        idbox.sendKeys(DataProperties.getTestData("welcomePageId"));
    }

    public void click(String name) throws InterruptedException {
        switch (name){
            case "submit":
                submitButton.click();
                break;
            case "prod":
                prodOption.click();
                break;
            case "leprechaun":
                clickToggle.click();
                break;
            case "setup":
                setupButton.click();
                break;
            case "ok":
                explicitWait(driver,okButton,500);
                okButton.click();
                break;
            case "SST":
                sstButton.click();
                break;
            case "searchBar":
                searchicon.click();
                break;
            case "quantity":
                quantity.click();
                break;
            case "add":
                add.click();
                System.out.println("1PLACE ORDER BTN IS CLICKED");
                break;
            case "placeOrder":
                placeOrderBtn.click();
                System.out.println("2PLACE ORDER BTN IS CLICKED");
                break;
            case "login":
                loginButton.click();
                break;
            case "review":
                Thread.sleep(5000);
                reviewButton.click();
                break;
            case "placeOrders":
                placeOrderButton.click();
                break;
            case "confirmOrder":
                confirmOrderButton.click();
                break;
        }
    }

    public boolean checkToggle(){
        String value=customBrokerToggle.getAttribute("checked");
        if(value.equals("false"))
            return false;
        else
            return true;
    }

    public void enterTextInSearchBar(String searchTerm){
        searchBar.sendKeys(searchTerm);
//        click ENTER using android key library
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void clickSuggestions(String name){
        List<WebElement> list=searchSuggestions;
        for(int i=0;i< list.size();i++)
            if((list.get(i).getText()).equals(name))
                searchSuggestions.get(i).click();
    }

    public void enterQuantity(int number){
        quantity.sendKeys(String.valueOf(number));
    }

    public void webviewContext() throws InterruptedException {
        Thread.sleep(2000);
        driver.context("WEBVIEW_in.smallcase.gateway.sample");
        System.out.println("Context Swithced To Webview");
    }

    public void clickMoreButton() throws InterruptedException {
        Thread.sleep(1000);
        try {
            motilalIcon.click();
            System.out.println("Motilal is available in the first bottomsheet");
        }
        catch (Exception e){
            moreButton.click();
            System.out.println("Motilal is not available hence clicking more button");
        }
    }

    public void tapMotilalOswal() throws InterruptedException {
        motilalIcon.click();
       Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
        }


    }

    public void switchToChromeWebview() throws InterruptedException {
        driver.context("WEBVIEW_chrome");
        Thread.sleep(7000);
    }

    public void enterIdInWebview(){
        leprechaunIdBox.click();
        leprechaunIdBox.sendKeys(DataProperties.getTestData("leprechaunId"));
    }

    public void transcationSuccess() throws InterruptedException {
        System.out.println("BEFORE"+driver.manage().getCookies());
        driver.manage().deleteAllCookies();
        Thread.sleep(10000);
        System.out.println("AFTER"+driver.manage().getCookies());
        driver.context("NATIVE_APP");
        explicitWait(driver,okButton,1000);
        okButton.click();
        System.out.println(driver.getClipboardText());
    }
}
