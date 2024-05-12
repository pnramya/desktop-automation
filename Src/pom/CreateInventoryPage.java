package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class CreateInventoryPage extends WebBase
{
	public CreateInventoryPage(WindowsDriver<WebElement> driver) 
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@FindBy(name = "Inventory")
	private WebElement inventoryOption;
	
	@WindowsFindBy(accessibility = "cmbInventoryAddSupplierNameId")
	private WebElement supplierNameDropDown;
	
	@WindowsFindBy(accessibility = "cmbInventoryAddPONumberId")
	private WebElement poNumberDropDown;
	
	@WindowsFindBy(accessibility = "rbAddInventoryInvoiceNumberId")
	private WebElement invoiceRadioButton;
	
	@WindowsFindBy(accessibility = "rbAddInventoryDcNumberId")
	private WebElement dcNumberRadioButton;
	
	@WindowsFindBy(accessibility = "txtAddInventoryInvoiceNumberId")
	private WebElement invoiceNumberTextField;
	
	@WindowsFindBy(accessibility = "dpAddInventoryInvoiceDateId")
	private WebElement invoiceDateTextField;
	
	@WindowsFindBy(accessibility = "txtAddInventoryQtyId")
	private WebElement qtyTextField;
	
	@WindowsFindBy(accessibility = "txtAddInventoryNetTotalId")
	private WebElement netTotalTextField;
	
	@WindowsFindBy(accessibility = "txtAddInventoryTotalGSTId")
	private WebElement gstTextField;
	
	@WindowsFindBy(accessibility = "txtAddInventoryTransportChargesId")
	private WebElement transportTextField;
	
	@WindowsFindBy(accessibility = "btnAddInventoryResetStockId")
	private WebElement refreshBtn;
	
	@WindowsFindBy(accessibility = "btnAddInventoryAddToStockId")
	private WebElement addToStockBtn;
	
	@WindowsFindBy(accessibility = "btnAddInventoryAddProductCardsId")
	private WebElement addProductBtn;
	
	@WindowsFindBy(accessibility = "btnFileAttachId")
	private WebElement attachButton;
	
	
	@WindowsFindBy(accessibility = "txtAddInvBaseUnitId")
	private WebElement baseUnitTypeDropDown;
	
	@WindowsFindBy(accessibility = "txtAddInvUnitId")
	private WebElement unitQTYTextField;
	
	@WindowsFindBy(accessibility = "txtAddInvSubUnitId")
	private WebElement subUnitQtyTextField;
	
	@WindowsFindBy(accessibility = "dpAddInvManufactureId")
	private WebElement manufactureDateTF;
	
	@WindowsFindBy(accessibility = "dpAddInvExpiryId")
	private WebElement expityDateTextField;
	
	@WindowsFindBy(accessibility = "cmbAddInvProductLocId")
	private WebElement productLocationDropDwn;
	
	@WindowsFindBy(accessibility = "cmbAddInvWarrantyId")
	private WebElement warrantyDropDown;
	
	@WindowsFindBy(accessibility = "txtAddInvRateId")
	private WebElement rateTextField;
	
	@WindowsFindBy(accessibility = "txtAddInvHsnId")
	private WebElement hsnCodeTextField;
	
	
	@WindowsFindBy(accessibility = "txtAddInvGstHeaderId")
	private WebElement gstDropDown;
	
	@FindBy(name = "Please Confirm Falca GSTIN")
	private WebElement gstPopUpText;
	
	@WindowsFindBy(accessibility = "txtGSTConfiirmationGSTINId")
	private WebElement falcaGSTnumberTextField;
	
	@WindowsFindBy(accessibility = "btnUpdateConfirmId")
	private WebElement validateAndSubmitButton;
	
	@WindowsFindBy(accessibility = "Text")
	private WebElement errorMessege;
	
	public void inventoryOptionClick() {
		inventoryOption.click();
	}
	public void addToStockButtonClick() {
		addToStockBtn.click();
	}
	public void refreshButtonClick() {
		refreshBtn.click();
	}
	public void addProductButtonClick() {
		addProductBtn.click();
	}
	public boolean addProductButtonIsDisplayed() {
		return addProductBtn.isDisplayed();
	}
	
	public WebElement getSupplierNameDropDown() {
		return supplierNameDropDown;
	}
	
	public void sendSupplierNameDropDown(String name) {
		supplierNameDropDown.sendKeys(name);
	}
	
	public WebElement getPONumberDropDown() {
		return poNumberDropDown;
	}
	
	
	public void sendPONumberDropDown(String name) {
		poNumberDropDown.sendKeys(name);
	}
	
	public boolean addToStockButtonIsDisplyed() {
		return addToStockBtn.isDisplayed();
	}
	public boolean refreshButtonIsDisplyed() {
		return refreshBtn.isDisplayed();
	}
	public WebElement getBaseUnitTypeDropDown() {
		return baseUnitTypeDropDown;
	}
	public void sendKeyToUnitQTYtextField(String name) {
		unitQTYTextField.clear();
		unitQTYTextField.sendKeys(name);
	}
	public void sendKeyToSubUnitQTYtextField(String name) {
		subUnitQtyTextField.clear();
		subUnitQtyTextField.sendKeys(name);
	}
	public void sendKeyToManufatureDatetextField(String name) {
		manufactureDateTF.sendKeys(name);
	}
	public void sendKeyToExpiryDatetextField(String name) {
		expityDateTextField.sendKeys(name);
	}
	public WebElement getProductLocationDropDown() {
		return productLocationDropDwn;
	}
	public WebElement getWarrantyDropDown() {
		return warrantyDropDown;
	}
	public void sendKeyToRateTextField(String name) {
		rateTextField.clear();
		rateTextField.sendKeys(name);
	}
	public WebElement getGSTDropDown() {
		return gstDropDown;
	}
	public void  invoiceRadioBtnClick() {
		 invoiceRadioButton.click();
	}
	public boolean  invoiceRadioBtnIsSelected() {
		 return invoiceRadioButton.isSelected();
	}
	public void sendKeyToInvoiceNumberTextField(String name) {
		invoiceNumberTextField.clear();
		invoiceNumberTextField.sendKeys(name);
	}
	public void sendKeyToInvoiceDateTextField(String name) {
		invoiceDateTextField.sendKeys(name);
	}
	public void sendKeyToQTYTextField(String name) {
		qtyTextField.clear();
		qtyTextField.sendKeys(name);
	}
	public void sendKeyToNetTotalTextField(String name) {
		netTotalTextField.clear();
		netTotalTextField.sendKeys(name);
	}
	public void sendKeyToTotalGSTTextField(String name) {
		gstTextField.clear();
		gstTextField.sendKeys(name);
	}
	public void sendKeyToTransportChargeTextField(String name) {
		transportTextField.clear();
		transportTextField.sendKeys(name);
	}
	public void attachButton() {
		attachButton.click();
	}
	public boolean gstNumberPopUpIsDisplayd() {
		return gstPopUpText.isDisplayed();
	}
	public void sendKeyToFalcaGstNumber(String name) {
		falcaGSTnumberTextField.sendKeys(name);
	}
	public void validateAndSubmitButton() {
		validateAndSubmitButton.click();
	}
	public String getErrorMessage() {
		return errorMessege.getAttribute("Name");
	}
	public void sendKeyToHSNCodeTF(String name) {
		hsnCodeTextField.sendKeys(name);
	}
	@FindBy(name  = "DSC framework.drawio")
	private WebElement attacableItem;
	
	public void clickAttachableItem() {
		attacableItem.click();
	}
	@WindowsFindBy(accessibility = "1")
	private WebElement openBtn;
	
	public void openButtonClick() {
		openBtn.click();
	}
	
	@WindowsFindBy(className = "Edit")
    private WebElement sendFile;
	
	public void sendFile(String name) {
        sendFile.sendKeys(name);
    }
	
	@WindowsFindBy(accessibility =  "txtAddInvLotId")
    private WebElement lotNo;
	
	public void sendLotNo(String name) {
		lotNo.sendKeys(name);
    }
}
