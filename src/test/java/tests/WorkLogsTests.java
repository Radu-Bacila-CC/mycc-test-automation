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
	
	@Test()
	public void addWorkFlowFromWorkLogPageTest()
	{
		setTimestamp("addWorkFlowFromWorkLogPageTest");
		Reporter.log("Navigating to My Work Logs Page");
		WorkLogs workLogs=dashboard.navigateToWorkLogsPage();
		workLogs.clickAddLogButton();
		Reporter.log("Clicked the Log Time button");
		workLogs.selectProject("My CC Test Project");
		Reporter.log("Selected project: My CC Test Project");
		workLogs.selectTask("Development Back End Test");
		Reporter.log("Selected task: Development Back End Test");
		workLogs.selectDate("2021-12-12");
		Reporter.log("Selected date: 2021-12-12");
		workLogs.selectTime("04","30");
		Reporter.log("Time was set to 04:30");
		workLogs.addComment("This is a test comment and was added by an automated test");
		Reporter.log("Added the test comment");
		assertTrue(workLogs.clickSaveLogButton(),"Work Log was not saved successfully");
		Reporter.log("Work log saved!");
		
		//Report duration
        Reporter.log("Test duration: " + getDurationInMillisFrom("addWorkFlowFromWorkLogPageTest") + " ms");
        
        
        //Log duration
        log.debug(Long.toString(getDurationInMillisFrom("addWorkFlowFromWorkLogPageTest")));
        System.out.println(getDurationInMillisFrom("addWorkFlowFromWorkLogPageTest"));
        long maxDuration = 20000L;
        
        assertTrue(maxDuration >= getDurationInMillisFrom("addWorkFlowFromWorkLogPageTest"));
	}
	
	@Test
	public void addWorkFlowFromDashboardTest()
	{
		setTimestamp("addWorkFlowFromDashboardTest");
		dashboard.clickLogTimeButton();
		sleep(2000);
		Reporter.log("Clicked the Log Time button from the Dashboard page");
		dashboard.selectProject("My CC Test Project");
		Reporter.log("Selected project: My CC Test Project");
		dashboard.selectTask("Development Back End Test");
		Reporter.log("Selected task: Development Back End Test");
		dashboard.selectTime("01", "00");
		Reporter.log("Time was set to 01:00");
		dashboard.addComment("This is a test comment and was added by an automated test");
		Reporter.log("Added the test comment");
		assertTrue(dashboard.clickSaveLogButton(),"Work Log was not saved successfully");
		Reporter.log("Work log saved!");
		
		//Report duration
        Reporter.log("Test duration: " + getDurationInMillisFrom("addWorkFlowFromDashboardTest") + " ms");
        
        
        //Log duration
        log.debug(Long.toString(getDurationInMillisFrom("addWorkFlowFromDashboardTest")));
        System.out.println(getDurationInMillisFrom("addWorkFlowFromDashboardTest"));
        long maxDuration = 20000L;
        
        assertTrue(maxDuration >= getDurationInMillisFrom("addWorkFlowFromDashboardTest"));
	}
	
	public static void sleep(int ms)
	{
	    try
	    {
	        Thread.sleep(ms);
	    }
	    catch(InterruptedException ex)
	    {
	        Thread.currentThread().interrupt();
	    }
	}

}
