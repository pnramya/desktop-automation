package script;

import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Lib;
import generic.WebBase;
import pom.GenerateBarcodePage;

public class GenerateBarcode extends WebBase {
	@Test(priority = 1, description = "Validation of search and refresh button.")
	public void validateSearchAndRefreshBtn() {
		try {
			GenerateBarcodePage barcode = new GenerateBarcodePage(driver);
			SoftAssert soft = new SoftAssert();
			barcode.stockOptionClick();
			soft.assertTrue(barcode.searchBtnIsDisplayed(), "Search button is not displayed.");
			soft.assertTrue(barcode.refreshBtnIsDisplayed(), "Refresh button is not displayed.");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 2, description = "Validation of search product text field")
	public void validateSearchProductTextField() {
		try {
			GenerateBarcodePage barcode = new GenerateBarcodePage(driver);
			SoftAssert soft = new SoftAssert();
			soft.assertTrue(barcode.getSearchProductTextField().isDisplayed(),
					"Search product text field is not displayed.");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 3, description = "Empty search error message validation.")
	public void emptySearchErrorValidation() {
		try {
			GenerateBarcodePage barcode = new GenerateBarcodePage(driver);
			SoftAssert soft = new SoftAssert();
			barcode.searchBtnClick();
			Thread.sleep(2000);
			soft.assertEquals(barcode.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "SearchEmptyError"),
					"Wrong error message.");
			soft.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 4, description = "Validation of enability of category, sub category, brand, product drop down before filling search product text field.")
	public void dropDownEnabilityValidation() {
		try {
			GenerateBarcodePage barcode = new GenerateBarcodePage(driver);
			SoftAssert soft = new SoftAssert();
			soft.assertTrue(barcode.getCategoryDropDown().isEnabled(), "Category drop down is disabled.");
			soft.assertTrue(barcode.getSubCategoryDropDown().isEnabled(), "Subcategory drop down is disabled.");
			soft.assertTrue(barcode.getBrandDropDown().isEnabled(), "Brand drop down is disabled.");
			soft.assertTrue(barcode.getProductDropDown().isEnabled(), "Product drop down is disabled.");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 5, description = "Validation of seraching through category dropdown.")
	public void searchByCategoryDropDown() {
		try {
			GenerateBarcodePage barcode = new GenerateBarcodePage(driver);
			SoftAssert soft = new SoftAssert();
			Thread.sleep(3000);
			Lib.SelectDropDownOptionByVisibleName(driver, barcode.getCategoryDropDown(),
					Lib.getProperty(INVENTORY_PATH, "Category"));
			barcode.searchBtnClick();
			soft.assertTrue(barcode.pannelIsDisplayed(), "Search by category dropdown is failed.");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 6, description = "Generation of barcode validation")
	public void barcodeGenerationValidation() {
		try {
			GenerateBarcodePage barcode = new GenerateBarcodePage(driver);
			SoftAssert soft = new SoftAssert();
			int count = 1;
			for (WebElement singleBarCode : barcode.getBarcodeList()) {
				if (count <= barcode.getBarcodeList().size() && driver
						.findElementByXPath("//Custom/DataGrid/Custom[1]/DataItem[" + count + "]" + "/Custom[7]/Text")
						.getAttribute("Name").equals(Lib.getProperty(WRITE_PATH, "LotNo"))) {
					driver.findElementByXPath(
							"//Custom/DataGrid/Custom[1]/DataItem[" + count + "]" + "/Custom[13]/Button").click();
					break;
				} else {
					count++;
				}
			}
			Thread.sleep(2000);
			Lib.writeProperties("Barcode", barcode.getBarcode());
			soft.assertAll();
			barcode.popUpCloseBtnClick();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}
}
