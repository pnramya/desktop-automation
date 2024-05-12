package script;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Lib;
import generic.WebBase;
import pom.UpdateSellingPricePage;

public class UpdateSellingPrice extends WebBase {
	private static String wrongMessage = "Wrong error message";
	
	@Test(priority = 1, description = "Update and refresh button validation in update selling price.")
	public void refreshAndUpdateBtnValidation() {
		try {
			UpdateSellingPricePage updateSellingPrice = new UpdateSellingPricePage(driver);
			SoftAssert soft = new SoftAssert();
			updateSellingPrice.updateSellingPriceOptionClick();
			soft.assertTrue(updateSellingPrice.updateButtonIsDisplayed(), "Update button is not displayed.");
			soft.assertTrue(updateSellingPrice.refreshBtnIsDisplayed(), "Refresh button is displayed.");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 2, description = "SKU error message validation")
	public void skuErrorMessageValidation() {
		try {
			UpdateSellingPricePage updateSellingPrice = new UpdateSellingPricePage(driver);
			SoftAssert soft = new SoftAssert();
			updateSellingPrice.updateButtonClick();
			Thread.sleep(2000);
			soft.assertEquals(updateSellingPrice.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "SKUError"),
					wrongMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 3, description = "Filter error message validation")
	public void filterErrorMessageValidation() {
		try {
			UpdateSellingPricePage updateSellingPrice = new UpdateSellingPricePage(driver);
			SoftAssert soft = new SoftAssert();
			updateSellingPrice.getSearchProductTextField().sendKeys(Lib.getProperty(INVENTORY_PATH, "Product"));
			updateSellingPrice.getSearchProductTextField().clear();
			updateSellingPrice.getSearchProductTextField().sendKeys(Lib.getProperty(INVENTORY_PATH, "Product"));
			updateSellingPrice.updateButtonClick();
			updateSellingPrice.updateButtonClick();
			Thread.sleep(2000);
			soft.assertEquals(updateSellingPrice.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "FilterError"),
					wrongMessage);
			soft.assertAll();
		}catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 4, description = "Validation of invalid selling price error message.")
	public void invalidSellingPriceErrorMessageValidation() {
		try {
			UpdateSellingPricePage updateSellingPrice = new UpdateSellingPricePage(driver);
			SoftAssert soft = new SoftAssert();
			Lib.SelectDropDownOptionByVisibleName(driver, updateSellingPrice.getZoneDropDown(),
					Lib.getProperty(INVENTORY_PATH, "Zone"));
			updateSellingPrice.updateButtonClick();
			Thread.sleep(2000);
			soft.assertEquals(updateSellingPrice.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "ValidPriceError"),
					wrongMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 5, description = "Validation of invalid selling price error message after selecting territory.")
	public void InvalidSellingPriceErrorMessageValidationAfterSeletingTerritory() {
		try {
			UpdateSellingPricePage updateSellingPrice = new UpdateSellingPricePage(driver);
			SoftAssert soft = new SoftAssert();
			Lib.SelectDropDownOptionByVisibleName(driver, updateSellingPrice.getTerritoryDropDown(),
					Lib.getProperty(INVENTORY_PATH, "Territory"));
			updateSellingPrice.updateButtonClick();
			Thread.sleep(2000);
			soft.assertEquals(updateSellingPrice.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "ValidPriceError"),
					wrongMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 6, description = "Validation of invalid selling price error message after selecting store.")
	public void invalidSellingPriceErrorMessageValidationAfterSeletingStore() {
		try {
			UpdateSellingPricePage updateSellingPrice = new UpdateSellingPricePage(driver);
			SoftAssert soft = new SoftAssert();
			Lib.SelectDropDownOptionByVisibleName(driver, updateSellingPrice.getStoreDropDown(),
					Lib.getProperty(INVENTORY_PATH, "Store"));
			updateSellingPrice.updateButtonClick();
			Thread.sleep(2000);
			soft.assertEquals(updateSellingPrice.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "ValidPriceError"),
					wrongMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 7, description = "Update selling price success message validation.")
	public void updateSellingPriceSuccessValidation() {
		try {
			UpdateSellingPricePage updateSellingPrice = new UpdateSellingPricePage(driver);
			SoftAssert soft = new SoftAssert();
			updateSellingPrice.sendKeyToNewSellingPriceTextField(Lib.getProperty(INVENTORY_PATH, "NewSellingPrice"));
			updateSellingPrice.updateButtonClick();
			updateSellingPrice.okButtonClick();
			//Currently the requirement is like this without entering SP invoice updating.
//			Thread.sleep(2000);
//			soft.assertEquals(updateSellingPrice.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "ValidPriceError"), "Wrong success message");
			soft.assertAll();
		}catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}
}