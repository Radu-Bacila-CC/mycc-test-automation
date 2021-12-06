package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {
    private WebDriver driver;
    private WebDriverWait wait;
    By addWorkflowButton=By.cssSelector("div:nth-of-type(2) > .card.card-custom.card-stretch.gutter-b.work-logs-widget .btn.btn-success.d-block.font-weight-bolder.m-auto.py-3.w-50");
    By workflowWindow=By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div[2]/div/div[2]/div[3]/button");
    public Dashboard(WebDriver driver){
        this.driver = driver;
    }
    
    public void clickAddWorkflowButton()
    {
    	wait=new WebDriverWait(driver, 5);
    	driver.findElement(addWorkflowButton).click();
    	sleep(1000);
    	driver.switchTo().activeElement();
    	sleep(1000);
    }
    
    public void selectProject()
    {
    	
    }
    
    public void selectTask()
    {
    	
    }
    
    public void selectHours()
    {
    	
    }
    
    public void addComment()
    {
    	
    }
    
    public void clickSaveLogButton()
    {
    	
    }
    
    private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
