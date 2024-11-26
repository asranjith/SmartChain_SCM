package visibleText;

public interface VisibleTextAdmin {
	interface LoginPage {
		String LOGIN = "Login";
	}

	interface AdminHomePage {
		String ADMIN_HOME = "Admin: Home";
		String WELCOME_ADMIN = "Welcome Admin";
		String RECENTALY_ADDED_RETAILERS = "Recently Added Retialers";
		String RECENTALY_ADDED_MANUFACTURERES = "Recently Added Manufacturers";
		String RECENTALY_ADDED_PRODUCTS = "Recently Added Products";
	}

	interface AddRetailerPage {
		String ADD_RETAILER = "Add Retailer";
	}

	interface AddManufacturerPage {
		String ADD_MANUFACTURER = "Add Manufacturer";
	}

	interface AddDistributorPage {
		String ADD_DISTRIBUTOR = "Add Distributor";
	}

	interface ViewUnitsPage {
		String VIEW_UNITS = "View Units";
	}

	interface ViewCategoryPage {
		String VIEW_CATEGORY = "View Category";
	}
	interface UpdateCategoryPage{
		String UPDATE_CATEGORY = "Update Category";
	}
	interface AddCategoryPage{
		String ADD_CATEGORY ="Add Category";
	}
	interface AddProductPage{
		String ADD_PRODUCT = "Add Product";
	}

	interface ViewAreaPage {
		String VIEW_AREA = "View Area";
	}
	interface AddAreaPage{
		String ADD_AREA="Add Area";
	}

	interface ViewProfile {
		String EDIT_PROFILE = "Edit Profile";
	}
	interface LogOutPage{
		String LOGOUT = "Log Out Successful";
	}
}
