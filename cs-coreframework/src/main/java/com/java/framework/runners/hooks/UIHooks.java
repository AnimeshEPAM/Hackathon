package com.java.framework.runners.hooks;

import com.java.framework.core.TestContext;
import com.java.framework.core.logging.logger.LogLevel;
import com.java.framework.core.reporting.Reporter;
import com.java.framework.core.utils.SauceUtils;
import com.java.framework.ui.UiConstants;
import com.java.framework.ui.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


import java.util.HashMap;
import java.util.Map;

public class UIHooks {

    @Before (order = 2)
    public void beforeBaseMethod(Scenario scenario){
        String testCaseName = scenario.getName();
        new TestContext().getLogger().log(LogLevel.INFO,"TestCase '{"+testCaseName+"}' is started...!!!");
        Map<String, Object> additionalCapabilities = new HashMap<>();
        additionalCapabilities.put("testCaseName", testCaseName);
        DriverManager.initializeDriver(UiConstants.BROWSER, UiConstants.BROWSER_VERSION, UiConstants.PLATFORM, UiConstants.EXEC_ENV, additionalCapabilities);
    }
    @After
    public void afterBaseMethod(Scenario scenario) {
        if(UiConstants.EXEC_ENV.equalsIgnoreCase("sauce")) {
            SauceUtils.updateResults(scenario.isFailed(), DriverManager.getSessionIds());
        }
        DriverManager.quitDriver();
        Reporter.tearDown();
    }
}
