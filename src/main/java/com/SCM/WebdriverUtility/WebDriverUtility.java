package com.SCM.WebdriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions act =new Actions(driver);
		act.doubleClick(element).perform();
	}

	
	public void clickAndHold(WebDriver driver,WebElement element) {
		Actions act =new Actions(driver);
		act.clickAndHold(element).perform();
	}

	public void mouseHoverAndClickElement(WebDriver driver,WebElement element) {
		Actions act =new Actions(driver);
		act.moveToElement(element).click().perform();
	}

	public void scrollToElement(WebDriver driver,WebElement element) {
		Actions act =new Actions(driver);
		act.scrollToElement(element).perform();
	}

	public void rightClick(WebDriver driver,WebElement element) {
		Actions act =new Actions(driver);
		act.contextClick(element).perform();
	}

	public void dragAndDop(WebDriver driver,WebElement sourceElement, WebElement targetElement) {
		Actions act =new Actions(driver);
		act.dragAndDrop(sourceElement, targetElement).perform();
	}


	public void switchToWindowByUrl(WebDriver driver, String expectedurl) {
		Set<String> allwindowid = driver.getWindowHandles();
		for (String id : allwindowid) {
			String actUrl = driver.switchTo().window(id).getCurrentUrl();
			if (actUrl.contains(expectedurl)) {
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allwindowid = driver.getWindowHandles();
		for (String id : allwindowid) {
			String actTitle = driver.switchTo().window(id).getTitle();
			if (actTitle.contains(expectedTitle)) {
				break;
			}
		}
	}

	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}

	public void jsScrollBy(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+");");
	}
	public void clickOnElementUsingJavaScript(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].click()", element);
	}

	public void sendValuesUsingJavaScript(WebDriver driver, String value, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + value + "'", element);
	}
	
	public void jsScrollToBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void waitForPageToLoad(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public void waitUntilElementToBeVisible(WebDriver driver, WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilElementToBeClickable(WebDriver driver, WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntilTitleContains(WebDriver driver, int sec, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.titleContains(title));
	}

	public void waitUntilUrlToBe(WebDriver driver, String url, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.urlToBe(url));
	}
	
	public void waitUnitAlertToPresent(WebDriver driver,int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void selectByVisibleText(WebElement element, String text) {
		Select builder = new Select(element);
		builder.selectByVisibleText(text);
	}

	public void selectByIndex(WebElement element, int index) {
		Select builder = new Select(element);
		builder.selectByIndex(index);
	}

	public void selectByValue(WebElement element, String value) {
		Select builder = new Select(element);
		builder.selectByValue(value);
	}

	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void switchToActiveElement(WebDriver driver, String keys) {
		driver.switchTo().activeElement().sendKeys(keys);
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToframe(WebDriver driver, String id_name) {
		driver.switchTo().frame(id_name);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void switchToNewTabByURL(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowid = it.next();
			driver.switchTo().window(windowid);
			String acturl = driver.getCurrentUrl();
			if (acturl.contains(partialURL)) {
				break;
			}

		}
	}

	public void switchToNewTabByTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowid = it.next();
			driver.switchTo().window(windowid);
			String acttitle = driver.getTitle();
			if (acttitle.contains(partialTitle)) {
				break;
			}

		}

	}
}
