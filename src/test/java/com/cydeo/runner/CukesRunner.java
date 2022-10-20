package com.cydeo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( //What is class will be running in this class? Give them in key-value format
        plugin = { //tells us what kind of file to create where in what name in what extension
                //"pretty",
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/json-cucumber-reports/cucumber.json"
        },

        features = "src/test/resources/features",
        glue = "com/cydeo/stepDefinitions",
        dryRun = false,
        tags = ""
)
public class CukesRunner { //is pointing to regular feature files
}

