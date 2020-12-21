package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // 1. By Locators: Object Repository
    private By MyAccountDropDown = By.xpath("//a[@title='My Account']");
    private By LoginLink = By.xpath("//a[normalize-space()='Login']");
    private By LoginPageLabel = By.xpath("//h2[normalize-space()='Returning Customer']");
    private By EmailTxt = By.xpath("//input[@id='input-email']");
    private By PasswordTxt = By.xpath("//input[@id='input-password']");
    private By LoginBtn = By.xpath("//input[@value='Login']");

    private By ForgottenLink = By.xpath("//div[@class='form-group']//a[normalize-space()='Forgotten Password']");
    private By RegistrationBtn = By.xpath("//a[normalize-space()='Continue']");

    private By ValidationMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

    // 2. Constructor of the page class:
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    // 3. page actions: features(behavior) of the page the form of methods:

    public void ClickOnMyAccountDP()
    {
        driver.findElement(MyAccountDropDown).click();
    }

    public void ClickOnLoginLink()
    {
        driver.findElement(LoginLink).click();
    }

    public String GetLoginPageHeader()
    {
        return driver.findElement(LoginPageLabel).getText();
    }

    public void enterEmail(String email)
    {
        driver.findElement(EmailTxt).clear();
        driver.findElement(EmailTxt).sendKeys(email);
    }

    public void enterPassword(String password)
    {
        driver.findElement(PasswordTxt).clear();
        driver.findElement(PasswordTxt).sendKeys(password);
    }

    public void ClickOnLoginBtn()
    {
        driver.findElement(LoginBtn).click();
    }

    public MyAccountPage doLogin(String emailID, String password)
    {
        driver.findElement(EmailTxt).clear();
        driver.findElement(EmailTxt).sendKeys(emailID);
        driver.findElement(PasswordTxt).clear();
        driver.findElement(PasswordTxt).sendKeys(password);
        driver.findElement(LoginBtn).click();
        System.out.println("Login with" + emailID + " and"  +password);

        return new MyAccountPage(driver);
    }

    public boolean isForgottenPasswordLinkPresent()
    {
        return driver.findElement(ForgottenLink).isDisplayed();
    }

    public boolean isRegistrationBtnPresent()
    {
        return driver.findElement(RegistrationBtn).isDisplayed();
    }

    public void clickOnRegistrationBtn()
    {
        driver.findElement(RegistrationBtn).click();
    }

    public String getLoginPageTitle()
    {
        return driver.getTitle();
    }

    public String getRegistrationPageURL()
    {
        return driver.getCurrentUrl();
    }

    public String getMyAccountPageURL()
    {
        return driver.getCurrentUrl();
    }

    public String GetTextFromValidationMessage()
    {
        return driver.findElement(ValidationMessage).getText();
    }
}
