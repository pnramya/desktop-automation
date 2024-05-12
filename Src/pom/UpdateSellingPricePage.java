package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class UpdateSellingPricePage extends WebBase{

	public UpdateSellingPricePage(WindowsDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(name = "SellingPrice Update")
	private WebElement sellingPriceUpdateOption;
	
	@WindowsFindBy(accessibility  = "cmbIndentPlanSelectZoneId")
	private WebElement selectZoneDropDown;

	@WindowsFindBy(accessibility = "cmbIndentPlanProductSearchListId")
	private WebElement searchProductTextField;
	
	@WindowsFindBy(accessibility  = "cmbIndentPlanSelectTerritoryId")
	private WebElement selectTerritoryDropDown;
	
	@WindowsFindBy(accessibility  = "cmbIndentPlanSelectStoreId")
	private WebElement selectStoreDropDown;
	
	@WindowsFindBy(accessibility  = "txtIndentPlanNewSellingPriceId")
	private WebElement sellingPriceUpdateTextField;

	@WindowsFindBy(accessibility = "BtnIndentPlanRefreshId")
	private WebElement refreshButton;

	@WindowsFindBy(accessibility = "BtnIndentPlanCreateId")
	private WebElement updateButton;

	@WindowsFindBy(accessibility = "btnSellingPriceUpdateUpdateYesId")
	private WebElement okButton;

	@WindowsFindBy(accessibility = "Text")
	private WebElement errorMessege;

	public void updateSellingPriceOptionClick() {
		sellingPriceUpdateOption.click();
	}

	public WebElement getSearchProductTextField() {
		return searchProductTextField;
	}

	public WebElement getZoneDropDown() {
		return selectZoneDropDown;
	}

	public WebElement getTerritoryDropDown() {
		return selectTerritoryDropDown;
	}

	public WebElement getStoreDropDown() {
		return selectStoreDropDown;
	}

	public void sendKeyToNewSellingPriceTextField(String name) {
		sellingPriceUpdateTextField.clear();
		sellingPriceUpdateTextField.sendKeys(name);
	}

	public boolean updateButtonIsDisplayed() {
		return updateButton.isDisplayed();
	}

	public boolean refreshBtnIsDisplayed() {
		return refreshButton.isDisplayed();
	}

	public void updateButtonClick() {
		updateButton.click();
	}

	public void refreshBtnClick() {
		refreshButton.click();
	}

	public String getErrorMessage() {
		return errorMessege.getAttribute("Name");
	}

	public void okButtonClick() {
		okButton.click();
	}

}
