package script;

import static org.testng.Assert.assertEquals;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Lib;
import generic.WebBase;
import pom.IndentClosePage;
import pom.IndentPlanByStorePersonPage;
import pom.ReviewIndentPage;

public class IndentClose extends WebBase {

	private IndentPlanByStorePersonPage indentPlan;

	@Test(priority = 1, description = "Update utr date and payref error message validation")
	public void updateUtrAndPayrefValidation() { // ref=reference no
		try {
			indentPlan = new IndentPlanByStorePersonPage(driver);
			ReviewIndentPage reviewIndent = new ReviewIndentPage(driver);
			IndentClosePage indentClose = new IndentClosePage(driver);
			indentPlan.clickIndentTab();
			reviewIndent.clickViewIndentTab();
			reviewIndent.clickViewIndentSearchBtn();
			reviewIndent.clickIndentSearchFlaOutBtn();
			reviewIndent.sendIndentStoreDropDown(Lib.getProperty(INDENT_PATH, "StoreName"));
			indentClose.clickFullCheckBox();
			reviewIndent.clickIndentSearchFlaOutBtn();
			String poNumber = Lib.getProperty(WRITE_PATH, "PoNumber");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			// Use the WebDriverWait to wait for the element to be clickable
			WebElement poNo = wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElementByAccessibilityId(poNumber)));
			poNo.click();
			reviewIndent.clickIndentChangeStatusButton();
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "UpdateUTRDate"));

		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 2, description = "Indent close remarks popup validation")
	public void remarksPopUpValidation() {
		try {
			indentPlan = new IndentPlanByStorePersonPage(driver);
			ReviewIndentPage reviewIndent = new ReviewIndentPage(driver);
			IndentClosePage indentClose = new IndentClosePage(driver);
			indentPlan.clickIndentTab();
			reviewIndent.clickViewIndentTab();
			reviewIndent.clickViewIndentSearchBtn();
			reviewIndent.sendIndentStoreDropDown(Lib.getProperty(INDENT_PATH, "StoreName"));
			indentClose.clickFullCheckBox();
			reviewIndent.clickIndentSearchFlaOutBtn();
			String poNumber = Lib.getProperty(WRITE_PATH, "PoNumber");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			// Use the WebDriverWait to wait for the element to be clickable
			WebElement poNo = wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElementByAccessibilityId(poNumber)));
			poNo.click();
			reviewIndent.clickIndentChangeStatusButton();
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(indentClose.remarksPopUpIsDisplayed());
			softAssert.assertTrue(indentClose.updateButtonIsDisplayed());
			softAssert.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 3, description = "Close indent validation")
	public void indentClosedValidation() {
		try {
			IndentClosePage indentClose = new IndentClosePage(driver);
			indentClose.sendRemarksFields(RandomStringUtils.randomAlphabetic(6));
			indentClose.clickUpdateButton();
			Thread.sleep(2000);
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "IndentClosed"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}
}
