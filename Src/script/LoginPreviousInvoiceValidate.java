package script;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.AutoConstant;
import generic.DataProviderExcelUtility;
import generic.Lib;
import io.appium.java_client.windows.WindowsDriver;
import pom.AddSalesPage;
import pom.LoginPage;
import pom.ViewSalesPage;

public class LoginPreviousInvoiceValidate implements AutoConstant
{
	public static String customerName;
	public static boolean environment=true;
	public static int numb=0;
	public static boolean flag;
	public static String invoiceNumber;
	public WindowsDriver<WebElement> driver = null;
	private Process process;
	private ProcessBuilder server;
	
	 @DataProvider(name = "Authentication")
	    public Object[][] Authentication() throws Exception
	 		{
	         Object[][] testObjArray = DataProviderExcelUtility.getTableArray(datProviderExcel,"Sheet1");
	         return (testObjArray);
			}
	 
	 @Test(dataProvider = "Authentication")
	 public void PreviousInvoiceDownload(String sUserName,String sPassword) throws IOException
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
				else 
				{
					cap.setCapability("app", APP_PATH);
				}
				try {
					driver = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723"), cap);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    LoginPage login = new LoginPage(driver);
			login.sendUserName(sUserName);
			login.sendPassword(sPassword);
			login.clickLoginButton();
			Thread.sleep(4000);
			getPreviousInvoiceNumber();
			
			//driver.close();
		 }
		 catch (Exception e) 
		 {
			 Assert.fail("Failed due to login configuration issue");
		 }
	 }
	 
	 public void getPreviousInvoiceNumber() 
	 {
		try 
		{
			AddSalesPage sale=new AddSalesPage(driver);	
			String strName = sale.getStoreName();
			ViewSalesPage viewSale=new ViewSalesPage(driver);
			Thread.sleep(5000);
			viewSale.clickViewSales();
			Thread.sleep(2000);
			//3 months
			viewSale.sendKeysToFromDateFilter("01-03-2024");
			viewSale.sendKeyToToDateFilter("29-04-2024");
			viewSale.clickOnSearchButton();
			try 
			{
				flag=viewSale.expandBtnIsDisplayed();
			} catch (Exception e) 
			{
				flag=false;
			}
			if(flag)
			{
				customerName=viewSale.getCustomerName();
				invoiceNumber=viewSale.getFirstInvoiceNumber();
				viewSale.clickDownloadBtn();
				Thread.sleep(7000);
				numb++;
				Lib.writePropToAnyFile(PREVIOUS_INV, String.valueOf(numb), invoiceNumber+"  "+strName);
			}
			else {
				Reporter.log("6 months data is not available");
				Assert.fail("6 months data is not available");
			}
			
		}
		catch (Exception e) {
			driver.quit();
			Reporter.log(e.getMessage(), true);
		}
	 }
}

