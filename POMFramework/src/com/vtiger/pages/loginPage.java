package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	private WebDriver driver;
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By username=By.name("user_name");
	By userpassword=By.name("user_password");
	By loginbtn=By.name("Login");
	By logo=By.xpath("//img[@src='include/images/login_left.gif']");
	By errMsg=By.xpath("//td[contains(text(),'You must specify a valid username and password.')]");
	
	
	public void login(String user,String pwd)
	{
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(user);
		driver.findElement(userpassword).clear();
		driver.findElement(userpassword).sendKeys(pwd);
		driver.findElement(loginbtn).click();	
	}
	
	public boolean validateTitle(String ExpectedTitle)
	{
		if(driver.getTitle().trim().equals(ExpectedTitle))		
			return true;		
		else
		    return false;
	}
	
	
	public boolean validatelogo()
	{
		if(driver.findElement(logo).isDisplayed())		
			return true;		
		else
		    return false;
	}
	
	
	public boolean validateErrorMsg()
	{
		if(driver.findElement(errMsg).isDisplayed())		
			return true;		
		else
		    return false;
	}
}
