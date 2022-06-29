package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Login_Steps {
    private WebDriver driver;

    @Before("@login")
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        System.out.println("✅ Opened Chrome");
        //driver.manage().window(),maximize();
    }

    @After("@login")
    public void tearDown() {
        driver.quit();
        System.out.println("✅ Closed Chrome");
    }

    @Given("I access the WebDriver University login page")
    public void i_access_the_web_driver_university_login_page() {
        driver.get("https://webdriveruniversity.com/Login-Portal/index.html");
        System.out.println("✅ Accessed the webpage");
    }

    /** Successful Login Step Definitions **/
    @When("I enter the correct username of an existing account {word}")
    public void i_enter_the_correct_username_of_an_existing_account(String username) {
        driver.findElement(By.id("text")).sendKeys(username);
        System.out.println("✅ Added username: " + username);
    }
    @And("I enter the correct password for that username {word}")
    public void i_enter_the_correct_password_for_that_username(String password) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        System.out.println("✅ Added password: " + password);
    }
    /** ------------------------------- **/

    /** Unsuccessful Login Step Definitions - Incorrect Username **/
    @When("I enter a username that is misspelled {word}")
    public void i_enter_a_username_that_is_misspelled(String username) {
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys(username);
        System.out.println("✅ Added username: " + username);
    }
    /** ------------------------------- **/


    /** Unsuccessful Login Step Definitions - Incorrect Password **/
    @And("I enter an incorrect password for that username {word}")
    public void i_enter_an_incorrect_password_for_that_username(String password) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        System.out.println("✅ Added password: " + password);
    }
    /** ------------------------------- **/

    @And("I click the login button")
    public void i_click_the_login_button() {
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
        System.out.println("✅ Pressed login button");
    }

    @Then("I should be presented with a successful login popup")
    public void i_should_be_presented_with_a_successful_login_popup() {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message, "validation succeeded");
        System.out.println("✅ Received submission message - succeeded");
    }

    @Then("I should be presented with a unsuccessful login popup")
    public void i_should_be_presented_with_a_unsuccessful_login_popup() {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message, "validation failed");
        System.out.println("✅ Received submission message - failed");
    }
}
