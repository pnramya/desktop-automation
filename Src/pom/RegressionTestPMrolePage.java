package pom;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class RegressionTestPMrolePage extends WebBase
{
	public RegressionTestPMrolePage(WindowsDriver<WebElement> driver) 
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@WindowsFindBy(accessibility = "imgFalcaLogoId")
	private WebElement falcaLoGo;
	
	@WindowsFindBy(xpath = "/Window[2]/ToolBar[1]/Text")
	private WebElement versionNumber;
	
	@FindBy(name = "GST Calculator")
	private WebElement gstCalculator;
	
	@WindowsFindBy(accessibility = "btnNotificationId")
	private WebElement notificationBtn;
	
	@WindowsFindBy(accessibility = "lblwelcome")
	private WebElement roleName;
	
	@WindowsFindBy(accessibility = "Minimize")
	private WebElement minimizeBtn;
	
	@WindowsFindBy(accessibility = "MaximizeRestore")
	private WebElement maximizeRestoreBtn;
	
	@WindowsFindBy(accessibility = "Close")
	private WebElement closeBtn;
	
	@WindowsFindBy(accessibility = "HamburgerButton")
	private WebElement hamburgerBtn;
	
	
	public boolean falcaLogoIsDisplayed() {
		return falcaLoGo.isDisplayed();
	}
	public String versionNumber() {
		return versionNumber.getAttribute("Name");
	}
	public void clickGstCalculator() {
		gstCalculator.click();
	}
	public boolean gstCalculatorIsDisplayed() {
		return gstCalculator.isDisplayed();
	}
	public boolean notificationBtnIsDisplayed() {
		return notificationBtn.isDisplayed();
	}
	public void clickNotificationBtn() {
		 notificationBtn.click();
	}
	
}
