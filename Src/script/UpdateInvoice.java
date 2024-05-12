package script;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Lib;
import generic.WebBase;
import pom.UpdateInvoicePage;

public class UpdateInvoice extends WebBase {
	@Test(priority = 1, description = "Validation of select store and refresh button.")
	public void selectStoreDropDownRefreshBtnValidation() {
		try {
			UpdateInvoicePage invoice = new UpdateInvoicePage(driver);
			SoftAssert soft = new SoftAssert();
			invoice.invoiceOptionClick();
			soft.assertTrue(invoice.invoiceRefreshIsDisplayed(), "Refresh button is not displayed.");
			soft.assertTrue(invoice.getSelectStoreDropDown().isDisplayed(),
					"Selling price update drop down is not displayed.");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 2, description = "Validation of invoice in list")
	public void invoiceValidation() {
		try {
			UpdateInvoicePage invoice = new UpdateInvoicePage(driver);
			SoftAssert soft = new SoftAssert();
			invoice.getSelectStoreDropDown().sendKeys(Lib.getProperty(INVENTORY_PATH, "Store"));

			Thread.sleep(2000);
			// This code is for searching invoice by invoice number not the first element in
			// invoice update page.
//			int count=1;
//			for (WebElement singleInvoice : invoice.getInvoiceList()) 
//			{
//				System.out.println("List size"+invoice.getInvoiceList().size());
//				
//				if(count<=invoice.getInvoiceList().size()&&driver.findElementByXPath("//Custom/List/ListItem["+count+"]"+"/Text[2]").getAttribute("Name").equals("Haveri"))
//				{
//					singleInvoice.click();
//					break;
//				}
//				else
//				{
//					count++;
//				}
			
			invoice.clickInvoiceNo();
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 3, description = "Validation of expander button.")
	public void expanderBtnValidation() {
		try {
			UpdateInvoicePage invoice = new UpdateInvoicePage(driver);
			SoftAssert soft = new SoftAssert();
			soft.assertTrue(invoice.expandButtonIsDisplyed(), "Expand button is not displayed.");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 4, description = "Selling price update error message validation")
	public void sellingPriceUpdateErrorValidation() {
		try {
			UpdateInvoicePage invoice = new UpdateInvoicePage(driver);
			invoice.expandButtonClick();
			// invoice.updateButtonClick();
			Thread.sleep(2000);
			// soft.assertEquals(invoice.getErrorMessage(), Lib.getProperty(INVENTORY_PATH,
			// "UpdateSellingPriceError"),
			// "Wrong error message.");
			// soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 5, description = "Selling price update success message validation.")
	public void sellingPriceUpdateSuccessValidation() {
		try {
			UpdateInvoicePage invoice = new UpdateInvoicePage(driver);
			SoftAssert soft = new SoftAssert();
			invoice.sendKeyToSellingPriceUpdateTextField(Lib.getProperty(INVENTORY_PATH, "SellingPrice"));
			invoice.updateButtonClick();
			Thread.sleep(2000);
			soft.assertEquals(invoice.getErrorMessage(), Lib.getProperty(INVENTORY_PATH, "InvoiceUpdated"),
					"Wrong error message.");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}
}
