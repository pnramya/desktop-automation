package generic;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;
import pom.LoginPage;

public class WebBase implements AutoConstant {
	public WindowsDriver<WebElement> driver = null;
	private Process process;
	private ProcessBuilder server;

	@Parameters({ "userName", "passWord" })
	@BeforeMethod
	public void openApplication(String usn, String pwd) throws InterruptedException, IOException {

		Runtime.getRuntime().exec("taskkill /F /IM <WinAppDriver>.exe");
		server = new ProcessBuilder(WinDriver_Path).inheritIO();
		process = server.start();
		Thread.sleep(2000);

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", APP_PATH);
		try {
			driver = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fshopLogin(usn, pwd);
	}

	public void fshopLogin(String usn, String pwd) throws InterruptedException, IOException {
		try {
			LoginPage login = new LoginPage(driver);
			login.sendUserName(usn);
			login.sendPassword(pwd);
			login.clickLoginButton();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
		}
	}

	@AfterMethod
	public void closeApplication() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
