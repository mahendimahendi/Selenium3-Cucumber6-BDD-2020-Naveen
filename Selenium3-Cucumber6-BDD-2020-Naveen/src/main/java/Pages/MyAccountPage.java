package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MyAccountPage<pubic> {

    private WebDriver driver;

    // 1. By Locators: Object Repository
    public By MyaccountSections = By.xpath("//div[@id='account-account']//div[@class='row']//ul[1]");


    // 2. Constructor of the page class:
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }


    // 3. page actions: features(behavior) of the page the form of methods:
    public String getMyAccountTitle()
    {
        return driver.getTitle();
    }

    public int myAccountSectionLinksCounts()
    {
        return driver.findElements(MyaccountSections).size();
    }

    public List<String> getAccountsSectionsList()
    {
        List<String> accountList = new ArrayList<>();
        List<WebElement> accountMenuList = driver.findElements(MyaccountSections);

        for(WebElement e : accountMenuList)
        {
            String text = e.getText();
            System.out.println("After executing getAccountsSectionsList method the output is " +text);
            accountList.add(text);
        }

        return accountList;

    }
}
