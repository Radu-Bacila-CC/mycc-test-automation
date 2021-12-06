package tests;

import base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;

import static utils.Timers.getDurationInMillisFrom;
import static utils.Timers.setTimestamp;

@Slf4j
public class LoginTests extends BaseTest{
	
   /* @Test(groups = "end2end")
    @Parameters({"user", "password"})
    public void testSuccessfulLogin(String user, String password){
    	
    	//Start timer
        setTimestamp("testSuccessfulLogin");
        
        LoginPage loginPage = dashboard.clickFormAuthentication();
        loginPage.setUsername(user);
        Reporter.log("Enter username: " + user);
        log.debug("Once before all tests within this class");
        loginPage.setPassword(password);
        Reporter.log("Enter password: " + password);
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        secureAreaPage.getAlertText();
        
        assertTrue(secureAreaPage.getAlertText()
                        .contains("You logged into a secure area!")
                , "Alert text is incorrect");
        
        //Report duration
        Reporter.log("Test duration: " + getDurationInMillisFrom("testSuccessfulLogin") + " ms");
        
        //Log duration
        log.debug(Long.toString(getDurationInMillisFrom("testSuccessfulLogin")));
        System.out.println(getDurationInMillisFrom("testSuccessfulLogin"));
        long maxDuration = 2000L;
        
        assertTrue(maxDuration >= getDurationInMillisFrom("testSuccessfulLogin"));
    }*/
	@Test()
	public void VoidTest()
	{
		
	}
    
}
