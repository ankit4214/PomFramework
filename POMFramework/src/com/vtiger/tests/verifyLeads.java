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
import com.vtiger.pages.newleadPage;

public class verifyLeads extends BaseTest {
	
    @BeforeClass(alwaysRun = true)
	public void LauchApp()
	{
    	luanchApp();
	}
	
	@Test(groups = { "Sanity"})
	public void verifyLeadCreation()
	{
		loginPage lp=null;
		headerPage hp = null;
		try
		{
			logger=report.startTest("verifyLeadCreation");
			lp=new loginPage(driver);
			lp.login("admin", "admin");
			hp=new headerPage(driver);
			boolean val=hp.validateLogout();
			if(val)
			{
				logger.log(LogStatus.PASS, "Valid login scenario working successfully");
			}
			else
			{
				logger.log(LogStatus.FAIL, "Valid login is not working");
			}
			}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
			logger.log(LogStatus.FAIL, "Valid login is not working. Error: "+t.getMessage());
		}
		
		try
		{
			hp.clickOnNewLead();		
			logger.log(LogStatus.PASS, "New Lead link clicked successfully");
			
			newleadPage nlp=new newleadPage(driver);
			nlp.createLeadWithManadatoryfields("Singh", "Vivek");
			boolean txtval=nlp.verifyleadcontent("Singh", "Vivek");
			if(txtval)
			{
				logger.log(LogStatus.PASS, "Lead Validated successfully");
			}
			else
			{
				logger.log(LogStatus.FAIL, "Lead scenario failed");
			}
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
			logger.log(LogStatus.FAIL, "Lead scenario failed. Error: "+t.getMessage());
		}
		finally
		{
			report.endTest(logger);
			report.flush();
		}
		
		
		
	}
	
	@Test(dependsOnMethods = { "verifyLeadCreation" })
	public void verifyLeadMandatoryFields()
	{	
		logger=report.startTest("verifyLeadMandatoryFields");
		newleadPage nlp=new newleadPage(driver);
		nlp.clickOnNewLead();
		boolean txtval=nlp.verifyManadatoryfields();			
		if(txtval)
		{
			logger.log(LogStatus.PASS, "Leads manadatory fields Validated successfully");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Lead manadatory fields are not working");
		}
		
		report.endTest(logger);
		report.flush();
		
	}
	
	@Test
	public void test1()
	{
		System.out.println("this is dummy test");
	}
	
	@AfterClass(alwaysRun = true)
	public void CloseApp()
	{
		driver.quit();
	}

}
