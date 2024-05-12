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

public class ReviewIndentPage extends WebBase {
	private WebDriverWait wait;

	@WindowsFindBy(accessibility = "tiIndentViewIndentId")
	private WebElement indentViewTab;

	@WindowsFindBy(accessibility = "btnIndentViewIndentIndentSearchId")
	private WebElement viewIndentSearchBtn;

	@WindowsFindBy(accessibility = "btnIndentStoreSearchId")
	private WebElement indentSearchButton;

	@WindowsFindBy(accessibility = "btnIndentViewIndentRefreshId")
	private WebElement refreshBtn;

	@WindowsFindBy(accessibility = "cmbIndentStoreSelectStatusId")
	private WebElement indentStatusDropDown;

	@WindowsFindBy(accessibility = "cmbIndentStoreSelectStoreId")
	private WebElement indentStoreDropDown;

	@WindowsFindBy(accessibility = "dpIndentStoreStartingDateId")
	private WebElement storeStartDate;

	@WindowsFindBy(accessibility = "dpIndentStoreEndingDateId")
	private WebElement storeEndDate;

	@WindowsFindBy(accessibility = "btnIndentProcessIndentChangeStatusId")
	private WebElement indentChangeStatusButton;

	@FindBy(name = "Submit")
	private WebElement submitButton;

	@WindowsFindBy(accessibility = "btnAddInvAddReviewProductCardsId")
	private WebElement addReviewProductBtn;

	@FindBy(name = "Add")
	private WebElement addBtn;

	@WindowsFindBy(accessibility = "txtIndentPlanQuantitytId")
	private WebElement indentQuantity;

	
	@WindowsFindBy(accessibility = "btnProcessIndentCSDeleteId")
	private WebElement removeProductBtn;

	@WindowsFindBy(xpath = "//Window/Custom/Edit[3]")
	private WebElement rmQty;

	@WindowsFindBy(xpath = "//Window/Custom/Edit[2]")
	private WebElement tmQty;

	@WindowsFindBy(xpath = "//Window/Custom/Edit[4]")
	private WebElement rspPrice;

	public ReviewIndentPage(WindowsDriver<WebElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickViewIndentTab() {
		indentViewTab.click();
	}

	public void clickViewIndentSearchBtn() {
		viewIndentSearchBtn.click();
	}

	public void sendIndentStatusDropDown(String name) {
		indentStatusDropDown.sendKeys(name);
	}

	public void sendIndentStoreDropDown(String name) {
		indentStoreDropDown.sendKeys(name);
	}

	public void clickIndentSearchFlaOutBtn() {
		indentSearchButton.click();
	}

	public void clickIndentChangeStatusButton() {
		indentChangeStatusButton.click();
	}

	public void clickSubmitButton() {
		submitButton.click();
	}

	public void clickAddProductBtn() {
		addReviewProductBtn.click();
	}

	public void clickAddBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		addBtn.click();
	}

	public void sendIndentQuantity(String name) {
		indentQuantity.sendKeys(name);
		
	}

	public void clickDeleteProductBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(removeProductBtn));
		removeProductBtn.click();
	}

	public void sendRmQty(String name) {
		rmQty.sendKeys(name);
	}

	public void sendTmQty(String name) {
		tmQty.sendKeys(name);
	}

	public void sendRspPrice(String name) {
		rspPrice.sendKeys(name);
	}

}
