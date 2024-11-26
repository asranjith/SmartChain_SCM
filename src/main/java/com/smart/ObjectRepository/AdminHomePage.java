package com.smart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	public AdminHomePage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	public WebElement getLoginTitle() {
		return loginTitle;
	}
	@FindBy(xpath = "//title")
	private WebElement loginTitle;
	
	public WebElement getRecentlyAddedRetailers() {
		return recentlyAddedRetailers;
	}

	public WebElement getRecentlyAddedManufacturers() {
		return RecentlyAddedManufacturers;
	}

	public WebElement getRecentlyAddedProducts() {
		return RecentlyAddedProducts;
	}

	public WebElement getAddProduct() {
		return addProduct;
	}

	public WebElement getAddRetailers() {
		return addRetailers;
	}

	public WebElement getAddManufacturer() {
		return addManufacturer;
	}

	public WebElement getAddDistributor() {
		return addDistributor;
	}

	public WebElement getManageUnit() {
		return manageUnit;
	}

	public WebElement getManageCategory() {
		return manageCategory;
	}

	public WebElement getManageArea() {
		return manageArea;
	}

	public WebElement getChangePassword() {
		return changePassword;
	}

	public WebElement getLogout() {
		return logout;
	}

	@FindBy(xpath = "//h2[text()='Recently Added Retialers']/parent::article/table/tbody/tr/td")
	private WebElement recentlyAddedRetailers;
	
	@FindBy(xpath = "//h2[text()='Recently Added Manufacturers']/parent::article/table/tbody/tr/td")
	private WebElement RecentlyAddedManufacturers;
	
	@FindBy(xpath = "//h2[text()='Recently Added Products']/parent::article/table/tbody/tr/td")
	private WebElement RecentlyAddedProducts;
	
	@FindBy(xpath = "//a[text()='Add Products']")
	private WebElement addProduct;
	
	@FindBy(xpath = "//a[text()='Add Retailers']")
	private WebElement addRetailers;
	
	@FindBy(xpath = "//a[text()='Add Retailer']")
	private WebElement addManufacturer;
	
	@FindBy(xpath = "//a[text()='Add Distributor']")
	private WebElement addDistributor;
	
	@FindBy(xpath = "//a[text()='Manage Unit']")
	private WebElement manageUnit;
	
	@FindBy(xpath = "//a[text()='Manage Category']")
	private WebElement manageCategory;
	
	@FindBy(xpath = "//a[text()='Manage Area']")
	private WebElement manageArea;
	
	@FindBy(xpath = "//a[text()='Change Password']")
	private WebElement changePassword;
	
	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement logout;
   
}
