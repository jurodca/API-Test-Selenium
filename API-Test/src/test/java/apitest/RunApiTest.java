package apitest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
		features = "classpath:features",
		glue = {"stepdefinitions"})

public class RunApiTest {

}
