package pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class StorePersionRegressionPage extends WebBase{
	
	@WindowsFindBy(accessibility = "imgFalcaLogoId")
	private WebElement falcaImage;

	@FindBy(xpath = "//ToolBar[1]/Text")
	private WebElement versionNumber;

	@WindowsFindBy(accessibility = "btnGSTCalculator")
	private WebElement gstCalculator;

	@WindowsFindBy(accessibility = "lblwelcome")
	private WebElement roleName;

	@WindowsFindBy(accessibility = "Minimize")
	private WebElement minimizeButton;

	@WindowsFindBy(accessibility = "Close")
	private WebElement closeButton;

	@WindowsFindBy(accessibility = "MaximizeRestore")
	private WebElement restoreButton;

	@WindowsFindBy(accessibility = "btnNotificationId")
	private WebElement notificationButton;

	@FindBy(xpath = "//Custom[5]/Custom[1]/Button")
	private WebElement notificationBackButton;

	@WindowsFindBy(accessibility = "MaximizeRestore")
	private WebElement maximizeRestore;

	@FindBy(xpath = "//Custom[2]/List[1]/ListItem")
	private List<WebElement> storePersonMenuList;

	//Sales Page
	
	@WindowsFindBy(accessibility = "txtSalesSearchPhoneId")
	private WebElement salesSearchPhoneField;

	@WindowsFindBy(accessibility = "btnSalesViewAddSalesId")
	private WebElement saveButton;

	@WindowsFindBy(accessibility = "btnSalesViewResetSalesId")
	private WebElement resetButton;

	@FindBy(name = "View Sales")
	private WebElement viewSales;

	@FindBy(className ="NewCustomerPopup")
	private WebElement customerDetails;

	@WindowsFindBy(accessibility = "txtSalesAddPhonePhoneNumberId")
	private WebElement customerDetailsPhnoField;

	@WindowsFindBy(accessibility = "txtSalesAddPhoneCustomerNameId")
	private WebElement customerNameField;

	@WindowsFindBy(accessibility = "cmbSalesAddPhoneCustomerTypeId")
	private WebElement typeOfCustomerDropdown;

	@WindowsFindBy(accessibility = "txtSalesAddPhonePinCodeId")
	private WebElement pincodeField;

	@WindowsFindBy(accessibility = "cmbSalesAddPhoneStateId")
	private WebElement stateDropdown;

	@WindowsFindBy(accessibility = "cmbSalesAddPhoneDistrictId")
	private WebElement districtDropdown;

	@WindowsFindBy(accessibility = "cmbSalesAddPhoneVillageId")
	private WebElement villageDropdown;

	@WindowsFindBy(accessibility = "txtSalesAddPhoneGSTNumberId")
	private WebElement gstNumber;

	@WindowsFindBy(accessibility = "btnSalesAddPhoneSaveCustomerDetailsId")
	private WebElement saveCustomerDetailsButton;

	@FindBy(className =  "Popup")
	private WebElement dropdownPopup;

	@WindowsFindBy(accessibility = "btnSalesAddPhoneExitId")
	private WebElement customerDetailsCloseButton;

	@WindowsFindBy(accessibility = "txtSalesViewSalesId")
	private WebElement viewSalesButton;

	@WindowsFindBy(accessibility = "txtSalesInvoiceNoId")
	private WebElement salesInvoiceNo;

	@WindowsFindBy(accessibility = "txtSalesInvoiceDateId")
	private WebElement salesInvoiceDate;

	@WindowsFindBy(accessibility = "txtSalesNetTotalId")
	private WebElement salesNetTotal;

	@WindowsFindBy(accessibility = "txtSalesTotalGstId")
	private WebElement totalGst;

	@WindowsFindBy(accessibility = "txtSalesTotalDiscountId")
	private WebElement totalDiscount;

	@WindowsFindBy(accessibility = "txtSalesTotalServiceId")
	private WebElement totalService;

	@WindowsFindBy(accessibility = "txtSalesCashId")
	private WebElement cash;

	@WindowsFindBy(accessibility = "txtSalesUPIId")
	private WebElement upi;

	@WindowsFindBy(accessibility = "txtSalesReferenceId")
	private WebElement referenceNo;

	@WindowsFindBy(accessibility = "txtSalesPayTotalId")
	private WebElement netPayTotal;

	@WindowsFindBy(accessibility = "searchproduct")
	private WebElement scanProductCode;

	@FindBy(name = "Product Details")
	private WebElement productDetails;

	@FindBy(xpath = "//Custom[2]/Custom/Custom[2]/Edit[1]")
	private WebElement viewSalescustomerName;

	@FindBy(xpath = "//Custom[2]/Custom/Custom[2]/Edit[2]")
	private WebElement viewSalesInvoiceNumber;

	@FindBy(xpath = "//Custom[2]/Custom/Custom[2]/Custom[1]/Edit")
	private WebElement viewSalesTodate;

	@FindBy(xpath = "//Custom[2]/Custom/Custom[2]/Custom[2]/Edit")
	private WebElement viewSalesFromDate;

	@WindowsFindBy(accessibility = "txtSalesFlyoutSearchId")
	private WebElement viewSalesSearchButton;

	@WindowsFindBy(accessibility = "txtSalesFlyoutRefreshId")
	private WebElement viewSalesPageRefreshButton;

	@WindowsFindBy(accessibility = "txtSalesFlyoutHomePageId")
	private WebElement viewSalesBackButton;
	
	@WindowsFindBy(accessibility = "PageDown")
	private WebElement pageDown;
	
	@WindowsFindBy(accessibility = "PageUp")
	private WebElement pageUp;
	
	public StorePersionRegressionPage(WindowsDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	public boolean falcaImageIsDisplayed() {
	    return falcaImage.isDisplayed();
	}

	public WebElement pageDown() {
	    return pageDown;
	}
	
	public WebElement pageUp() {
	    return pageUp;
	}

	public String getVersionNumberValidation() {
	    return versionNumber.getAttribute("Name");
	}

	public boolean gstCalculatorIsDisplayed() {
	    return gstCalculator.isDisplayed();
	}

	public boolean roleNameIsDisplayed() {
	    return roleName.isDisplayed();
	}

	public String getRoleName() {
	    return roleName.getAttribute("Name");
	}

	public boolean minimizeButtonIsDisplayed() {
	    return minimizeButton.isDisplayed();
	}

	public boolean closeButtonIsDisplayed() {
	    return closeButton.isDisplayed();
	}

	public boolean restoreButtonIsDisplayed() {
	    return restoreButton.isDisplayed();
	}

	public void restoreButtonClick() {
	    restoreButton.click();
	}

	public boolean notificationButtonIsDisplayed() {
	    return notificationButton.isDisplayed();
	}

	public void notificationButtonClick() {
	    notificationButton.click();
	}

	public void notificationBackButtonClick() {
	    notificationBackButton.click();
	}

	public void maximizeRestoreButtonClick() {
	    maximizeRestore.click();
	}

	public List<WebElement> getMenuLists() {
	    return storePersonMenuList;
	}

	//Sales  page
	public boolean salesPagePhnoFieldIsEnabled() {
	    return salesSearchPhoneField.isEnabled();
	}

	public void sendSalesPhno(String name) {
	    salesSearchPhoneField.sendKeys(name);
	}

	public boolean customerDetailsIsDisplayed() {
	    return customerDetails.isDisplayed();
	}

	public boolean salesPageSaveButtonIsEnabled() {
	    return saveButton.isEnabled();
	}

	public boolean salesPageResetButtonIsEnabled() {
	    return resetButton.isEnabled();
	}
	
	
	
	
	public boolean isCustomerDetailsPhnoEnabled() {
	    return customerDetailsPhnoField.isEnabled();
	}

	public String getCustomerDetailsPhno() {
	    return customerDetailsPhnoField.getAttribute("Value.Value");
	}

	public boolean isCustomerNameFieldEnabled() {
	    return customerNameField.isEnabled();
	}

	public boolean isTypeOfCustomerDropdownEnabled() {
	    return typeOfCustomerDropdown.isEnabled();
	}

	public boolean isPincodeFieldEnabled() {
	    return pincodeField.isEnabled();
	}

	public boolean isStateDropdownEnabled() {
	    return stateDropdown.isEnabled();
	}

	public boolean isDistrictDropdownEnabled() {
	    return districtDropdown.isEnabled();
	}

	public boolean isGstNumberFieldEnabled() {
	    return gstNumber.isEnabled();
	}

	public boolean isSaveCustomerDetailsButtonEnabled() {
	    return saveCustomerDetailsButton.isEnabled();
	}

	public void clickSaveCustomerDetailsButton() {
	    saveCustomerDetailsButton.click();
	}

	public boolean isVillageDropdownEnabled() {
	    return villageDropdown.isEnabled();
	}

	public void clickTypeOfCustomerDropdown() {
	    typeOfCustomerDropdown.click();
	}

	public boolean isDropdownPopupElementsDisplayed() {
	    return dropdownPopup.isDisplayed();
	}

	public void clickStateDropdown() {
	    stateDropdown.click();
	}

	public void clickDistrictDropdown() {
	    districtDropdown.click();
	}

	public void clickVillageDropdown() {
	    villageDropdown.click();
	}

	public boolean isCustomerDetailsCloseButtonEnabled() {
	    return customerDetailsCloseButton.isEnabled();
	}

	public void clickCustomerDetailsCloseButton() {
	    customerDetailsCloseButton.click();
	}

	public boolean isViewSalesButtonEnabled() {
	    return viewSalesButton.isEnabled();
	}

	public void clickViewSalesButton() {
	    viewSalesButton.click();
	}

	public boolean isSalesInvoiceNoDisplayed() {
	    return salesInvoiceNo.isDisplayed();
	}

	public boolean isInvoiceDateFieldDisplayed() {
	    return salesInvoiceDate.isDisplayed();
	}

	public boolean isNetTotalFieldDisplayed() {
	    return salesNetTotal.isDisplayed();
	}

	public boolean isTotalGstFieldDisplayed() {
	    return totalGst.isDisplayed();
	}

	public boolean isTotalDiscountFieldDisplayed() {
	    return totalDiscount.isDisplayed();
	}

	public boolean isTotalServiceFieldDisplayed() {
	    return totalService.isDisplayed();
	}

	public boolean isCashFieldDisplayed() {
	    return cash.isDisplayed();
	}

	public boolean isUpiFieldDisplayed() {
	    return upi.isDisplayed();
	}

	public boolean isReferenceNoFieldDisplayed() {
	    return referenceNo.isDisplayed();
	}

	public boolean isNetPayTotalFieldDisplayed() {
	    return netPayTotal.isDisplayed();
	}

	public boolean isScanProductCodeFieldDisplayed() {
	    return scanProductCode.isDisplayed();
	}

	public boolean isProductDetailsFieldDisplayed() {
	    return productDetails.isDisplayed();
	}

	public boolean isViewSalescustomerNameFieldDisplayed() {
	    return viewSalescustomerName.isDisplayed();
	}

	public boolean isViewSalesInvoiceNumberFieldDisplayed() {
	    return viewSalesInvoiceNumber.isDisplayed();
	}

	public boolean isViewSalesTodateFieldDisplayed() {
	    return viewSalesTodate.isDisplayed();
	}

	public boolean isViewSalesFromDateFieldDisplayed() {
	    return viewSalesFromDate.isDisplayed();
	}

	public boolean isViewSalesSearchButtonDisplayed() {
	    return viewSalesSearchButton.isDisplayed();
	}

	public boolean isViewSalesPageRefreshButtonDisplayed() {
	    return viewSalesPageRefreshButton.isDisplayed();
	}

	public boolean isViewSalesBackButtonDisplayed() {
	    return viewSalesBackButton.isDisplayed();
	}

	public void clickViewSalesBackButton() {
	    viewSalesBackButton.click();
	}
	
	@WindowsFindBy(accessibility = "txtSaleCouponId")
	private WebElement saleCouponCode;
	
	@FindBy(name = "Apply")
	private WebElement applyButton;
	
	public boolean isSaleCouponCodeDisplayed() {
	    return saleCouponCode.isDisplayed();
	}

	public boolean isApplyButtonDisplayed() {
	    return applyButton.isDisplayed();
	}


	public boolean isSalesPageViewSalesLinkEnabled() {
	    return viewSalesButton.isEnabled();
	}

	public void clickViewSalesLink() {
	    viewSalesButton.click();
	}
	
	
	
	
	//Stock Page
	
	@FindBy(name = "Stock")
	private WebElement stockTab;

	@WindowsFindBy(accessibility = "cmbSelectStockSearchproductId")
	private WebElement productSearchList;

	@WindowsFindBy(accessibility = "cmbStockSearchCategoryId")
	private WebElement stockCatagoryTypes;

	@WindowsFindBy(accessibility = "cmbStockSearchSubcategoryId")
	private WebElement stockSearchSubcategory;

	@WindowsFindBy(accessibility = "cmbStockSearchBrandsId")
	private WebElement stockSeacrhBrands;

	@WindowsFindBy(accessibility = "cmbStockSearchProductNameId")
	private WebElement stockSearchProductName;

	@WindowsFindBy(accessibility = "btnStockSearchId")
	private WebElement searchButton;

	@WindowsFindBy(accessibility = "btnStockDwonloadStockId")
	private WebElement stockDownloadButton;

	@WindowsFindBy(accessibility = "BtnstockRefreshFieldsId")
	private WebElement refreshButton;

	//Customer page
	@FindBy(name = "Customer")
	private WebElement customerTab;

	@WindowsFindBy(accessibility = "txtCustomerSearchCustomerNameId")
	private WebElement searchCustomer;

	@WindowsFindBy(accessibility = "dpCustomerSalesInvoiceStartingDateId")
	private WebElement customerStartDate;

	@WindowsFindBy(accessibility = "dpCustomerSalesInvoiceEndingDateId")
	private WebElement customerEndingDate;

	@WindowsFindBy(accessibility = "btnCustomerSearchId")
	private WebElement customerSearchBtn;

	@WindowsFindBy(accessibility = "btnCustomerRefreshId")
	private WebElement customerRefresh;

	@WindowsFindBy(accessibility = "lblCustomerTotalInvoiceId")
	private WebElement customerTotalInvoice;

	@FindBy(name = "Total Invoices")
	private WebElement totalInvoicesText;

	@WindowsFindBy(accessibility = "txtCustomerSearchCustomerNameId")
	private WebElement sendCustomerField;

	@WindowsFindBy(accessibility = "dpCustomerSalesInvoiceStartingDateId")
	private WebElement sendCustomerStartDateField;

	@WindowsFindBy(accessibility = "dpCustomerSalesInvoiceEndingDateId")
	private WebElement sendCustomerEndingDateField;

	@WindowsFindBy(accessibility = "btnCustomerSearchId")
	private WebElement clickCustomerSearchBtnButton;

	//Weekly Stock Report
	@FindBy(name = "Weekly Stock Report")
	private WebElement weeklyStockReportTab;

	@WindowsFindBy(accessibility = "btnWeeklyStockReportRefreshStockDetailsId")
	private WebElement weeklyStockReportRefreshButton;

	@WindowsFindBy(accessibility = "lblWeeklyStockReportProductCountId")
	private WebElement weeklyStockReportProductCount;

	//Master SKU Sheet
	@FindBy(name = "Master SKU Sheet")
	private WebElement masterSKUSheetTab;

	@WindowsFindBy(accessibility = "btnMasterSKUSheetRefreshId")
	private WebElement masterSKURefreshButton;

	@WindowsFindBy(accessibility = "btnMasterSKUSheetDownloadId")
	private WebElement masterSKUDownloadButton;

	@WindowsFindBy(accessibility = "tbMasterSKUSheetTotalProductsId")
	private WebElement materSKUSheetTotalProductCount;

	@FindBy(name = "Total Products")
	private WebElement totalProductsText;

	
	//stock page
	public void clickStockTab() {
	    stockTab.click();
	}

	public boolean isProductSearchListDropdownDisplayed() {
	    return productSearchList.isDisplayed();
	}

	public boolean isStockCategoryTypesDropdownDisplayed() {
	    return stockCatagoryTypes.isDisplayed();
	}

	public boolean isStockSearchSubcategoryDropdownDisplayed() {
	    return stockSearchSubcategory.isDisplayed();
	}

	public boolean isStockSearchBrandsDropdownDisplayed() {
	    return stockSeacrhBrands.isDisplayed();
	}

	public boolean isStockSearchProductNameDropdownDisplayed() {
	    return stockSearchProductName.isDisplayed();
	}

	public boolean isSearchButtonDisplayed() {
	    return searchButton.isDisplayed();
	}

	public boolean isStockDownloadButtonDisplayed() {
	    return stockDownloadButton.isDisplayed();
	}

	public boolean isRefreshButtonDisplayed() {
	    return refreshButton.isDisplayed();
	}

	//customer page
	public void clickCustomerTab() {
	    customerTab.click();
	}

	public boolean isSearchCustomerDisplayed() {
	    return searchCustomer.isDisplayed();
	}

	public boolean isCustomerStartDateDisplayed() {
	    return customerStartDate.isDisplayed();
	}

	public boolean isCustomerEndDateDisplayed() {
	    return customerEndingDate.isDisplayed();
	}

	public boolean isCustomerSearchButtonDisplayed() {
	    return customerSearchBtn.isDisplayed();
	}

	public boolean isCustomerRefreshDisplayed() {
	    return customerRefresh.isDisplayed();
	}

	public boolean isCustomerTotalInvoiceFieldDisplayed() {
	    return customerTotalInvoice.isDisplayed();
	}

	public boolean isTotalInvoicesTextDisplayed() {
	    return totalInvoicesText.isDisplayed();
	}

	public void sendCustomerName(String name) {
	    sendCustomerField.sendKeys(name);
	}

	public void sendCustomerStartDate(String date) {
	    sendCustomerStartDateField.sendKeys(date);
	}

	public void sendCustomerEndDate(String date) {
	    sendCustomerEndingDateField.sendKeys(date);
	}

	public void clickCustomerSearchButton() {
	    clickCustomerSearchBtnButton.click();
	}

	public void clickWeeklyStockReportTab() {
	    weeklyStockReportTab.click();
	}

	public boolean isWeeklyStockReportRefreshButtonDisplayed() {
	    return weeklyStockReportRefreshButton.isDisplayed();
	}

	public boolean isWeeklyStockReportProductCountDisplayed() {
	    return weeklyStockReportProductCount.isDisplayed();
	}

	//Master SKU Sheet
	public void clickMasterSkuTab() {
	    masterSKUSheetTab.click();
	}

	public boolean isMasterSKURefreshButtonDisplayed() {
	    return masterSKURefreshButton.isDisplayed();
	}

	public boolean isMasterSKUDownloadButtonDisplayed() {
	    return masterSKUDownloadButton.isDisplayed();
	}

	public boolean isMasterSKUTotalProductCountDisplayed() {
	    return materSKUSheetTotalProductCount.isDisplayed();
	}

	public boolean isTotalProductsTextDisplayed() {
	    return totalProductsText.isDisplayed();
	}

	
	public void sendCustomerNameField(String name) {
	     customerNameField.sendKeys(name);
	}

	public void sendTypeOfCustomer(String name) {
	     typeOfCustomerDropdown.sendKeys(name);
	}

	public void sendPincode(String name) {
	     pincodeField.sendKeys(name);
	}
	

}
