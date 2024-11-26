package com.smart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailerHomePage {
	public RetailerHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[text()='New Order']")
	private WebElement newOrder;
	
	public WebElement getNewOrder() {
		return newOrder;
	}

	public WebElement getEditProfile() {
		return editProfile;
	}
	@FindBy(xpath = "//a[text()='Edit Profile']")
	private WebElement editProfile;
	
	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement logout;

	public WebElement getLogout() {
		return logout;
	}
	@FindBy(xpath = "//a[text()='My Orders']")
	private WebElement myOrdersHeader;

	public WebElement getMyOrdersHeader() {
		return myOrdersHeader;
	}
}
