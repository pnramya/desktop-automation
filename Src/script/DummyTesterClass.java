package script;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;

import generic.AutoConstant;
import generic.Lib;
import generic.PdfValidatorUtility;
import io.appium.java_client.windows.WindowsDriver;
import pom.AddSalesPage;
import pom.CreateInventoryPage;
import pom.DenominationPage;
import pom.GenerateBarcodePage;
import pom.LoginPage;

public class DummyTesterClass implements AutoConstant
{
	public static String barcode=null;
	public static String invoiceNumber;
	public static int numb=0;
	public static boolean environment=false;
	public static boolean flag;
	public static boolean denominationflag;
	public static WindowsDriver<WebElement> driver = null;
	public static Process process;
	public static ProcessBuilder server;
	public static void main(String[] args) 
	{
		 try 
		 {
			    Runtime.getRuntime().exec("taskkill /F /IM <WinAppDriver>.exe");
				server = new ProcessBuilder(WinDriver_Path).inheritIO();
				process = server.start();
				Thread.sleep(2000);

				DesiredCapabilities cap = new DesiredCapabilities();
				if(environment)
				{
					cap.setCapability("app", PRE_PROD_PATH);
				}
				else {
				cap.setCapability("app", APP_PATH);
				}
				try {
					driver = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723"), cap);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		    LoginPage login = new LoginPage(driver);
			login.sendUserName("hangalsp");
			login.sendPassword("admin");
			login.clickLoginButton();
			Thread.sleep(6000);
			CreateInventoryPage inv=new CreateInventoryPage(driver);
			Thread.sleep(3000);
			try 
			{
			  flag=inv.addToStockButtonIsDisplyed();
			}
			catch(Exception e)
			{
				flag=false;
			}
			if(flag)
			{
				barcode=new DummyTesterClass().picUpBarcode();
				System.out.println(barcode);
				Lib.writeProp2("Barcode", barcode);
				driver.quit();
			}
			else if(!(Lib.getProperty(WRITE_PATH_2, "Barcode")).equals("null"))
			{
				AddSalesPage sale=new AddSalesPage(driver);	
				try
				{
					denominationflag=sale.getSavebutton().getAttribute("IsEnabled").equals("False");
					
				}
				catch(Exception e)
				{
					denominationflag=false;
				}
				if(denominationflag) 
				{
					sale.clickEod();
					//new AddSales().addDenomination();
					try {
						DenominationPage denominationPage = new DenominationPage(driver);
						//denominationPage.clickEodCashDeclarationTab();
						int closingCashBalance = Integer.parseInt(denominationPage.getClosingCashBalance());
						//logger.log(Level.INFO, "denomination.getClosingCashBalance()" + denominationPage.getClosingCashBalance());
						denominationPage.clickAddDenominationButton();

						int[] denominations = { 2000, 500, 200, 100, 50, 20, 10,1,2,3,4,5,6,7,8,9 };

						//logger.log(Level.INFO, "closingCashBalance: " + closingCashBalance);

						for (int denomination : denominations) {
							if (closingCashBalance >= denomination) {
								int count = closingCashBalance / denomination;
								closingCashBalance %= denomination;
								//logger.log(Level.INFO, "Denomination: " + denomination + " x " + count);

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
					sale.clickSubmitButton();
					sale.salesOptionClick();
					Thread.sleep(3000);
				}
				sale.sendKeyToPhoneNumberTextField("9110863957");
				invoiceNumber=sale.getInvoiceNumber();
				System.out.println(invoiceNumber);
				sale.sendKeyToBarcodeTextField(Lib.getProperty(WRITE_PATH_2, "Barcode"));
				Lib.writeProp2("Barcode", "null");
				sale.sendKeytoCashTextField(sale.getSellingPrice());
				String strName = sale.getStoreName();
				sale.saveBtnClick();
				Thread.sleep(9000);
				numb++;
				Lib.writeProperties(String.valueOf(numb), invoiceNumber+"  "+strName);
//				PdfValidatorUtility validatePdf=new PdfValidatorUtility();
//				validatePdf.validate(invoiceNumber, invoiceNumber);
				
			}
			driver.quit();
		 } 
		 catch (Exception e)
		 {
			driver.quit();
			Reporter.log(e.getMessage(), true);
		 }
	 }
	 public String picUpBarcode() throws InterruptedException 
	 {
		 GenerateBarcodePage barcode = new GenerateBarcodePage(driver);
		 barcode.stockOptionClick();
//		 barcode.getSearchProductTextField().sendKeys("UREA NEEM COATED 45KG");
//		 barcode.getSearchProductTextField().clear();
//		 barcode.getSearchProductTextField().sendKeys("UREA NEEM COATED 45KG");
		 Thread.sleep(2000);
		 Lib.SelectDropDownOptionByVisibleName(driver, barcode.getCategoryDropDown(), "Tools & Implements");
		 barcode.searchBtnClick();
		 Thread.sleep(1000);
		 try 
		 { 
		 boolean found = barcode.getErrorMessage().equals("No Data Found");
		 if(found)
		 {
			 return null;
		 }
		 else 
		 {
			 barcode.getAvailableqtyFilt().click();
			 Thread.sleep(1000);
			 barcode.getAvailableqtyFilt().click();
			 Thread.sleep(1000);
			 barcode.getFirstBarPrintButton().click();
			 String bar=barcode.getBarcode(); 
			 barcode.popUpCloseBtnClick();
			 return bar;
			  
		 }
		 }
		 catch(Exception e)
		 {
		  System.out.println(e.getStackTrace());
		  barcode.getAvailableqtyFilt().click();
		  Thread.sleep(1000);
		  barcode.getAvailableqtyFilt().click();
		  Thread.sleep(1000);
		  barcode.getFirstBarPrintButton().click();
		  String bar=barcode.getBarcode(); 
		  barcode.popUpCloseBtnClick();
		  return bar;
		 }
	}
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
			case 2:
				denominationPage.sendCoins(String.valueOf(count));
				break;
			case 3:
				denominationPage.sendCoins(String.valueOf(count));
				break;
			case 4:
				denominationPage.sendCoins(String.valueOf(count));
				break;
			case 5:
				denominationPage.sendCoins(String.valueOf(count));
				break;
			case 6:
				denominationPage.sendCoins(String.valueOf(count));
				break;
			case 7:
				denominationPage.sendCoins(String.valueOf(count));
				break;
			case 8:
				denominationPage.sendCoins(String.valueOf(count));
				break;
			case 9:
				denominationPage.sendCoins(String.valueOf(count));
				break;
			default:
				//logger.log(Level.INFO, "Unsupported denomination: " + denomination);
			}
		}

}
