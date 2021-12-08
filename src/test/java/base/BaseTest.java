package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
import com.microsoft.edge.seleniumtools.EdgeDriver;
import com.microsoft.edge.seleniumtools.EdgeOptions;

import pages.Dashboard;
import pages.LoginPage;

public class BaseTest {

	private WebDriver driver;
	protected Dashboard dashboard;
	protected LoginPage loginPage;
	private By dashboardText=By.xpath("/html//div[@id='kt_content']//h3[.=' Dashboard ']");

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "driverPath", "browser", "url" })
	public void goHome(ITestResult result, String driverPath, String browser, String url) throws Exception {

		// Check if parameter passed from TestNG is 'Chrome'
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath);
			// create Chrome instance
			driver = new ChromeDriver(getChromeHeadlessOptions());
		}

		// Check if parameter passed as 'Firefox'
		else if (browser.equalsIgnoreCase("Firefox")) {
			// set path to chromedriver.exe
			System.setProperty("webdriver.gecko.driver", driverPath);
			// create Firefox instance
			driver = new FirefoxDriver(getFirefoxHeadlessOptions());
		}
		// Check if parameter passed as 'Edge'
		else if (browser.equalsIgnoreCase("Edge")) {
			// set path to Edge.exe
			System.setProperty("webdriver.edge.driver", driverPath);
			// create Edge instance
			driver = new EdgeDriver(getEdgeHeadlessOptions());
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not supported");
		}

		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(url);
		driver.manage().window().maximize();
		if (driver.getCurrentUrl().equals("https://mycc-staging.n13.ro/login"))
		{
		Reporter.log("Starting login process with credentials: ");
		WebDriverWait wait=new WebDriverWait(driver, 5);
		loginPage = new LoginPage(driver);
		loginPage.setUsername("cctestuser11@yopmail.com");
		Reporter.log("Username: cctestuser11@yopmail.com");
		loginPage.setPassword("CCTest@2021");
		Reporter.log("Password: CCTest@2021");
		dashboard=loginPage.clickLoginButton();
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardText));
		}
		else
		{
			Reporter.log("We are already logged in the application");
			dashboard=new Dashboard(driver);
		}
		Reporter.setCurrentTestResult(result);
		Reporter.log("BeforeMethod ended");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) {

		driver.quit();

		Reporter.setCurrentTestResult(result);
		Reporter.log("AfterMethod ended");
	}

	private ChromeOptions getChromeHeadlessOptions() {
		ChromeOptions options = new ChromeOptions();
		// options.setHeadless(true);
		return options;
	}

	private FirefoxOptions getFirefoxHeadlessOptions() {
		FirefoxOptions options = new FirefoxOptions();
		// options.setHeadless(true);
		return options;
	}

	private EdgeOptions getEdgeHeadlessOptions() {
		EdgeOptions options = new EdgeOptions();
		// options.setHeadless(true);
		// options.addArguments("headless");
		return options;
	}

}


