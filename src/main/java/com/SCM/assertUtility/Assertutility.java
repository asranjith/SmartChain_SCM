package com.SCM.assertUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Assertutility {
	public void softAssert(boolean actual,boolean expected,String message) {
		SoftAssert softObj = new SoftAssert();
		softObj.assertEquals(actual, expected,message);
		softObj.assertAll();
	}
	
	public void softAssert(String actual,String expected,String message ) {
		SoftAssert softObj = new SoftAssert();
		softObj.assertEquals(actual, expected, message);
		softObj.assertAll();
	}
	
	public void softAssert(int actual,int expected,String message) {
		SoftAssert softObj = new SoftAssert();
		softObj.assertEquals(actual,expected,message);
		softObj.assertAll();
	}
	public void softAssert(char actual,char expected,String message) {
		SoftAssert softObj = new SoftAssert();
		softObj.assertEquals(actual, expected,message);
		softObj.assertAll();
	}
	public void verifyTitle(WebDriver driver,String expected) {
		String title = driver.getTitle();
		Assert.assertEquals(title, expected,"Title miss match!");
	}
	public void verifyText(WebElement element,String expected) {
		String actual = element.getText();
		Assert.assertEquals(actual, expected,"Text miss match!");
	}
}
