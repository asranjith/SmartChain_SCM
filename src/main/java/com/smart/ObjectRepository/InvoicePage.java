package com.smart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {
	public InvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLogout() {
		return logout;
	}

	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement logout;
	
	
	public WebElement getInvoiceSearchDropdown() {
		return invoiceSearchDropdown;
	}

	public WebElement getInputTextField() {
		return inputTextField;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public WebElement getDetailslink() {
		return detailslink;
	}

	@FindBy(xpath = "//select[@id='cmbFilter']")
	private WebElement invoiceSearchDropdown;
	
	@FindBy(xpath = "//input[@id='txtOrderId']")
	private WebElement inputTextField;
	
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchbutton;
	
	@FindBy(xpath = "//a[text()='Details']")
	private WebElement detailslink;
}
