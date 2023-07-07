package com.java.framework.runners.hooks;

import com.java.framework.core.Context;
import com.java.framework.core.TestContext;
import com.java.framework.core.logging.logger.LogLevel;
import com.java.framework.core.reporting.Reporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks {

    private static boolean report_start = false;
    TestContext testContext;

    @Before(order = 1)
    public void onStart(){
        if(!report_start){
            testContext = new TestContext();
            testContext.getLogger().log(LogLevel.INFO,"<=============================On Before Class======================================>");
            Context scenarioContext = new Context();
            testContext.registerContext(scenarioContext);
            Reporter.register(testContext.getReporter());
            Reporter.setUp();
            report_start = true;
        }
    }

    @Before (order = 2)
    public synchronized void onTestStart(Scenario scenario) {
        String methodName = scenario.getName();
        Reporter.createTest(methodName);
        Reporter.info("TEST EXECUTION STARTED - "+methodName);
    }

    @After (order = 1)
    public synchronized void onTestFinished(Scenario scenario) {
        String methodName = scenario.getName();
        if (scenario.isFailed()){
            Reporter.fail("FAILED - " + methodName);
            Reporter.addScreenshot(methodName + "-Failed", "Screenshot After Test Failure..!!!");
        } else if (String.valueOf(scenario.getStatus()).equals("PASSED")){
            Reporter.pass("PASSED - " + methodName);
        } else {
            Reporter.info("INFO - " + methodName);
        }

    }
    @After (order = 2)
    public void onFinish(){
        Reporter.tearDown();
    }
}
