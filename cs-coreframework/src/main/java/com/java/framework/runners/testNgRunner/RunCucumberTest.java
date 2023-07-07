package com.java.framework.runners.testNgRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = {"com.java.stepdefinitions","com.java.framework.runners"},
        features = "src/test/resources/features"
)

public class RunCucumberTest extends AbstractTestNGCucumberTests {

}


