package com.smart.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.SCM.WebdriverUtility.JavaUtility;
import com.SCM.WebdriverUtility.WebDriverUtility;

public class ManufacturerOrderPage {
	public WebDriverUtility wutils;
	public JavaUtility jutils;
	
	public ManufacturerOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLogout() {
		return logout;
	}

	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement logout;
	
	
	public WebElement getOrderSearchByDropdown() {
		return orderSearchByDropdown;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public WebElement getDetailslink() {
		return detailslink;
	}

	@FindBy(xpath = "//select[@id='cmbFilter']")
	private WebElement orderSearchByDropdown;
	
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchbutton;
	
	@FindBy(xpath = "//a[text()='Details']")
	private WebElement detailslink;
	
	@FindBy(xpath = "//a[text()='Confirm']")
	private WebElement confirmLink;


	public WebElement getConfirmLink() {
		return confirmLink;
	}
	
	@FindBy(xpath = "//input[@id='txtId']")
	private WebElement idInputTextField;
	
	public WebElement getIdInputTextField() {
		return idInputTextField;
	}

	public void searchOrderById(WebDriver driver,String visibleText,String id) {
		wutils.selectByVisibleText(orderSearchByDropdown, visibleText);
		idInputTextField.sendKeys(id);
		searchbutton.click();
		confirmLink.click();
	}
	
	 public void orderConfirm(WebDriver driver) throws InterruptedException {
		 wutils=new WebDriverUtility();
		 jutils=new JavaUtility();
		 String todaysdate = jutils.getSystemDatedd_MM_yyyy();
		 driver.findElement(By.xpath("//td[contains(text(),'"+todaysdate+"')]/following-sibling::td/a[text()='Confirm']"));
		 confirmLink.click();
		 Reporter.log("order is confermed",true);
		 Thread.sleep(5000);
	  }
}
