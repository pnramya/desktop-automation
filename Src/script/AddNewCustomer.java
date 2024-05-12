package script;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import generic.Lib;
import generic.WebBase;
import pom.IndentPlanByStorePersonPage;
import pom.StorePersionRegressionPage;

public class AddNewCustomer extends WebBase {
	private String salesCustomerPoNumber="SalesCustomerPoNumber";
	@Test(priority = 1, description = "Validation of customerdetails popup fields")
	public void addNewCustomer() {
		try {
			StorePersionRegressionPage storePerson = new StorePersionRegressionPage(driver);
			Actions act = new Actions(driver);
			for (int i = 0; i < 10; i++) {
				long phno = generateNextNumber();
				storePerson.sendSalesPhno(Long.toString(phno));
				act.sendKeys(Keys.ENTER).perform();
				long newTestData = Long.parseLong(Lib.getProperty(WRITE_PATH, "NewTestData"));
				storePerson.sendCustomerNameField("Test Data" + Lib.getProperty(WRITE_PATH, "NewTestData"));
				Lib.writeProperties(salesCustomerPoNumber, Long.toString(newTestData + 1));
				storePerson.sendTypeOfCustomer("store");
				storePerson.sendPincode("58210");
				act.sendKeys(Keys.DELETE).perform();
				act.sendKeys("3").perform();
				act.sendKeys(Keys.ENTER).perform();
				storePerson.clickVillageDropdown();
				act.sendKeys(Keys.PAGE_DOWN).perform();
				act.sendKeys(Keys.ENTER).perform();
				storePerson.clickSaveCustomerDetailsButton();
				storePerson.clickCustomerDetailsCloseButton();
			}

		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	public synchronized long generateNextNumber() throws IOException {
		long phno = Long.parseLong(Lib.getProperty(WRITE_PATH, salesCustomerPoNumber));
		phno = phno + 1;
		Lib.writeProperties(salesCustomerPoNumber, Long.toString(phno)); // Update the property
		return phno;
	}
}
