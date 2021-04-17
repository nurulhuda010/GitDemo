package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObj {
	public WebDriver driver;
	By username=By.name("user_name");
	By pass=By.name("user_password");
	By login=By.name("Login");
	//By h=By.xpath("//div[contains(@class, 'card-header') and text()='Login']");
			
	public LoginObj(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getUser() {
		return driver.findElement(username);
	}
	public WebElement get_password() {
		return driver.findElement(pass);
	}
	public WebElement get_loginButton() {
		return driver.findElement(login);
	}
}
