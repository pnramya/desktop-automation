package script;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Lib;
import generic.WebBase;
import pom.IndentPlanByStorePersonPage;
import pom.StockStoreRequestPage;

public class StockStoreRequest extends WebBase {
	private IndentPlanByStorePersonPage getText;

	@Test(priority = 1, description = "Select from store error message validation")
	public void selectFromStoreValidation() {
		try {
			StockStoreRequestPage storeRequest = new StockStoreRequestPage(driver);
			getText = new IndentPlanByStorePersonPage(driver);
			storeRequest.clickStockTransferTab();
			storeRequest.clickStockRequestTab();
			storeRequest.clickCreateRequestBtn();
			assertEquals(getText.getErrorMessage(), Lib.getProperty(STOCKTRANSFER_PATH, "SelectFromStore"));
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 2, description = "Select product error message validation")
	public void selectProductValidation() {
		try {
			StockStoreRequestPage storeRequest = new StockStoreRequestPage(driver);
			getText = new IndentPlanByStorePersonPage(driver);
			storeRequest.sendFromStoreDropdown(Lib.getProperty(INDENT_PATH, "StoreName"));
			storeRequest.clickAddButton();
			storeRequest.clickCreateRequestBtn();
			assertEquals(getText.getErrorMessage(), Lib.getProperty(STOCKTRANSFER_PATH, "SelectProduct"));
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 3, description = "Brand and subcategory name validation")
	public void brandAndSubcategoryValidation() {
		try {
			StockStoreRequestPage storeRequest = new StockStoreRequestPage(driver);
			getText = new IndentPlanByStorePersonPage(driver);
			storeRequest.sendStockTransferProductSearch(Lib.getProperty(INDENT_PATH, "SkuNo"));
			List<WebElement> dropDown = driver.findElements(By.xpath("//ListItem/Text[2]"));
			for (WebElement ele : dropDown) {
				if (ele.getText().contains(Lib.getProperty(INDENT_PATH, "SkuNo"))) {
					ele.click();
					break;
				}

			}
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(storeRequest.getStockTransferBrandName(),
					Lib.getProperty(INDENT_PATH, "ProductBrandName"));
			softAssert.assertEquals(storeRequest.getStockTransferSubCategoryName(),
					Lib.getProperty(INDENT_PATH, "SubCategoryName"));
			softAssert.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 4, description = "Stock transfer request sent validation")
	public void transferRequestSentValidation() {
		try {
			StockStoreRequestPage storeRequest = new StockStoreRequestPage(driver);
			storeRequest.sendProductQuantity(Lib.getProperty(STOCKTRANSFER_PATH, "RequestQuantity"));
			storeRequest.sendKeys(Keys.DELETE);
			storeRequest.clickCreateRequestBtn();
			Thread.sleep(2000);
			assertEquals(getText.getErrorMessage(), Lib.getProperty(STOCKTRANSFER_PATH, "StockTransferRequestSent"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}
}
