package script;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.Lib;
import generic.WebBase;
import pom.IndentPlanByStorePersonPage;
import pom.StockTransferPage;

public class StockTransfer extends WebBase {
	private IndentPlanByStorePersonPage getText;
	private Actions actions;

	@Test(priority = 1, description = "Add product for stock transfer validation")
	public void addProductValidation() {
		try {
			StockTransferPage stockTransfer = new StockTransferPage(driver);
			getText = new IndentPlanByStorePersonPage(driver);
			stockTransfer.clickStockTransferTab();
			stockTransfer.clickTransferTab();
			stockTransfer.clickRefreshButton();
			stockTransfer.clickExpanderButton();
			stockTransfer.clickTransferButton();
			assertEquals(getText.getErrorMessage(), Lib.getProperty(STOCKTRANSFER_PATH, "AddStockProduct"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 2, description = "Validate product does not match the requested product error")
	public void missMatchingProductValidation() {
		try {
			StockTransferPage stockTransfer = new StockTransferPage(driver);
			getText = new IndentPlanByStorePersonPage(driver);
			stockTransfer.sendProductCode(Lib.getProperty(STOCKTRANSFER_PATH, "DifferentProductCode"));
			actions = new Actions(driver);
			actions.sendKeys(Keys.ENTER).perform();
			Thread.sleep(1000);
			assertEquals(getText.getErrorMessage(),
					Lib.getProperty(STOCKTRANSFER_PATH, "MissMatchingRequestedProduct"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 3, description = "Expired product validation")
	public void expireProductValidation() {
		try {
			StockTransferPage stockTransfer = new StockTransferPage(driver);
			getText = new IndentPlanByStorePersonPage(driver);
			stockTransfer.clearProductCode();
			stockTransfer.sendProductCode(Lib.getProperty(STOCKTRANSFER_PATH, "ExpireProductCode"));
			actions.sendKeys(Keys.ENTER).perform();
			Thread.sleep(1000);
			assertEquals(getText.getErrorMessage(), Lib.getProperty(STOCKTRANSFER_PATH, "ExpiredProduct"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 4, description = "Product transfer qty is not matching error validation")
	public void transferQtyNotMatchingValidation() {
		try {
			StockTransferPage stockTransfer = new StockTransferPage(driver);
			getText = new IndentPlanByStorePersonPage(driver);
			stockTransfer.clearProductCode();
			stockTransfer.sendProductCode(Lib.getProperty(STOCKTRANSFER_PATH, "LessQuantityProductCode"));
			actions.sendKeys(Keys.ENTER).perform();
			stockTransfer.clickTransferButton();
			assertEquals(getText.getErrorMessage(), Lib.getProperty(STOCKTRANSFER_PATH, "QuantityNotMatching"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 5, description = "product already exists error validation")
	public void productAlreadyExistsValidation() {
		try {
			StockTransferPage stockTransfer = new StockTransferPage(driver);
			getText = new IndentPlanByStorePersonPage(driver);
			Actions action = new Actions(driver);
			stockTransfer.clickRefreshButton();
			stockTransfer.clickExpanderButton();
			stockTransfer.sendProductCode(Lib.getProperty(STOCKTRANSFER_PATH, "ProductCode"));
			action.sendKeys(Keys.ENTER).perform();
			stockTransfer.clearProductCode();
			stockTransfer.sendProductCode(Lib.getProperty(STOCKTRANSFER_PATH, "ProductCode"));
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(1000);
			assertEquals(getText.getErrorMessage(), Lib.getProperty(STOCKTRANSFER_PATH, "ProductAlreadyAdded"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 6, description = "Stock transfer completed message validation")
	public void transferCompletedValidation() {
		try {
			StockTransferPage stockTransfer = new StockTransferPage(driver);
			stockTransfer.clickTransferButton();
			stockTransfer.clickConfirmButton();
			Thread.sleep(1000);
			assertEquals(getText.getErrorMessage(), Lib.getProperty(STOCKTRANSFER_PATH, "StockTransferCompleted"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

}
