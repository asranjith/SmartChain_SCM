package com.smart.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SCM.WebdriverUtility.WebDriverUtility;

public class ManufacturerManageStockPage {
	public ManufacturerManageStockPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value='Update Stock']")
	private WebElement updateStock;

	public WebElement getUpdateStock() {
		return updateStock;
	}
	
	public void updateManageStock(WebDriver driver,String product,String quantity,WebDriverUtility wutils) throws InterruptedException {
		WebElement quantitytextfield = driver.findElement(By.xpath("//td[text()='"+product+"']/parent::tr/td/input"));
		quantitytextfield.clear();
		quantitytextfield.sendKeys(quantity);
		wutils.jsScrollToBottom(driver);
		updateStock.click();
	}
}
