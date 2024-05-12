package script;

import static org.testng.Assert.assertEquals;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.DateAndTime;
import generic.Lib;
import generic.WebBase;
import pom.AddDepositPage;
import pom.CreateInventoryPage;

public class AddDeposit extends WebBase {
	private String closingCash="ClosingCash";
	@Test(priority = 1, description = "Deposit date text field error message validation")
	public void depositDateError() {
		try {
			AddDepositPage addDeposit = new AddDepositPage(driver);
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			SoftAssert soft = new SoftAssert();
			addDeposit.clickEodOption();
			soft.assertTrue(addDeposit.closingCashBalanceTextIsDisplayed(),
					"Closing cash balance text is not displayed");
			Lib.writeProperties(closingCash, addDeposit.getCashAmount());
			addDeposit.clickAddDeposit();
			addDeposit.clickAddDepositBtnInPOpUp();
			Thread.sleep(3000);
			assertEquals(inventory.getErrorMessage(), Lib.getProperty(ADDSALES_PATH, "DepositDateError"));
			soft.assertAll();

		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 2, description = "Deposit amount error message validation")
	public void depositAmtError() {
		try {
			AddDepositPage addDeposit = new AddDepositPage(driver);
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			SoftAssert soft = new SoftAssert();
			DateAndTime dt = new DateAndTime();
			addDeposit.sendKeyToDepositDateTF(dt.currentdate());
			addDeposit.clickAddDepositBtnInPOpUp();
			Thread.sleep(3000);
			assertEquals(inventory.getErrorMessage(), Lib.getProperty(ADDSALES_PATH, "DepositAmountError"));
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 3, description = "Deposit amount greater error message validation")
	public void depositAmtGreaterErrorValidation() {
		try {
			AddDepositPage addDeposit = new AddDepositPage(driver);
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			SoftAssert soft = new SoftAssert();
			addDeposit.sendKeyToDepositAmountTF(Lib.getProperty(WRITE_PATH,closingCash) + "1");
			addDeposit.clickAddDepositBtnInPOpUp();
			Thread.sleep(3000);
			assertEquals(inventory.getErrorMessage(), Lib.getProperty(ADDSALES_PATH, "greaterThanError"));
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 4, description = "Seect bank error message validation")
	public void selectBankErrorValidation() {
		try {
			AddDepositPage addDeposit = new AddDepositPage(driver);
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			SoftAssert soft = new SoftAssert();
			addDeposit.sendKeyToDepositAmountTF(Lib.getProperty(WRITE_PATH, closingCash));
			addDeposit.clickAddDepositBtnInPOpUp();
			Thread.sleep(3000);
			assertEquals(inventory.getErrorMessage(), Lib.getProperty(ADDSALES_PATH, "SelectBankError"));
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 5, description = "Attach button error message validation")
	public void attachBtnError() {
		try {
			AddDepositPage addDeposit = new AddDepositPage(driver);
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			SoftAssert soft = new SoftAssert();
			addDeposit.getSelectBankDropDown().sendKeys(Lib.getProperty(ADDSALES_PATH, "BankName"));
			addDeposit.clickAddDepositBtnInPOpUp();
			Thread.sleep(3000);
			assertEquals(inventory.getErrorMessage(), Lib.getProperty(ADDSALES_PATH, "AddAttachmentError"));
			addDeposit.clickAddAttachment();
			inventory.sendFile(pdfPath);
			inventory.openButtonClick();
			addDeposit.clickAddDepositBtnInPOpUp();
			Thread.sleep(2000);
			soft.assertEquals(inventory.getErrorMessage(), Lib.getProperty(ADDSALES_PATH, "DepositSuccess"),
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
