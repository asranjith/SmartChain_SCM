package com.smart.ObjectRepository;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SCM.FileUtility.IpathConstant;
import com.SCM.FileUtility.JsonUtility;
import com.SCM.WebdriverUtility.WebDriverUtility;

public class AdminAddProductPage {
	public JsonUtility jsonutils=new  JsonUtility();
	public AdminAddProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductPrice() {
		return productPrice;
	}

	public WebElement getProductUnitDropDown() {
		return productUnitDropDown;
	}

	public WebElement getProductCategoryDropDown() {
		return productCategoryDropDown;
	}

	public WebElement getEnableStockManage() {
		return enableStockManage;
	}

	public WebElement getDisableStockManage() {
		return disableStockManage;
	}

	public WebElement getAddProductButton() {
		return addProductButton;
	}
	@FindBy(id = "product:name")
	private WebElement productName;
	
	@FindBy(id = "product:price")
	private WebElement productPrice;
	
	@FindBy(id = "product:unit")
	private WebElement productUnitDropDown;
	
	@FindBy(id = "product:category")
	private WebElement productCategoryDropDown;
	
	@FindBy(xpath = "//input[@value='1']")
	private WebElement enableStockManage;
	
	@FindBy(xpath = "//input[@value='2']")
	private WebElement disableStockManage;
	
	@FindBy(xpath = "//input[@value='Add Product']")
	private WebElement addProductButton;
	
	public void addProduct(WebDriver driver,String product,String Price,String unit,String category,WebDriverUtility wutils) throws FileNotFoundException, IOException, ParseException {
		String PRODUCT = jsonutils.readDataFromJsonFile(IpathConstant.jsonpathaddproduct,"addProduct",product);
		String UNIT = jsonutils.readDataFromJsonFile(IpathConstant.jsonpathaddproduct,"addUnit",unit);
		String CATEGORY = jsonutils.readDataFromJsonFile(IpathConstant.jsonpathaddproduct,"addCategory",category);
		System.out.println(PRODUCT+" "+UNIT+" "+CATEGORY);
		productName.sendKeys(PRODUCT);
		productPrice.sendKeys(Price);
		wutils.selectByVisibleText(productUnitDropDown, UNIT);
		wutils.selectByVisibleText(productCategoryDropDown, CATEGORY);
		enableStockManage.click();
		addProductButton.click();
	}
}
