package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class DenominationPage extends WebBase{	
	@WindowsFindBy(accessibility =  "lblEODClosingCashBalanceId")
	private WebElement closingCashBalance;
	
	@WindowsFindBy(accessibility =  "txtEODAddDenomination2000Id")
	private WebElement denomination2000;
	
	@WindowsFindBy(accessibility = "txtEODAddDenomination500Id")
	private WebElement denomination500;
	
	@WindowsFindBy(accessibility = "txtEODAddDenomination200Id")
	private WebElement addDenomination200;
	
	
	@WindowsFindBy(accessibility = "txtEODAddDenomination100Id")
	private WebElement addDenomination100;

	@WindowsFindBy(accessibility =  "txtEODAddDenomination50Id")
	private WebElement addDenomination50;
	
	@WindowsFindBy(accessibility = "txtEODAddDenomination20Id")
	private WebElement addDenomination20;
	
	@WindowsFindBy(accessibility = "txtEODAddDenomination10Id")
	private WebElement addDenomination10;
	
	@WindowsFindBy(accessibility = "txtEODAddDenominationCoinsId")
	private WebElement denominationCoins;
	
	
	@FindBy(name = "EOD (Cash Declaration)")
	private WebElement eodCashDeclaration;
	
	@WindowsFindBy(accessibility = "btnEODAddDenominationId")
	private WebElement addDenominationButton;
	
	@WindowsFindBy(accessibility =  "btnEODAddDenominationSubmitId")
	private WebElement denominationSubmitButton;
	
	public DenominationPage(WindowsDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickEodCashDeclarationTab() {
		eodCashDeclaration.click();
	}
	
	public void clickAddDenominationButton() {
		addDenominationButton.click();
	}

	public void sendDenomination2000(String name) {
		denomination2000.sendKeys(name);
	}
	
	public void sendDenomination500(String name) {
		denomination500.sendKeys(name);
	}
	
	public void sendAddDenomination200(String name) {
		addDenomination200.sendKeys(name);
	}
	
	public void sendAddDenomination100(String name) {
		addDenomination100.sendKeys(name);
	}
	
	public void sendAddDenomination50(String name) {
		addDenomination50.sendKeys(name);
	}
	
	public void sendAddDenomination20(String name) {
		addDenomination20.sendKeys(name);
	}
	
	public void sendAddDenomination10(String name) {
		addDenomination10.sendKeys(name);
	}
	
	public void sendCoins(String name) {
		denominationCoins.sendKeys(name);
	}
	public String getClosingCashBalance() {
		return closingCashBalance.getAttribute("Name");
	}
	
}
