package Hooks;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import TestHooks.ExtentReportUtils;

public class ReportHooks
{
	
	public static ExtentReportUtils extentReportUtils = new ExtentReportUtils();
	
	
	@BeforeTest
	public void createTest()
	{
		extentReportUtils.AttachReport("New Test");
	}
	
	
	@AfterSuite
	public void FlushReport()
	{
		ExtentReportUtils.closeReport();
	}
}
