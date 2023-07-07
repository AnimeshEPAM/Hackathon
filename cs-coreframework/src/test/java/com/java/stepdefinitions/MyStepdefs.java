package com.java.stepdefinitions;

import com.java.framework.core.constants.WaitConstants;
import com.java.framework.ui.DragAndDrop;
import com.java.framework.ui.SyncUtils;
import com.java.pages.LoginPage;
import io.cucumber.java.en.*;

public class MyStepdefs extends BaseStepDef {

    LoginPage login = new LoginPage(getDriver());

    @Given("User navigates to the time sheet application")
    public void user_navigates_to_the_time_sheet_application() {
        getDriver().get("https://demo.wpeverest.com/user-registration/");
        SyncUtils.waitUntilPageIsFullyLoaded(getDriver(), WaitConstants.LONG);
    }

    @When("User logs in as admin")
    public void user_logs_in_as_admin() throws InterruptedException {
     //   login.getGuestForm();
        login.getOnlineForm();
        Thread.sleep(10000);
        login.switchToWindowWithIndex("1");
    }

    @Then("User Verifies Home Page is Displayed and Navigate through top buttons")
    public void userVerifiesHomePageIsDisplayedAndNavigateThroughTopButtons() {

    }
}
