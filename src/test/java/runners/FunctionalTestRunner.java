package runners;

import core.BaseSetup;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/test/resources/functionalTests",
        glue = {"stepDefinitions"},
        plugin = {
                "pretty","json:target/cucumber.json"
                })
public class FunctionalTestRunner extends BaseSetup {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeSuite(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "testng cucumber feature", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickleEvent, FeatureWrapper cucumberFeature)throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickle());

    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}
