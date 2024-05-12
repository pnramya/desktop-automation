package script;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.DateAndTime;
import generic.Lib;
import generic.WebBase;
import pom.CreateInventoryPage;

public class CreateInventoryByPO extends WebBase {
	@Test(priority = 1, description = "Validation of add to stock button and add product, refresh button")
	public void validationOfAddToStockAddProductBtn() {
		try {
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			SoftAssert soft = new SoftAssert();
			inventory.inventoryOptionClick();
			soft.assertTrue(inventory.addToStockButtonIsDisplyed(), "Add to stock button is not displayed.");
			soft.assertTrue(inventory.addProductButtonIsDisplayed(), "Add product button is not displayed.");
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 2, description = "Add product error message validation")
	public void addProductErrorMessage() {
		try {
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			SoftAssert soft = new SoftAssert();
			inventory.addToStockButtonClick();
			Thread.sleep(2000);
			soft.assertEquals(inventory.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "AddProductError"));
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 3, description = "Supplier drop down error message validation")
	public void supplierDropDownErrorValidation() {
		try {
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			SoftAssert soft = new SoftAssert();
			inventory.addProductButtonClick();
			Thread.sleep(1000);
			soft.assertEquals(inventory.getErrorMessage(),
					Lib.getProperty(INVENTORY_PATH, "SelectSupplierDropDownError"));
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 4, description = "Select indent error message validation")
	public void poNumberDropDownErrorValidation() {
		try {
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			Lib.SelectDropDownOptionByVisibleName(driver, inventory.getSupplierNameDropDown(), " National Marketing");
			Thread.sleep(3000);
			//Lib.SelectDropDownOptionByVisibleName(driver, inventory.getSupplierNameDropDown(),"Aadeshwar Polymers");
					//Lib.getProperty(INVENTORY_PATH, "AgnihotriSupplier"));
			inventory.addProductButtonClick();
			assertEquals(inventory.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "SelectIndentError"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 5, description = "Indent supplier not matching error message validation")
	public void baseUnitTypeDropDownErrorValidation() {
		try {
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			Lib.SelectDropDownOptionByVisibleName(driver, inventory.getPONumberDropDown(), Lib.getProperty(WRITE_PATH, "InventoryPoNo"));
			//inventory.sendPONumberDropDown(Lib.getProperty(WRITE_PATH, "InventoryPoNo"));
			assertEquals(inventory.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "SupplierNotMatch"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 6, description = "Sub unit qty text field error message validation")
	public void subUnitQTYErrorValidation() {
		try {
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			inventory.refreshButtonClick();
			Thread.sleep(2000);
			Lib.SelectDropDownOptionByVisibleName(driver, inventory.getPONumberDropDown(),
					Lib.getProperty(WRITE_PATH, "InventoryPoNo"));
			inventory.addToStockButtonClick();
			Thread.sleep(1000);
			assertEquals(inventory.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "EnterReceivedQty"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 7, description = "Manufature date text field error message validation")
	public void manufactureDateErrorValidation() {
		try {
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			inventory.sendKeyToSubUnitQTYtextField(Lib.getProperty(INVENTORY_PATH, "SubUnitQTY"));
			inventory.addToStockButtonClick();
			Thread.sleep(2000);
			Lib.assertEqualsIgnoreCase(inventory.getErrorMessage(),
					Lib.getProperty(INVENTORY_PATH, "ManufactureDateError"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 8, description = "Rate text field error message validation")
	public void rateTextFieldErrorValidation() {
		try {
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			DateAndTime date = new DateAndTime();
			inventory.sendKeyToManufatureDatetextField(date.currentdate());
			inventory.addToStockButtonClick();
			assertEquals(inventory.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "ProductRateError"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 9, description = "Expiry date text field error message validation")
	public void expiryDateTextFieldErrorValidation() {
		try {
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			inventory.sendKeyToRateTextField(Lib.getProperty(INVENTORY_PATH, "Rate"));
			inventory.addToStockButtonClick();
			Lib.assertEqualsIgnoreCase(inventory.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "ExperyDateError"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 10, description = "Invoice number text field error message validation")
	public void invoiceNumberTextFieldErrorValidation() {
		try {
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			String lotNo = Integer.toString(Lib.getRandomNumber(11, 99999));
			Lib.writeProperties("LotNo", lotNo);
			inventory.sendLotNo(lotNo);
			DateAndTime date = new DateAndTime();
			date.currentdate();
			inventory.sendKeyToExpiryDatetextField(date.monthplus(3));
			inventory.addToStockButtonClick();
			assertEquals(inventory.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "InvoiceNumberError"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 11, description = "Invoice date text field error message validation")
	public void invoiceDateTextFieldErrorValidation() {
		try {
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			inventory.sendKeyToInvoiceNumberTextField("INV23/" + Lib.getRandomNumber(111, 9999));
			inventory.addToStockButtonClick();
			Thread.sleep(1000);
			assertEquals(inventory.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "InvoiceDateError"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 12, description = "QTY field error message validation")
	public void qtyTextFieldErrorValidation() {
		try {
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			inventory.sendKeyToInvoiceDateTextField(Lib.getProperty(INVENTORY_PATH, "InvoiceDate"));
			inventory.addToStockButtonClick();
			Thread.sleep(1000);
			assertEquals(inventory.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "QTYerror"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 13, description = "Net total text field error message validation")
	public void netTotalTextFieldErrorValidation() {
		try {
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			inventory.sendKeyToQTYTextField(Lib.getProperty(INVENTORY_PATH, "UnitQty"));
			inventory.addToStockButtonClick();
			Thread.sleep(2000);
			assertEquals(inventory.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "NetTotalError"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 14, description = "Total GST missmatch error mesage validation")
	public void totalGSTMissmatchErrorValidation() {
		try {
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			inventory.getGSTDropDown().click();
			inventory.getGSTDropDown().sendKeys(Lib.getProperty(INVENTORY_PATH, "GST"));
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
			inventory.sendKeyToNetTotalTextField(Lib.getProperty(INVENTORY_PATH, "NetTotalCorrected"));
			inventory.addToStockButtonClick();
			Thread.sleep(1000);
			assertEquals(inventory.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "TotalGSTMissmatchError"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}

	}

	@Test(priority = 15, description = "Invoice attachment error message validation")
	public void invoiceAttachmentErrorValidation() {
		try {
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			inventory.sendKeyToTotalGSTTextField(Lib.getProperty(INVENTORY_PATH, "TotalGST"));
			inventory.addToStockButtonClick();
			Thread.sleep(1000);
			assertEquals(inventory.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "AttachmentError"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 16, description = "Falca Gst number pop up validation")
	public void falcaGSTPopUpValidation() {
		try {
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			SoftAssert soft = new SoftAssert();
			inventory.attachButton();
			inventory.sendFile(pdfPath);
			inventory.openButtonClick();
			inventory.addToStockButtonClick();
			soft.assertTrue(inventory.gstNumberPopUpIsDisplayd(), "Falca GST number pop up is not displayed.");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 17, description = "Falca gst number text field error message validation")
	public void falcaGSTNumberTextFieldErrorValidation() {
		try {
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			inventory.validateAndSubmitButton();
			assertEquals(inventory.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "EnterGSTINerror"));
			inventory.sendKeyToFalcaGstNumber(Lib.getProperty(INVENTORY_PATH, "FalcaGSTNumber"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 18, description = "Inventory success message validation")
	public void inventoryCreateSuccessValidation() {
		try {
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			inventory.validateAndSubmitButton();
			Thread.sleep(2000);
			assertEquals(inventory.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "InventrySuccessMessage"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}
}
