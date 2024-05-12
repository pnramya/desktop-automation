package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class AddDepositPage extends WebBase{
	public AddDepositPage(WindowsDriver<WebElement> driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@FindBy(name = "EOD (Cash Declaration)")
	private WebElement eodOption;
	
	@FindBy(name = "Closing Cash Balance")
	private WebElement closingCashBalText;
	
	@WindowsFindBy(accessibility = "lblEODClosingCashBalanceId")
	private WebElement closingCashBalance;
	
	@WindowsFindBy(accessibility = "btnEODAddDepositId")
	private WebElement addDepositButton;
	
	@WindowsFindBy(accessibility = "dpEODAddDepositDepositDateId")
	private WebElement depositDateTextField;
	
	@WindowsFindBy(accessibility = "txtEODAddDepositDepositAmountId")
	private WebElement depositAmttTextField;
	
	@WindowsFindBy(accessibility = "cmbEODAddDepositSelectBankId")
	private WebElement selectBankDropDown;
	
	@WindowsFindBy(accessibility = "btnEODAddDepositAddAttachmentId")
	private WebElement attachButton;
	
	@WindowsFindBy(accessibility = "btnEODAddDepositAddDepositId")
	private WebElement addDepositBtn;
	
	
	public void clickEodOption() {
		eodOption.click();
	}
	
	public boolean closingCashBalanceTextIsDisplayed() {
		return closingCashBalText.isDisplayed();
	}
	
	public String getCashAmount() {
		return closingCashBalance.getAttribute("Name");
	}
	public void clickAddDeposit() {
		addDepositButton.click();
	}
	public void sendKeyToDepositDateTF(String name) {
		depositDateTextField.sendKeys(name);
	}
	public void sendKeyToDepositAmountTF(String name) {
		depositAmttTextField.clear();
		depositAmttTextField.sendKeys(name);
	}
	public WebElement getSelectBankDropDown() {
		return selectBankDropDown;
	}
	public void clickAddAttachment() {
		attachButton.click();
	}
	public void clickAddDepositBtnInPOpUp() {
		addDepositBtn.click();
	}
		

}
