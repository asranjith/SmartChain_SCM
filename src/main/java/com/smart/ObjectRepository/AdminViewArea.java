package com.smart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminViewArea {
	public AdminViewArea(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAddAreaButton() {
		return addAreaButton;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	@FindBy(xpath = "//input[@value='+ Add Area']")
	private WebElement addAreaButton;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteButton;
	
	public void editArea() {
		
	}
	public void deleteArea() {
		
	}
}
