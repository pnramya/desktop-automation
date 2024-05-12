package script;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Lib;
import generic.WebBase;
import pom.StockReceivePage;

public class StockReceive extends WebBase {
	@Test(priority = 1, description = "New selling price error message validation")
	public void addProductValidation() {
		try {
			StockReceivePage stockReceive = new StockReceivePage(driver);
			stockReceive.clickStockTransferTab();
			stockReceive.clickStockReceiveTab();
			stockReceive.clickRefreshButton();
			stockReceive.clickReceiveButton();
			assertEquals(stockReceive.getErrorMessage(), Lib.getProperty(STOCKTRANSFER_PATH, "NewSellingPrice"));
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 2, description = "Enter less selling price error message validation")
	public void enterLessSellingPriceValidation() {
		try {
			StockReceivePage stockReceive = new StockReceivePage(driver);
			stockReceive.sendNewSellingPrice(Lib.getProperty(SKU_PATH, "LessThanSellingPriceAmount"));
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.DELETE).perform();
			stockReceive.clickReceiveButton();
			assertEquals(stockReceive.getErrorMessage(), Lib.getProperty(STOCKTRANSFER_PATH, "NewSellingPrice"));
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 3, description = "Stock receiver confrimpopup validation")
	public void confrimpopupValidation() {
		try {
			StockReceivePage stockReceive = new StockReceivePage(driver);
			stockReceive.clearNewSellingPrice();
			stockReceive.sendNewSellingPrice(Lib.getProperty(SKU_PATH, "SellingPrice"));
			stockReceive.clickReceiveButton();
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(stockReceive.confrimPopupisEnabled());
			softAssert.assertTrue(stockReceive.closeButtonisEnabled());
			softAssert.assertTrue(stockReceive.stockreceiveupdateisEnabled());
			stockReceive.clickCloseButton();
			softAssert.assertFalse(stockReceive.confrimPopupisEnabled());
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 4, description = "Attachment error message validation")
	public void attachmentErrorValidation() {
		try {
			StockReceivePage stockReceive = new StockReceivePage(driver);
			stockReceive.clickReceiveButton();
			stockReceive.sendTransportChrages(Lib.getProperty(SKU_PATH, "SellingPrice"));
			stockReceive.clickUpdateButton();
			assertEquals(stockReceive.getErrorMessage(), Lib.getProperty(STOCKTRANSFER_PATH, "AddAttachment"));
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 5, description = "Stock received successfully validation")
	public void stockReceivedValidation() {
		try {
			StockReceivePage stockReceive = new StockReceivePage(driver);
			stockReceive.clearTransportChrages();
			stockReceive.clickUpdateButton();
			assertEquals(stockReceive.getErrorMessage(),
					Lib.getProperty(STOCKTRANSFER_PATH, "StockReceivedSuccessfully"));
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}
}
