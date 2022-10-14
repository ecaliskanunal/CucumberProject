package com.cydeo.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) //This annotation changes the behaviour: we run this class as a Cucumber class, not Java class
@CucumberOptions(
        glue = "com/cydeo/stepDefinitions",
        features = "@target/rerun.txt"
)
public class FailedTestRunner {
}
