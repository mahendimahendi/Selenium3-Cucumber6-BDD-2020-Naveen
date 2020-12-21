package stepDefinations;

import Factory.DriverFactory;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginSteps {

    public static String title;
    public static String validationText;
    public LoginPage loginpage = new LoginPage(DriverFactory.getDriver());


    @Given("^User is launching the browser and enter the URL \"([^\"]*)\"$")
    public void user_is_launching_the_browser_and_enter_the_url_something(String url) throws Throwable {

        DriverFactory.getDriver().get(url);
    }

    @When("^User is clicks on the MyAccount dropdown$")
    public void user_is_clicks_on_the_myaccount_dropdown() throws Throwable {
            loginpage.ClickOnMyAccountDP();
    }

   @And("^User is clicks on the Login link$")
    public void user_is_clicks_on_the_login_link() throws Throwable {
            loginpage.ClickOnLoginLink();
    }

    @Then("^User should navigate on the login page$")
    public void user_should_navigate_on_the_login_page() throws Throwable {
            String loginPageHeader = loginpage.GetLoginPageHeader();
            Assert.assertEquals("Returning Customer",loginPageHeader);
    }

    @And("^User gets the title of the page$")
    public void user_gets_the_title_of_the_page() throws Throwable {
        title = loginpage.getLoginPageTitle();
        System.out.println("Login page title is " +title);
    }

    @And("^Page title should be \"([^\"]*)\"$")
    public void page_title_should_be_something(String expectedTitleName) {

        Assert.assertTrue(title.contains(expectedTitleName));
    }

    @Given("User is on login page")
    public void user_is_on_login_page() {

        DriverFactory.getDriver().get("https://gocommerce.kmms.com.au/index.php?route=account/login");
    }

    @Then("Forgotten Password link should be displayed")
    public void forgotten_password_link_should_be_displayed() {

        Assert.assertTrue(loginpage.isForgottenPasswordLinkPresent());

    }

    @When("^User is clicks on the continue button from the New customer section$")
    public void user_is_clicks_on_the_continue_button_from_the_new_customer_section() throws Throwable {

        loginpage.clickOnRegistrationBtn();
    }

    @Then("^User should navigate on the Registration page$")
    public void user_should_navigate_on_the_registration_page() throws Throwable {

        String registrationPageURL = loginpage.getRegistrationPageURL();
        Assert.assertEquals("https://gocommerce.kmms.com.au/index.php?route=account/register",registrationPageURL);

    }

    @When("^User enters valid email \"([^\"]*)\"$")
    public void user_enters_valid_email_something(String email) throws Throwable {
        loginpage.enterEmail(email);
    }

    @And("^User enters valid password \"([^\"]*)\"$")
    public void user_enters_valid_password_something(String password) throws Throwable {
        loginpage.enterPassword(password);
    }

    @And("^User is clicks on the login button$")
    public void user_is_clicks_on_the_login_button() throws Throwable {
        loginpage.ClickOnLoginBtn();
    }

    @Then("^User should be redirected on the Account page$")
    public void user_should_be_redirected_on_the_account_page() throws Throwable {

        String myAccountPageURL = loginpage.getMyAccountPageURL();
        Assert.assertEquals("https://gocommerce.kmms.com.au/index.php?route=account/account",myAccountPageURL);

    }

    @And("^User enters invalid password \"([^\"]*)\"$")
    public void user_enters_invalid_password_something(String invalidPassword) throws Throwable {

        loginpage.enterPassword(invalidPassword);
    }

    @Then("^Validation message should displayed$")
    public void validation_message_should_displayed() throws Throwable {
        validationText = loginpage.GetTextFromValidationMessage();
        Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.",validationText);
    }

    @And("^User should remain on the login and title should be \"([^\"]*)\"$")
    public void user_should_remain_on_the_login_and_title_should_be_something(String expectedTitle) throws Throwable {

        title = loginpage.getLoginPageTitle();
        System.out.println("Login page title is " +title);
        Assert.assertTrue(title.contains(expectedTitle));

    }


}
