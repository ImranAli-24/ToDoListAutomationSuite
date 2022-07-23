package com.automation.base;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileBy;



public class CommonTestActions extends CommonTestBase{
	
	//Common action method for click
	public void customizeClick(WebElement element,String description) {
		try {
		element.click();
		getThreadLogger().log(LogStatus.PASS, description);
		}catch (StaleElementReferenceException e) {
			// trying again for click
			element.click();
			//test.log(LogStatus.valueOf(description), description);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		}
	
	public void sendText(WebElement element, String value, String description) {
		//waitForElement(element);
		element.sendKeys(value);
		getThreadLogger().log(LogStatus.PASS, description);
	}
	
	
	public boolean isWebElementDisplayed(WebElement element) {
		try {
		new WebDriverWait(getDriver(), 30).until(ExpectedConditions.visibilityOf(element));
		return true;
		}catch (Exception e) {
			System.out.println("Element not found");
			return false;
		}
	}
	public boolean isWebElementDisplayedBrowser(WebElement element) {
		try {
		new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(element));
		return true;
		}catch (Exception e) {
			System.out.println("Element not found");
			return false;
		}
	}
	public void waitForTime() throws InterruptedException {
		Thread.sleep(2000);
	}
	public boolean waitForElement(WebElement element) {
		FluentWait<WebDriver> fWait = new WebDriverWait(getDriver(), 30);
		fWait.withTimeout(30,TimeUnit.SECONDS).pollingEvery(1000, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver arg0) {
				if(element!=null && element.isEnabled() && element.isDisplayed()) {
					return true;
				}
				return false;
			}
		};
		try {
			fWait.until(function);
		}catch (Exception e) {
			return false;
		}
		return true;
		}
	
	public boolean waitForElementWeb(WebElement element) {
		FluentWait<WebDriver> fWait = new WebDriverWait(getDriver(), 30);
		fWait.withTimeout(30,TimeUnit.SECONDS).pollingEvery(1000, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver arg0) {
				if(element!=null && element.isEnabled() && element.isDisplayed()) {
					return true;
				}
				return false;
			}
		};
		try {
			fWait.until(function);
		}catch (Exception e) {
			return false;
		}
		return true;
		}
		
		public void swipeAndFindElementClick(String text) {
			
			WebElement ele = getDriver().findElement(MobileBy
                    .AndroidUIAutomator("new UiScrollable(new UiSelector()).setAsVerticalList().scrollIntoView("
                            + "new UiSelector().text(\""+text+"\"));")); 
			ele.click();
			
		}
		}
