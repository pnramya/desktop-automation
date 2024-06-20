package script;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Lib;
import generic.WebBase;
import pom.AddSalesPage;
import pom.DenominationPage;

public class AddSales extends WebBase {
	private static Logger logger = Logger.getLogger(AddSales.class.getName());
	private static String wrongMessage = "Wrong error message";
	private static String village = "Village";

	@Test(priority = 1, description = "Validation of save and refresh button")
	public void refreshAndSaveBtnValidation() {
		try {
			AddSalesPage addSales = new AddSalesPage(driver);
			SoftAssert soft = new SoftAssert();
			Thread.sleep(2000);
			// Handle Denomination
			WebElement element = driver.findElement(By.xpath("//Custom[2]/Custom/Custom/Text[1]"));
			// Check if the element is displayed and contains the text
			if (element.isDisplayed() && element.getText().contains("Denomination on")) {
				String text = element.getText();
				addDenomination();
				addSales.clickSubmitButton();
				addSales.salesOptionClick();
			}
			soft.assertTrue(addSales.saveBtnIsDisplayed(), "Save button is not displayed");
			soft.assertTrue(addSales.refreshBtnIsDisplayed(), "Refresh button is not displayed");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 2, description = "Validation of phone number text field error message")
	public void phoneNumberTextFieldErrorValidation() {
		try {
			AddSalesPage addSales = new AddSalesPage(driver);
			SoftAssert soft = new SoftAssert();
			addSales.saveBtnClick();
			Thread.sleep(2000);
			soft.assertEquals(addSales.getErrorMessage(), Lib.getProperty(ADDSALES_PATH, "PhoneNumberTextFieldError"),
					wrongMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 3, description = "Validation of add new customer pop up")
	public void addNewCustomerPopUpValidation() {
		try {
			AddSalesPage addSales = new AddSalesPage(driver);
			SoftAssert soft = new SoftAssert();
			addSales.sendKeyToPhoneNumberTextField(Lib.getProperty(ADDSALES_PATH, "NewPhoneNumberForNewCustomer"));
			soft.assertTrue(addSales.newCustomerPopUpTextIsDisplayed(), "Add new customer pop up is not displayed.");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 4, description = "Validation of phone number text field in add new customer pop up.")
	public void phoneNumberTExtFieldValidationInPopUp() {
		try {
			AddSalesPage addSales = new AddSalesPage(driver);
			SoftAssert soft = new SoftAssert();
			soft.assertTrue(addSales.phoneNumTextFieldInPopUpIsDisplayed(),
					"Phone number text field in pop up is not displayed.");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 5, description = "Customer name error message validation.")
	public void customerNameTextFieldErrorMsgValidation() {
		try {
			AddSalesPage addSales = new AddSalesPage(driver);
			SoftAssert soft = new SoftAssert();
			addSales.saveCustomerDetailsBtnClick();
			Thread.sleep(2000);
			soft.assertEquals(addSales.getErrorMessage(), Lib.getProperty(ADDSALES_PATH, "CustomerNameTextFieldError"),
					wrongMessage);
			Thread.sleep(2000);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 6, description = "Type of customer error message validation.")
	public void customerTypeDropDownErrorMsgValidation() {
		try {
			AddSalesPage addSales = new AddSalesPage(driver);
			SoftAssert soft = new SoftAssert();
			addSales.sendKeyToCustomerNameTextField(Lib.getProperty(ADDSALES_PATH, "CustomerName"));
			addSales.saveCustomerDetailsBtnClick();
			Thread.sleep(2000);
			soft.assertEquals(addSales.getErrorMessage(), Lib.getProperty(ADDSALES_PATH, "TypeOfCustomerError"),
					wrongMessage);
			Thread.sleep(2000);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 7, description = "Pin code error message validation.")
	public void pinCodeErrorMsgValidation() {
		try {
			AddSalesPage addSales = new AddSalesPage(driver);
			SoftAssert soft = new SoftAssert();
			addSales.getTypeOfCustomerDropDown().sendKeys(Lib.getProperty(ADDSALES_PATH, "TypeOfCustomer1"));
			addSales.saveCustomerDetailsBtnClick();
			Thread.sleep(2000);
			soft.assertEquals(addSales.getErrorMessage(), Lib.getProperty(ADDSALES_PATH, "PinCodeError"), wrongMessage);
			Thread.sleep(2000);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 8, description = "village dropdown error message validation.")
	public void villageDropDownErrorMsgValidation() {
		try {
			AddSalesPage addSales = new AddSalesPage(driver);
			SoftAssert soft = new SoftAssert();
			addSales.sendKeyToPinCodeTextField(Lib.getProperty(ADDSALES_PATH, "PinCode"));
			addSales.saveCustomerDetailsBtnClick();
			Thread.sleep(2000);
			soft.assertEquals(addSales.getErrorMessage(), Lib.getProperty(ADDSALES_PATH, "SelectVillageError"),
					wrongMessage);
			Thread.sleep(2000);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 9, description = "GST number text field error message validation.")
	public void gstNumberErrorMsgValidation() {
		try {
			AddSalesPage addSales = new AddSalesPage(driver);
			SoftAssert soft = new SoftAssert();
			addSales.getVillageDropDown().sendKeys(Lib.getProperty(ADDSALES_PATH, village));
			addSales.saveCustomerDetailsBtnClick();
			Thread.sleep(2000);
			soft.assertEquals(addSales.getErrorMessage(), Lib.getProperty(ADDSALES_PATH, "GSTError"), wrongMessage);
			Thread.sleep(2000);
			soft.assertAll();
			addSales.sendKeyToGSTNumTextField(Lib.getProperty(ADDSALES_PATH, "CustomerGSTNumber"));
			addSales.popUpCloseBtnClick();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 10, description = "Existing customer name validation")
	public void existingCustomerNameValidation() {
		try {
			AddSalesPage addSales = new AddSalesPage(driver);
			SoftAssert soft = new SoftAssert();
			addSales.sendKeyToPhoneNumberTextField(Lib.getProperty(ADDSALES_PATH, "ExistingCustomerPhoneNumber"));
			soft.assertEquals(addSales.getCustomerNameText(),
					Lib.getProperty(ADDSALES_PATH, "ExistingCustomerNameValidate"), "Wrong customer name");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 11, description = "Existing customer location validation.")
	public void existingCustomerLocationValidation() {
		try {
			AddSalesPage addSales = new AddSalesPage(driver);
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(addSales.getLocation(), Lib.getProperty(ADDSALES_PATH, village), "Wrong location name");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 12, description = "Edit button validation.")
	public void editButtonValidation() {
		try {
			AddSalesPage addSales = new AddSalesPage(driver);
			SoftAssert soft = new SoftAssert();
			soft.assertTrue(addSales.editBtnIsDisplayed(), "Edit button is not displayed.");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 13, description = "Barcode textfield error message validation.")
	public void barCodeTexfieldValidation() {
		try {
			AddSalesPage addSales = new AddSalesPage(driver);
			SoftAssert soft = new SoftAssert();
			addSales.saveBtnClick();
			soft.assertEquals(addSales.getErrorMessage(),
					Lib.getProperty(ADDSALES_PATH, "SalesHaveAtleastOneProductError"), wrongMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 14, description = "UPI,cash,card error message validation.")

	public void upiCashFieldValidation() {
		try {
			AddSalesPage addSales = new AddSalesPage(driver);
			SoftAssert soft = new SoftAssert();
			addSales.sendKeyToBarcodeTextField(Lib.getProperty(WRITE_PATH, "Barcode"));
			addSales.saveBtnClick();
			Thread.sleep(2000);
			soft.assertEquals(addSales.getErrorMessage(), Lib.getProperty(ADDSALES_PATH, "UPIerror"), wrongMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 15, description = "Invalid total error message validation.")

	public void invalidNetTotalErrorValidation() {
		try {
			AddSalesPage addSales = new AddSalesPage(driver);
			SoftAssert soft = new SoftAssert();
			addSales.sendKeytoCashTextField(Lib.getProperty(ADDSALES_PATH, "CashAmount"));
			addSales.saveBtnClick();
			Thread.sleep(3000);
			soft.assertEquals(addSales.getErrorMessage(), Lib.getProperty(ADDSALES_PATH, "HalfCashError"),
					wrongMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 16, description = "Maximum quantity error message validation.")

	public void maximumQTYerror() {
		try {
			AddSalesPage addSales = new AddSalesPage(driver);
			SoftAssert soft = new SoftAssert();
			addSales.clearCashTextField();
			addSales.sendKeyToSellingQtyTextField(Lib.getProperty(ADDSALES_PATH, "OverSellingQty"));
			addSales.clickCashTextField();
			Thread.sleep(2000);
			soft.assertEquals(addSales.getErrorMessage(), Lib.getProperty(ADDSALES_PATH, "MaximumSellingQtyError"),
					wrongMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 17, description = "Valid UPI number error message validation.")

	public void upiNumberErrorValidation() {
		try {
			AddSalesPage addSales = new AddSalesPage(driver);
			SoftAssert soft = new SoftAssert();
			addSales.sendKeyToSellingQtyTextField(Lib.getProperty(ADDSALES_PATH, "SellingQty"));
			addSales.sendKeytoCashTextField(Lib.getProperty(ADDSALES_PATH, "CashAmount"));
			addSales.sendKeytoUPITextField(Lib.getProperty(ADDSALES_PATH, "UPIamount"));
			addSales.saveBtnClick();
			Thread.sleep(2000);
			soft.assertEquals(addSales.getErrorMessage(), Lib.getProperty(ADDSALES_PATH, "UPINumberError"),
					wrongMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 18, description = "Sale success message validation.")

	public void sellingSuccessValidation() {
		try {
			AddSalesPage addSales = new AddSalesPage(driver);
			SoftAssert soft = new SoftAssert();
			addSales.sendKeyToSellingQtyTextField(Lib.getProperty(ADDSALES_PATH, "SellingQty"));
//			addSales.sendKeyToCoupenTextField(
//					Lib.getProperty(ADDSALES_PATH, "CoupenCode") + Lib.getRandomNumber(111, 99999));
			// Will open once delete query is implemented.
			addSales.sendKeyToPhoneNumberTextField(Lib.getProperty(ADDSALES_PATH, "ExistingCustomerPhoneNumber"));
			addSales.saveBtnClick();
			Thread.sleep(1000);
			//Enter valid amount for UPI/Cash/Card
			soft.assertEquals(addSales.getErrorMessage(), Lib.getProperty(ADDSALES_PATH, "EnterValidAmountUPIAndCash"),
					wrongMessage);
			// Add new customer
			String mobNum = Lib.getProperty(ADDSALES_PATH, "CreatingNewCustomerNumber")
					+ Lib.getRandomNumber(11111, 99999);
			addSales.sendKeyToPhoneNumberTextField(mobNum);
			addSales.sendKeyToCustomerNameTextField(Lib.getProperty(ADDSALES_PATH, "CustomerName"));// Random name
			addSales.getTypeOfCustomerDropDown().sendKeys(Lib.getProperty(ADDSALES_PATH, "TypeOfCustomer2"));
			addSales.sendKeyToPinCodeTextField(Lib.getProperty(ADDSALES_PATH, "PinCode"));
			addSales.getVillageDropDown().sendKeys(Lib.getProperty(ADDSALES_PATH, village));
			addSales.saveCustomerDetailsBtnClick();
			Thread.sleep(1000);
			addSales.sendKeyToPhoneNumberTextField(mobNum);
			addSales.sendKeytoCashTextField(Lib.getProperty(ADDSALES_PATH, "cashAmt1"));
			addSales.clearUPITextField();
			addSales.saveBtnClick();
		Thread.sleep(2000);
		Thread.sleep(1000);
			soft.assertEquals(addSales.getErrorMessage(), Lib.getProperty(ADDSALES_PATH, "SaleSuccess"), wrongMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	public void addDenomination() {
		try {
			DenominationPage denominationPage = new DenominationPage(driver);
			//denominationPage.clickEodCashDeclarationTab();
			int closingCashBalance = Integer.parseInt(denominationPage.getClosingCashBalance());
			logger.log(Level.INFO, "denomination.getClosingCashBalance()" + denominationPage.getClosingCashBalance());
			denominationPage.clickAddDenominationButton();

			int[] denominations = { 2000, 500, 200, 100, 50, 20, 10 };

			logger.log(Level.INFO, "closingCashBalance: " + closingCashBalance);

			for (int denomination : denominations) {
				if (closingCashBalance >= denomination) {
					int count = closingCashBalance / denomination;
					closingCashBalance %= denomination;
					logger.log(Level.INFO, "Denomination: " + denomination + " x " + count);

					// Send method based on the denomination
					sendDenomination(denomination, count, denominationPage);
					Actions action = new Actions(driver);
					action.sendKeys(Keys.DELETE).perform();
				}
			}

			// If there's any remaining Balance, you can handle it here (e.g., as change).
			if (closingCashBalance > 0) {
				// logger.log(Level.INFO,"Remaining Amount: " + closingCashBalance);
			}
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	// Move the sendDenomination method outside of addProductValidation method
	public static void sendDenomination(int denomination, int count, DenominationPage denominationPage) {
		switch (denomination) {
		case 2000:
			denominationPage.sendDenomination2000(String.valueOf(count));
			break;
		case 500:
			denominationPage.sendDenomination500(String.valueOf(count));
			break;
		case 200:
			denominationPage.sendAddDenomination200(String.valueOf(count));
			break;
		case 100:
			denominationPage.sendAddDenomination100(String.valueOf(count));
			break;
		case 50:
			denominationPage.sendAddDenomination50(String.valueOf(count));
			break;
		case 20:
			denominationPage.sendAddDenomination20(String.valueOf(count));
			break;
		case 10:
			denominationPage.sendAddDenomination10(String.valueOf(count));
			break;

		case 1:
			denominationPage.sendCoins(String.valueOf(count));
			break;
		default:
			logger.log(Level.INFO, "Unsupported denomination: " + denomination);
		}
	}

}
