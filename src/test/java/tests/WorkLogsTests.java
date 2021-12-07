package tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import pages.WorkLogs;

import static org.testng.Assert.assertTrue;
import static utils.Timers.getDurationInMillisFrom;
import static utils.Timers.setTimestamp;

@Slf4j
public class WorkLogsTests extends BaseTest{
	
	@Test
	public void addWorkFlowFromDashboardTest()
	{
		setTimestamp("addWorkFlowFromDashboardTest");
		Reporter.log("Navigating to My Work Logs Page");
		WorkLogs workLogs=dashboard.navigateToWorkLogsPage();
		workLogs.clickAddLogButton();
		Reporter.log("Clicked the Log Time button");
		workLogs.selectProject("My CC Test Project");
		Reporter.log("Selected project: My CC Test Project");
		workLogs.selectTask("Development Back End Test");
		Reporter.log("Selected task: Development Back End Test");
		workLogs.addComment("Test comment added and must be at least 20 characters");
		Reporter.log("Added the test comment");
		//workLogs.selectTime();
		
		//Report duration
        Reporter.log("Test duration: " + getDurationInMillisFrom("addWorkFlowFromDashboardTest") + " ms");
        
        
        //Log duration
        log.debug(Long.toString(getDurationInMillisFrom("addWorkFlowFromDashboardTest")));
        System.out.println(getDurationInMillisFrom("addWorkFlowFromDashboardTest"));
        long maxDuration = 20000L;
        
        assertTrue(maxDuration >= getDurationInMillisFrom("addWorkFlowFromDashboardTest"));
	}
	
	 private void sleep(long m) {
			try {
				Thread.sleep(m);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
