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

    @When("I enter a username {word}")
    public void i_enter_a_username(String username) {
        driver.findElement(By.id("text")).sendKeys(username);
        System.out.println("✅ Added username: " + username);
    }
    @And("I enter a password {word}")
    public void i_enter_a_password(String password) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        System.out.println("✅ Added password: " + password);
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
        System.out.println("✅ Pressed login button");
    }

    @Then("I should be presented with a login validation popup {}")
    public void i_should_be_presented_with_a_login_validation_popup(String expectedLoginMessage) {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message, expectedLoginMessage);
        System.out.println("✅ Received submission message - " + login_Message);
    }
}
