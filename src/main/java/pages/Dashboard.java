package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {
    private WebDriver driver;
    private WebDriverWait wait;
    private By myTimesheetLink=By.xpath("//*[@id=\"kt_aside_menu\"]/div/ul/li[3]/a");
    private By myWorkLogsLink=By.xpath("//div[@id='kt_aside_menu']//ul[@class='menu-nav']/li[3]/div[@class='menu-submenu menu-submenu-classic menu-submenu-right']/ul[@class='menu-subnav']//a[@href='/timesheet/work-log']/span[@class='menu-text']");
    private By myWorkLogsText=By.xpath("/html//div[@id='kt_content']//h3[.=' My Work Logs ']");
    private By myProfileLink=By.xpath("//div[@id='kt_aside_menu']//ul[@class='menu-nav']//a[@href='/profile']/span[@class='menu-text']");
    private By myProfileText=By.xpath("/html//div[@id='kt_content']//h3[.=' My Profile ']");
    
    public Dashboard(WebDriver driver){
        this.driver = driver;
    }
    
    public WorkLogs navigateToWorkLogsPage()
    {
    	wait=new WebDriverWait(driver,5);
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
    	wait=new WebDriverWait(driver,5);
    	driver.findElement(myProfileLink).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(myProfileText));
    	return new Profile(driver);
    }
    
    
    private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
