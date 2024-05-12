package pom;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
public class UpdateInvoicePage extends WebBase
{
	public UpdateInvoicePage(WindowsDriver<WebElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@FindBy(name = "Invoice")
	private WebElement invoiceOption;
	
	@WindowsFindBy(accessibility = "cmbInvoiceSelectedStoreId")
	private WebElement selectStoreDropDown;
	
	@FindBy(xpath = "//Custom/List/ListItem")
	private List<WebElement> invoiceList;
	
	@WindowsFindBy(accessibility = "txtInvoiceSellingPrice/QtyId")
	private WebElement sellingPriceTextField;
	
	@WindowsFindBy(accessibility = "btnInvoiceUpdateInvoiceId")
	private WebElement updateButton;
	
	@WindowsFindBy(accessibility = "btnInvoiceExpandId")
	private WebElement expandButton;
	
	@WindowsFindBy(accessibility = "btnInvoiceRefreshId")
	private WebElement refreshForInvoice;
	
	@WindowsFindBy(accessibility = "Text")
	private WebElement errorMessege;
	
	@FindBy(name = "FalcaPOS.Entites.AddInventory.InvoiceListViewModel")
	private WebElement invoiceNo;
	
	public void clickInvoiceNo() {
		invoiceNo.click();
	}
	public void invoiceOptionClick() {
		invoiceOption.click();
	}
	public WebElement getSelectStoreDropDown() {
		return selectStoreDropDown;
	}
	public void invoiceRefreshClick() {
		refreshForInvoice.click();
	}
	public boolean invoiceRefreshIsDisplayed() {
		return refreshForInvoice.isDisplayed();
	}
	public List<WebElement> getInvoiceList() {
		return  invoiceList;
	}
	public boolean expandButtonIsDisplyed() {
		return expandButton.isDisplayed();
	}
	public void expandButtonClick() {
		expandButton.click();
	}
	public boolean updateButtonIsDisplyed() {
		return updateButton.isDisplayed();
	}
	public boolean sellingPriceUpdateTextFieldIsDisplyed() {
		return sellingPriceTextField.isDisplayed();
	}
	public void sendKeyToSellingPriceUpdateTextField(String name) {
		sellingPriceTextField.clear();
		sellingPriceTextField.sendKeys(name);
	}
	public void updateButtonClick() {
		updateButton.click();
	}
	public String getErrorMessage() {
		return errorMessege.getAttribute("Name");
	}
}
