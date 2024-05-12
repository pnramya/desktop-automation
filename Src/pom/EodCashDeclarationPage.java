package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class EodCashDeclarationPage extends WebBase
{
	public EodCashDeclarationPage(WindowsDriver<WebElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@WindowsFindBy(xpath = "//Custom[2]/Custom/Custom/Text[1]")
	private WebElement denominationText;
	
	String denom="Denomination on 29-08-2023 not found";
	
	@FindBy(name = "EOD (Cash Declaration)")
	private WebElement eodOption;
	
	@FindBy(name = "Denomination Summary")
	private WebElement denominationPageText;
	
	@WindowsFindBy(accessibility = "btnEODRefresh1Id")
	private WebElement refreshBtn;
	
	@WindowsFindBy(accessibility = "btnEODFlyoutViewId")
	private WebElement viewBtn;
	
	@WindowsFindBy(accessibility = "btnEODAddDenominationId")
	private WebElement addDenominationBtn;
	
	@WindowsFindBy(accessibility = "txtEODAddDenomination2000Id")
	private WebElement twoThousandField;
	
	@WindowsFindBy(accessibility = "txtEODAddDenomination500Id")
	private WebElement fiveHundredField;
	
	@WindowsFindBy(accessibility = "txtEODAddDenomination200Id")
	private WebElement twoHundred;
	
	@WindowsFindBy(accessibility = "txtEODAddDenomination100Id")
	private WebElement hundred;
	
	@WindowsFindBy(accessibility = "txtEODAddDenomination50Id")
	private WebElement fifty;
	
	@WindowsFindBy(accessibility = "txtEODAddDenomination20Id")
	private WebElement twenty;
	
	@WindowsFindBy(accessibility = "txtEODAddDenomination10Id")
	private WebElement ten;
	
	@WindowsFindBy(accessibility = "btnEODAddDenominationSubmitId")
	private WebElement submitBtn;
	
	@WindowsFindBy(accessibility = "btnEODAddDenominationExitId")
	private WebElement denominationPopUpCloseBtn;
	
	@WindowsFindBy(xpath = "/Window[2]/Window/Custom/Text[3]/Text")
	private WebElement cashInHand;
	
	
	public String getDenominationWarning() {
		return denominationText.getAttribute("Name");
	}
	public void eodOptionClick() {
		eodOption.click();
	}
	public boolean denominationTextInEodPageIsDisplayed() {
		return denominationPageText.isDisplayed();
	}
	
	public int getCashInHand() {
		return Integer.valueOf(cashInHand.getAttribute("Name"));
	}
	
	public void submitBtnClick() {
		submitBtn.click();
	}
	public void sendKeyToTwoThousand(String name) {
		twoThousandField.sendKeys(name);
	}
	public void sendKeyToFiveHundered(String name) {
		fiveHundredField.sendKeys(name);
	}
	public void sendKeyToTwoHundered(String name) {
		twoHundred.sendKeys(name);
	}
	public void sendKeyToHundered(String name) {
		hundred.sendKeys(name);
	}
	public void sendKeyToFifty(String name) {
		fifty.sendKeys(name);
	}
	public void sendKeyToTwenty(String name) {
		twenty.sendKeys(name);
	}
	public void sendKeyToTen(String name) {
		ten.sendKeys(name);
	}
}
