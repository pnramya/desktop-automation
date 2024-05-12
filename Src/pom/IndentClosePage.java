package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class IndentClosePage extends WebBase{
	private WebDriverWait wait;
	
	@WindowsFindBy(accessibility = "cbIndentStoreFullId")
	private WebElement fullCheckBox;

	@WindowsFindBy(className =  "IndentPopupStatusPlacedAndTransit")
	private WebElement remarksPopUp;
	
	@WindowsFindBy(accessibility = "btnupdate")
	private WebElement updateButton;
	
	@WindowsFindBy(accessibility = "reason")
	private WebElement remarksFields;
	
	
	public IndentClosePage(WindowsDriver<WebElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickFullCheckBox() {
		fullCheckBox.click();
	}

	public boolean remarksPopUpIsDisplayed() {
		return remarksPopUp.isDisplayed();
	}
	public boolean updateButtonIsDisplayed() {
		return updateButton.isDisplayed();
	}
	
	
	public void sendRemarksFields(String name) {
		remarksFields.sendKeys(name);
	}
	
	public void clickUpdateButton() {
		wait.until(ExpectedConditions.elementToBeClickable(updateButton));
		updateButton.click();
	}
}
