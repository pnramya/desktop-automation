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
import pom.StorePersionRegressionEPToPRPage;
import pom.StorePersionRegressionPage;

public class StorePersionRegressionEPToPR extends WebBase {
	// EP stands for Expiry Product and PR stands for Purchase Return
	private static String headerItemMissing = "Header item is missing in list";

	@Test(priority = 1, description = "Validation of expired product page")
	public void expiredProductPage() {
		try {
			StorePersionRegressionEPToPRPage expirProducts = new StorePersionRegressionEPToPRPage(driver);
			expirProducts.clickExpiryProductsTab();

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(expirProducts.isExpiredProductTabDisplayed(), "Expiry Product tab is not displayed");
			softAssert.assertTrue(expirProducts.isCurrentMonthExpiryProductTabDisplayed(),
					"Current month expiry product is not displayed");
			softAssert.assertTrue(expirProducts.isNextMonthExpiryProductTabDisplayed(),
					"Next month expiry product is not displayed");
			softAssert.assertTrue(expirProducts.isNext3MonthExpiryProductTabDisplayed(),
					"Next 3 months expiry product tab is not displayed");
			softAssert.assertTrue(expirProducts.isNext6MonthExpiryProductTabDisplayed(),
					"Next 6 months expiry product tab is not displayed");
			softAssert.assertTrue(expirProducts.isExpiryProductRefreshButtonDisplayed(),
					"Expiry Product refresh button is not displayed");
			softAssert.assertTrue(expirProducts.isExpiryProductDownloadButtonDisplayed(),
					"Expiry Product download button is not displayed");

			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true); // This logs the exception message
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 2, description = "Validation of expried product sheet HeaderItem")
	public void testExpriedProductHeaderItem() {
		try {

			List<WebElement> headerItems = driver
					.findElements(By.xpath("//Custom[2]/Custom/Tab/TabItem[1]/Custom/DataGrid/Header/HeaderItem"));
			List<String> getList = new ArrayList<>();
			for (WebElement element : headerItems) {
				getList.add(element.getAttribute("Name").trim());
			}
			List<String> list = Arrays.asList("Category", "Sub Category", "Brand", "Product Name", "SKU", "Qty",
					"Expiry Date", "Days");

			assertEquals(getList, list, headerItemMissing);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true); // This logs the exception message
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	// Indent
	@Test(priority = 3, description = "Validation of indent plan tab")
	public void indentPlanTab() {
		try {
			StorePersionRegressionEPToPRPage indent = new StorePersionRegressionEPToPRPage(driver);

			indent.clickIndentTab();

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(indent.isIndentPlanTabDisplayed());
			softAssert.assertTrue(indent.isViewIndentTabDisplayed());
			softAssert.assertTrue(indent.isIndentPONumberDisplayed());
			softAssert.assertTrue(indent.isIndentPlanDateDisplayed());
			softAssert.assertTrue(indent.isIndentPlanReatilOrderRadioButtonDisplayed());
			softAssert.assertTrue(indent.isIndentPlanWholesaleOrderRadioButtonDisplayed());
			softAssert.assertTrue(indent.isIndentPlanCreateButtonDisplayed());
			softAssert.assertTrue(indent.isIndentPlanAddProductButtonDisplayed());
			softAssert.assertTrue(indent.isIndentPlanRefreshButtonDisplayed());
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 4, description = "Validation of add products fields")
	public void testAddProductsFields() {
		try {
			StorePersionRegressionEPToPRPage indent = new StorePersionRegressionEPToPRPage(driver);

			indent.clickAddProductButton();

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(indent.isIndentPlanSearchProductFieldDisplayed());
			softAssert.assertTrue(indent.isIndentPlanSearchBrandDisplayed());
			softAssert.assertTrue(indent.isIndentPlanSubCategoryDisplayed());
			softAssert.assertTrue(indent.isIndentPlanSearchSubUnitDisplayed());
			softAssert.assertTrue(indent.isIndentPlanQuantityDisplayed());
			softAssert.assertTrue(indent.isIndentPlanRemoveProductButtonDisplayed());
			softAssert.assertTrue(indent.isAddNewProductButtonDisplayed());
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 5, description = "Validation of view indent tab")
	public void testViewIndentTab() {
		try {
			StorePersionRegressionEPToPRPage indent = new StorePersionRegressionEPToPRPage(driver);
			indent.clickViewIndentTab();
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(indent.isViewIndentSearchButtonDisplayed());
			softAssert.assertTrue(indent.isViewIndentRefreshButtonDisplayed());

			indent.clickViewIndentSearchButton();
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 6, description = "Validation of view indent search flyout")
	public void testIndentSearchFlyout() {
		try {
			StorePersionRegressionEPToPRPage indent = new StorePersionRegressionEPToPRPage(driver);
			indent.clickViewIndentSearchButton();

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(indent.isIndentStoreDropdownDisplayed());
			softAssert.assertTrue(indent.isIndentSelectStatusDropdownDisplayed());
			softAssert.assertTrue(indent.isIndentStartingDateDisplayed());
			softAssert.assertTrue(indent.isIndentEndingDateDisplayed());
			softAssert.assertTrue(indent.isFullPaymentModeDisplayed());
			softAssert.assertTrue(indent.isPartialPaymentModeDisplayed());
			softAssert.assertTrue(indent.isIndentStoreRefreshButtonDisplayed());
			softAssert.assertTrue(indent.isFlyoutSearchButtonDisplayed());
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 7, description = "Validation of view indent search flyout dropdown functionality")
	public void testSearchFlyoutDropdownFunctionality() {
		try {
			StorePersionRegressionEPToPRPage indent = new StorePersionRegressionEPToPRPage(driver);
			StorePersionRegressionPage storePerson = new StorePersionRegressionPage(driver);
			indent.clickIndentStoreDropdown();

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());

			indent.clickIndentStoreDropdown();
			indent.clickIndentSelectStatusDropdown();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());

			Lib.scrollDown(storePerson.pageDown());

			indent.clickIndentSelectStatusDropdown();
			indent.clickIndentStartingDate();
			indent.clickIndentEndingDate();
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 8, description = "Validation of view indent headerItem")
	public void testViewIndentHeaderItem() {
		try {
			StorePersionRegressionEPToPRPage indent = new StorePersionRegressionEPToPRPage(driver);
			indent.sendIndentStoreDropDown(Lib.getProperty(INDENT_PATH, "StoreName"));
			indent.sendIndentStatusDropDown(Lib.getProperty(INDENT_PATH, "IndentPlanned"));
			indent.clickFlyoutSearchButton();

			List<WebElement> headerItem = driver
					.findElements(By.xpath("//Custom[2]/Custom/Tab/TabItem[2]/Custom/DataGrid/Header/HeaderItem"));
			List<String> getList = new ArrayList<>();

			for (WebElement i : headerItem) {
				getList.add(i.getAttribute("Name"));
			}

			List<String> viewIndentList = Arrays.asList("PO NO.", "PO Date", "Store", "Status", "Supplier", "Remark",
					"Payment Mode", "Details");

			assertEquals(getList, viewIndentList, "Header item is missing in the list");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	// Sku Tab
	@Test(priority = 9, description = "Validation of sku tab")
	public void testSkuTab() {
		try {
			StorePersionRegressionEPToPRPage sku = new StorePersionRegressionEPToPRPage(driver);

			sku.clickSKUTab();
			sku.clickSkuCertificateTab();

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(sku.isSkuCategoryDropDownDisplayed());
			softAssert.assertTrue(sku.isSkuSubCategoryDropDownDisplayed());
			softAssert.assertTrue(sku.isSkuSearchBrandDropDownDisplayed());
			softAssert.assertTrue(sku.isSkuSearchButtonDisplayed());
			softAssert.assertTrue(sku.isSkuRefreshButtonDisplayed());
			softAssert.assertTrue(sku.isExpiredTabDisplayed());
			softAssert.assertTrue(sku.isNoCertificateTabDisplayed());
			softAssert.assertTrue(sku.isValidCertificateTabDisplayed());

			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 10, description = "Validation of sku fields functionality")
	public void testSkuFieldsFunctionality() {
		try {
			StorePersionRegressionEPToPRPage sku = new StorePersionRegressionEPToPRPage(driver);
			StorePersionRegressionPage storePerson = new StorePersionRegressionPage(driver);
			Thread.sleep(1000);
			sku.clickSkuCategoryDropDown();
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());

			Lib.scrollDown(storePerson.pageDown());

			sku.clickSkuCategoryDropDown();
			sku.clickSkuSubCategoryDropDown();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());
			sku.clickSkuSubCategoryDropDown();

			sku.clickSkuSearchBrandDropDown();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());
			sku.clickSkuSearchBrandDropDown();

			sku.clickExpiredTab();
			sku.clickNoCertificateTab();
			sku.clickValidCertificateTab();

			softAssert.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

//our store tab
	@Test(priority = 10, description = "Validation of our store tab")
	public void ourStoreTabValidation() {
		try {
			StorePersionRegressionEPToPRPage ourStore = new StorePersionRegressionEPToPRPage(driver);
			ourStore.clickOurStore();
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(ourStore.isOurStoreStateDropDownDisplayed());
			softAssert.assertTrue(ourStore.isOurStoreDistrictDropDownDisplayed());
			softAssert.assertTrue(ourStore.isOurStoreSearchButtonDisplayed());
			softAssert.assertTrue(ourStore.isOurStoreRefreshButtonDisplayed());
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 11, description = "Validation of our store scroll functionality")
	public void ourStoreScrollFunctionality() {
		try {
			StorePersionRegressionPage storePerson = new StorePersionRegressionPage(driver);
			Lib.scrollDown(storePerson.pageDown());
			Lib.scrollDown(storePerson.pageDown());
			Lib.scrollDown(storePerson.pageUp());
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 12, description = "Validation our store state and district dropdown functionality")
	public void stateAndDistrictDropdownFunctionality() {
		try {
			StorePersionRegressionEPToPRPage indent = new StorePersionRegressionEPToPRPage(driver);
			StorePersionRegressionPage storePerson = new StorePersionRegressionPage(driver);
			SoftAssert softAssert = new SoftAssert();
			indent.clickOurStoreStateDropDown();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());
			Lib.scrollDown(storePerson.pageDown());
			indent.clickOurStoreStateDropDown();
			indent.sendOurStoreStateDropDown(Lib.getProperty(Regression_PATH, "State"));
			indent.clickOurStoreDistrictDropDown();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());
			Lib.scrollDown(storePerson.pageDown());
			Actions act = new Actions(driver);
			act.sendKeys(Keys.PAGE_DOWN).perform();
			act.sendKeys(Keys.ENTER).perform();
			indent.clickOurStoreSearchButton();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 13, description = "Validation of purchase return tab")
	public void testPurchaseReturnTab() {
		try {
			StorePersionRegressionEPToPRPage purchaseReturn = new StorePersionRegressionEPToPRPage(driver);
			purchaseReturn.clickPurchaseReturnTab();

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(purchaseReturn.isPurchaseReturnSupplierNamesDisplayed());
			softAssert.assertTrue(purchaseReturn.isPurchaseReturnProductSKUDisplayed());
			softAssert.assertTrue(purchaseReturn.isPurchaseReturnLotNumberDisplayed());
			softAssert.assertTrue(purchaseReturn.isPurchaseReturnSearchButtonDisplayed());
			softAssert.assertTrue(purchaseReturn.isPurchaseReturnAmountFieldDisplayed());
			softAssert.assertTrue(purchaseReturn.isPurchaseReturnCreateRequestButtonDisplayed());
			softAssert.assertTrue(purchaseReturn.isPurchaseReturnViewRequestButtonDisplayed());
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 14, description = "Validation of purchase return table headerItem")
	public void testPurchaseReturnHeaderItem() {
		try {
			List<WebElement> headerItem = driver.findElements(By.xpath("//Custom[2]/Custom/Custom[1]/Text"));
			List<String> getList = new ArrayList<>();

			for (int index = 3; index < headerItem.size(); index++) {
				WebElement item = headerItem.get(index);
				getList.add(item.getAttribute("Name"));
			}

			List<String> purchaseReturnList = Arrays.asList("SKU", "Product Name", "Brand", "Invoice No", "Lot Number",
					"Rate", "GST(%)", "Selling Price", "Stock", "Return Qty", "Return Total");
			assertEquals(getList, purchaseReturnList, headerItemMissing);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 15, description = "Validation of purchase return view request page")
	public void testpurchaseReturnViewRequestTab() {
		try {
			StorePersionRegressionEPToPRPage purchaseReturn = new StorePersionRegressionEPToPRPage(driver);
			purchaseReturn.clickViewRequestButton();

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(purchaseReturn.isViewRequestSupplierNameDisplayed());
			softAssert.assertTrue(purchaseReturn.isViewReturnStatusDisplayed());
			softAssert.assertTrue(purchaseReturn.isViewRequestRefreshButtonDisplayed());
			softAssert.assertTrue(purchaseReturn.isViewRequestBackButtonDisplayed());
			softAssert.assertTrue(purchaseReturn.isViewRequestSearchButtonDisplayed());
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 16, description = "Validation of view purchase return dropdown functionality")
	public void testPurchaseReturnDropdownFunctionality() {
		try {
			StorePersionRegressionEPToPRPage purchaseReturn = new StorePersionRegressionEPToPRPage(driver);
			StorePersionRegressionPage storePerson = new StorePersionRegressionPage(driver);
			purchaseReturn.clickViewRequestSupplierName();
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());
			Lib.scrollDown(storePerson.pageDown());
			purchaseReturn.clickViewRequestSupplierName();

			purchaseReturn.clickViewReturnStatus();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());
			purchaseReturn.clickViewReturnStatus();

			purchaseReturn.clickViewRequestBackButton();

			purchaseReturn.clickPurchaseReturnSupplierNamesDropdown();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());
			Lib.scrollDown(storePerson.pageDown());
			purchaseReturn.clickPurchaseReturnSupplierNamesDropdown();

			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 17, description = "Validation of purchase return view request page")
	public void testViewRequestTab() {
		try {
			StorePersionRegressionEPToPRPage purchaseReturn = new StorePersionRegressionEPToPRPage(driver);
			purchaseReturn.clickViewRequestButton();
			List<WebElement> headerItem = driver.findElements(By.xpath("//Custom[2]/DataGrid/Header/HeaderItem"));
			List<String> getList = new ArrayList<>();

			for (int index = 0; index < headerItem.size(); index++) {
				WebElement item = headerItem.get(index);
				getList.add(item.getAttribute("Name"));
			}

			List<String> expectedList = Arrays.asList("Supplier", "Total", "C/N Number", "C/N Date", "Created Date",
					"Remarks");
			assertEquals(getList, expectedList, headerItemMissing);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 19, description = "Validation of EOD cash declaration tab")
	public void testEodTab() {
		try {
			StorePersionRegressionEPToPRPage eod = new StorePersionRegressionEPToPRPage(driver);
			eod.clickEODCashDeclarationTab();
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(eod.isEODRefreshButtonDisplayed());
			softAssert.assertTrue(eod.isEODViewButtonDisplayed());
			softAssert.assertTrue(eod.isEODOpeningCashBalanceFieldDisplayed());
			softAssert.assertTrue(eod.isEODTotalSalesForTheDayFieldDisplayed());
			softAssert.assertTrue(eod.isEODCashSalesFieldDisplayed());
			softAssert.assertTrue(eod.isEODUpiSalesFieldDisplayed());
			softAssert.assertTrue(eod.isEODCreditSalesFieldDisplayed());
			softAssert.assertTrue(eod.isEODAvailableCashBalanceFieldDisplayed());
			softAssert.assertTrue(eod.isEODBankDepositFieldDisplayed());
			softAssert.assertTrue(eod.isEODClosingCashBalanceFieldDisplayed());
			softAssert.assertTrue(eod.isEODAddDepositButtonDisplayed());
			softAssert.assertTrue(eod.isEODAddDenominationButtonDisplayed());
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 20, description = "Validation of add Deposit popup")
	public void testAddDepositPopUp() {
		try {
			StorePersionRegressionEPToPRPage eod = new StorePersionRegressionEPToPRPage(driver);
			eod.clickEODAddDepositButton();

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(eod.isAddDepositDateFieldDisplayed());
			softAssert.assertTrue(eod.isAddDepositAmountFieldDisplayed());
			softAssert.assertTrue(eod.isAddDepositSelectBankDropdownDisplayed());
			softAssert.assertTrue(eod.isAddDepositAccountNoFieldDisplayed());
			softAssert.assertTrue(eod.isAddDepositIFSCCodeFieldDisplayed());
			softAssert.assertTrue(eod.isAddDepositBranchFieldDisplayed());
			softAssert.assertTrue(eod.isAddDepositAddAttachmentFieldDisplayed());
			softAssert.assertTrue(eod.isAddDepositButtonDisplayed());
			softAssert.assertTrue(eod.isAddDepositRefreshRefreshButonDisplayed());
			softAssert.assertTrue(eod.isCloseAddDepositButtonDisplayed());
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 21, description = "Validation of select bank dropdown functionality")
	public void testSelectBankDropdown() {
		try {
			StorePersionRegressionEPToPRPage eod = new StorePersionRegressionEPToPRPage(driver);
			StorePersionRegressionPage storePerson = new StorePersionRegressionPage(driver);
			eod.clickAddDepositSelectBankDropdown();
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(storePerson.isDropdownPopupElementsDisplayed());

			List<WebElement> dropDownList = driver.findElements(By.xpath("//Window/Custom/ComboBox/ListItem/Text"));
			List<String> getList = new ArrayList<>();

			for (WebElement item : dropDownList) {
				getList.add(item.getAttribute("Name"));
			}
			List<String> expectedAddDepositBankList = Arrays.asList("State Bank of India", "ICICI Bank Ltd");
			softAssert.assertEquals(getList, expectedAddDepositBankList, "Bank item is missing in list");
			eod.clickAddDepositSelectBankDropdown();
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 22, description = "Validation of state bank details on deposit popup")
	public void testStateBankDetails() {
		try {
			StorePersionRegressionEPToPRPage eod = new StorePersionRegressionEPToPRPage(driver);
			eod.sendBankName(Lib.getProperty(Regression_PATH, "StateBank"));
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(Lib.getProperty(Regression_PATH, "SbiAccountNo"), eod.getDepositAccountNo());
			softAssert.assertEquals(Lib.getProperty(Regression_PATH, "SbiIFSCCode"), eod.getDepositIFSCCode());
			softAssert.assertEquals(Lib.getProperty(Regression_PATH, "SbiBranchName"), eod.getDepositBranchName());
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 23, description = "Validation of ICICI bank details on add deposit popup")
	public void testICICIBankDetails() {
		try {
			StorePersionRegressionEPToPRPage eod = new StorePersionRegressionEPToPRPage(driver);
			eod.sendBankName(Lib.getProperty(Regression_PATH, "ICICIBank"));
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(Lib.getProperty(Regression_PATH, "ICICIAccountNo"), eod.getDepositAccountNo());
			softAssert.assertEquals(Lib.getProperty(Regression_PATH, "ICICIIFSCCode"), eod.getDepositIFSCCode());
			softAssert.assertEquals(Lib.getProperty(Regression_PATH, "ICICIBranchName"), eod.getDepositBranchName());
			eod.clickCloseAddDepositButton();
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 24, description = "Validation of view denomination page")
	public void testViewDenomination() {
		try {
			StorePersionRegressionEPToPRPage eod = new StorePersionRegressionEPToPRPage(driver);
			eod.clickEODViewButton();

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(eod.isViewDenominationStartingDateDisplayed());
			softAssert.assertTrue(eod.isViewDenominationEndingDateDisplayed());
			softAssert.assertTrue(eod.isViewDenominationSearchButtonDisplayed());
			softAssert.assertTrue(eod.isViewDenominationRefreshIdDisplayed());
			softAssert.assertTrue(eod.isViewDenominationDownloadDisplayed());
			softAssert.assertTrue(eod.isViewDenominationBackButtonDisplayed());
			softAssert.assertTrue(eod.isDenominationRedioButtonDisplayed());
			softAssert.assertTrue(eod.isDepositRedioButtonDisplayed());

			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 25, description = "Validation of view denomination headerItem")
	public void testViewDenominationHeaderItem() {
		try {
			StorePersionRegressionEPToPRPage eod = new StorePersionRegressionEPToPRPage(driver);
			DateAndTime date = new DateAndTime();
			eod.sendViewDenominationStartingDate(Lib.getProperty(Regression_PATH, "startDate"));
			eod.sendViewDenominationEndingDate(date.currentdate());
			eod.clickViewDenominationSearchButton();

			List<WebElement> headerItem = driver
					.findElements(By.xpath("//Custom[2]/Custom/Custom[1]/Custom[1]/DataGrid/Header/HeaderItem"));
			List<String> getList = new ArrayList<>();

			for (WebElement i : headerItem) {
				getList.add(i.getAttribute("Name"));
			}

			List<String> expectedDenominationHeaderItem = Arrays.asList("OnDate", "Opening Cash", "Cash Sale",
					"Cash Return", "UPI Sale", "Total Sales", "Bank Deposit", "Closing Cash");

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(getList, expectedDenominationHeaderItem, headerItemMissing);

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
