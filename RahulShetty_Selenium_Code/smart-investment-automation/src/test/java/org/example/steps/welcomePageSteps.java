package org.example.steps;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Capabilities;
import org.example.Pages.WelcomePage;
import org.junit.Assert;


public class welcomePageSteps {

    AndroidDriver driver = Capabilities.appCapabilities();

    WelcomePage welcomePage=new WelcomePage(driver);

    @Given("^user is on welcome page$")
    public void checkHomepage(){
        Assert.assertTrue("Welcome page is not shown on opening the app", welcomePage.welcomePageText());
    }

    @And("^user enters the id in the box$")
    public void enterIdInBox(){
        welcomePage.clickIdBox();
        welcomePage.enterId();
    }

    @Then("^user clicks the \"([^\"]*)\" button$")
    public void user_clicks_the_submit_button(String name) throws InterruptedException {
        Thread.sleep(1000);
        welcomePage.click(name);

    }

    @And("^user selects \"([^\"]*)\" environment$")
    public void user_selects_prod_environment(String name) throws InterruptedException {
        welcomePage.click(name);
    }

    @And("^user enables the \"([^\"]*)\" toggle$")
    public void user_enables_the_leprechaun_toggle(String name) throws InterruptedException {
        welcomePage.click(name);
    }

    @And("^user checks the Custom broker config is false$")
    public void user_checks_the_Custom_broker_config_is_false(){
        Assert.assertFalse("Custom brokerconfig is not false",welcomePage.checkToggle());
    }

    @Then("^user enters \"([^\"]*)\" search term in search bar$")
    public void enter_Search_Text(String searchTerm){
        welcomePage.enterTextInSearchBar(searchTerm);
    }

    @Then("^user selects the \"([^\"]*)\" text from suggestions$")
    public void select_suggestions(String name){
        welcomePage.clickSuggestions(name);
    }

    @When("^user enters (.*) quantity$")
    public void user_enter_quantity(int quantity){
        welcomePage.enterQuantity(quantity);
    }

    @Then("^user should see the webview bottomsheet$")
    public void webviewBottomsheet() throws InterruptedException {
        welcomePage.webviewContext();
    }

    @When("^user clicks the more button on webview$")
    public void clickMoreOnWebview() throws InterruptedException {
        welcomePage.clickMoreButton();
    }

    @And("^user clicks the motilal oswal broker$")
    public void clickMotilalOswal() throws InterruptedException {
        Thread.sleep(1000);
        welcomePage.tapMotilalOswal();

    }

    @Then("^user switches chrome webview context$")
    public void chromeWebviewSwitch() throws InterruptedException {
        welcomePage.switchToChromeWebview();
    }

    @When("^user enters leprechaunId in chromw webview$")
    public void enterLeprechaunId(){
        welcomePage.enterIdInWebview();
    }

    @Then("^user should see the transaction success popup$")
    public void transactionSuccessPopup() throws InterruptedException {

        welcomePage.transcationSuccess();
    }
}
