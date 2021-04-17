package E2EPOM_TDD.E2EPOM_TDD;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LoginObj;
import Resources.Base;
//import resources.base;

public class Login extends Base{
	public WebDriver driver;
	//public static Logger logg =LogManager.getLogger(Base.class.getName());
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	
	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		driver=load_driver();
		log.info("Driver is initialized");
		
		// log.info("Successfully Loaded driver");

	}
	@Test(dataProvider="login_data")
	public void load_login(String user,String pass) throws IOException {
		driver.get(prop.getProperty("url"));
		LoginObj lo=new LoginObj(driver);
		lo.getUser().sendKeys(user);
		lo.get_password().sendKeys(pass);
		lo.get_loginButton().click();
		log.info("successfully run...");
	}
	
	
	
	
	@DataProvider
	public Object[][] login_data() {
		Object[][] data=new Object[3][2];
		
		data[0][0]="admin";
		data[0][1]="123456";
		
		data[1][0]="admin1";
		data[1][1]="123456";
		
		data[2][0]="admin";
		data[2][1]="111111";
		
		return data;
	}
	
	@Test
	public void title_validation() {
		
		//System.out.println("Title:");
		//System.out.println();
		Assert.assertEquals(driver.getTitle(), "Admin Login");
		log.info("Successfully validated");
	}
	
	
	@AfterTest
	public void browser_close() {
		driver.close();
	}
}
