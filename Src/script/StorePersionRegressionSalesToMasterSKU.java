package script;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.DateAndTime;
import generic.Lib;
import generic.WebBase;
import pom.IndentPlanByStorePersonPage;
import pom.StorePersionRegressionPage;

public class StorePersionRegressionSalesToMasterSKU extends WebBase {
	@Test(priority = 1, description = "Suggi logo and version visibility validation")
	public void suggiLogoAndVersionValidation() {
		try {
			StorePersionRegressionPage storePersonrole = new StorePersionRegressionPage(driver);
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(storePersonrole.falcaImageIsDisplayed(), "Falca logo is not displayed");
			softAssert.assertEquals(storePersonrole.getVersionNumberValidation(),
					Lib.getProperty(Regression_PATH, "Version"), "Version number is incorrect");
			softAssert.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 2, description = "GST calculator and notification button visibility validation")
	public void SuggiGatCalculatorNotification() {
		try {
			StorePersionRegressionPage storePersonrole = new StorePersionRegressionPage(driver);
			SoftAssert softAssert = new SoftAssert();
			// Check if GST calculator is displayed
			softAssert.assertTrue(storePersonrole.gstCalculatorIsDisplayed(), "GST button is not displayed");
			// Check if notification button is displayed
			softAssert.assertTrue(storePersonrole.notificationButtonIsDisplayed(),
					"Notification button is not displayed");
			// click notification button click
			storePersonrole.notificationButtonClick();
			// Perform notification back button click
			storePersonrole.notificationBackButtonClick();
			softAssert.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 3, description = "Login role name validation")
	public void loginRoleNameValidation() {
		try {
			StorePersionRegressionPage storePersonrole = new StorePersionRegressionPage(driver);
			SoftAssert softAssert = new SoftAssert();

			// Check if login name is displayed
			softAssert.assertTrue(storePersonrole.roleNameIsDisplayed(), "Login name is not displayed");

			// Check if the login name matches the expected value
			softAssert.assertEquals(Lib.getProperty(Regression_PATH, "StorepersonLoginName"),
					storePersonrole.getRoleName(), "Name is incorrect");

			softAssert.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 4, description = "Window control buttons validation")
	public void minimizeMaximizeAndCloseButton() {
		try {
			StorePersionRegressionPage storePersonrole = new StorePersionRegressionPage(driver);
			SoftAssert softAssert = new SoftAssert();
			// Check if minimize button is displayed
			softAssert.assertTrue(storePersonrole.minimizeButtonIsDisplayed(), "Minimize button is not displayed");
			// Check if restore button is displayed
			softAssert.assertTrue(storePersonrole.restoreButtonIsDisplayed(), "Restore button is not displayed");
			// Click on restore button
			storePersonrole.restoreButtonClick();
			// Click on maximize/restore button (assuming this button toggles between
			// maximize and restore)
			storePersonrole.maximizeRestoreButtonClick();
			// Check if close button is displayed
			softAssert.assertTrue(storePersonrole.closeButtonIsDisplayed(), "Close button is not displayed");

			softAssert.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 5, description = "Menu list validation")
	public void menuListBox() {
		try {
			StorePersionRegressionPage storePersonrole = new StorePersionRegressionPage(driver);
			SoftAssert softAssert = new SoftAssert();

			List<String> getList = new ArrayList<>();
			for (WebElement element : storePersonrole.getMenuLists()) {
				String isOffscreenValue = element.getAttribute("IsOffscreen");
				if (isOffscreenValue.equalsIgnoreCase("false")) {
					getList.add(element.getAttribute("Name"));
				}
			}
			// Define store menu list
			List<String> expectedMenuList = Arrays.asList("Sales", "Stock", "Customer", "Weekly Stock Report",
					"Master SKU Sheet", "Expiry Products", "EOD (Cash Declaration)", "Indent", "SKU", "Our Store",
					"Purchase Return", "Report");
			// Check if the actual menu list matches the expected menu list
			softAssert.assertEquals(getList, expectedMenuList, "Menu item is missing in the menu list box");
			softAssert.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 6, description = "Validation of sales phone no field")
	public void salesPhoneNoField() {
		try {
			StorePersionRegressionPage storePerson = new StorePersionRegressionPage(driver);
			SoftAssert softAssert = new SoftAssert();
			// Validation of sales phone no field
			softAssert.assertTrue(storePerson.salesPagePhnoFieldIsEnabled());
			// Send customer phone number
			storePerson.sendSalesPhno(Lib.getProperty(Regression_PATH, "CustomerPhoneNo"));
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();
			softAssert.assertTrue(storePerson.customerDetailsIsDisplayed());
			softAssert.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 7, description = "Validation of customerdetails popup fields")
	public void customerDetailsPopUp() {
		try {
			StorePersionRegressionPage storePerson = new StorePersionRegressionPage(driver);
			SoftAssert softAssert = new SoftAssert();
			// Validation of customerdetails popup fields
			softAssert.assertTrue(storePerson.isCustomerDetailsPhnoEnabled());
			softAssert.assertTrue(storePerson.isCustomerNameFieldEnabled());
			softAssert.assertTrue(storePerson.isTypeOfCustomerDropdownEnabled());
			softAssert.assertTrue(storePerson.isPincodeFieldEnabled());
			softAssert.assertTrue(storePerson.isStateDropdownEnabled());
			softAssert.assertTrue(storePerson.isDistrictDropdownEnabled());
			softAssert.assertTrue(storePerson.isGstNumberFieldEnabled());
			softAssert.assertTrue(storePerson.isSaveCustomerDetailsButtonEnabled());
			softAssert.assertTrue(storePerson.isVillageDropdownEnabled());
			softAssert.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 8, description = "Validation of customer phone no on customer details popup")
	public void customerPhoneNo() {
		try {
			StorePersionRegressionPage storePerson = new StorePersionRegressionPage(driver);
			// Validation of customer phone no on customer details popup
			assertEquals(storePerson.getCustomerDetailsPhno(), Lib.getProperty(Regression_PATH, "CustomerPhoneNo"));
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 9, description = "Validation of customerdetails popup dropdown functionality")
	public void customerDetailsPopUpDropdown() {
		try {
			StorePersionRegressionPage storePerson = new StorePersionRegressionPage(driver);
			SoftAssert softAssert = new SoftAssert();
			// Validation of customerdetails popup dropdown functionality
			storePerson.clickTypeOfCustomerDropdown();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());
			storePerson.clickTypeOfCustomerDropdown();
			storePerson.clickStateDropdown();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());
			// Scroll down if needed
			Lib.scrollDown(storePerson.pageDown());
			storePerson.clickStateDropdown();
			storePerson.clickDistrictDropdown();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());
			storePerson.clickVillageDropdown();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());

			softAssert.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 10, description = "Validation of customerdetails popup close and savecustomerdetails button functionality")
	public void closeAndSaveCustomerDetailsButton() {
		try {
			StorePersionRegressionPage customerDetailsPopUp = new StorePersionRegressionPage(driver);
			SoftAssert softAssert = new SoftAssert();
			IndentPlanByStorePersonPage getError = new IndentPlanByStorePersonPage(driver);
			// Validation of customerdetails popup close and savecustomerdetails button
			// functionality
			customerDetailsPopUp.clickSaveCustomerDetailsButton();
			softAssert.assertEquals(getError.getErrorMessage(), Lib.getProperty(Regression_PATH, "EnterCustomerName"));
			softAssert.assertTrue(customerDetailsPopUp.closeButtonIsDisplayed());
			customerDetailsPopUp.clickCustomerDetailsCloseButton();
			softAssert.assertTrue(customerDetailsPopUp.closeButtonIsDisplayed());
			softAssert.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 11, description = "Validation of sales details on the sales page")
	public void salesDetails() {
		try {
			StorePersionRegressionPage salesPage = new StorePersionRegressionPage(driver);
			SoftAssert softAssert = new SoftAssert();

			// Validation of sales details on the sales page
			softAssert.assertTrue(salesPage.isSalesInvoiceNoDisplayed());
			softAssert.assertTrue(salesPage.isInvoiceDateFieldDisplayed());
			softAssert.assertTrue(salesPage.isNetTotalFieldDisplayed());
			softAssert.assertTrue(salesPage.isTotalGstFieldDisplayed());
			softAssert.assertTrue(salesPage.isTotalDiscountFieldDisplayed());
			softAssert.assertTrue(salesPage.isTotalServiceFieldDisplayed());
			softAssert.assertTrue(salesPage.isCashFieldDisplayed());
			softAssert.assertTrue(salesPage.isUpiFieldDisplayed());
			softAssert.assertTrue(salesPage.isReferenceNoFieldDisplayed());
			softAssert.assertTrue(salesPage.isNetPayTotalFieldDisplayed());
			softAssert.assertTrue(salesPage.isScanProductCodeFieldDisplayed());
			softAssert.assertTrue(salesPage.isProductDetailsFieldDisplayed());
			softAssert.assertTrue(salesPage.salesPageSaveButtonIsEnabled());
			softAssert.assertTrue(salesPage.salesPageResetButtonIsEnabled());
			softAssert.assertTrue(salesPage.isSaleCouponCodeDisplayed());
			softAssert.assertTrue(salesPage.isApplyButtonDisplayed());
			softAssert.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 12, description = "Validation of view sales page")
	public void viewSalesPage() {
		try {
			StorePersionRegressionPage viewSalesPage = new StorePersionRegressionPage(driver);
			SoftAssert softAssert = new SoftAssert();
			// Validation of view sales page
			softAssert.assertTrue(viewSalesPage.isSalesPageViewSalesLinkEnabled());
			viewSalesPage.clickViewSalesLink();
			softAssert.assertTrue(viewSalesPage.isViewSalescustomerNameFieldDisplayed());
			softAssert.assertTrue(viewSalesPage.isViewSalesInvoiceNumberFieldDisplayed());
			softAssert.assertTrue(viewSalesPage.isViewSalesTodateFieldDisplayed());
			softAssert.assertTrue(viewSalesPage.isViewSalesFromDateFieldDisplayed());
			softAssert.assertTrue(viewSalesPage.isViewSalesSearchButtonDisplayed());
			softAssert.assertTrue(viewSalesPage.isViewSalesPageRefreshButtonDisplayed());
			softAssert.assertTrue(viewSalesPage.isViewSalesBackButtonDisplayed());
			viewSalesPage.clickViewSalesBackButton();
			softAssert.assertTrue(viewSalesPage.salesPagePhnoFieldIsEnabled());
			softAssert.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	// stock page
	@Test(priority = 13, description = "Validation of stock page")
	public void stockPage() {
		try {
			StorePersionRegressionPage stockSearch = new StorePersionRegressionPage(driver);
			SoftAssert softAssert = new SoftAssert();

			// Validation of stock page
			stockSearch.clickStockTab();
			softAssert.assertTrue(stockSearch.isProductSearchListDropdownDisplayed());
			softAssert.assertTrue(stockSearch.isStockCategoryTypesDropdownDisplayed());
			softAssert.assertTrue(stockSearch.isStockSearchSubcategoryDropdownDisplayed());
			softAssert.assertTrue(stockSearch.isStockSearchBrandsDropdownDisplayed());
			softAssert.assertTrue(stockSearch.isStockSearchProductNameDropdownDisplayed());
			softAssert.assertTrue(stockSearch.isSearchButtonDisplayed());
			softAssert.assertTrue(stockSearch.isStockDownloadButtonDisplayed());
			softAssert.assertTrue(stockSearch.isRefreshButtonDisplayed());

			softAssert.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 16, description = "Validation of customer page")
	public void customerTab() {
		try {
			StorePersionRegressionPage stockSearch = new StorePersionRegressionPage(driver);
			SoftAssert softAssert = new SoftAssert();

			// Validation of customer page
			stockSearch.clickCustomerTab();
			softAssert.assertTrue(stockSearch.isSearchCustomerDisplayed());
			softAssert.assertTrue(stockSearch.isCustomerStartDateDisplayed());
			softAssert.assertTrue(stockSearch.isCustomerEndDateDisplayed());
			softAssert.assertTrue(stockSearch.isCustomerSearchButtonDisplayed());
			softAssert.assertTrue(stockSearch.isCustomerRefreshDisplayed());
			softAssert.assertTrue(stockSearch.isCustomerTotalInvoiceFieldDisplayed());
			softAssert.assertTrue(stockSearch.isTotalInvoicesTextDisplayed());

			softAssert.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 17, description = "Validation of customer tab sales invoice table header item")
	public void customerTabHeaderItem() {
		try {
			StorePersionRegressionPage stockSearch = new StorePersionRegressionPage(driver);
			SoftAssert softAssert = new SoftAssert();
			// Input customer details and search
			stockSearch.sendCustomerName(Lib.getProperty(Regression_PATH, "customerTabPhno"));
			stockSearch.sendCustomerStartDate(Lib.getProperty(Regression_PATH, "startDate"));
			DateAndTime date = new DateAndTime();
			stockSearch.sendCustomerEndDate(date.currentdate());
			stockSearch.clickCustomerSearchButton();
			// Get the header items from the table
			List<WebElement> headerItem = driver
					.findElements(By.xpath("//Custom[2]/Custom/DataGrid/Header/HeaderItem"));
			List<String> getList = new ArrayList<>();
			for (WebElement i : headerItem) {
				getList.add(i.getAttribute("Name"));
			}
			List<String> list = Arrays.asList("Customer Name", "Phone No.", "Invoice No.", "Invoice Date", "Category",
					"Sub Category", "Brand", "Product Name");
			// Validate header items
			softAssert.assertEquals(getList, list, "Header item is missing in list");

			softAssert.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 18, description = "Validation of weekly stock report page")
	public void testWeeklyStockReportPage() {
		try {
			StorePersionRegressionPage weeklyStockReport = new StorePersionRegressionPage(driver);
			weeklyStockReport.clickWeeklyStockReportTab();
			// SoftAssert can be used here without importing explicitly
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(weeklyStockReport.isWeeklyStockReportRefreshButtonDisplayed(),
					"Weekly stock report refresh button is not displayed");
			softAssert.assertTrue(weeklyStockReport.isWeeklyStockReportProductCountDisplayed(),
					"Weekly stock report product count is not displayed");
			softAssert.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 19, description = "Validation of master sku sheet page")
	public void MasterSKUSheetPage() {
		try {
			SoftAssert softAssert = new SoftAssert(); // Initialize SoftAssert
			StorePersionRegressionPage masterSkuSheet = new StorePersionRegressionPage(driver);
			masterSkuSheet.clickMasterSkuTab();
			softAssert.assertTrue(masterSkuSheet.isMasterSKURefreshButtonDisplayed());
			softAssert.assertTrue(masterSkuSheet.isMasterSKUDownloadButtonDisplayed());
			softAssert.assertTrue(masterSkuSheet.isMasterSKUTotalProductCountDisplayed());
			softAssert.assertTrue(masterSkuSheet.isTotalProductsTextDisplayed());
			softAssert.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 20, description = "Validation of master sku sheet header item")
	public void validateMasterSkuSheetHeaderItem() {
		try {
			SoftAssert softAssert = new SoftAssert();
			List<WebElement> headerItems = driver
					.findElements(By.xpath("//Custom[2]/Custom/DataGrid/Header/HeaderItem"));
			List<String> getList = new ArrayList<>();
			for (WebElement i : headerItems) {
				getList.add(i.getAttribute("Name").trim());
			}
			List<String> list = Arrays.asList("SKU", "Brand", "Product Name", "Technical Name", "Packing Size",
					"Own/Trade", "Category", "Sub Category");
			softAssert.assertEquals(getList, list, "Header item is missing in the list");
			softAssert.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}
}
