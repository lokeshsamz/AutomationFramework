package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Enums.Enums.TimeOutInSeconds;
import Hooks.WebHooks;
import testBase.BrowserUtils;

public class WindowHandles extends WebHooks{
	
	private BrowserUtils browserUtils;
	
	private WindowHandles() {
		browserUtils = new BrowserUtils();
	}
	
	@Test
	public void WindowHandlesTest()
	{
		boolean status = false;
		browserUtils.MaximizeScreen();
		browserUtils.NavigateToUrl("https://opensource-demo.orangehrmlive.com/");
		BrowserUtils.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String parentWindow = BrowserUtils.driver.getWindowHandle();
		System.out.println(parentWindow);

		String allLinks = "//div[@id='social-icons']/a/img" ;
		browserUtils.FindElements(By.xpath(allLinks)).forEach(x -> x.click());
		Set<String> activeWindows = BrowserUtils.driver.getWindowHandles();
		List<String> activeWindowsList = new ArrayList<>(activeWindows);
		activeWindowsList.forEach(System.out::println);
		status = this.SwitchToDesiredWindow(activeWindowsList, "YouTube");
		
		if (status)
		{
			System.out.println("Switched to facebook page"); 
		}
		else
		{
			System.out.println("Failed to switch to facebook page");
		};
		
		this.SwitchToWindow(parentWindow);
		System.out.println("Switch to parent window");
		this.CloseActiveWindows(activeWindowsList, parentWindow);
	}
	
	public void CloseActiveWindows(List<String> activeWindowsList, String parentWindow)
	{
		activeWindowsList.stream().filter(x -> !x.contains(parentWindow)).forEach(x -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(x);
		this.SwitchToWindow(x).close();}
		);
	}

	public boolean SwitchToDesiredWindow(List<String> activeWindowsList, String windowName)
	{
		return activeWindowsList.stream().anyMatch(x -> this.GetCurrentWindowTitle(x).contains(windowName));
	}
	
	public String GetCurrentWindowTitle(String window)
	{
		return this.SwitchToWindow(window).getTitle();
	}
	
	public WebDriver SwitchToWindow(String window)
	{
		return BrowserUtils.driver.switchTo().window(window);
	}
	
	public void ClickListofLinks(List<By> links)
	{
		links.forEach(link ->
		{
			browserUtils.WaitForElement(link, TimeOutInSeconds.TEN);
			browserUtils.ClickElement(link);
		});
	}

}
