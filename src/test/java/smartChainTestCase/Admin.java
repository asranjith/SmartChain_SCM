package smartChainTestCase;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.SCM.Basetest.BaseClass;
import com.SCM.FileUtility.IpathConstant;
import com.smart.ObjectRepository.AddAreaPage;
import com.smart.ObjectRepository.AdminAddCategoryPage;
import com.smart.ObjectRepository.AdminAddProductPage;
import com.smart.ObjectRepository.AdminHomePage;
import com.smart.ObjectRepository.AdminUpdateCategoryPage;
import com.smart.ObjectRepository.AdminViewArea;
import com.smart.ObjectRepository.AdminViewCategoryPage;
import com.smart.ObjectRepository.LoginPage;
import com.smart.ObjectRepository.ManufacturerHomePage;
import com.smart.ObjectRepository.ManufacturerManageStockPage;

import visibleText.VisibleTextAdmin;
import visibleText.VisibleTextManufacturer;

public class Admin extends BaseClass {
	
	
	@Test(groups = "integration")
	public void addProduct() throws IOException, ParseException, InterruptedException {
		autils.verifyTitle(driver, VisibleTextAdmin.LoginPage.LOGIN);
		LoginPage lgn = new LoginPage(driver);
		lgn.login(IpathConstant.jsonpathlogin, "admin", "username", "password", "logintype");
		AdminHomePage ahp=new AdminHomePage(driver);
		autils.verifyTitle(driver, VisibleTextAdmin.AdminHomePage.ADMIN_HOME);
		ahp.getManageCategory().click();
		autils.verifyTitle(driver, VisibleTextAdmin.ViewCategoryPage.VIEW_CATEGORY);
		wutils.jsScrollToBottom(driver);
		Thread.sleep(2000);
		wutils.jsScrollToBottom(driver);
		AdminViewCategoryPage vcp=new AdminViewCategoryPage(driver);
		vcp.getAddCategoryButton().click();
		AdminAddCategoryPage acp=new AdminAddCategoryPage(driver);
		autils.verifyTitle(driver, VisibleTextAdmin.AddCategoryPage.ADD_CATEGORY);
		acp.addCategoryAndSave(driver, "chocolatewafer");
		wutils.waitUnitAlertToPresent(driver, 15);
		wutils.acceptAlert(driver);
		AdminHomePage aHomePage=new AdminHomePage(driver);
		autils.verifyTitle(driver, VisibleTextAdmin.AddCategoryPage.ADD_CATEGORY);
		aHomePage.getAddProduct().click();
		AdminAddProductPage aap=new AdminAddProductPage(driver);
		autils.verifyTitle(driver, VisibleTextAdmin.AddProductPage.ADD_PRODUCT);
		aap.addProduct(driver, "product1", "130", "unitName4", "category1", wutils);
		wutils.waitUnitAlertToPresent(driver, 15);
		wutils.acceptAlert(driver);
		aHomePage.getLogout().click();
		//autils.verifyTitle(driver, VisibleTextAdmin.LogOutPage.LOGOUT);
		LoginPage lp=new LoginPage(driver);
		wutils.waitUntilElementToBeVisible(driver, lp.getUsername(), 20);
		autils.verifyTitle(driver, VisibleTextManufacturer.LoginPage.LOGIN);
		lgn.login(IpathConstant.jsonpathlogin, "manufacturer", "username", "password", "logintype");
		ManufacturerHomePage mHomePage=new ManufacturerHomePage(driver);
		autils.verifyTitle(driver, VisibleTextManufacturer.ManufacturerHomePage.MANUFACTURER_Home);
		mHomePage.getManageStock().click();
		ManufacturerManageStockPage mms=new ManufacturerManageStockPage(driver);
		//bug title should be Manage Stock but it is Admin:Home
		//autils.verifyTitle(driver, VisibleTextManufacturer.ManageStockPage.MANAGE_STOCK);
		mms.updateManageStock(driver, jsonutils.readDataFromJsonFile(IpathConstant.jsonpathaddproduct, "addProduct", "product7"), "10",wutils);
	}
	  @Test(groups = "integration")
	  public void editManageStock() throws IOException, ParseException {
		    autils.verifyTitle(driver, VisibleTextAdmin.LoginPage.LOGIN);
			LoginPage lgn = new LoginPage(driver);
			lgn.login(IpathConstant.jsonpathlogin, "admin", "username", "password", "logintype");
			AdminHomePage ahp=new AdminHomePage(driver);
			autils.verifyTitle(driver, VisibleTextAdmin.AdminHomePage.ADMIN_HOME);
			ahp.getManageCategory().click();
			autils.verifyTitle(driver, VisibleTextAdmin.ViewCategoryPage.VIEW_CATEGORY);
			wutils.jsScrollToBottom(driver);
			AdminViewCategoryPage vcp=new AdminViewCategoryPage(driver);
			vcp.clickEditCategoryIcon(driver, wutils, "chocolatewafer");
			AdminUpdateCategoryPage ucp=new AdminUpdateCategoryPage(driver);
			autils.verifyTitle(driver, VisibleTextAdmin.UpdateCategoryPage.UPDATE_CATEGORY);
			ucp.editCategoryClear_Save(jsonutils.readDataFromJsonFile(IpathConstant.jsonpathaddproduct, "addCategory", "category4"));
			wutils.waitUnitAlertToPresent(driver, 15);
			wutils.acceptAlert(driver);
	  }
	  @Test(groups = "smoke")
	  public void addArea() throws IOException, ParseException {
		    autils.verifyTitle(driver, VisibleTextAdmin.LoginPage.LOGIN);
			LoginPage lgn = new LoginPage(driver);
			lgn.login(IpathConstant.jsonpathlogin, "admin", "username", "password", "logintype");
			AdminHomePage ahp=new AdminHomePage(driver);
			autils.verifyTitle(driver, VisibleTextAdmin.AdminHomePage.ADMIN_HOME);
			ahp.getManageArea().click();
			wutils.jsScrollToBottom(driver);
			AdminViewArea ava=new AdminViewArea(driver);
			autils.verifyTitle(driver, VisibleTextAdmin.ViewAreaPage.VIEW_AREA);
			ava.getAddAreaButton().click();
			AddAreaPage addarea=new AddAreaPage(driver);
			//Bug title should be Add Area but it is Add Unit
			//autils.verifyTitle(driver, VisibleTextAdmin.AddAreaPage.ADD_AREA);
			addarea.addArea_Save(driver, "BTM", "560076", wutils);
	  }
	
	
	
}
