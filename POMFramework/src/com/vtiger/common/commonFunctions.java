package com.vtiger.common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;

public class commonFunctions {
	public static String reportpath;
	
	
	public static void SwitchToFrame(WebDriver driver,String frameid)
	{
		driver.switchTo().frame(frameid);
	}
	
	public static void selectvisibletext(WebDriver driver,WebElement elm,String val)
	{
		Select sel=new Select(elm);
		sel.selectByVisibleText(val);
	}
	
	public static ExtentReports setupResult()
	{	
		DateFormat format=new SimpleDateFormat("yyyyMMddhhmmss");
		Date date=new Date();
		String datestr=format.format(date);
		String extentReport=System.getProperty("user.dir")+"\\src\\com\\vtiger\\reports\\vtigerReport_"+datestr+".html";
		reportpath=extentReport;
		System.out.println(extentReport);
		ExtentReports report=new ExtentReports(extentReport);
		return report;
	}
	
	
	 public static void getscreenshot(String testname,WebDriver driver) throws Exception 
     {
		    DateFormat format=new SimpleDateFormat("yyyyMMddhhmmss");
			Date date=new Date();
			String datestr=format.format(date);
			String filename=System.getProperty("user.dir")+"\\src\\com\\ServiceNow\\reports\\screenshot\\"+testname+"_"+datestr+".png";
		 
             File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //The below method will save the screen shot in d drive with name "screenshot.png"
             FileUtils.copyFile(scrFile, new File(filename));
     }
	
	

	

}
