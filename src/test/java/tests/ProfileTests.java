package tests;

import static org.testng.Assert.assertTrue;
import static utils.Timers.getDurationInMillisFrom;
import static utils.Timers.setTimestamp;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.Base;
import lombok.extern.slf4j.Slf4j;
import pages.Profile;

@Slf4j
public class ProfileTests extends Base{
	
	@Test
	public void addFirstContactTest()
	{
		setTimestamp("addFirstContactTest");
		Reporter.log("Navigating to My Profile Page");
		Profile profile=dashboard.navigateToProfile();
		profile.clickAddNewContact();
		Reporter.log("Clicked the Add New Contact button");
		profile.insertFirstName("Test");
		Reporter.log("Set the First Name to Test");
		profile.insertLastName("Test");
		Reporter.log("Set the Last Name to Test");
		profile.insertPhoneNumber("0000000000");
		Reporter.log("Set Phone Number to 0000000000");
		profile.insertEmail("cctestuser11@yopmail.com");
		Reporter.log("Set the Email to cctestuser11@yopmail.com");
		profile.selectRelationship("Sibling");
		Reporter.log("Set Relationship to Sibling");
		assertTrue(profile.clickSaveChangesButton(),"Contact was not saved successfully");
		Reporter.log("Contact saved!");
		
		//Report duration
        Reporter.log("Test duration: " + getDurationInMillisFrom("addFirstContactTest") + " ms");
        
        //Log duration
        log.debug(Long.toString(getDurationInMillisFrom("addFirstContactTest")));
        System.out.println(getDurationInMillisFrom("addFirstContactTest"));
        long maxDuration = 20000L;
        
        assertTrue(maxDuration >= getDurationInMillisFrom("addFirstContactTest"));
	}

}
