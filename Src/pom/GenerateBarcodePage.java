package pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsBy;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class GenerateBarcodePage extends WebBase{

	public GenerateBarcodePage(WindowsDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(name = "Stock")
	private WebElement stockOption;

	@WindowsFindBy(accessibility = "cmbSelectStockSearchproductId")
	private WebElement searchProductTextField;

	@WindowsFindBy(accessibility = "cmbStockSearchCategoryId")
	private WebElement categoryDropDown;

	@WindowsFindBy(accessibility = "cmbStockSearchSubcategoryId")
	private WebElement subCategoryDropDown;

	@WindowsFindBy(accessibility = "cmbStockSearchBrandsId")
	private WebElement brandDropDown;

	@WindowsFindBy(accessibility = "cmbStockSearchProductNameId")
	private WebElement productDropDown;

	@WindowsFindBy(accessibility = "BtnstockRefreshFieldsId")
	private WebElement refreshButton;

	@WindowsFindBy(accessibility = "btnStockSearchId")
	private WebElement searchButton;

	@WindowsFindBy(accessibility = "Text")
	private WebElement errorMessege;

	@WindowsFindBy(accessibility = "PART_GroupPanel")
	private WebElement pannel;

	@FindBy(xpath = "//Custom/DataGrid/Custom[1]/DataItem")
	private List<WebElement> barcodeList;

	@WindowsFindBy(accessibility = "txStockGenrateBarcodeBarcodeNoId")
	private WebElement getBarcode;
	
	@WindowsFindBy(accessibility = "CellElement_0_12")
	private WebElement barcodeFirstPrintButton;
	
	@WindowsFindBy(accessibility = "AvailableUnits")
	private WebElement availableQtyFilter;
	
	public WebElement getAvailableqtyFilt() 
	{
		return availableQtyFilter;
	}
	
	public WebElement getFirstBarPrintButton() {
		return barcodeFirstPrintButton;
	}
	
	public String getBarcode() {
		return getBarcode.getAttribute("Name");
	}

	public List<WebElement> getBarcodeList() {
		return barcodeList;
	}

	public void stockOptionClick() {
		stockOption.click();
	}

	public boolean searchBtnIsDisplayed() {
		return searchButton.isDisplayed();
	}

	public boolean refreshBtnIsDisplayed() {
		return refreshButton.isDisplayed();
	}

	public void searchBtnClick() {
		searchButton.click();
	}

	public void refreshBtnClick() {
		refreshButton.click();
	}

	public WebElement getSearchProductTextField() {
		return searchProductTextField;
	}

	public WebElement getCategoryDropDown() {
		return categoryDropDown;
	}

	public WebElement getSubCategoryDropDown() {
		return subCategoryDropDown;
	}

	public WebElement getBrandDropDown() {
		return brandDropDown;
	}

	public WebElement getProductDropDown() {
		return productDropDown;
	}

	public String getErrorMessage() {
		return errorMessege.getAttribute("Name");
	}

	public boolean pannelIsDisplayed() {
		return pannel.isDisplayed();
	}

	@WindowsFindBy(accessibility = "btnstockBarcodedetailscancel")
	private WebElement popUpCloseBtn;

	public void popUpCloseBtnClick() {
		popUpCloseBtn.click();

	}
}
