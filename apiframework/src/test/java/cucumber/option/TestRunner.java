package cucumber.option;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/placeValidation3.feature", glue= {"stepDefinition"}, plugin="html:target/addLocation.html")
public class TestRunner {
	

}
