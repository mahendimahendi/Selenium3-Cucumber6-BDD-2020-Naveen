package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features/MyAccountPage.feature",
        glue={"stepDefinations","AppHooks"},

        monochrome = true,
        dryRun = false,
        plugin = {"pretty", "html:target/HTMLreports",
                "json:target/JSONReports/report.json",
                "json:target/JUnitReports/report.xml"})

public class TestRunner
        {


        }
