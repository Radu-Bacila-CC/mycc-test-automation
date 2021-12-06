package tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import lombok.extern.slf4j.Slf4j;

import static org.testng.Assert.assertTrue;
import static utils.Timers.getDurationInMillisFrom;
import static utils.Timers.setTimestamp;

@Slf4j
public class WorkflowTests extends BaseTest{
	
	@Test
	public void addWorkFlowFromDashboardTest()
	{
		setTimestamp("testSuccessfulLogin");
		Reporter.log("Clicking add workflow button");
		log.debug("Once before all tests within this class");
		dashboard.clickAddWorkflowButton();
		
		
		//Report duration
        Reporter.log("Test duration: " + getDurationInMillisFrom("testSuccessfulLogin") + " ms");
        
        //Log duration
        log.debug(Long.toString(getDurationInMillisFrom("testSuccessfulLogin")));
        System.out.println(getDurationInMillisFrom("testSuccessfulLogin"));
        long maxDuration = 2000L;
        
        assertTrue(maxDuration >= getDurationInMillisFrom("testSuccessfulLogin"));
	}

}
