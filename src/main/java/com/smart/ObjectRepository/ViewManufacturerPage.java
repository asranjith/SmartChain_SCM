package com.smart.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewManufacturerPage {
	public ViewManufacturerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deletebutton;
	
	public WebElement getDeletebutton() {
		return deletebutton;
	}
	
	public WebElement getLogout() {
		return logout;
	}

	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement logout;

	public void deleteManufacturer(WebDriver driver,String name) {
		WebElement checkbox = driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]/parent::tr/td/input"));
		checkbox.click();
		deletebutton.click();
	}
}
