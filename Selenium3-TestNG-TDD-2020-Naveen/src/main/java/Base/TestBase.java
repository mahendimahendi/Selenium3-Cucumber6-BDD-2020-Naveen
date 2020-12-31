package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static WebDriverWait wait;
    protected final Logger logger = LogManager.getLogger(getClass());
    public static Date date = new Date();
    public static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
    public static String dt = formatter.format(date);
    public static FileReader fileReader;


    //Read config property file define in the Construction
    public TestBase() {

        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "./Config/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    // Browser Name is defined in the config.properties
    public static void setup() {
        String browserName = prop.getProperty("Browser");

        if (browserName.equalsIgnoreCase("Chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            System.setProperty("webdriver.chrome.logfile", "./Logs/ChromeLogs.txt");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();

           /* System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")  + "//src//main//java//com//qa//executables//chromedriver.exe"));
            driver = new ChromeDriver();*/


        } else if (browserName.equalsIgnoreCase("Firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "./Logs/FirefoxLogs.txt");
            FirefoxOptions options = new FirefoxOptions();
            options.setLogLevel(FirefoxDriverLogLevel.TRACE);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();

           /*System.setProperty("webdriver.gecko.driver", (System.getProperty("user.dir") + "//src//main//java//com//qa//executables//geckodriver.exe"));
            driver = new FirefoxDriver();*/


        } else if (browserName.equalsIgnoreCase("Opera")) {

            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();

            System.setProperty("webdriver.opera.logfile", "./logs/OperaLogs.txt");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();

           /*System.setProperty("webdriver.opera.driver", (System.getProperty("user.dir") + "//src//main//java//com//qa//executables//operadriver.exe"));
            driver = new OperaDriver();*/


        } else if (browserName.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

            System.setProperty("webdriver.edge.logfile", "./logs/EdgeLogs.txt");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();

           /*System.setProperty("webdriver.edge.driver", (System.getProperty("user.dir") + "//src//main//java//com//qa//executables//msedgedriver.exe"));
            driver = new EdgeDriver();*/


        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();

            System.setProperty("webdriver.ie.logfile", "./logs/ieLogs.txt");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();

           /*System.setProperty("webdriver.edge.driver", (System.getProperty("user.dir") + "//src//main//java//com//qa//executables//msedgedriver.exe"));
            driver = new EdgeDriver();*/


        } else {

          System.out.println("Browser name is not defined in the config property");

        }

            // Defined in the config.properties
            driver.get(prop.getProperty("URL"));

    }

    public static void tearDown()
    {
        driver.quit();
    }


}

