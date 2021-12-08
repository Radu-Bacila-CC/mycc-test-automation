package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WorkLogs {
	
	private WebDriver driver;
	private By addLogButton=By.xpath("//div[@id='kt_content']//div[@class='card card-custom']/div[@class='container']/div[1]/div[2]/button[@type='button']");
	private By projectDropDown=By.xpath("/html//select[@id='project-input']");
	private By taskDropDown=By.xpath("/html//select[@id='task-input']");
	
	private By datePickerButton=By.xpath("//*[@id=\"created-at-datepicker\"]");
	
	private By timePickerButton=By.xpath("//span[@class=\"vue__time-picker time-picker\"]");
	
	private By commentTextBox=By.xpath("/html//textarea[@id='comments-minutes-input']");
	
	private By saveLogButton=By.xpath("//*[@id=\"logWorkModal___BV_modal_footer_\"]/div/div/button");
	
	private By statusMessage=By.xpath("//div[@role=\"status\"]");
	
	public WorkLogs(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickAddLogButton()
	{
		driver.findElement(addLogButton).click();
		driver.switchTo().activeElement();
	}
	
	public void selectProject(String projectName)
	{
		Select selectProject=new Select(driver.findElement(projectDropDown));
		selectProject.selectByVisibleText(projectName);
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.MILLISECONDS);
	}
	
	public void selectTask(String taskName)
	{
		Select selectTask=new Select(driver.findElement(taskDropDown));
		selectTask.selectByVisibleText(taskName);
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.MILLISECONDS);
	}
	
	public void selectDate(String date)
	{
		driver.findElement(datePickerButton).click();
		driver.findElement(By.xpath("//div[@data-date=\""+date+"\"]")).click();
	}
	
	public void selectTime(String hours, String minutes)
	{
		driver.findElement(timePickerButton).click();
		
		By hoursBy=By.xpath("//li[@data-key=\""+hours+"\"]");
		driver.findElement(hoursBy).click();
		driver.findElement(timePickerButton).click();
		By minutesBy;
		if(minutes.equals("00"))
			 minutesBy=By.xpath("//ul[2]//li[@data-key=\"00\"]");
		else
			 minutesBy=By.xpath("//ul[2]//li[@data-key=\"30\"]");
		driver.findElement(minutesBy).click();
	}
	
	public void addComment(String comment)
	{
		driver.findElement(commentTextBox).sendKeys(comment);
	}
	
	public boolean clickSaveLogButton()
	{
		WebDriverWait wait=new WebDriverWait(driver, 5);
		driver.findElement(saveLogButton).click();
		driver.switchTo().activeElement();
		wait.until(ExpectedConditions.visibilityOfElementLocated(statusMessage));
		return driver.findElement(statusMessage).isDisplayed();
	}
	
}
