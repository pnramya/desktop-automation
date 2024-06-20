package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class AddSalesPage 
extends WebBase{
	//Declaring parameterized constructor to initialize driver and Web element
	public AddSalesPage(WindowsDriver<WebElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@FindBy(xpath ="//Custom[2]/List[1]/ListItem[5]")
	private WebElement salesOption;
	
	@WindowsFindBy(accessibility = "btnSalesViewResetSalesId")
	private WebElement refreshBtnInSalesPage;
	
	@WindowsFindBy(accessibility = "btnSalesViewAddSalesId")
	private WebElement saveButton;
	
	@FindBy(name = "View Sales")
	private WebElement viewSalesLink;
	
	@WindowsFindBy(accessibility = "txtSalesSearchPhoneId")
	private WebElement phoneNumberTextField;
	
	@WindowsFindBy(accessibility = "txtSalesScanorenterbarcode")
	private WebElement barcodeTextField;
	
	@FindBy(name = "New Customer Details")
	private WebElement newCustomerDetailsPopUp;
	
	@WindowsFindBy(accessibility = "txtSalesAddPhonePhoneNumberId")
	private WebElement phoneNumberTextFieldInPopUp;
	
	@WindowsFindBy(accessibility = "txtSalesAddPhoneCustomerNameId")
	private WebElement customerNameTextField;
	
	@WindowsFindBy(accessibility = "cmbSalesAddPhoneCustomerTypeId")
	private WebElement typeOfCustomerDropDown;
	
	@WindowsFindBy(accessibility = "txtSalesAddPhonePinCodeId")
	private WebElement pincodeTextField;
	
	@WindowsFindBy(accessibility = "cmbSalesAddPhoneStateId")
	private WebElement stateDropDown;
	
	@WindowsFindBy(accessibility = "cmbSalesAddPhoneDistrictId")
	private WebElement districtDropdown;
	
	@WindowsFindBy(accessibility = "cmbSalesAddPhoneVillageId")
	private WebElement villageDropDown;
	
	@WindowsFindBy(accessibility = "txtSalesAddPhoneGSTNumberId")
	private WebElement gstNumberTextField;
	
	@WindowsFindBy(accessibility = "btnSalesAddPhoneSaveCustomerDetailsId")
	private WebElement saveCustomerDetailsButton;
	
	@WindowsFindBy(accessibility = "btnSalesAddPhoneExitId")
	private WebElement popUpCloseBtn;
	
	@WindowsFindBy(accessibility = "tbSalesCutomerNameByPhoneNoId") 
	private WebElement customerNameText;
	
	@WindowsFindBy(accessibility = "tbSalesStoreNameByPhoneNoId")
	private WebElement customerLocation;
	
	@WindowsFindBy(accessibility = "btnSalesEditCustomerDetailsPhoneNoId")
	private WebElement editBtn;
	
	@WindowsFindBy(accessibility = "txtSalesCashId")
	private WebElement cashTextField;
	
	@WindowsFindBy(accessibility = "txtSalesUPIId")
	private WebElement upiTextField;
	
	@WindowsFindBy(accessibility = "txtSaleCouponId")
	private WebElement coupenTextField;
	
	@FindBy(name = "Apply")
	private WebElement applyLink;
	
	@WindowsFindBy(accessibility = "Text")
	private WebElement errorMessege;
	
	@FindBy(name = "Clear")
	private WebElement clearText;
	
	@WindowsFindBy(accessibility = "txtSalesInvoiceNoId")
	private WebElement invoiceNumber;
	
	@WindowsFindBy(accessibility = "tbSalesProductDetailsSellingPriceId")
	private WebElement sellingPrice;
	
	@FindBy(name = "EOD (Cash Declaration)")
	private WebElement eodCashDeclaration;
	
	@WindowsFindBy(accessibility = "lblwelcome")
	private WebElement storename;
	
	public String getStoreName() 
	{
		return storename.getAttribute("Name");
	}
	
	public void clickEod() 
	{
		eodCashDeclaration.click();
	}
	
	public String getSellingPrice() {
		return sellingPrice.getAttribute("Name");
	}
	
	public String getInvoiceNumber() 
	{
		return invoiceNumber.getAttribute("Name");
	}
	
	
	public String getClearText() {
		return clearText.getAttribute("Name");
	}
	
	
	
	public void sendKeyToCoupenTextField(String name) {
		coupenTextField.sendKeys(name);
	}
	
	public void clickApplyLink() {
		applyLink.click();
	}
	
	
	
	public String getErrorMessage() {
		return errorMessege.getAttribute("Name");
	}
	
	public void salesOptionClick() {
		salesOption.click();
	}
	public void refreshBtnClick() {
		refreshBtnInSalesPage.click();
	}
	public boolean refreshBtnIsDisplayed() {
		return refreshBtnInSalesPage.isDisplayed();
	}
	public boolean saveBtnIsDisplayed() {
		return saveButton.isDisplayed();
	}
	public void saveBtnClick() {
		saveButton.click();
	}
	public WebElement getSavebutton() {
		return saveButton;
	}
	public void viewSalesLinkClick() {
		viewSalesLink.click();
	}
	public boolean viewSalesLinkIsDisplayed() {
		 return viewSalesLink.isDisplayed();
	}
	public void sendKeyToPhoneNumberTextField(String name) {
		phoneNumberTextField.clear();
		phoneNumberTextField.sendKeys(name);
		phoneNumberTextField.sendKeys(Keys.ENTER);
	}
	public boolean newCustomerPopUpTextIsDisplayed() {
		 return newCustomerDetailsPopUp.isDisplayed();
	}
	public void saveCustomerDetailsBtnClick() {
		saveCustomerDetailsButton.click();
	}
	public boolean phoneNumTextFieldInPopUpIsDisplayed() {
		return phoneNumberTextFieldInPopUp.isDisplayed();
	}
	public void sendKeyToCustomerNameTextField(String name) {
		customerNameTextField.sendKeys(name);
	}
	public WebElement getTypeOfCustomerDropDown() {
		return typeOfCustomerDropDown;
	}
	public void sendKeyToPinCodeTextField(String name) {
		pincodeTextField.clear();
		pincodeTextField.sendKeys(name);
		pincodeTextField.sendKeys(Keys.ENTER);
	}
	public WebElement getStateDropDown() {
		return stateDropDown;
	}
	public WebElement getVillageDropDown() {
		return villageDropDown;
	}
	public void sendKeyToGSTNumTextField(String name) {
		gstNumberTextField.sendKeys(name);
	}
	public void popUpCloseBtnClick() {
		popUpCloseBtn.click();
	}
	public String getCustomerNameText() {
		return customerNameText.getAttribute("Name");
	}
	public String getLocation() {
		return customerLocation.getAttribute("Name");
	}
	public boolean editBtnIsDisplayed() {
		return editBtn.isDisplayed();
	}
	public void sendKeyToBarcodeTextField(String name) {
		barcodeTextField.sendKeys(name);
		barcodeTextField.sendKeys(Keys.ENTER);
	}
	public void sendKeytoCashTextField(String name) {
		cashTextField.clear();
		cashTextField.sendKeys(name);
	}
	public void clearCashTextField() {
		cashTextField.clear();
	}
	public void clickCashTextField() {
		cashTextField.click();
	}
		
	public void sendKeytoUPITextField(String name) {
		upiTextField.clear();
		upiTextField.sendKeys(name);
	}
	public void clearUPITextField() {
		upiTextField.clear();
	}
	@WindowsFindBy(accessibility = "txtSalesProductDetailsQuantityId")
	private WebElement sellingQTYtextField;
	
	public void sendKeyToSellingQtyTextField(String name) {
		sellingQTYtextField.clear();
		sellingQTYtextField.sendKeys(name);
	}
	
	@WindowsFindBy(accessibility =  "btnEODAddDenominationSubmitId")
	private WebElement denominationSubmitButton;
	
	public void clickSubmitButton() {
		denominationSubmitButton.click();
	}
}
