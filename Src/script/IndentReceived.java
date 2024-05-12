package script;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.Lib;
import generic.WebBase;
import pom.AddSupplierByPurchaseManagerPage;
import pom.IndentPlanByStorePersonPage;
import pom.ReviewIndentPage;

public class IndentReceived extends WebBase {

	private IndentPlanByStorePersonPage indentPlan;
	private static String indentInTransit = "InTransit";
	private static String storeName = "StoreName";

	@Test(priority = 1, description = "Add inward inventory validation")
	public void addInwardInventoryValidation() {
		try {
			indentPlan = new IndentPlanByStorePersonPage(driver);
			ReviewIndentPage reviewIndent = new ReviewIndentPage(driver);
			indentPlan.clickIndentTab();
			reviewIndent.clickViewIndentTab();
			reviewIndent.clickViewIndentSearchBtn();
			reviewIndent.sendIndentStatusDropDown(Lib.getProperty(INDENT_PATH, indentInTransit));
			reviewIndent.sendIndentStoreDropDown(Lib.getProperty(INDENT_PATH, storeName));
			reviewIndent.clickIndentSearchFlaOutBtn();
			String poNumber = Lib.getProperty(WRITE_PATH, "PoNumber");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			// Use the WebDriverWait to wait for the element to be clickable
			WebElement poNo = wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElementByAccessibilityId(poNumber)));
			poNo.click();
			reviewIndent.clickIndentChangeStatusButton();
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "AddInwardInventory"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 2, description = "Indent received validation")
	public void indentReceived() {
		try {
			ReviewIndentPage reviewIndent = new ReviewIndentPage(driver);
			AddSupplierByPurchaseManagerPage purchaseManager = new AddSupplierByPurchaseManagerPage(driver);
			indentPlan = new IndentPlanByStorePersonPage(driver);
			indentPlan.clickIndentTab();
			reviewIndent.clickViewIndentTab();
			reviewIndent.clickViewIndentSearchBtn();
			reviewIndent.sendIndentStatusDropDown(Lib.getProperty(INDENT_PATH, indentInTransit));
			reviewIndent.sendIndentStoreDropDown(Lib.getProperty(INDENT_PATH, storeName));
			reviewIndent.clickIndentSearchFlaOutBtn();
			String poNumber = Lib.getProperty(WRITE_PATH, "PoNumber");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			// Use the WebDriverWait to wait for the element to be clickable
			WebElement poNo = wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElementByAccessibilityId(poNumber)));
			poNo.click();
			Thread.sleep(1000);
			reviewIndent.clickIndentChangeStatusButton();
			purchaseManager.clickIndentReceivedUpdateBtn();
			Thread.sleep(2000);
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "IndentReceived"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 3, description = "Received quantity and available quantity mismatch validation")
	public void quantityMismatchValidation() {
		try {
			ReviewIndentPage reviewIndent = new ReviewIndentPage(driver);
			AddSupplierByPurchaseManagerPage purchaseManager = new AddSupplierByPurchaseManagerPage(driver);
			indentPlan = new IndentPlanByStorePersonPage(driver);
			indentPlan.clickIndentTab();
			reviewIndent.clickViewIndentTab();
			reviewIndent.clickViewIndentSearchBtn();
			reviewIndent.sendIndentStatusDropDown(Lib.getProperty(INDENT_PATH, indentInTransit));
			reviewIndent.sendIndentStoreDropDown(Lib.getProperty(INDENT_PATH, storeName));
			reviewIndent.clickIndentSearchFlaOutBtn();
			List<WebElement> table = driver.findElementsByXPath("//DataGrid/Custom[1]/DataItem/Custom[1]/Text");
			for (int i = 0; i < table.size(); i++) {
				WebElement data = table.get(i);
				String text = data.getText();
				String poNumber = Lib.getProperty(INDENT_PATH, "QuantityMismatchPoNo");
				if (text.contains(poNumber)) {
					driver.findElementByXPath("//DataGrid/Custom[1]/DataItem[" + (i + 1) + "]/Custom[8]/Custom/Button")
							.click();
					break;
				}
			}

			reviewIndent.clickIndentChangeStatusButton();
			purchaseManager.clickIndentReceivedUpdateBtn();
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "QuantityMismatch"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}
}
