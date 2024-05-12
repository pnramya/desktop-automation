package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class IndentPlanByStorePersonPage extends WebBase {
	private WebDriverWait wait;
	private String value="Value.Value";
	
	@FindBy(name = "Indent")
	private WebElement indentTab;

	@WindowsFindBy(accessibility = "tiIndentPlanId")
	private WebElement indentPlanTab;

	@WindowsFindBy(accessibility = "tiIndentViewIndentId")
	private WebElement indentViewTab;

	@WindowsFindBy(accessibility = "txtIndentPlanPONumberId")
	private WebElement getIndentPONumber;

	@WindowsFindBy(accessibility = "txtIndentPlanPODateId")
	private WebElement indentPODate;

	@WindowsFindBy(accessibility = "rbIndentPlanReatilOrderId")
	private WebElement reatilOrderRbBtn;

	@WindowsFindBy(accessibility = "rbIndentPlanWholesaleOrderId")
	private WebElement indentPlanWholesaleOrderRbBtn;

	@WindowsFindBy(accessibility = "btnIndentPlanAddProductCardId")
	private WebElement indentPlanAddProductBtn;

	@WindowsFindBy(accessibility = "cmbIndentPlanProductSearchListId")
	private WebElement indentPlanProductSearchList;

	@WindowsFindBy(accessibility = "BtnIndentPlanCreateId")
	private WebElement indentCreateBtn;

	@WindowsFindBy(accessibility = "Text")
	private WebElement getText;

	@WindowsFindBy(accessibility = "BtnIndentPlanRefreshId")
	private WebElement indentPlanRefreshButton;

	public IndentPlanByStorePersonPage(WindowsDriver<WebElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 0);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickIndentTab() {
		wait.until(ExpectedConditions.elementToBeClickable(indentTab));
		indentTab.click();
	}

	public String getIndentPONumber() {
		return getIndentPONumber.getAttribute(value);
	}

	public String getIndentPODate() {
		return indentPODate.getAttribute(value);
	}

	public void clickIndentCreateBtn() {
		indentCreateBtn.click();
	}

	public String getErrorMessage() {
		return getText.getText();
	}

	public String getSuccessMessage() {
		return getText.getText();
	}

	public void clickIndentPlanAddProductBtn() {
		indentPlanAddProductBtn.click();
	}

	public void clickIndentPlanRefreshButton() {
		indentPlanRefreshButton.click();
	}

	public void clickReatilOrderRbBtn() {
		reatilOrderRbBtn.click();
	}

	@WindowsFindBy(accessibility = "txtIndentPlanSearchBrandId")
	private WebElement indentPlanSearchBrand;

	@WindowsFindBy(accessibility = "txtIndentPlanSubCategoryId")
	private WebElement indentPlanSubCategory;

	public String getIndentBrandName() {
		return indentPlanSearchBrand.getAttribute(value);
	}

	public String getIndentSubCategoryName() {
		return indentPlanSubCategory.getAttribute(value);
	}

	public void sendProduct(String name) {
		indentPlanProductSearchList.sendKeys(name);
	}

	public void clearProduct() {
		indentPlanProductSearchList.clear();
	}
	@WindowsFindBy(accessibility = "txtIndentPlanQuantitytId")
	private WebElement indentQuantity;

	public void sendIndentQuantity(String name) {
		indentQuantity.sendKeys(name);
		
	}

}
