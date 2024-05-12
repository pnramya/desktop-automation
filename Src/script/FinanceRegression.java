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
import pom.FinanceRegressionPage;
import pom.StorePersionRegressionPage;

public class FinanceRegression extends WebBase {
	private static String headerItemMissing = "Header item is missing in list";
	private static String storeName = "StoreName";

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
	public void suggiGatCalculatorNotification() {
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
			softAssert.assertEquals(Lib.getProperty(Regression_PATH, "FinanceLoginName"), storePersonrole.getRoleName(),
					"Name is incorrect");
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
			List<String> expectedMenuList = Arrays.asList("Sales", "Purchase and Returns", "Stock", "Stock Transfer",
					"Customer", "Sales Report", "Closing Stock", "Weekly Stock Report", "Master SKU Sheet",
					"Expiry Products", "EOD (Cash Declaration)", "Indent", "Suppliers", "Assets");
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

	@Test(priority = 6, description = "Validation of sales mis tab")
	public void testMisTab() {
		try {
			FinanceRegressionPage financeRole = new FinanceRegressionPage(driver);
			financeRole.salesTabClick();
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(financeRole.isMisTabDisplayed());
			softAssert.assertTrue(financeRole.isCreditSalesTabDisplayed());
			softAssert.assertTrue(financeRole.isFromDateDisplayed());
			softAssert.assertTrue(financeRole.isToDateDisplayed());
			softAssert.assertTrue(financeRole.isStoreNameDropDownDisplayed());
			softAssert.assertTrue(financeRole.isRefreshBtnDisplayed());
			softAssert.assertTrue(financeRole.isSearchBtnDisplayed());
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 7, description = "Validation of mis table all store headerItem")
	public void testMisTableAllStoreHeaderItem() {
		try {
			List<WebElement> headerItem = driver
					.findElements(By.xpath("//Custom[2]/Custom/Tab/TabItem[1]/Custom/Pane/DataGrid/Header/HeaderItem"));
			List<String> getList = new ArrayList<>();

			for (WebElement item : headerItem) {
				getList.add(item.getAttribute("Name"));
			}
			List<String> expectedDenominationHeaderItem = Arrays.asList(storeName, "Date", "DayBusiness", "DayCash",
					"DayCard", "DayUPI", "DayCheque", "DayTotal", "MonthBusiness", "Average");
			assertEquals(getList, expectedDenominationHeaderItem, headerItemMissing);

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 8, description = "Validation of sales mis fields functionality")
	public void testMisFields() {
		try {
			FinanceRegressionPage financeRole = new FinanceRegressionPage(driver);
			StorePersionRegressionPage storePerson = new StorePersionRegressionPage(driver);
			SoftAssert softAssert = new SoftAssert();
			DateAndTime date = new DateAndTime();
			financeRole.clickStoreDropDown();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());
			Lib.scrollDown(storePerson.pageDown());
			financeRole.clickStoreDropDown();
			financeRole.sendStoreDropDown(Lib.getProperty(Regression_PATH, storeName));
			financeRole.sendMisFromDate(Lib.getProperty(Regression_PATH, "startDate"));
			financeRole.sendMisToDate(date.currentdate());
			financeRole.clickSearchBtn();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 9, description = "Validation of mis table individual store headerItem")
	public void testMisTableIndividualStoreHeaderItem() {
		try {
			List<WebElement> headerItem = driver
					.findElements(By.xpath("//Custom[2]/Custom/Tab/TabItem[1]/Custom/Pane/DataGrid/Header/HeaderItem"));
			List<String> getList = new ArrayList<>();

			for (WebElement item : headerItem) {
				getList.add(item.getAttribute("Name"));
			}

			List<String> expectedHeaderItems = Arrays.asList(storeName, "Date", "DayBusiness", "DayCash", "DayCard",
					"DayUPI", "DayCheque", "DayTotal");

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(getList, expectedHeaderItems, headerItemMissing);

			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 10, description = "Validation of credit sales tab")
	public void testCreditSalesTab() {
		try {
			FinanceRegressionPage financeRole = new FinanceRegressionPage(driver);
			financeRole.clickCreditSalesTab();

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(financeRole.isCreditSalesTotalCountsFieldDisplayed());
			softAssert.assertTrue(financeRole.isCreditSalesFromDateFieldDisplayed());
			softAssert.assertTrue(financeRole.isCreditSalesToDateFieldDisplayed());
			softAssert.assertTrue(financeRole.isCreditSalesRefreshButtonDisplayed());
			softAssert.assertTrue(financeRole.isCreditSalesDownloadButtonDisplayed());
			softAssert.assertTrue(financeRole.isCreditSalesSearchButtonDisplayed());
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 11, description = "Validation of credit sales table headerItem")
	public void testCreditSalesTableHeaderItem() {
		try {
			FinanceRegressionPage financeRole = new FinanceRegressionPage(driver);
			List<WebElement> headerItem = driver
					.findElements(By.xpath("//Custom[2]/Custom/Tab/TabItem[2]/Custom/DataGrid/Header/HeaderItem "));
			List<String> getList = new ArrayList<>();

			for (WebElement item : headerItem) {
				getList.add(item.getAttribute("Name"));
			}

			List<String> expectedHeaderItems = Arrays.asList("Invoice Number", "Invoice Date", "Customer Name",
					"Phone number", "Net Payable Amount", "Cheque", "Cheque Number", "Cheque Date", "Realize Date",
					"Remarks", "OrderTakenBy");

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(getList, expectedHeaderItems, headerItemMissing);

			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 12, description = "Validation of purchase returns page")
	public void testPurchaseReturnsTab() {
		try {
			FinanceRegressionPage financeRole = new FinanceRegressionPage(driver);
			financeRole.clickPurchaseReturnsTab();

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(financeRole.isPurchaseInvoiceTabDisplayed());
			softAssert.assertTrue(financeRole.isCreditNoteViewTabDisplayed());
			// softAssert.assertTrue(financeRole.creditNoteSummaryTabIsDisplayed());

			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 13, description = "Validation of purchase invoice tab")
	public void testPurchaseInvoiceTab() {
		try {
			FinanceRegressionPage financeRole = new FinanceRegressionPage(driver);

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(financeRole.isShowOnCheckBoxDisplayed());
			softAssert.assertTrue(financeRole.isPurchaseInvoiceFromDateDisplayed());
			softAssert.assertTrue(financeRole.isPurchaseInvoiceToDateDisplayed());
			softAssert.assertTrue(financeRole.isPurchaseInvoiceStoreDropdownDisplayed());
			softAssert.assertTrue(financeRole.isPurchaseInvoiceRefreshButtonDisplayed());
			softAssert.assertTrue(financeRole.isPurchaseInvoiceSearchButtonDisplayed());

			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 14, description = "Validation of credit note view tab")
	public void testCreditNoteViewTab() {
		try {
			FinanceRegressionPage financeRole = new FinanceRegressionPage(driver);
			financeRole.clickCreditNoteViewTab();

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(financeRole.isCreditNoteSupplierNameDropdownDisplayed());
			softAssert.assertTrue(financeRole.isCreditNoteStoreNameDropdownDisplayed());
			softAssert.assertTrue(financeRole.isCreditNoteReturnStatusDropdownDisplayed());
			softAssert.assertTrue(financeRole.isCreditNoteRefreshButtonDisplayed());
			softAssert.assertTrue(financeRole.isCreditNoteSearchButtonDisplayed());
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 15, description = "Validation of credit note view tab dropdown functionality")
	public void testCreditNoteViewDropdowns() {
		try {
			FinanceRegressionPage financeRole = new FinanceRegressionPage(driver);
			financeRole.clickCreditNoteSupplierNameDropdown();
			SoftAssert softAssert = new SoftAssert();
			StorePersionRegressionPage storePerson = new StorePersionRegressionPage(driver);
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());
			financeRole.clickCreditNoteSupplierNameDropdown();

			financeRole.clickCreditNoteStoreNameDropdown();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());
			financeRole.clickCreditNoteStoreNameDropdown();

			financeRole.clickCreditNoteReturnStatusDropdown();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());
			financeRole.clickCreditNoteReturnStatusDropdown();

			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 16, description = "Validation of credit note summary tab")
	public void testCreditNoteSummaryTab() {
		try {
			FinanceRegressionPage financeRole = new FinanceRegressionPage(driver);
			financeRole.clickCreditNoteSummaryTab();

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(financeRole.isCnSummaryStoreNameDropdownDisplayed());
			softAssert.assertTrue(financeRole.isCnSummarySuppliersDropdownDisplayed());
			softAssert.assertTrue(financeRole.isCnSummaryFromDateDisplayed());
			softAssert.assertTrue(financeRole.isCnSummaryToDateDisplayed());
			softAssert.assertTrue(financeRole.isCnSummaryRefreshButtonDisplayed());
			softAssert.assertTrue(financeRole.isCnSummaryDownloadButtonDisplayed());
			softAssert.assertTrue(financeRole.isCnSummarySearchButtonDisplayed());

			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 17, description = "Validation of credit note summary tab dropdown functionality")
	public void testCreditNoteSummaryDropdowns() {
		try {
			FinanceRegressionPage financeRole = new FinanceRegressionPage(driver);
			StorePersionRegressionPage storePerson = new StorePersionRegressionPage(driver);
			SoftAssert softAssert = new SoftAssert();
			financeRole.clickCnSummaryStoreNameDropdown();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());
			financeRole.clickCnSummaryStoreNameDropdown();

			financeRole.clickCnSummarySuppliersDropdown();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());
			financeRole.clickCnSummarySuppliersDropdown();

			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 18, description = "Validation of purchase return table headerItem")
	public void testPurchaseReturnHeaderItem() {
		try {
			FinanceRegressionPage financeRole = new FinanceRegressionPage(driver);
			DateAndTime date = new DateAndTime();
			financeRole.clickCnSummaryStoreNameDropdown();
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ARROW_DOWN).perform();
			act.sendKeys(Keys.ENTER).perform();

			financeRole.sendCnSummarySuppliersDropdown("All");

			financeRole.sendCnSummaryFromDate(Lib.getProperty(Regression_PATH, "startDate"));
			financeRole.sendCnSummaryToDate(date.currentdate());

			financeRole.clickCnSummarySearchButton();

			List<WebElement> headerItem = driver
					.findElements(By.xpath("//Custom[2]/Custom/Tab/TabItem[4]/Custom/DataGrid/Header/HeaderItem"));
			List<String> getList = new ArrayList<>();

			for (WebElement i : headerItem) {
				getList.add(i.getAttribute("Name"));
			}

			List<String> expectedCnSummaryHeaderItems = Arrays.asList("SupplierName", "TotalAmount", "AdjustedAmount",
					"BalanceAmount");

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(getList, expectedCnSummaryHeaderItems, headerItemMissing);

			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

}
