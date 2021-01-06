package pivotal.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import pivotal.config.Environment;

@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features"},
        glue = {"pivotal"}
)
public final class Runner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    /**
     * Executes code before all scenarios.
     */
    @BeforeClass
    public void beforeAllScenarios() {
        System.setProperty("dataproviderthreadcount", Environment.getInstance().getProperties().get("cucumberThreadCount"));
    }
}
