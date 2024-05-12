package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class AddSupplierByPurchaseManagerPage extends WebBase {
	private WebDriverWait wait;
	private String value="Value.Value";
	@WindowsFindBy(accessibility = "reason")
	private WebElement reason;

	@WindowsFindBy(accessibility = "btnupdate")
	private WebElement btnupdate;

	@WindowsFindBy(accessibility = "tackingid")
	private WebElement trackingId;

	@WindowsFindBy(accessibility = "btnaddsupplier")
	private WebElement indentReceivedUpdateBtn;

	@WindowsFindBy(accessibility = "btnIndentPICSContinueId")
	private WebElement continueButton;

	@WindowsFindBy(accessibility = "btnIndentPICSContinue1Id")
	private WebElement addProductcontinueButton;

	@WindowsFindBy(accessibility = "cmbIndentPICSSupplierId")
	private WebElement indentSupplierDropDown;

	@WindowsFindBy(accessibility = "rbIndentPICSExclusiveGSTId")
	private WebElement indentExclusiveGSTRedioButton;

	@WindowsFindBy(accessibility = "rbIndentPICSInclusiveGSTId")
	private WebElement indentInclusiveGSTRedioButton;

	@WindowsFindBy(accessibility = "txtIndentPICSContinueRequestedQtyId")
	private WebElement requestedQty;

	@WindowsFindBy(accessibility = "txtIndentPICSContinueTMQtyId")
	private WebElement tmQuantity;

	@WindowsFindBy(accessibility = "txtIndentPICSsContinueRMQtyId")
	private WebElement rmQuantity;

	@WindowsFindBy(accessibility = "txtIndentPICSContinueRSPId")
	private WebElement indentRetailSellingPrice;

	@WindowsFindBy(accessibility = "txtIndentPICSContinueAvailableQtyId")
	private WebElement availableQuantity;

	@WindowsFindBy(accessibility = "txtIndenPICSContinueGSTId")
	private WebElement sendGST;

	@WindowsFindBy(accessibility = "tbIndentPICSContinue1ProductTotalId")
	private WebElement productTotalWithGST;

	@WindowsFindBy(xpath = "//Window/Custom/Text[12]")
	private WebElement totalGst;

	@WindowsFindBy(accessibility = "rbIndenPICSContinue1FullId")
	private WebElement paymentModeFullRedioButton;

	@WindowsFindBy(accessibility = "btnIndentPICSContinue1SaveId")
	private WebElement saveButton;

	@WindowsFindBy(accessibility = "dpIndentPICSContinueETAId")
	private WebElement estimatedDate; // ETA=Estimated Time

	@WindowsFindBy(accessibility = "txtIndentPICSContinueEstimatedPriceId")
	private WebElement estimatedPricePrice; // ETA=Estimated Time

	@WindowsFindBy(accessibility = "btnUpdateConfirmId")
	private WebElement yesButton;

	// Initializing the web element
	public AddSupplierByPurchaseManagerPage(WindowsDriver<WebElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void sendReason(String name) {
		reason.sendKeys(name);
	}

	public void clickUpdateBtn() {
		btnupdate.click();
	}

	public void sendTrackingId(String name) {
		trackingId.sendKeys(name);
	}

	public void clickIndentReceivedUpdateBtn() {
		indentReceivedUpdateBtn.click();
	}

	public void clickcontinueButton() {
		continueButton.click();
	}

	public void clickAddProductcontinueButton() {
		addProductcontinueButton.click();
	}

	public void sendindentSupplierDropDown(String name) {
		indentSupplierDropDown.sendKeys(name);
	}

	public WebElement getIndentSupplierDropDown() {
		 return indentSupplierDropDown;
	}
	

	public void clickIndentExclusiveGSTRedioButton() {
		indentExclusiveGSTRedioButton.click();
	}

	public void clickIndentInclusiveGSTRedioButton() {
		indentInclusiveGSTRedioButton.click();
	}
	
	
	public String getRequestedQuantity() {
		return requestedQty.getAttribute(value);
	}

	public String getTMQuantity() {
		return tmQuantity.getAttribute(value);
	}

	public String getRmQuantity() {
		return rmQuantity.getAttribute(value);
	}

	public String getIndentRetailSellingPrice() {
		return indentRetailSellingPrice.getAttribute(value);
	}

	public void sendAvailableQuantity(String name) {
		availableQuantity.sendKeys(name);
	}

	public void sendGST(String name) {
		sendGST.sendKeys(name);
	}

	public String getProductTotalWithGST() {
		return productTotalWithGST.getAttribute("Name");
	}

	public String getTotalGst() {
		return totalGst.getAttribute("Name");
	}

	public void clickPaymentModeFullRedioButton() {
		paymentModeFullRedioButton.click();
	}

	public void clickSaveButton() {
		saveButton.click();
	}
	public void sendEstimatedDate(String name) {
		estimatedDate.sendKeys(name);
	}

	public void sendEstimatedPricePrice(String name) {
		estimatedPricePrice.sendKeys(name);
	}

	@FindBy(name = "Confirmation")
	private WebElement paymentConfirmation;

	public boolean paymentConfirmationisDisplayed() {
		return paymentConfirmation.isDisplayed();
	}

	public void clickYesButton() {
		yesButton.click();
	}
	
	@WindowsFindBy(accessibility = "btnIndentPICSContinue1Id")
	private WebElement continueBtn;
	public void clickContinueBtn() {
		continueBtn.click();
	}
}
