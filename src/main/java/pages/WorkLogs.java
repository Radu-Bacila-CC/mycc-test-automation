package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ch.qos.logback.core.joran.action.Action;

public class WorkLogs {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private By addLogButton=By.xpath("//div[@id='kt_content']//div[@class='card card-custom']/div[@class='container']/div[1]/div[2]/button[@type='button']");
	private By projectDropDown=By.xpath("/html//select[@id='project-input']");
	private By taskDropDown=By.xpath("/html//select[@id='task-input']");
	
	private By datePickerButton=By.xpath("//*[@id=\"created-at-datepicker\"]");
	private By datePicker=By.xpath("//div[@id='created-at-datepicker__dialog_']/div/div[@role='group']/div[@role='application']");
	
	private By timePickerButton=By.xpath("/html/body/div[2]/div[1]/div/div/div/form/div[2]/div[2]/fieldset/div/span/input");
	private By timePickerHours=By.xpath("/html/body/div[2]/div[1]/div/div/div/form/div[2]/div[2]/fieldset/div/span/div[3]/div/ul[1]");
	private By timePickerMinutes=By.xpath("/html/body/div[2]/div[1]/div/div/div/form/div[2]/div[2]/fieldset/div/span/div[3]/div/ul[2]");
	
	private By time=By.xpath("//*[@id='__BVID__214']/div/span/div[3]/div");
	private By commentTextBox=By.xpath("/html//textarea[@id='comments-minutes-input']");
	
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
		sleep(2000);

		/*
		wait.until(ExpectedConditions.visibilityOfElementLocated(datePicker));
		sleep(2000);
		WebElement dateWidget=driver.findElement(datePicker);
		sleep(2000);
		List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
		for (WebElement cell:columns)
			if (cell.getText().equals(date))
			{
				cell.findElement(By.linkText(date)).click();
				break;
			}
		sleep(2000);*/
	}
	
	public void selectTime()
	{
		/*Select selectHours=new Select(driver.findElement(timePickerHours));
		selectHours.selectByValue("12");
		sleep(2000);
		Select selectMinutes=new Select(driver.findElement(timePickerMinutes));
		selectMinutes.selectByValue("30");
		sleep(2000);*/
		
		
	}
	
	public void addComment(String comment)
	{
		driver.findElement(commentTextBox).sendKeys(comment);
	}
	
	 private void sleep(long m) {
			try {
				Thread.sleep(m);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
