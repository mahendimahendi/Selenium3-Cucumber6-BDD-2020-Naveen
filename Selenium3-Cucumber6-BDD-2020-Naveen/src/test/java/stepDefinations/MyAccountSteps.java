package stepDefinations;

import Factory.DriverFactory;
import Pages.LoginPage;
import Pages.MyAccountPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
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


}
