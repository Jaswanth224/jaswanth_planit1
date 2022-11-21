import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        glue="planit.stpdef",
        features = "src/test/resources/planit.feature",

        plugin={"pretty","html:target/cucumber.html"},
        tags = "@sprint001",
        dryRun=false
)


public class testrunner {

}
