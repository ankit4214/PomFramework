package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class headerPage {
	
	private WebDriver driver;
	
	public headerPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By lnkLogout=By.linkText("Logout");
	By lnkLeads=By.linkText("Leads");
	By lnkNewLead=By.linkText("New LLead");
	
	
	public void clickOnLogout()
	{
		driver.findElement(lnkLogout).click();
	}
	
	public void clickOnleads()
	{
		driver.findElement(lnkLeads).click();
	}
	
	public void clickOnNewLead()
	{
		driver.findElement(lnkNewLead).click();
	}
	
	public boolean validateLogout()
	{
		if(driver.findElement(lnkLogout).isDisplayed())		
			return true;		
		else
		    return false;
	}
}
