package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class CreateSupplierPage extends WebBase {
	private WebDriverWait wait;
	
	@WindowsFindBy(accessibility = "PART_Toggle")
	private WebElement addSupplierButton;
	
	@FindBy(name = "Suppliers")
	private WebElement suppliersTab;
	
	@FindBy(name = "Manufacturer")
	private WebElement manufacturer;
	
	@WindowsFindBy(accessibility = "txtManageSuppliersSupplierNameId")
	private WebElement supplierName;
	
	@WindowsFindBy(accessibility = "txtManageSuppliersGSTNumberId")
	private WebElement suppliersGSTNumber;
	
	@WindowsFindBy(accessibility = "cmbManageSuppliersSupplierTypeId")
	private WebElement supplierType;
	
	@WindowsFindBy(accessibility = "txtManageSuppliersPhoneId")
	private WebElement supplierPhno;
	
	@WindowsFindBy(accessibility = "txtManageSuppliersEmailId")
	private WebElement supplierEmail;
	
	@WindowsFindBy(accessibility = "txtManageSuppliersStreetId")
	private WebElement supplierStreet;
	
	@WindowsFindBy(accessibility = "txtManageSuppliersTallyCodeId")
	private WebElement supplierTally;
	
	@WindowsFindBy(accessibility = "cmbManageSuppliersSelectStateId")
	private WebElement supplierState;
	
	@WindowsFindBy(accessibility = "txtManageSuppliersCityId")
	private WebElement supplierCity;
	
	@WindowsFindBy(accessibility = "txtManageSuppliersPinCodeId")
	private WebElement supplierPinCode;
	
	@WindowsFindBy(accessibility = "cmbManageSuppliersSelectDistrictId")
	private WebElement supplierDistrict;
	
	// Initializing the web element
		public CreateSupplierPage(WindowsDriver<WebElement> driver) {
			this.driver = driver;
			wait = new WebDriverWait(driver, 10);
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	
	public void clickAddSupplierButton() {
		addSupplierButton.click();
	}
	
	public void clickSuppliersTab() {
		suppliersTab.click();
	}
	
	public void clickManufacturer() {
		manufacturer.click();
	}
	
	public void clickSupplierType() {
		supplierType.click();
	}
	public void sendKeySupplierName(String name) {
		supplierName.sendKeys(name);
	}
	
	public void sendKeySuppliersGSTNumber(String name) {
		suppliersGSTNumber.sendKeys(name);
	}
	
	public void sendKeySupplierPhno(String name) {
		supplierPhno.sendKeys(name);
	}
	
	public void sendKeySupplierEmail(String name) {
		supplierEmail.sendKeys(name);
	}
	
	public void sendKeySupplierPinCode(String name) {
		supplierPinCode.sendKeys(name);
	}
	
	public void sendKeySupplierStreet(String name) {
		supplierStreet.sendKeys(name);
	}
	
	public void sendKeySupplierTally(String name) {
		supplierTally.sendKeys(name);
	}
	
	public void sendKeySupplierDistrict(String name) {
		supplierDistrict.sendKeys(name);
	}
	
	public void sendKeySupplierState(String name) {
		supplierState.sendKeys(name);
	}
	
	public void sendKeysupplierCity(String name) {
		supplierCity.sendKeys(name);
	}
	
	
	@WindowsFindBy(accessibility = "btnManageSuppliersAddId")
	private WebElement suppliersAddButton;
	
	public void clickSuppliersAddButton() {
		suppliersAddButton.click();
	}
	
	@WindowsFindBy(accessibility = "rbSupplierDetailsViewMSMERegisteredNoId")
	private WebElement noRedioButton;
	
	public void clickTheNoRadioButton() {
		noRedioButton.click();
	}
	
	
	@WindowsFindBy(accessibility = "cmbSupplierDetailsViewAddBankDetailsBankNameId")
	private WebElement bankName;
	
	public void sendKeyBankName(String name) {
		bankName.sendKeys(name);
	}	
	@WindowsFindBy(accessibility = "txtSupplierDetailsViewAddBankDetailsBranchNameId")
	private WebElement branchName;
	
	public void sendKeyBranchName(String name) {
		branchName.sendKeys(name);
	}
	
	@WindowsFindBy(accessibility = "txtSupplierDetailsViewAddBankDetailsAccountNumberId")
	private WebElement accountNumber;
	
	public void sendKeyAccountNumber(String name) {
		accountNumber.sendKeys(name);
	}
	
	@WindowsFindBy(accessibility = "txtSupplierDetailsViewAddBankDetailsIFSCCodeId")
	private WebElement ifscCode;
	
	public void sendKeyifscCode(String name) {
		ifscCode.sendKeys(name);
	}
	
	@WindowsFindBy(accessibility = "rbSupplierDetailsViewAddBankDetailsSavingId")
	private WebElement saveRedioButton;
	
	public void clickSaveRadioButton() {
		saveRedioButton.click();
	}
	
	
	@WindowsFindBy(accessibility = "btnSupplierDetailsViewAddBankDetailsAddId")
	private WebElement addBank;
	
	public void clickAddBankButton() {
		addBank.click();
	}
	
	@WindowsFindBy(accessibility ="AddsupplierDetailUpdateBtnId")
	private WebElement updateButton;
	
	public void clickUpdateButton() {
		updateButton.click();
	}
	
	
	@WindowsFindBy(accessibility = "tiSuppliers")
	private WebElement supplierTab;
	
	public void clickSupplierTab() {
		supplierTab.click();
	}
	
	@WindowsFindBy(accessibility = "txtSupplierDetailsViewAddBankDetailsAttachFileId")
	private WebElement attachFile;
	
	public void attachButton() {
		attachFile.click();
	}
	
	@WindowsFindBy(className = "Edit")
    private WebElement sendFile;
	
	public void sendFile(String name) {
        sendFile.sendKeys(name);
    }
	
	@WindowsFindBy(accessibility = "1")
	private WebElement openBtn;
	
	public void openButtonClick() {
		openBtn.click();
	}
	
	@WindowsFindBy(accessibility = "Text")
	private WebElement errorMessege;
	
	public String getErrorMessage() {
		return errorMessege.getAttribute("Name");
	}
}
