package com.smart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SCM.WebdriverUtility.WebDriverUtility;

public class MyOrdersPage {
	public WebDriverUtility wutils;
	public MyOrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//select[@id='cmbFilter']")
	private WebElement orderSearchByDropdown;
	
	public WebElement getOrderSearchByDropdown() {
		return orderSearchByDropdown;
	}
	@FindBy(xpath = "//input[@id='txtId']")
	private WebElement idInputTextField;
	
	public WebElement getIdInputTextField() {
		return idInputTextField;
	}
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchbutton;
	
	
	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public void searchOrderById(WebDriver driver,String visibleText,String id) {
		wutils=new WebDriverUtility();
		wutils.selectByVisibleText(orderSearchByDropdown, visibleText);
		idInputTextField.sendKeys(id);
		searchbutton.click();
		
	}
}
