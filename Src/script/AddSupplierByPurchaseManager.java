package script;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.DateAndTime;
import generic.Lib;
import generic.WebBase;
import pom.AddSupplierByPurchaseManagerPage;
import pom.IndentPlanByStorePersonPage;
import pom.ReviewIndentPage;

public class AddSupplierByPurchaseManager extends WebBase {
	private static IndentPlanByStorePersonPage indentPlan;
	private static String indentPlaced = "IndentPlaced";

	@Test(priority = 1, description = "Empty search validation")
	public void emptySearchValidation() {
		try {
			indentPlan = new IndentPlanByStorePersonPage(driver);
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
	public void enterRMQtyValidation() throws InterruptedException, IOException {
		try {
			ReviewIndentPage reviewIndent = new ReviewIndentPage(driver);
			reviewIndent.sendIndentStatusDropDown(Lib.getProperty(INDENT_PATH, "IndentApprove"));

			reviewIndent.sendIndentStoreDropDown(Lib.getProperty(INDENT_PATH, "StoreName"));
			reviewIndent.clickIndentSearchFlaOutBtn();
			String poNumber = Lib.getProperty(WRITE_PATH, "PoNumber");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			// Use the WebDriverWait to wait for the element to be clickable
			WebElement poNo = wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElementByAccessibilityId(poNumber)));
			poNo.click();
			reviewIndent.clickIndentChangeStatusButton();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 3, description = "Select supplier validation in add supplier popup")
	public void selectSupplierValidation() throws InterruptedException, IOException {
		try {
			AddSupplierByPurchaseManagerPage addSupplier = new AddSupplierByPurchaseManagerPage(driver);
			IndentPlanByStorePersonPage indentPlan = new IndentPlanByStorePersonPage(driver);
			addSupplier.clickcontinueButton();
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "PleaseSelectSupplier"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 4, description = "Select inclusive or exclusive gst validation")
	public void selectInclusiveOrExclusiveGSTValidation() throws InterruptedException, IOException {
		try {
			AddSupplierByPurchaseManagerPage addSupplier = new AddSupplierByPurchaseManagerPage(driver);
			IndentPlanByStorePersonPage indentPlan = new IndentPlanByStorePersonPage(driver);
			Lib.SelectDropDownOptionByVisibleName(driver, addSupplier.getIndentSupplierDropDown(), Lib.getProperty(INDENT_PATH, "AishwaryaSupplier"));
			//addSupplier.sendindentSupplierDropDown(Lib.getProperty(INDENT_PATH, "AishwaryaSupplier"));// National Marketing-->GUJARAT-->Vadodara
			addSupplier.clickcontinueButton();
			Thread.sleep(1000);
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "SelectInclusiveOrExclusiveGST"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 5, description = "Verify Request,RM/TM quantity, and Rsp price in the add supplier popup")
	public void verifyRspPriceAndRmTmQuantity() throws InterruptedException, IOException {
		try {
			AddSupplierByPurchaseManagerPage addSupplier = new AddSupplierByPurchaseManagerPage(driver);
			IndentPlanByStorePersonPage indentPlan = new IndentPlanByStorePersonPage(driver);
			SoftAssert softAssert = new SoftAssert();
			addSupplier.clickIndentExclusiveGSTRedioButton();
			addSupplier.clickcontinueButton();
			softAssert.assertEquals(addSupplier.getRequestedQuantity(), Lib.getProperty(INDENT_PATH, "IndentQuantity"));
			softAssert.assertEquals(addSupplier.getTMQuantity(), Lib.getProperty(INDENT_PATH, "TmQuantity"));
			softAssert.assertEquals(addSupplier.getRmQuantity(), Lib.getProperty(INDENT_PATH, "RmQuantity"));
			softAssert.assertEquals(addSupplier.getIndentRetailSellingPrice().replace(".00", ""),
					Lib.getProperty(INDENT_PATH, "RspPrice"));
			softAssert.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 6, description = "Select gst value validation")
	public void gstValueValidation() throws InterruptedException, IOException {
		try {
			AddSupplierByPurchaseManagerPage addSupplier = new AddSupplierByPurchaseManagerPage(driver);
			IndentPlanByStorePersonPage indentPlan = new IndentPlanByStorePersonPage(driver);
			addSupplier.sendAvailableQuantity(Lib.getProperty(INDENT_PATH, "AvailableQuantity"));
			Actions action = new Actions(driver);
			action.sendKeys(Keys.DELETE).perform();
			addSupplier.clickAddProductcontinueButton();
			Thread.sleep(1000);
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "SelectGSTValue"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 7, description = "Estimated price and date validation")
	public void estimatedPriceAndDateValidation() throws InterruptedException, IOException {
		try {
			AddSupplierByPurchaseManagerPage addSupplier = new AddSupplierByPurchaseManagerPage(driver);
			IndentPlanByStorePersonPage indentPlan = new IndentPlanByStorePersonPage(driver);
			SoftAssert softAssert = new SoftAssert();
			addSupplier.sendGST(Lib.getProperty(INDENT_PATH, "GstValue"));
			addSupplier.clickAddProductcontinueButton();
			Thread.sleep(1000);
			softAssert.assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "EnterEstimatedPrice"));
			addSupplier.sendEstimatedPricePrice(Lib.getProperty(INDENT_PATH, "EstimatedPrice"));
			Actions action = new Actions(driver);
			action.sendKeys(Keys.DELETE).perform();
			Thread.sleep(1000);
			addSupplier.clickAddProductcontinueButton();
			Thread.sleep(1000);
			softAssert.assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "EnterEstimatedDate"));
			softAssert.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 8, description = "Verify Gst and product total with Gst calculation")
	public void verifyProductTotalCalculation() throws InterruptedException, IOException {
		try {
			AddSupplierByPurchaseManagerPage addSupplier = new AddSupplierByPurchaseManagerPage(driver);
			SoftAssert softAssert = new SoftAssert();
			DateAndTime date = new DateAndTime();
			addSupplier.sendEstimatedDate(date.currentdate());
			addSupplier.clickAddProductcontinueButton();
			Thread.sleep(1000);
			int estimatedPrice = Integer.parseInt(Lib.getProperty(INDENT_PATH, "EstimatedPrice").trim());
			int availableQty = Integer.parseInt(Lib.getProperty(INDENT_PATH, "AvailableQuantity").trim());
			int gstPercentage = Integer.parseInt(Lib.getProperty(INDENT_PATH, "GstValue").trim().replace("%", ""));
			int totalGst = (estimatedPrice * availableQty * gstPercentage) / 100;
			softAssert.assertEquals(Lib.getProperty(INDENT_PATH, "TotalGstAmt"), Integer.toString(totalGst));
			int productTotalWithGst = (estimatedPrice * availableQty) + totalGst;
			softAssert.assertEquals(addSupplier.getProductTotalWithGST(), Integer.toString(productTotalWithGst));
			softAssert.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 9, description = "Added supplier to indent validation")
	public void addPaymentValidation() throws InterruptedException, IOException {
		try {
			AddSupplierByPurchaseManagerPage addSupplier = new AddSupplierByPurchaseManagerPage(driver);
			IndentPlanByStorePersonPage indentPlan = new IndentPlanByStorePersonPage(driver);
			SoftAssert softAssert = new SoftAssert();
			addSupplier.clickPaymentModeFullRedioButton();
			
			addSupplier.clickContinueBtn();
			Thread.sleep(1000);
			addSupplier.clickSaveButton();
			softAssert.assertTrue(addSupplier.paymentConfirmationisDisplayed());
			Actions action = new Actions(driver);
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.TAB).perform();
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			softAssert.assertEquals(indentPlan.getErrorMessage(),
					Lib.getProperty(INDENT_PATH, "AddedSupplierToIndent"));
			softAssert.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}
	// Indent Placed Status

	@Test(priority = 10, description = "Indent placed success message validation")
	public void indentPlaced() throws InterruptedException, IOException {
		try {
			ReviewIndentPage reviewIndent = new ReviewIndentPage(driver);
			AddSupplierByPurchaseManagerPage purchaseManager = new AddSupplierByPurchaseManagerPage(driver);
			reviewIndent.clickIndentChangeStatusButton();
			Thread.sleep(1000);
			purchaseManager.sendReason(Lib.getProperty(INDENT_PATH, indentPlaced));
			purchaseManager.clickUpdateBtn();
			Thread.sleep(2000);
			assertEquals(indentPlan.getSuccessMessage(), Lib.getProperty(INDENT_PATH, indentPlaced));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 11, description = "Indent intransit status validation")
	public void indentIntransitStatus() throws InterruptedException, IOException {
		try {
			ReviewIndentPage reviewIndent = new ReviewIndentPage(driver);
			AddSupplierByPurchaseManagerPage purchaseManager = new AddSupplierByPurchaseManagerPage(driver);
			IndentPlanByStorePersonPage indentPlan = new IndentPlanByStorePersonPage(driver);
			reviewIndent.clickIndentChangeStatusButton();
			purchaseManager.sendReason(Lib.getProperty(INDENT_PATH, indentPlaced));
			purchaseManager.sendTrackingId(RandomStringUtils.randomAlphabetic(5));
			purchaseManager.clickUpdateBtn();
			Thread.sleep(2000);
			assertEquals(indentPlan.getSuccessMessage(), Lib.getProperty(INDENT_PATH, "IndentIntransit"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

}
