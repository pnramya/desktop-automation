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
import pom.IndentPlanByStorePersonPage;

public class IndentPlanByStorePerson extends WebBase {

	@Test(priority = 1, description = "Validate add product error message")
	public void addProductValidation() {
		try {
			IndentPlanByStorePersonPage indentPlan = new IndentPlanByStorePersonPage(driver);
			indentPlan.clickIndentTab();
			Lib.writeProperties("PoDate", indentPlan.getIndentPODate());
			indentPlan.clickIndentCreateBtn();
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "AddProductErrorMsg"));
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 2, description = "Validate select po type error message")
	public void selectPoTypeValidation() throws InterruptedException {
		try {
			IndentPlanByStorePersonPage indentPlan = new IndentPlanByStorePersonPage(driver);
			indentPlan.clickIndentPlanRefreshButton();
			indentPlan.clickIndentCreateBtn();
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "SelectPoType"));
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 3, description = "Validate select product error message")
	public void searchProductValidation() throws InterruptedException {
		try {
			IndentPlanByStorePersonPage indentPlan = new IndentPlanByStorePersonPage(driver);
			indentPlan.clickReatilOrderRbBtn();
			indentPlan.clickIndentPlanAddProductBtn();
			indentPlan.clickIndentCreateBtn();
			Lib.assertEqualsIgnoreCase(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "SelectAProduct"));
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 4, description = "Subcategory and brand validation")
	public void subcategoryAndBrandValidation() throws InterruptedException {
		try {
			IndentPlanByStorePersonPage indentPlan = new IndentPlanByStorePersonPage(driver);
			SoftAssert softAssert = new SoftAssert();
			indentPlan.sendProduct(Lib.getProperty(INDENT_PATH, "SkuProductName"));
			indentPlan.clearProduct();
			indentPlan.sendProduct(Lib.getProperty(INDENT_PATH, "SkuProductName"));
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
			DateAndTime date = new DateAndTime();
			String poNumber = indentPlan.getIndentPONumber();
			Lib.writeProperties("PoNumber", poNumber);
			String inventoryPono = poNumber + "-->" + date.currentdate() + "-->"
					+ "11AAutoSplr";
			Lib.writeProperties("InventoryPoNo", inventoryPono);
			softAssert.assertEquals(indentPlan.getIndentBrandName(), Lib.getProperty(INDENT_PATH, "ProductBrandName"));
			softAssert.assertEquals(indentPlan.getIndentSubCategoryName(),
					Lib.getProperty(INDENT_PATH, "SubCategoryName"));
			softAssert.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 5, description = "Validate indent created successfully toast message")
	public void indentCreationSuccessMessageValidation() {
		try {
			IndentPlanByStorePersonPage indentPlan = new IndentPlanByStorePersonPage(driver);
			indentPlan.sendIndentQuantity(Lib.getProperty(INDENT_PATH, "IndentQuantity"));
			Actions action = new Actions(driver);
			action.sendKeys(Keys.DELETE).perform();
			indentPlan.clickIndentCreateBtn();
			Thread.sleep(1000);
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "IndentCreatedSuccessMsg"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}
}
