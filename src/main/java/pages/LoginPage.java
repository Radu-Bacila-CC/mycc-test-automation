package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.xpath("//form[@id='kt_login_signin_form']/div[2]/div[1]/input[@name='email']");
    private By passwordField = By.xpath("//form[@id='kt_login_signin_form']/div[3]/div[2]/input[@name='password']");
    private By loginButton = By.xpath("/html//form[@id='kt_login_signin_form']//button[.=' Sign In ']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage(WebDriver driver, String format) {
    }

    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public Dashboard clickLoginButton(){
        driver.findElement(loginButton).click();
        return new Dashboard(driver);
    }
}
