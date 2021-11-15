package pages;

import org.openqa.selenium.By;

import Enums.Enums.TimeOutInSeconds;
import ObjectRepository.IElementRepo;
import TestHooks.ExtentReportUtils;
import testBase.BrowserUtils;

public class HomePage{
	
	private BrowserUtils browserUtils;
	private ExtentReportUtils extentReportUtils;
	private By locator;

	public HomePage(BrowserUtils browserUtils, ExtentReportUtils extentReportUtils)
	{
		this.browserUtils = browserUtils;
		this.extentReportUtils = extentReportUtils;
	}
	
	public void LaunchHomePage(String url)
	{
		try
		{
			this.browserUtils.NavigateToUrl(url);
			extentReportUtils.NodePassed("I have navigated to the home page", false);		
		}
		catch (Exception e)
		{
			extentReportUtils.NodeFailed("Failed to navigate to the home page", e);
		}
	}
		
	public void ClickMovieName(String movieName)
	{
		try
		{
			locator = IElementRepo.tab_HomePage_Movies;
			this.browserUtils.WaitForElement(locator, TimeOutInSeconds.TWENTY, TimeOutInSeconds.FIVE);
			By locatorToClick = By.xpath(IElementRepo.Txt_HomePage_MovieName.replace("M_MovieName", movieName));
			this.browserUtils.MouseHoverAndClickElement(locator, locatorToClick);
			extentReportUtils.NodePassed("I clicked the Movie name '" + movieName + "'");
		}
		catch (Exception e)
		{
			extentReportUtils.NodeFailed("Failed to click the Movie name '" + movieName + "'", e);
		}
	}
	

}
