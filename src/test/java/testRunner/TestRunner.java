package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "C:\\Users\\1767\\eclipse-workspace\\slotsAutomationPoC\\src\\test\\java\\features", // Path to .feature files
    glue = {"stepDefinitions","hooks"},       // Packages containing step definitions and hooks
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // No need to override anything unless customizing test execution
}
