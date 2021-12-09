package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {
    private WebDriver driver;
    private By myTimesheetLink=By.xpath("//*[@id=\"kt_aside_menu\"]/div/ul/li[3]/a");
    private By myWorkLogsLink=By.xpath("//div[@id='kt_aside_menu']//ul[@class='menu-nav']/li[3]/div[@class='menu-submenu menu-submenu-classic menu-submenu-right']/ul[@class='menu-subnav']//a[@href='/timesheet/work-log']/span[@class='menu-text']");
    private By myWorkLogsText=By.xpath("/html//div[@id='kt_content']//h3[.=' My Work Logs ']");
    private By myProfileLink=By.xpath("//div[@id='kt_aside_menu']//ul[@class='menu-nav']//a[@href='/profile']/span[@class='menu-text']");
    private By myProfileText=By.xpath("/html//div[@id='kt_content']//h3[.=' My Profile ']");
    
    private By logTimeButton=By.xpath("//button[contains(text(), 'Log time')]");
    private By projectDropDown=By.xpath("//select[@id=\"project-input\"]");
    private By taskDropDown=By.xpath("//select[@id=\"task-input\"]");
    private By timePickerButton=By.xpath("//span[@class=\"vue__time-picker time-picker\"]");
    private By commentTextBox=By.xpath("//textarea[@id=\"comments-minutes-input\"]");
    
    private By saveLogButton=By.xpath("//div[@class='b-overlay-wrap position-relative float-right']//button");
    private By statusMessage=By.xpath("//div[@role='status']");
    
    public Dashboard(WebDriver driver){
        this.driver = driver;
    }
    
    public WorkLogs navigateToWorkLogsPage()
    {
    	WebDriverWait wait=new WebDriverWait(driver,5);
    	driver.findElement(myTimesheetLink).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(myWorkLogsLink));
    	sleep(1000);
    	driver.findElement(myWorkLogsLink).click();
    	sleep(1000);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(myWorkLogsText));
    	return new WorkLogs(driver);
    }
    
    public Profile navigateToProfile()
    {
    	WebDriverWait wait=new WebDriverWait(driver,5);
    	driver.findElement(myProfileLink).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(myProfileText));
    	return new Profile(driver);
    }
    
    public void clickLogTimeButton()
    {
    	WebDriverWait wait=new WebDriverWait(driver, 5);
    	wait.until(ExpectedConditions.elementToBeClickable(logTimeButton));
    	WebElement logTimeButtonElement=driver.findElement(logTimeButton);
    	
    	JavascriptExecutor jse=(JavascriptExecutor) driver;
    	jse.executeScript("arguments[0].click()", logTimeButtonElement);
    	driver.switchTo().activeElement();
    }
    
    public void selectProject(String projectName)
	{
		Select selectProject=new Select(driver.findElement(projectDropDown));
		selectProject.selectByVisibleText("My CC Test Project");
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.MILLISECONDS);
	}
    
    public void selectTask(String taskName)
	{
		Select selectTask=new Select(driver.findElement(taskDropDown));
		selectTask.selectByVisibleText("Development Back End Test");
		driver.manage().timeouts().implicitlyWait(400, TimeUnit.MILLISECONDS);
	}
    
    public void selectTime(String hours, String minutes)
	{
    	driver.findElement(timePickerButton).click();
    	By minutesBy;
    	if(minutes.equals("00"))
			 minutesBy=By.xpath("//ul[2]//li[@data-key='00']");
		else
			 minutesBy=By.xpath("//ul[2]//li[@data-key='30']");
    	By hoursBy=By.xpath("//li[@data-key=\""+hours+"\"]");
		driver.findElement(hoursBy).click();
		driver.findElement(minutesBy).click();
		driver.findElement(hoursBy).click();
	}
    
    public void selectHours(String hours)
    {
    	driver.findElement(timePickerButton).click();
		By hoursBy=By.xpath("//ul[1]//li[@data-key=\""+hours+"\"]");
		driver.findElement(hoursBy).click();
    }
    
    public void addComment(String comment)
	{
		driver.findElement(commentTextBox).sendKeys(comment);
	}
    
    public boolean clickSaveLogButton()
	{
    	WebDriverWait wait=new WebDriverWait(driver,5);
		driver.findElement(saveLogButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(statusMessage));
		return driver.findElement(statusMessage).isDisplayed();
	}
    
    private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
