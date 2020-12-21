package Pages;

import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    private WebDriver driver;

    // 1. By Locators: Object Repository


    // 2. Constructor of the page class:
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }


    // 3. page actions: features(behavior) of the page the form of methods:
    public String getMyAccountTitle()
    {
        return driver.getTitle();
    }

}
