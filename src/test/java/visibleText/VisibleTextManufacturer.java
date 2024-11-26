package visibleText;

public interface VisibleTextManufacturer {
	interface LoginPage {
		String LOGIN = "Login";
	}
	interface ManufacturerHomePage{
		String MANUFACTURER_Home ="Manufacturer: Home"; 
	}
    interface EditProfilePage{
  	   String EDIT_PROFILE="Edit Profile";
     }
     interface AddProductPage{
  	   String ADD_PRODUCT="Add Product";
     }
     interface ManageStockPage{
  	   String MANAGE_STOCK="Manage Stock";
     }
     interface ViewUnitsPage{
  	   String VIEW_UNITS="View Units";
     }
     interface ViewCategoryPage{
  	   String VIEW_CATEGORY="View Category";
     }
     interface AddCategoryPage{
    	 String ADD_CATEGORY="Add Category";
     }
}
