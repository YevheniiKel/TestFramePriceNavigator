package runners;

import dto.UserDto;
import io.cucumber.java.ParameterType;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "steps")
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
