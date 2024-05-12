package script;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.Lib;
import generic.WebBase;
import pom.IndentPlanByStorePersonPage;
import pom.ReviewIndentPage;

public class ApproveIndent extends WebBase {
	@Test(priority = 1, description = "Empty search validation")
	public void emptySearchValidation() {
		try {
			IndentPlanByStorePersonPage indentPlan = new IndentPlanByStorePersonPage(driver);
			ReviewIndentPage reviewIndent = new ReviewIndentPage(driver);
			indentPlan.clickIndentTab();
			reviewIndent.clickViewIndentTab();
			reviewIndent.clickViewIndentSearchBtn();
			reviewIndent.clickIndentSearchFlaOutBtn();
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "EmptySearch"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 2, description = "Enter RM qty validation")
	public void enterRmQtyValidation() throws InterruptedException, IOException {
		try {
			ReviewIndentPage reviewIndent = new ReviewIndentPage(driver);
			IndentPlanByStorePersonPage indentPlan = new IndentPlanByStorePersonPage(driver);
			reviewIndent.sendIndentStatusDropDown(Lib.getProperty(INDENT_PATH, "IndentReview"));
			reviewIndent.sendIndentStoreDropDown(Lib.getProperty(INDENT_PATH, "StoreName"));
			reviewIndent.clickIndentSearchFlaOutBtn();
			String poNumber = Lib.getProperty(WRITE_PATH, "PoNumber");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			// Use the WebDriverWait to wait for the element to be clickable
			WebElement poNo = wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElementByAccessibilityId(poNumber)));
			poNo.click();
			reviewIndent.clickIndentChangeStatusButton();
			reviewIndent.clickSubmitButton();
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "EnterRmQty"));

		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 3, description = "Select product validation")
	public void selectProductValidation() {
		try {
			ReviewIndentPage reviewIndent = new ReviewIndentPage(driver);
			IndentPlanByStorePersonPage indentPlan = new IndentPlanByStorePersonPage(driver);
			reviewIndent.clickAddProductBtn();
			reviewIndent.clickAddBtn();
			Thread.sleep(1000);
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "SelectProduct"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 4, description = "Quantity field validation")
	public void quantityFieldValidation() {
		try {
			ReviewIndentPage reviewIndent = new ReviewIndentPage(driver);
			IndentPlanByStorePersonPage indentPlan = new IndentPlanByStorePersonPage(driver);
			indentPlan.sendProduct(Lib.getProperty(INDENT_PATH, "SkuProductName"));
			indentPlan.clearProduct();
			indentPlan.sendProduct(Lib.getProperty(INDENT_PATH, "SkuProductName"));
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
			reviewIndent.clickAddBtn();
			Thread.sleep(1000);
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "EnterQuantity"));

		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 5, description = "duplicate product  validation")
	public void duplicateProductValidation() {
		try {
			ReviewIndentPage reviewIndent = new ReviewIndentPage(driver);
			IndentPlanByStorePersonPage indentPlan = new IndentPlanByStorePersonPage(driver);
			reviewIndent.sendIndentQuantity(Lib.getProperty(INDENT_PATH, "RmQuantity"));
			reviewIndent.clickAddBtn();
			Thread.sleep(1000);
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "ProductAlreadyAdded"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 6, description = "Enter Retail selling price validation")
	public void enterRspValidation() {
		try {
			ReviewIndentPage reviewIndent = new ReviewIndentPage(driver);
			IndentPlanByStorePersonPage indentPlan = new IndentPlanByStorePersonPage(driver);
			reviewIndent.clickDeleteProductBtn();
			reviewIndent.sendRmQty(Lib.getProperty(INDENT_PATH, "RmQuantity"));
			reviewIndent.clickSubmitButton();
			Thread.sleep(1000);
			assertEquals(indentPlan.getSuccessMessage(), Lib.getProperty(INDENT_PATH, "EnterRsp"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 7, description = "Indent approved validation")
	public void validateindentReviewSuccessfully() {
		try {
			ReviewIndentPage reviewIndent = new ReviewIndentPage(driver);
			IndentPlanByStorePersonPage indentPlan = new IndentPlanByStorePersonPage(driver);
			reviewIndent.sendRspPrice(Lib.getProperty(INDENT_PATH, "RspPrice"));
			Actions action = new Actions(driver);
			action.sendKeys(Keys.DELETE).perform();
			reviewIndent.clickSubmitButton();
			Thread.sleep(1000);
			assertEquals(indentPlan.getSuccessMessage(), Lib.getProperty(INDENT_PATH, "IndentApproveSuccessfully"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

}
