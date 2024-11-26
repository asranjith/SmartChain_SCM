package com.smart.ObjectRepository;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.SCM.FileUtility.JsonUtility;
import com.SCM.WebdriverUtility.WebDriverUtility;

public class LoginPage {
	
	public WebDriverUtility wutils=new WebDriverUtility();
	public JsonUtility jsonutils = new JsonUtility();
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogintype() {
		return logintype;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	@FindBy(id = "login:username")
	private WebElement username;

	@FindBy(id = "login:password")
	private WebElement password;

	@FindBy(id = "login:type")
	private WebElement logintype;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	public void login(String filepath,String user,String userName, String passWord, String loginType) throws FileNotFoundException, IOException, ParseException {
		String USERNAME = jsonutils.readDataFromJsonFile(filepath,user,userName);
		String PASSWORD = jsonutils.readDataFromJsonFile(filepath,user,passWord);
		String LOGINTYPE =  jsonutils.readDataFromJsonFile(filepath,user,loginType);
		username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
		wutils.selectByVisibleText(logintype, LOGINTYPE);
		loginButton.click();
		Reporter.log("======Login is Successfull=====",true);
	}

}
