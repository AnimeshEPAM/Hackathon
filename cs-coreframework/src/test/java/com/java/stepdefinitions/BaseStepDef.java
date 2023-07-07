package com.java.stepdefinitions;


import com.java.framework.ui.Browser;
import com.java.framework.ui.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseStepDef {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }

}
