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
import pageObject.Contact_Us_PO;

public class Contact_Us_Steps extends Base_PO {
    private WebDriver driver = getDriver();

    private Contact_Us_PO contact_us_po;

    public Contact_Us_Steps(Contact_Us_PO contact_us_po) {
        this.contact_us_po = contact_us_po;
    }

    @Given("I access the WebDriver University contact us page")
    public void i_access_the_web_driver_university_contact_us_page() {
        contact_us_po.navigateTo_WebDriverUniversity_Contact_Us_Page();
        System.out.println("✅ Accessed the webpage");
    }

    /** Unique Data Step Definitions **/
    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        contact_us_po.setUnique_FirstName();
        System.out.println("✅ Entered generated first name");
    }
    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        contact_us_po.setUnique_LastName();
        System.out.println("✅ Entered generated last name");
    }
    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        contact_us_po.setUnique_EmailAddress();
        System.out.println("✅ Entered email address");
    }
    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        contact_us_po.setUnique_Comment();
        System.out.println("✅ Entered generated message");
    }
    /** ------------------------------- **/

    /** Specific Data Step Definitions **/
    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        contact_us_po.setSpecific_FirstName(firstName);
        System.out.println("✅ Added first name: " + firstName);
    }
    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        contact_us_po.setSpecific_LastName(lastName);
        System.out.println("✅ Added last name: " + lastName);
    }
    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String emailAddress) {
        contact_us_po.setSpecific_EmailAddress(emailAddress);
        System.out.println("✅ Added email address: " + emailAddress);
    }
    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        contact_us_po.setSpecific_Comment(comment);
        System.out.println("✅ Added comment: " + comment);
    }
    /** ------------------------------- **/

    @And("I click the submit button")
    public void i_click_the_submit_button() {
        contact_us_po.clickOn_Submit_Button();
        System.out.println("✅ Pressed submit button");
    }
    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
       // WebElement contactUs_Submission_Message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        contact_us_po.validate_SuccessfulSubmission_Message();
        System.out.println("✅ Received submission message");
    }
}
