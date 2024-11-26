package com.smart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SCM.WebdriverUtility.WebDriverUtility;

public class AddAreaPage {
	public AddAreaPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAreaName() {
		return areaName;
	}

	public WebElement getAreacode() {
		return areacode;
	}

	public WebElement getAddAreaButton() {
		return addAreaButton;
	}

	@FindBy(id = "areaName")
	private WebElement areaName;

	@FindBy(id = "areaCode")
	private WebElement areacode;

	@FindBy(xpath = "//input[@value='Add Area']")
	private WebElement addAreaButton;

	public void addArea_Save(WebDriver driver,String area, String areaCode,WebDriverUtility wutils) {
		areaName.sendKeys(area);
		areacode.sendKeys(areaCode);
		addAreaButton.click();
		wutils.waitUnitAlertToPresent(driver, 15);
		wutils.acceptAlert(driver);
	}
}
