package testBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class testbase 
{
	WebBrowser browser = new WebBrowser();
	public static WebDriver driver = null;
	
	@BeforeMethod
	public void LaunchBrowser() 
	{
		try 
		{
			Webdriver.getWebdriver().setDriver(browser.CreateBrowserInstance("chrome"));
			driver = Webdriver.getWebdriver().getDriver();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void CloseBrowser() 
	{
		Webdriver.getWebdriver().closeDriver();
	}
}
