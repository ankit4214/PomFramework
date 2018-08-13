package com.vtiger.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class newleadPage extends headerPage {
	private WebDriver driver;
	
	public newleadPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	
	By lastname=By.name("lastname");
	By comp=By.name("company");
	By btnsave=By.name("button");
	By lastnametxt=By.xpath("//td[contains(text(),'Last Name:')]//following-sibling::td[1]");
	By comapnytxt=By.xpath("//td[contains(text(),'Company:')]//following-sibling::td[1]");
	
	
	public void createLeadWithManadatoryfields(String lname,String company)
	{
		driver.findElement(lastname).sendKeys(lname);
		driver.findElement(comp).sendKeys(company);
		driver.findElement(btnsave).click();		
	}
	
	public boolean verifyleadcontent(String lname,String company)
	{
		String lnametxt=driver.findElement(lastnametxt).getText();
		String comptxt=driver.findElement(comapnytxt).getText();
		if(lname.equals(lnametxt.trim()) && (company.equals(comptxt.trim())))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean verifyManadatoryfields()
	{
		driver.findElement(btnsave).click();
		Alert alt=driver.switchTo().alert();
		String vtxt=alt.getText();
		alt.accept();		
		driver.findElement(lastname).sendKeys("Modi");
		driver.findElement(btnsave).click();
		Alert alt1=driver.switchTo().alert();
		String vtxt1=alt1.getText();
		alt1.accept();	
		driver.findElement(comp).sendKeys("BJP");
		driver.findElement(btnsave).click();
		if(vtxt.equals("Last Name cannot be empty") && vtxt1.equals("Company cannot be empty"))
			return true;
		else
			return false;
				
	}
}
