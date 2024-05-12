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

public class StockReceivePage extends WebBase{
	private WebDriverWait wait;

	@WindowsFindBy(accessibility = "tiStockreceiverId")
	private WebElement stockReceiveTab;

	@WindowsFindBy(xpath = "//Custom/Tab/TabItem[4]/Custom/Edit[4]")
	private WebElement newSellingPrice;

	@WindowsFindBy(xpath = "//TabItem[4]/Custom/Button[3]")
	private WebElement receiveButton;

	@WindowsFindBy(xpath = "//TabItem[4]/Custom/Button[1]")
	private WebElement refreshButton;

	@FindBy(name = "Stock Transfer")
	private WebElement stockTransferTab;

	@WindowsFindBy(className = "StockReceiverConfrimPopup")
	private WebElement stockReceiverConfrimPopup;

	@WindowsFindBy(accessibility = "btnclose")
	private WebElement closeButton;

	@WindowsFindBy(accessibility = "btnstockreceiveupdate")
	private WebElement btnstockreceiveupdate;

	@WindowsFindBy(xpath = "//Window/Custom/Edit[4]")
	private WebElement transportChrages;

	@WindowsFindBy(xpath = "//Window/Custom/Edit[5]")
	private WebElement outhersChrages;

	@WindowsFindBy(xpath = "//Window/Custom/Button[2]")
	private WebElement attachment;

	@WindowsFindBy(accessibility = "Text")
	private WebElement getText;
	
	public StockReceivePage(WindowsDriver<WebElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickStockReceiveTab() {
		stockReceiveTab.click();
	}

	public void clickReceiveButton() {
		receiveButton.click();
	}

	public void sendNewSellingPrice(String name) {
		newSellingPrice.sendKeys(name);
	}

	public void clearNewSellingPrice() {
		newSellingPrice.clear();
	}

	public void clickRefreshButton() {
		refreshButton.click();
	}

	public void clickStockTransferTab() {
		wait.until(ExpectedConditions.elementToBeClickable(stockTransferTab));
		stockTransferTab.click();
	}

	public void clickCloseButton() {
		closeButton.click();
	}

	public void clickUpdateButton() {
		btnstockreceiveupdate.click();
	}

	public boolean closeButtonisEnabled() {
		return closeButton.isEnabled();
	}

	public boolean stockreceiveupdateisEnabled() {
		return btnstockreceiveupdate.isEnabled();
	}

	public boolean confrimPopupisEnabled() {
		return stockReceiverConfrimPopup.isEnabled();
	}

	public void sendOuthersChrages(String name) {
		outhersChrages.sendKeys(name);
	}

	public void sendAttachment(String name) {
		attachment.sendKeys(name);
	}

	public void sendTransportChrages(String name) {
		transportChrages.sendKeys(name);
	}

	public void clearTransportChrages() {
		transportChrages.clear();
	}
	
	public String getErrorMessage() {
		wait.until(ExpectedConditions.visibilityOf(getText));
		return getText.getText();
	}
}
