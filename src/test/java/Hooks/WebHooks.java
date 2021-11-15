package Hooks;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import testBase.Page;
import testBase.WebBrowser;

public class WebHooks extends ReportHooks
{
	WebBrowser browser = new WebBrowser();
	Page page = new Page();
	public static WebDriver Webdriver = null;
	
	
	@BeforeMethod
	public void LaunchBrowser() 
	{
		page.SelectBrowser(browser, "chrome");
		Webdriver = Page.driver;
	}
	
	@AfterMethod
	public void CloseBrowser() 
	{
		page.CloseBrowser();
	}
}
