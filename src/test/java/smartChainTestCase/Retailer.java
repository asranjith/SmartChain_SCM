package smartChainTestCase;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.SCM.Basetest.BaseClass;
import com.SCM.FileUtility.IpathConstant;
import com.SCM.FileUtility.JsonUtility;
import com.smart.ObjectRepository.LoginPage;
import com.smart.ObjectRepository.ManufacturerHomePage;
import com.smart.ObjectRepository.ManufacturerOrderPage;
import com.smart.ObjectRepository.MyOrdersPage;
import com.smart.ObjectRepository.OrderItemsPage;
import com.smart.ObjectRepository.RetailerHomePage;

import visibleText.VisibleTextRetailer;

public class Retailer extends BaseClass {
	public JsonUtility jsonutils = new JsonUtility();
	@Test(groups = "integration")
	public void order_Manufacturer() throws IOException, ParseException, InterruptedException {
		autils.verifyTitle(driver, VisibleTextRetailer.LoginPage.LOGIN);
		LoginPage lgn = new LoginPage(driver);
		lgn.login(IpathConstant.jsonpathlogin, "retailer", "username", "password", "logintype");
		RetailerHomePage rHomePage = new RetailerHomePage(driver);
		autils.verifyTitle(driver, VisibleTextRetailer.RetailerHomePage.RETAILER_HOME);
		rHomePage.getNewOrder().click();
		autils.verifyTitle(driver, VisibleTextRetailer.OrderItemsPage.ORDER_ITEMS);
		OrderItemsPage orderitem= new OrderItemsPage(driver);
		orderitem.placeOrder(driver, "mobile", "2",wutils);
		//After posting order it going for blank page
		rHomePage.getLogout().click();
		wutils.waitUntilElementToBeVisible(driver, lgn.getUsername(), 20);
		lgn.login(IpathConstant.jsonpathlogin, "retailer", "username", "password", "logintype");
		ManufacturerHomePage mhp=new ManufacturerHomePage(driver);
		mhp.getOrdersHeader().click();
		ManufacturerOrderPage mop=new ManufacturerOrderPage(driver);
		mop.orderConfirm(driver);
	}
	
	@Test(groups = "smoke")
	public void retailer_myorders() throws IOException, ParseException, InterruptedException {
		autils.verifyTitle(driver, VisibleTextRetailer.LoginPage.LOGIN);
		LoginPage lgn = new LoginPage(driver);
		lgn.login(IpathConstant.jsonpathlogin, "retailer", "username", "password", "logintype");
		RetailerHomePage rHomePage = new RetailerHomePage(driver);
		autils.verifyTitle(driver, VisibleTextRetailer.RetailerHomePage.RETAILER_HOME);
		rHomePage.getMyOrdersHeader().click();
		MyOrdersPage mop=new MyOrdersPage(driver);
		mop.searchOrderById(driver, "Id", "198");
		Thread.sleep(5000);
	}
}
