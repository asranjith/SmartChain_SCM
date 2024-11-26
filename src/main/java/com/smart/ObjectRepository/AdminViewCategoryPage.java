package com.smart.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SCM.WebdriverUtility.WebDriverUtility;

public class AdminViewCategoryPage {
	public AdminViewCategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value='+ Add Category']")
	private WebElement addCategoryButton;
	
	public WebElement getAddCategoryButton() {
		return addCategoryButton;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteButton;
	
	public void clickEditCategoryIcon(WebDriver driver,WebDriverUtility wutils,String product) {
		WebElement editcategory = driver.findElement(By.xpath("(//td[contains(text(),'"+product+"')]/parent::tr/td/a)[1]"));
		editcategory.click();
	}
}
