package com.atmecs.windowshandling.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.locatorSmartFixTool.models.SmartFixPageFileHandler;
import com.atmecs.windowshandling.constant.FilePathConstants;
import com.atmecs.windowshandling.constant.LocatorKeyContainer;
import com.atmecs.windowshandling.testsuite.SampleTestSuiteBase;

public class HandlingWindows extends SampleTestSuiteBase
{
private ReportLogService report = new ReportLogServiceImpl(HandlingWindows.class);
	
	@Test
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void sampleTest(String os, String osVersion, String br, String browserVersion) throws InterruptedException 
	{
		// Handling Frames
		report.info("Opening browser: " + br);
		browser.openURL(SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HANDLING_WINDOWS,
								LocatorKeyContainer.BROWSER_URL), os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();

		browser.getWait().safeWait(5000);
		report.info("Switching to footer section");
		browser.getDriver().findElement(By.xpath(SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HANDLING_WINDOWS,
								LocatorKeyContainer.SWITCH_TO_FOOTER))).click();
		
		report.info("Clicking the media icons and handling windows");
		browser.getWait().safeWait(5000);
		WebElement mediaIcons = browser.getFindFromBrowser().findElementByXpath(SmartFixPageFileHandler.getLocatorValue(FilePathConstants.HANDLING_WINDOWS,
								LocatorKeyContainer.HANDLING_WINDOWS));
		for(int i=0;i<mediaIcons.findElements(By.tagName("a")).size();i++)
		{
			String link=Keys.chord(Keys.CONTROL,Keys.ENTER);
			mediaIcons.findElements(By.tagName("a")).get(i).sendKeys(link);
		}
		
	}
}
