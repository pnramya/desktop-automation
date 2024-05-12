package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class StockStoreRequestPage extends WebBase{
	public WebDriverWait wait;

	@FindBy(name = "Stock Transfer")
	private WebElement stockTransferTab;

	@WindowsFindBy(accessibility = "tistocksrequesId")
	private WebElement stocksRequestTab;

	@WindowsFindBy(accessibility = "cmbFromStoreId")
	private WebElement fromStoreDropdown;

	@WindowsFindBy(accessibility = "btnCreateRequestId")
	private WebElement createRequestBtn;

	@WindowsFindBy(accessibility = "btnAddInvAddIndentProductCardsId")
	private WebElement addButton;

	@WindowsFindBy(accessibility = "cmbSelectStockTransferRspRequestProductSearchbyProductId")
	private WebElement stockTransferProductSearch;

	@WindowsFindBy(accessibility = "txtSelectStockTransferRspRequestProductQuantity")
	private WebElement productQuantity;
	
	@WindowsFindBy(accessibility = "txtSelectStockTransferRspRequestProductBrandId")
	private WebElement stockTransferBrandName;

	@WindowsFindBy(accessibility = "txtSelectStockTransferRspRequestProductSubCategory")
	private WebElement stockTransferSubCategory;

	public StockStoreRequestPage(WindowsDriver<WebElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickStockTransferTab() {
		wait.until(ExpectedConditions.elementToBeClickable(stockTransferTab));
		stockTransferTab.click();
	}

	public void clickStockRequestTab() {
		wait.until(ExpectedConditions.visibilityOf(stocksRequestTab));
		stocksRequestTab.click();
	}

	public void sendFromStoreDropdown(String name) {
		fromStoreDropdown.sendKeys(name);
	}

	public void clickCreateRequestBtn() {
		createRequestBtn.click();
	}

	public void clickAddButton() {
		addButton.click();
	}

	public void sendStockTransferProductSearch(String name) {
		stockTransferProductSearch.sendKeys(name);
	}


	public String getStockTransferBrandName() {
		return stockTransferBrandName.getAttribute("Value.Value");
	}

	public String getStockTransferSubCategoryName() {
		return stockTransferSubCategory.getAttribute("Value.Value");
	}


	public void sendProductQuantity(String name) {
		productQuantity.sendKeys(name);
	}
	
	public void sendKeys(Keys name) {
		productQuantity.sendKeys(name);
	}
	
	
	
}
