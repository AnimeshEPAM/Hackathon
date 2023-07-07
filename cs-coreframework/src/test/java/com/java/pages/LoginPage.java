package com.java.pages;

import com.java.framework.ui.PageWrapper;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageWrapper {

    private static final String guestForm = "xpath -> //a[text()='Guest Registration Form']";
    private static final String onlineForm = "xpath -> //a[text()='Online Event Registration Form']";



    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

   // public void getGuestForm(String ... formatArgs)
//    {
//        click(guestForm,"GuestForm",formatArgs);
//    }

    public void getOnlineForm(String ... formatArgs){
        click(onlineForm,"Online Form", formatArgs);
    }
}
