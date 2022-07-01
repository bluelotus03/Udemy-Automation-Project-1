package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.testng.Assert;
import pageObject.Base_PO;
import pageObject.Login_PO;

public class Login_Steps extends Base_PO {
    private WebDriver driver = getDriver();

    private Login_PO login_po;
    public Login_Steps(Login_PO login_po) {
        this.login_po = login_po;
    }
    @Given("I access the WebDriver University login page")
    public void i_access_the_web_driver_university_login_page() {
        login_po.navigateTo_WebDriverUniversity_Login_Page();
        System.out.println("✅ Accessed the webpage");
    }

    @When("I enter a username {word}")
    public void i_enter_a_username(String username) {
        //driver.findElement(By.id("text")).sendKeys(username);
        login_po.setUsername(username);
        System.out.println("✅ Added username: " + username);
    }
    @And("I enter a password {word}")
    public void i_enter_a_password(String password) {
        //driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        login_po.setPassword(password);
        System.out.println("✅ Added password: " + password);
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        //driver.findElement(By.xpath("//button[@id='login-button']")).click();
        login_po.clickOnLoginButton();
        System.out.println("✅ Pressed login button");
    }

    @Then("I should be presented with a login validation popup {}")
    public void i_should_be_presented_with_a_login_validation_popup(String expectedLoginMessage) {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message, expectedLoginMessage);
        System.out.println("✅ Received submission message - " + login_Message);
    }
}
