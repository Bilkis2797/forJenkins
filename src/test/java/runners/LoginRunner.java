package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
//		features = "src\\test\\java\\features\\TechfiosLogin.feature",
		features = "classpath:features",
		glue="steps",
 //		tags="@OtherScenario2",
//		tags ="@smoke",
//		tags = "Regression",
//		tags = "OtherScenario1",
		tags="@DbScenario1",
		monochrome=true,
		dryRun=false,
		plugin= {
				"pretty",
				"html:target/cucumber",
				"json:target/cucumber.json"
		}
		)

public class LoginRunner {

}
