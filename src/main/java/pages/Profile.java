package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Profile {

	private WebDriver driver;
	private WebDriverWait wait;
	
	private By addNewContactButton=By.xpath("//div[@id='kt_content']//div[@class='container pt-0']/div/div[2]/div/div[@class='card card-custom']/div[2]/div[1]/button[@type='button']");
	
	private By firstNameTextBox=By.xpath("//div[@id='contactDetailsModal___BV_modal_body_']/form/fieldset[1]//input[@name='firstName']");
	private By lastNameTextBox=By.xpath("//div[@id='contactDetailsModal___BV_modal_body_']/form/fieldset[2]//input[@name='lastName']");
	private By phoneTextBox=By.xpath("//div[@id='contactDetailsModal___BV_modal_body_']/form/fieldset[3]//div[@role='group']/input[@name='primaryPhoneNumber']");
	private By emailTextBox=By.xpath("/html//input[@id='email-input']");
	private By relationshipSelect=By.xpath("/html//select[@id='relationship-input']");
	private By saveChangesButton=By.xpath("//*[@id=\"contactDetailsModal___BV_modal_footer_\"]/div/div/button");
	
	//private String successMessage="Contact created successfully!";
	private By successMessage=By.xpath("//div[@id='app-layout']//div[@name='snackbars']/div//div[@role='status']");
	public Profile(WebDriver driver)
	{
		this.driver=driver;
		sleep(2000);
	}
	
	public void clickAddNewContact()
	{
		driver.findElement(addNewContactButton).click();
		driver.switchTo().activeElement();
	}
	
	public void insertFirstName(String firstName)
	{
		driver.findElement(firstNameTextBox).sendKeys(firstName);
	}
	
	public void insertLastName(String lastName)
	{
		driver.findElement(lastNameTextBox).sendKeys(lastName);
	}
	
	public void insertPhoneNumber(String phoneNumber)
	{
		driver.findElement(phoneTextBox).sendKeys(phoneNumber);
	}
	
	public void insertEmail(String email)
	{
		driver.findElement(emailTextBox).sendKeys(email);
	}
	
	public void selectRelationship(String relationship)
	{
		Select selectRelation=new Select(driver.findElement(relationshipSelect));
		selectRelation.selectByVisibleText(relationship);
	}
	
	public void clickSaveChangesButton()
	{
		wait=new WebDriverWait(driver, 5);
		driver.findElement(saveChangesButton).click();
		driver.switchTo().activeElement();
		wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
	}
	
	
	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
