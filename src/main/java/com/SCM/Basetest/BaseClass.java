package com.SCM.Basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.SCM.FileUtility.ExcelUtility;
import com.SCM.FileUtility.IpathConstant;
import com.SCM.FileUtility.JsonUtility;
import com.SCM.ListenersUtility.UtilityClassObject;
import com.SCM.WebdriverUtility.JavaUtility;
import com.SCM.WebdriverUtility.WebDriverUtility;
import com.SCM.assertUtility.Assertutility;
import com.SCM.databaseUtility.DataBaseUtility;


public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public DataBaseUtility dbUtilis=new DataBaseUtility();   
    public ExcelUtility eutils = new ExcelUtility();
	public JsonUtility jsonutils=new  JsonUtility();
	public WebDriverUtility wutils;
	public JavaUtility jutils =new JavaUtility();
	public Assertutility autils=new Assertutility();
	
	
    @BeforeSuite(groups = {"smokeTest","regressionTest"})
    public void connectToDB() throws SQLException {
    
    }
    
    @Parameters("BROWSER")
    @BeforeClass(groups = {"smokeTest","regressionTest"})
       public void launchBrowser(@Optional("chrome") String browser) throws IOException, ParseException {
		String URL = jsonutils.readDataFromJsonFile(IpathConstant.jsonpathlogin,"url");
    	String BROWSER=jsonutils.readDataFromJsonFile(IpathConstant.jsonpathlogin,"browser");
    	System.out.println(URL+" "+BROWSER);
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			Reporter.log("====CHROME IS LAUNCHED SUCCESSFULLY====",true);
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		wutils=new WebDriverUtility();
		wutils.waitForPageToLoad(driver, 15);
		driver.manage().window().maximize();
		driver.get(URL);
		
    }
    
   // @AfterMethod(groups = {"smokeTest","regressionTest"})
//    public void logout() {
//    	AdminHomePage homepage=new AdminHomePage(driver);
//    	homepage.getLogout().click();
//    	Reporter.log("=====Logout is Successfull=====",true);
//    }
    
    @AfterClass(groups = {"smokeTest","regressionTest"})
    public void closeBrowser() {
    	driver.quit();
    	Reporter.log("=====BROWSER IS CLOSED======",true);
    }
    
    @AfterSuite(groups = {"smokeTest","regressionTest"})
    public void closeDB() {
 
    }
}
