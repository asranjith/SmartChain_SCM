package com.smart.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.SCM.WebdriverUtility.WebDriverUtility;

public class OrderItemsPage {
	public OrderItemsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
		@FindBy(xpath = "//input[@value='Log out']")
		private WebElement logout;
		
		public WebElement getLogout() {
			return logout;
		}
		
		@FindBy(xpath = "//input[@value='Post Order']")
		private WebElement postOrder;
		
	public WebElement getPostOrder() {
			return postOrder;
		}

	public void placeOrder(WebDriver driver,String productName,String quantity,WebDriverUtility wutils) throws InterruptedException {
		WebElement quantityTextField = driver.findElement(By.xpath("//td[contains(text(),'"+productName+"')]/parent::tr/child::td/input"));
		quantityTextField.sendKeys(quantity);
		wutils.jsScrollToBottom(driver);
		postOrder.click();
		Reporter.log("order is posted successfully",true);
	}
	
}
