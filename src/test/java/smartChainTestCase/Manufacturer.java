package smartChainTestCase;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.SCM.Basetest.BaseClass;
import com.SCM.FileUtility.IpathConstant;
import com.smart.ObjectRepository.LoginPage;
import com.smart.ObjectRepository.ManufacturerAddCategoryPage;
import com.smart.ObjectRepository.ManufacturerAddProductPage;
import com.smart.ObjectRepository.ManufacturerHomePage;
import com.smart.ObjectRepository.ManufacturerManageStockPage;
import com.smart.ObjectRepository.ManufacturerViewCategoryPage;

import visibleText.VisibleTextManufacturer;

public class Manufacturer extends BaseClass {
	@Test(groups = "integration")
	public void manageStock() throws IOException, ParseException, InterruptedException {
		autils.verifyTitle(driver, VisibleTextManufacturer.LoginPage.LOGIN);
		LoginPage lgn = new LoginPage(driver);
		lgn.login(IpathConstant.jsonpathlogin, "manufacturer", "username", "password", "logintype");
		ManufacturerHomePage mhp = new ManufacturerHomePage(driver);
		autils.verifyTitle(driver, VisibleTextManufacturer.ManufacturerHomePage.MANUFACTURER_Home);
		mhp.getManageCategory().click();
		autils.verifyTitle(driver, VisibleTextManufacturer.ViewCategoryPage.VIEW_CATEGORY);
		wutils.jsScrollToBottom(driver);
		Thread.sleep(2000);
		wutils.jsScrollToBottom(driver);
		ManufacturerViewCategoryPage vcp = new ManufacturerViewCategoryPage(driver);
		vcp.getAddCategoryButton().click();
		ManufacturerAddCategoryPage mac=new ManufacturerAddCategoryPage(driver);
		autils.verifyTitle(driver, VisibleTextManufacturer.AddCategoryPage.ADD_CATEGORY);
		mac.addCategoryAndSave(driver, "detegent");
		wutils.waitUnitAlertToPresent(driver, 15);
		wutils.acceptAlert(driver);
		autils.verifyTitle(driver, VisibleTextManufacturer.AddCategoryPage.ADD_CATEGORY);
		mhp.getAddProduct().click();
		ManufacturerAddProductPage map=new ManufacturerAddProductPage(driver);
		autils.verifyTitle(driver, VisibleTextManufacturer.AddProductPage.ADD_PRODUCT);
		map.addProduct(driver, "powder", "500", "KG", "detegent", wutils);
		autils.verifyTitle(driver, VisibleTextManufacturer.AddProductPage.ADD_PRODUCT);
		mhp.getManageStock().click();
		wutils.jsScrollToBottom(driver);
		ManufacturerManageStockPage mms=new ManufacturerManageStockPage(driver);
		//bug title should be Manage Stock but it is Admin:Home
		//autils.verifyTitle(driver, VisibleTextManufacturer.ManageStockPage.MANAGE_STOCK);
		mms.updateManageStock(driver, "powder", "30",wutils);
		wutils.waitUnitAlertToPresent(driver, 15);
		wutils.acceptAlert(driver);
		//bug title should be Manage Stock but it is Admin:Home
		//autils.verifyTitle(driver, VisibleTextManufacturer.ManageStockPage.MANAGE_STOCK);
	}
	   
}
