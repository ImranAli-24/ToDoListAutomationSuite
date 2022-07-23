package com.automation.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonTestBase {
	public static ThreadLocal<WebDriver> driver_web = new ThreadLocal<WebDriver>();
	//public static WebDriver driver_web;
	public String initializeinfo;
	public static ThreadLocal<AppiumDriver<WebElement>> driver_mobile = new ThreadLocal<AppiumDriver<WebElement>>();
	public WebDriver driver;
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public ExtentReports report;
	public static ExtentTest logger;
	public static Properties inputFile;
	public static String driverInfo;
	public static TakesScreenshot screen;
	public static File srcFile;
	public static File destinationFile;
	public static String login_username;
	public static String login_password;
	//public Status s;
@BeforeSuite
	public void initiatePrerequiste(ITestContext context) {
	try {
		driverInfo = context.getCurrentXmlTest().getParameter("browser");
		
		switch (driverInfo) {
		
		case "Chrome":
			//report.set(new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults_web.html",true,DisplayOrder.NEWEST_FIRST));
			report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults_web.html",true,DisplayOrder.NEWEST_FIRST);
			break;
		}
	
		inputFile = new Properties();
			inputFile.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\inputdata.properties")));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
@BeforeMethod
public void initializeDriver(ITestContext driverinfo) {
	
	initializeinfo = driverinfo.getCurrentXmlTest().getParameter("browser");
			
	switch (initializeinfo) {
	case "Chrome":
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/lib/chromedriver.exe");
		driver_web.set(new ChromeDriver());
		break;
	}
}
	public WebDriver getDriver() {
		return this.driver = driver_web.get();
	}
	
	public ExtentTest getThreadLogger() {
		return this.logger = test.get();
	}
	@AfterMethod
	public void methodEnd(ITestResult testResult, ITestContext context) {
	
		switch (testResult.getStatus()) {
		case ITestResult.SUCCESS:
			screenShot(testResult);
			break;

		case ITestResult.FAILURE:
			screenShot(testResult);
			break;
		}
		report.endTest(getThreadLogger());
			getDriver().quit();
		}
			
			
	
	@AfterSuite
	public void closeAll() {
		
		report.close();
	}
	
	public void screenShot(ITestResult context) {
		try {
			switch (driverInfo) {
			case "Chrome":
				screen = ((TakesScreenshot)getDriver());
				srcFile = screen.getScreenshotAs(OutputType.FILE);
				destinationFile = new File(System.getProperty("user.dir")+"//Screenshots//"+context.getMethod().getMethodName()+"_testScreenshot_Web.png");
				
				break;
			}
			FileUtils.copyFile(srcFile, destinationFile);
			getThreadLogger().log(LogStatus.INFO, getThreadLogger().addScreenCapture(destinationFile.getAbsolutePath()));
			//getThreadLogger().addScreenCapture(destinationFile.getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
