package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage extends headerPage {
	private WebDriver driver;
	
	public homePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	
	By txtMyUpcomingActivities =By.xpath("//td[contains(text(),'My Upcoming and Pending Activities')]");
	
	
	public boolean verifyMyUpcomingActivities()
	{
		if(driver.findElement(txtMyUpcomingActivities).isDisplayed())
			return true;
		else
			return false;
	}
}
