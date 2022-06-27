package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Contact_Us_Steps {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        System.out.println("✅ Opened Chrome");
        //driver.manage().window(),maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
        System.out.println("✅ Closed Chrome");
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    @Given("I access the WebDriver University contact us page")
    public void i_access_the_web_driver_university_contact_us_page() {
        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
        System.out.println("✅ Accessed the website");
    }
    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + generateRandomNumber(5));
        System.out.println("✅ Entered generated first name");
    }
    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("AutoLN" + generateRandomNumber(5));
        System.out.println("✅ Entered generated last name");
    }
    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("AutoEmail" + generateRandomNumber(7) + "@mail.com");
        System.out.println("✅ Entered email address");
    }
    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Hello! " + generateRandomString(20));
        System.out.println("✅ Entered generated message");
    }
    @And("I click the submit button")
    public void i_click_the_submit_button() {
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
        System.out.println("✅ Pressed submit button");
    }
    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        WebElement contactUs_Submission_Message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUs_Submission_Message.getText(), "Thank You for your Message!");
        System.out.println("✅ Received submission message");
    }
}
