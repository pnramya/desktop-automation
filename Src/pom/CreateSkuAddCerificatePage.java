package pom;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class CreateSkuAddCerificatePage 
extends WebBase{
	//Initializing Web element using parameterized constructor
	public CreateSkuAddCerificatePage(WindowsDriver<WebElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	// SKU create
	
	@WindowsFindBy(accessibility = "Text")
	private WebElement errorMessege;
	
	@FindBy(name = "SKU")
	private WebElement skuOption;
	
	@WindowsFindBy(accessibility = "cmbSKUCreateCategoryId")
	private WebElement categoryDropDownInCreate;
	
	@WindowsFindBy(accessibility = "cmbSKUCreateSubCategoryId")
	private WebElement subCatDropDownInCreate;
	
	@WindowsFindBy(accessibility = "btnSKUCreateCreateId")  
	private WebElement createBtnInSkuCreate;
	
	@WindowsFindBy(accessibility = "btnSKUCreateRefreshId")
	private WebElement refreshBtnInCreateSku;
	
	
	@WindowsFindBy(accessibility = "cmbSKUCreateSelectBrandId")
	private WebElement brandDropDownInSKUcreate;
	
	@WindowsFindBy(accessibility = "txtCreatCardProductNameId")
	private WebElement productNameTextField;
	
	@WindowsFindBy(accessibility = "txtCreatCardTechnicalNameId")
	private WebElement technicalNameTextField;
	
	@WindowsFindBy(accessibility = "txtCreatCardsDescriptionId")
	private WebElement descriptionTextField;
	
	@WindowsFindBy(accessibility = "txtCreatCardPackgingSizeId")
	private WebElement packingSizeTextField;
	
	@WindowsFindBy(accessibility = "cmbCreatCardsUOMId")
	private WebElement uomDropDown;
	
	@WindowsFindBy(accessibility = "btnCreatCardsAddProductId")
	private WebElement addProductButton;
	
	@WindowsFindBy(accessibility = "btnCreatCardsRemoveProductId")
	private WebElement removeProductButton;
	
	
	public void skuOptionClick() {
		skuOption.click();
	}
	public String getErrorMessage() {
		return errorMessege.getAttribute("Name");
	}
	public WebElement getCategoryDropDownInSKUCreate() {
		return categoryDropDownInCreate;
	}
	public void createBtnClickInSkuCreate() {
		createBtnInSkuCreate.click();
	}
	public boolean createBtnIsDisplayedInSkuCreate() {
		return createBtnInSkuCreate.isDisplayed();
	}
	public boolean refreshBtnIsDisplayedInSkuCreate() {
		return refreshBtnInCreateSku.isDisplayed();
	}
	public void refreshBtnClickInSkuCreate() {
		refreshBtnInCreateSku.click();
	}
	public WebElement getSubCategoryDropDownInSKUCreate() {
		return subCatDropDownInCreate;
	}
	public WebElement getBrandDropDownInSKUcreate() {
		return brandDropDownInSKUcreate;
	}
	public void sendKeyToProductNameTF(String name) {
		productNameTextField.sendKeys(name);
	}
	public void sendKeyToTechnicalNameTF(String name) {
		technicalNameTextField.sendKeys(name);
	}	
	public void sendKeyToDescriptionNameTF(String name) {
		descriptionTextField.sendKeys(name);
	}
	public void sendKeyToPackingSizeNameTF(String name) {
		packingSizeTextField.sendKeys(name);
	}
	public WebElement getUomDropDown() {
		return uomDropDown;
	}
	public boolean addProductButtonIsDisplayed() {
		return addProductButton.isDisplayed();
	}
	public boolean removeProductButtonIsDisplayed() {
		return removeProductButton.isDisplayed();
	}
	
	// Add certificate
	@WindowsFindBy(accessibility = "tiSKUCertificateId")
	private WebElement certificateNavigMenu;
	
	@WindowsFindBy(accessibility = "cmbSKUCertificateSearchCategoryId")
	private WebElement catDropDownInCertificate;
	
	@WindowsFindBy(accessibility = "cmbSKUCertificateSearchSubCategoryId")
	private WebElement subCatDropDownInCertificate;
	
	@WindowsFindBy(accessibility = "cmbSKUCertificateSearchBrandId")
	private WebElement brandDropdownInCertificate;
	
	@WindowsFindBy(accessibility = "cmbSKUCertificateSearchStoreId")
	private WebElement storeDropdown;
	
	@WindowsFindBy(accessibility = "cbSKUCertificateExpiredId")
	private WebElement expiredCheckBox;
	
	@WindowsFindBy(accessibility = "cbSKUCertificateNoCertificateId")
	private WebElement noCertificateCheckBox;
	
	@WindowsFindBy(accessibility = "cbSKUCertificateValidCertificateId")
	private WebElement validCertificateCheckBox;
	
	@WindowsFindBy(accessibility = "btnSKUCertificateSearchId")
	private WebElement searchButtonInCertificate;
	
	@WindowsFindBy(accessibility = "btnSKUCertificateRefreshId")
	private WebElement refreshButtonInCertificate;
	
	
	public void certificateNavigMenuClick() {
		certificateNavigMenu.click();
	}
	public WebElement getCategoryDropDownInCertificate() {
		return catDropDownInCertificate;
	}
	public WebElement getSubCategoryDropDownInCertificate() {
		return subCatDropDownInCertificate;
	}
	public WebElement getBrandDropDownInCertificate() {
		return brandDropdownInCertificate;
	}
	public WebElement getStoreDropDownInCertificate() {
		return storeDropdown;
	}
	public WebElement getExpiredCheckBox() {
		return expiredCheckBox;
	}
	public WebElement getNoCertificateCheckBox() {
		return noCertificateCheckBox;
	}
	public WebElement getValidCertificateCheckBox() {
		return validCertificateCheckBox;
	}
	public boolean serachBtnInCertificateIsDisplayed() {
		return searchButtonInCertificate.isDisplayed();
	}
	public boolean refreshBtnInCertificateIsDisplayed() {
		return refreshButtonInCertificate.isDisplayed();
	}
	public void searchBtnInCertificateClick() {
		searchButtonInCertificate.click();
	}
	public void refreshBtnInCertificateClick() {
		refreshButtonInCertificate.click();
	}
	
	@WindowsFindBy(xpath = "//DataGrid/Custom[1]/DataItem/Custom[8]/Custom/Button[2]")
	private WebElement editButton;
	
	public void editButtonClick() {
		editButton.click();
	}
	@FindBy(name = "Add New Certificate")
	private WebElement addNewCertificateText;
	
	public boolean addNewCertificateTextIsDisplayed() {
		return addNewCertificateText.isDisplayed();
	}
	@WindowsFindBy(accessibility  = "txtSKUCertificateDataEditCertificateNumberId")
	private WebElement certificateNumberTextField;
	
	public void sendKeyToCertificateNumberTextField(String name) {
		certificateNumberTextField.sendKeys(name);
	}
	@WindowsFindBy(accessibility = "dpSKUCertificateDataEditIssueDateId")
	private WebElement issueDateTextField;
	
	public void sendKeyToIssueDateTextField(String name) {
		issueDateTextField.sendKeys(name);
	}
	@WindowsFindBy(accessibility = "dpSKUCertificateDataEditValidUptoDateId")
	private WebElement validUpToTextField;
	
	public void sendKeyToValidUpToTextField(String name) {
		validUpToTextField.sendKeys(name);
	}
	@WindowsFindBy(accessibility = "btnSKUCertificateDataEditSaveId")
	private WebElement saveButton;
	
	public void saveBtnClick() {
		saveButton.click();
	}
	@WindowsFindBy(accessibility = "btnSKUCertificateDataEditAddBrandCertificateId")
	private WebElement attachBtn;
	
	public void attachBtnClick() {
		attachBtn.click();
	}
	@WindowsFindBy(accessibility = "btnSKUCertificateDataEditExitId")
	private WebElement popUpCloseBtn;
	
	public void popUpCloseBtnClick() {
		popUpCloseBtn.click();
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
	
}
