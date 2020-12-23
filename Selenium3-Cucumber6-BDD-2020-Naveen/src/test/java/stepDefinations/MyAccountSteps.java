package stepDefinations;

import Factory.DriverFactory;
import Pages.LoginPage;
import Pages.MyAccountPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.List;
import java.util.Map;

public class MyAccountSteps {

    public LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
    public MyAccountPage myAccountPage;

    @Given("^User has already logged in to application$")
    public void user_has_already_logged_in_to_application(DataTable dataTable) throws Throwable {

        List<Map<String, String>> credential = dataTable.asMaps();
        String Email = credential.get(0).get("email");
        String Password = credential.get(0).get("password");

        DriverFactory.getDriver().get("https://gocommerce.kmms.com.au/index.php?route=account/login");
        myAccountPage = loginpage.doLogin(Email,Password);
    }

    @Given("^User is on my account page$")
    public void user_is_on_my_account_page() throws Throwable {

        myAccountPage.getMyAccountTitle();

    }

    @Then("^User gets my account section$")
    public void user_gets_my_account_section(DataTable sectionsTable) throws Throwable {

       List<String> expAccountSectionsList = sectionsTable.asList();
       System.out.println("Expected Account Sections List " +expAccountSectionsList);

       List<String> actAccountSectionsList = myAccountPage.getAccountsSectionsList();
       System.out.println("Actual Account Sections List " +actAccountSectionsList);

       Assert.assertTrue(expAccountSectionsList.containsAll(actAccountSectionsList));

    }

    @And("^My account section links count should be {int}$")
    public void my_account_section_links_count_should_be(Integer expectedCount) {
        Assert.assertTrue(myAccountPage.myAccountSectionLinksCounts() == expectedCount);

    }




}
