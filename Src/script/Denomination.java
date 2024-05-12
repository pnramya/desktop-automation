package script;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import generic.WebBase;
import io.appium.java_client.windows.WindowsDriver;
import pom.DenominationPage;

public class Denomination extends WebBase {
	@Test(priority = 1, description = "New selling price error message validation")
	public void addDenomination() {
		try {
			DenominationPage denominationPage = new DenominationPage(driver);
			denominationPage.clickEodCashDeclarationTab();
			int closingCashBalance = Integer.parseInt(denominationPage.getClosingCashBalance());
			System.out.println("denomination.getClosingCashBalance()" + denominationPage.getClosingCashBalance());
			denominationPage.clickAddDenominationButton();
			
			int[] denominations = { 2000, 500, 200, 100, 50, 20, 10 };

			System.out.println("closingCashBalance: " + closingCashBalance);

			for (int denomination : denominations) {
				if (closingCashBalance >= denomination) {
					int count = closingCashBalance / denomination;
					closingCashBalance %= denomination;
					System.out.println("Denomination: " + denomination + " x " + count);

					// Send  method based on the denomination
					sendDenomination(denomination, count, denominationPage);
					Actions action=new Actions(driver);
					action.sendKeys(Keys.DELETE).perform();
				}
			}

			// If there's any remaining Balance, you can handle it here (e.g., as change).
			if (closingCashBalance > 0) {
				System.out.println("Remaining Amount: " + closingCashBalance);
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
				denominationPage.sendAddDenomination10(String.valueOf(count));
				break;
			default:
				System.out.println("Unsupported denomination: " + denomination);
		}
	}
}
