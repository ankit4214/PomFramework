package com.vtiger.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.vtiger.pages.headerPage;
import com.vtiger.pages.loginPage;

public class LoginPageValidation extends BaseTest {
	
	@BeforeClass(alwaysRun = true)
	public void LauchApp()
	{
		 createReport();
		 luanchApp();
	}
	
	@Test(groups = { "Sanity","Smoke" })
	public void verifyTitle()
	{
		logger=report.startTest("verifyTitle");
		loginPage lp=new loginPage(driver);
		boolean val=lp.validateTitle("vtiger CRM - Commercial Open Source CRM");
		if(val)
		{
			logger.log(LogStatus.PASS, "Title matched successfully");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Title did not match");
		}
		report.endTest(logger);
		report.flush();
	}
	
	@Test(groups = { "Sanity","Smoke" })
	public void verifylogo()
	{
		logger=report.startTest("verifylogo");
		loginPage lp=new loginPage(driver);
		boolean val=lp.validatelogo();
		if(val)
		{
			logger.log(LogStatus.PASS, "Logo displayed successfully");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Logo not found");
		}
		report.endTest(logger);
		report.flush();
	}
	
	@Test(groups = { "Sanity"})
	public void verifyinvalidLogin()
	{
		logger=report.startTest("verifyinvalidLogin");
		loginPage lp=new loginPage(driver);
		lp.login("sfsf", "sdsg");
		boolean val=lp.validateErrorMsg();
		if(val)
		{
			logger.log(LogStatus.PASS, "Error msg displayed");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Error msg not found");
		}
		report.endTest(logger);
		report.flush();
		
	}
	
	@Test(groups = { "Sanity","Smoke" })
	public void verifyvalidLogin()
	{
		logger=report.startTest("verifyvalidLogin");
		loginPage lp=new loginPage(driver);
		lp.login("admin", "admin");
		headerPage hp=new headerPage(driver);
		boolean val=hp.validateLogout();
		
		if(val)
		{
			logger.log(LogStatus.PASS, "Valid login scenario working successfully");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Valid login is not working");
		}
		report.endTest(logger);
		report.flush();	
	}
	
	@AfterClass(alwaysRun = true)
	public void CloseApp()
	{
		driver.quit();
	}

}
