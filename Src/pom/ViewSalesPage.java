package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class ViewSalesPage 
{
	WindowsDriver<WebElement> driver;
	public ViewSalesPage(WindowsDriver<WebElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@FindBy(name = "View Sales")
	private WebElement viewSalesLink;
	
	@WindowsFindBy(xpath = "//Custom[2]/Custom/Custom[2]/Custom[1]/Edit")//Custom[1]
	private WebElement fromDateFilter;
	
	@WindowsFindBy(xpath = "//Custom[2]/Custom/Custom[2]/Custom[2]/Edit")
	private WebElement toDateFilter;
	
	@WindowsFindBy(accessibility = "txtSalesFlyoutSearchId")
	private WebElement searchButton;
	
	@WindowsFindBy(accessibility = "txtSalesFlyoutRefreshId")
	private WebElement refreshButton;
	
	@WindowsFindBy(accessibility = "plus")
	private WebElement expandButton;
	
	@WindowsFindBy(accessibility = "CellElement_0_1")
	private WebElement invoiceNumber;
	
	@WindowsFindBy(accessibility = "CellElement_0_3")
	private WebElement customerName;
	
	@WindowsFindBy(accessibility = "btnSave")
	private WebElement downloadButton;
	
	public void clickViewSales() 
	{
		viewSalesLink.click();
	}
	public void sendKeysToFromDateFilter(String name) 
	{
		//fromDateFilter.click();
		fromDateFilter.sendKeys(name);
	}
	public void sendKeyToToDateFilter(String name) 
	{
		//toDateFilter.click();
		toDateFilter.sendKeys(name);
	}
	public void clickOnSearchButton() 
	{
		searchButton.click();
	}
	public void refreshClick() 
	{
		refreshButton.click();
	}
	public boolean expandBtnIsDisplayed() 
	{
		return expandButton.isDisplayed();
	}
	public String getFirstInvoiceNumber() 
	{
		return invoiceNumber.getAttribute("Name");
	}
	public String getCustomerName()
	{
		return customerName.getAttribute("Name");
	}
	public void clickDownloadBtn() 
	{
		downloadButton.click();
	}
}
