package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObject.Base_PO;

public class Contact_Us_Steps extends Base_PO {
    private WebDriver driver = getDriver();

    @Given("I access the WebDriver University contact us page")
    public void i_access_the_web_driver_university_contact_us_page() {
        navigateTo_URL("https://webdriveruniversity.com/Contact-Us/contactus.html");
        System.out.println("✅ Accessed the webpage");
    }

    /** Unique Data Step Definitions **/
    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        sendKeys(By.xpath("//input[@name='first_name']"), "AutoFN" + generateRandomNumber(5));
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
    /** ------------------------------- **/

    /** Specific Data Step Definitions **/
    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
        System.out.println("✅ Added first name: " + firstName);
    }
    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
        System.out.println("✅ Added last name: " + lastName);
    }
    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String emailAddress) {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(emailAddress);
        System.out.println("✅ Added email address: " + emailAddress);
    }
    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(comment);
        System.out.println("✅ Added comment: " + comment);
    }
    /** ------------------------------- **/

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
