package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class IndentFinancePaymentPage extends WebBase {

	  @WindowsFindBy(accessibility = "tiIndentPaymentUpdateIndentId")
	    private WebElement indentPaymentBulkUpdateTab;

	    @WindowsFindBy(accessibility = "tiIndentPaymentUpdateDownloadId")
	    private WebElement indentPaymentBulkDownloadTab;

	    @WindowsFindBy(accessibility = "tiIndentPaymentUpdateUploadId")
	    private WebElement indentPaymentBulkUploadTab;

	    @WindowsFindBy(accessibility = "btnIndentPaymentUpdateUploadUploadId")
	    private WebElement indentPaymentUploadButton;

	    @WindowsFindBy(accessibility = "btnIndentPaymentUpdateUploadRefreshId")
	    private WebElement refreshButon;

	    @WindowsFindBy(className = "Edit")
	    private WebElement sendFile;

	    @WindowsFindBy(accessibility = "1")
	    private WebElement openButton;

	    @WindowsFindBy(accessibility = "btnIndentIndentPaymentUpdateDownloadSearchId")
	    private WebElement searchButton;

	    @WindowsFindBy(accessibility = "cmbIndentIndentPaymentUpdateDownloadStoreId")
	    private WebElement storeDropDown;

	    @WindowsFindBy(xpath = "//Window/Custom/Text")
	    private WebElement getText;

	    @WindowsFindBy(xpath = "//TabItem[1]/Custom/ComboBox[2]")
	    private WebElement supplierDropDown;

	    @WindowsFindBy(accessibility = "tbIndentIndentPaymentUpdateDownloadCardSupplierNameId")
	    private WebElement supplierName;

	    @WindowsFindBy(accessibility = "ExpanderButton")
	    private WebElement expanderButton;

	    @WindowsFindBy(accessibility = "btnIndentIndentPaymentUpdateDownloadDownloadId")
	    private WebElement downloadButton;
	    
	   

	    @WindowsFindBy(accessibility = "rbIndentIndentPaymentUpdateDownloadSBIBankId")
	    private WebElement sbiBankRedioButton;

	    @FindBy(xpath = "//TabItem[2]/Custom/Button[3]")
	    private WebElement updateButton;
	    
	    @WindowsFindBy(accessibility = "plus")
	    private WebElement plusButton;
	    
	    @WindowsFindBy(xpath =  "//TabItem[4]/Custom/Tab/TabItem[1]/Custom/Custom[1]/Edit")
	    private WebElement fromDate;
	    
	    @WindowsFindBy(xpath =  "//TabItem[4]/Custom/Tab/TabItem[1]/Custom/Custom[2]/Edit")
	    private WebElement toDate;
	    
	public IndentFinancePaymentPage(WindowsDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickIndentPaymentBulkUpdateTab() {
		indentPaymentBulkUpdateTab.click();
	}
	public void clickPlusButton() {
		plusButton.click();
	}
	public void clickIndentPaymentBulkDownloadTab() {
		indentPaymentBulkDownloadTab.click();
	}

	public void clickIndentPaymentUploadTab() {
		indentPaymentBulkUploadTab.click();
	}

	public void clickIndentPaymentUploadButton() {
		indentPaymentUploadButton.click();
	}

	public boolean indentPaymentUploadButtonIsDisplayed() {
		return indentPaymentUploadButton.isDisplayed();
	}

	public boolean refreshButonIsDisplayed() {
		return indentPaymentUploadButton.isDisplayed();
	}

	public void sendFile(String name) {
		sendFile.sendKeys(name);
	}

	public void clickOpenButton() {
		openButton.click();
	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public void sendStoreName(String name) {
		storeDropDown.sendKeys(name);
	}

	public String getErrorMessage() {
		return getText.getText();
	}


	public void clickSupplierDropDown() {
		supplierDropDown.click();
	}


	public String getSupplierName() {
		return supplierName.getAttribute("Name");
	}


	public void clickExpandButton() {
		expanderButton.click();
	}


	public void clickDownloadButton() {
		downloadButton.click();
	}


	public void clickSbiBankRedioButton() {
		sbiBankRedioButton.click();
	}


	public void clickUpdateButton() {
		updateButton.click();
	}
	
	public void sendFromDate(String name) {
		fromDate.sendKeys(name);
	}
	public void sendToDate(String name) {
		toDate.sendKeys(name);
	}
}
