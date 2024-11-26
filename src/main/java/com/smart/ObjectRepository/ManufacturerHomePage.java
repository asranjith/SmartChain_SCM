package com.smart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturerHomePage {
	public ManufacturerHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Orders']")
	private WebElement ordersHeader;

	public WebElement getOrdersHeader() {
		return ordersHeader;
	}
	
	@FindBy(xpath = "//a[text()='Manage Stock']")
	private WebElement manageStock;

	public WebElement getManageStock() {
		return manageStock;
	}
	@FindBy(xpath = "//a[text()='Manage Category']")
	private WebElement manageCategory;
	
	public WebElement getManageCategory() {
		return manageCategory;
	}

	public WebElement getAddProduct() {
		return addProduct;
	}

	@FindBy(xpath = "//a[text()='Add Products']")
	private WebElement addProduct;
	
	
}
