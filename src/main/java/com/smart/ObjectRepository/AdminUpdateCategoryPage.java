package com.smart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminUpdateCategoryPage {
	public AdminUpdateCategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='categoryName']")
	private WebElement categoryName;
	
	public WebElement getCategoryName() {
		return categoryName;
	}

	public WebElement getAddCategory() {
		return addCategory;
	}

	@FindBy(xpath = "//input[@value='Update Category']")
	private WebElement addCategory;
	
	public void editCategoryClear_Save(String product) {
		categoryName.clear();
		categoryName.sendKeys(product);
		addCategory.click();
	}
}
