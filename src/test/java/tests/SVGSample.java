package tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bouncycastle.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


import Hooks.WebHooks;
import testBase.BrowserUtils;

public class SVGSample extends WebHooks
{
	BrowserUtils browserUtils;

	private SVGSample()
	{
		browserUtils = new BrowserUtils();
	}
	
//	@Test
//	public void SVG() throws InterruptedException
//	{
//		browserUtils.MaximizeScreen();
//		browserUtils.NavigateToUrl("https://www.google.com/search?q=covid+cases&rlz=1C1CHZL_enIN830IN830&ei=X5-DYY-nNr-95OUP36-xsAc");
//		WebElement ele = browserUtils.FindElement(By.xpath("(//*[name()='svg'][@class='uch-psvg'])[1]"));
//		((JavascriptExecutor)BrowserUtils.driver).executeScript("arguments[0].scrollIntoView(true);", ele);
//		List<WebElement> elements = browserUtils.FindElements(By.xpath("//*[name()='svg'][@class='uch-psvg']/*[name()='g']/*[name()='rect']"));
//		elements.forEach(x -> { browserUtils.MouseHover(x); 
//		String text = browserUtils.GetTextFromElement(By.xpath("//div[@class='ExnoTd']"));
//		System.out.println("-------------------------------------------------");
//		System.out.println(text);
//		});
//		Thread.sleep(5000);
//	}
//	
//	@Test
//	public void SVG2() throws InterruptedException
//	{
//		browserUtils.MaximizeScreen();
//		browserUtils.NavigateToUrl("https://www.google.com/search?q=covid+cases&rlz=1C1CHZL_enIN830IN830&ei=X5-DYY-nNr-95OUP36-xsAc");
//		WebElement ele = browserUtils.FindElement(By.xpath("(//*[name()='svg'][@class='uch-psvg'])[2]"));
//		((JavascriptExecutor)BrowserUtils.driver).executeScript("arguments[0].scrollIntoView(true);", ele);
//		Thread.sleep(5000);
//		Actions actions = new Actions(BrowserUtils.driver);
//		int offsextY = - ele.getSize().getHeight()/2;
//		int offsextX = - ele.getSize().getWidth()/2;
//		System.out.println("X = " + offsextX);
//		System.out.println("Y = "+ offsextY);
//		System.out.println("width = "+ ele.getSize().getWidth());
//		String temp = "Last";
//		List<String> dates = new ArrayList<>();
//		Map<String, Integer> datesPrintedCount = new LinkedHashMap<>();
//		for (int i = offsextX; i <= ele.getSize().getWidth(); i++)
//		{
//		    actions.moveToElement(ele, i, offsextY).build().perform();
//			String text = browserUtils.GetTextFromElement(By.xpath("//div[@jsname='qAPsYb']"));
//			String date = text.split("\\r?\\n")[0];
//			if (date.isBlank() || date.isEmpty())
//			{
//				break;
//			}
//			if (!datesPrintedCount.containsKey(date))
//			{
//				datesPrintedCount.put(date, 1);
//			}
//			else
//			{
//				datesPrintedCount.computeIfPresent(date, (k,v) -> v + 1);
//			}
//			
//			System.out.println("date = " + date);
//			dates.add(date);
//			if(datesPrintedCount.containsValue(10))
//			{
//				System.out.println("inside break");
//				break;
//			}
//			System.out.println("-------------------------------------------------");
//			System.out.println(text);
//			temp = text;
//			System.out.println("temp = " + temp);
//		}
//		
//		System.out.println("------------Printing all dates-------------");
//		dates.forEach(System.out::println);
//		System.out.println("------------Printing all hashmap dates-------------");
//		datesPrintedCount.forEach((k,v) -> System.out.println("date: " + k + " and occured: " + v.toString()));
//		Integer maxVal = datesPrintedCount.values().parallelStream().max((x, y) -> x.compareTo(y)).get();
//		System.out.println("max value without stream : " + maxVal.toString());
//		Entry<String, Integer> max = datesPrintedCount.entrySet().stream().max((v1,v2) -> v1.getValue().compareTo(v2.getValue())).get();
//		System.out.println("max value with streams : key = "  + max.getKey() + " and value = " + max.getValue());
//		Map<Integer, String> newMap = datesPrintedCount.entrySet().parallelStream().sorted((a,b) -> a.getValue().compareTo(b.getValue()))
//		.collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.joining(","))));
//		System.out.println("------------Printing all grouped value hashmap-------------");
//		newMap.forEach((k,v) -> System.out.println("Key : " + k.toString() + " and Values : " + v));
//		newMap.forEach((k,v) -> System.out.println("Key : " + k.toString() + " and Values : " + v.split(",").length));
//		
//
//		Thread.sleep(5000);
//	}
//	
//	@Test
//	public void SVG3() throws InterruptedException
//	{
//		browserUtils.MaximizeScreen();
//		browserUtils.NavigateToUrl("https://www.google.com/search?q=covid+cases&rlz=1C1CHZL_enIN830IN830&ei=X5-DYY-nNr-95OUP36-xsAc");
//		WebElement ele = browserUtils.FindElement(By.xpath("(//*[name()='svg'][@class='uch-psvg'])[3]"));
//		Thread.sleep(2000);
//		JavascriptExecutor js = (JavascriptExecutor) BrowserUtils.driver;
//		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", ele);
//		int offsetY = - ele.getSize().height / 2;
//		int OffsetX = - ele.getSize().width / 2;
//		Map<String, String> firstDose = new LinkedHashMap<String, String>();
//		Map<String, String> fullyVaccinated = new LinkedHashMap<String, String>();
//		Actions actions = new Actions(BrowserUtils.driver);
//		for (int i = OffsetX; i <= ele.getSize().getWidth(); i++)
//		{
//			actions.moveToElement(ele, i, offsetY).build().perform();
//			String text = browserUtils.GetTextFromElement(By.xpath("//table[contains(@class,'Gkq')]"));
//			String[] textArray = text.split("\\r?\\n");
//			System.out.println("array count = " + textArray.length);
//			List.of(textArray).forEach(System.out::println);
//			if(textArray.length > 2)
//			{
//			firstDose.put(textArray[0], textArray[1]);
//			fullyVaccinated.put(textArray[0], textArray[2]);
//			}
//			System.out.println("--------------------");
//			System.out.println(text);
//			if (text.isBlank() || text.isEmpty())
//			{
//				System.out.println("inside break");
//				break;
//			}
//		}
//		
//		firstDose.entrySet().parallelStream().sorted().distinct();
//		firstDose.forEach((k,v) -> System.out.println("Key : " + k + " and " + "Value : " + v));
//		
//		fullyVaccinated.entrySet().parallelStream().sorted().distinct();
//		fullyVaccinated.forEach((k,v) -> System.out.println("Key : " + k + " and " + "Value : " + v));
//		
//		Thread.sleep(5000);
//	}
//	
}
