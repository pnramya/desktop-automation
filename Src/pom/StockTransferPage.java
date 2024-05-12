package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class StockTransferPage extends WebBase{

    @FindBy(name = "Stock Transfer")
    private WebElement stockTransferTab;
    
    @WindowsFindBy(accessibility = "tistockstransferId")
    private WebElement transferTab;

    @WindowsFindBy(accessibility = "ExpanderButton")
    private WebElement expanderButton;

    @WindowsFindBy(accessibility = "productcode")
    private WebElement productCode;

    @FindBy(xpath = "//TabItem[3]/Custom/Group[1]/Button[2]")
    private WebElement transferButton;

    @WindowsFindBy(accessibility = "btnstockeupdate")
    private WebElement confirmButton;

    @WindowsFindBy(xpath = "//TabItem[3]/Custom/Button")
    private WebElement refreshButton;

    public StockTransferPage(WindowsDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickStockTransferTab() {
        stockTransferTab.click();
    }

    public void clickTransferTab() {
        transferTab.click();
    }

    
    public void clickExpanderButton() {
    	expanderButton.click();
    }

    public void sendProductCode(String name) {
    	productCode.sendKeys(name);
    }
    
    public void clearProductCode() {
    	productCode.clear();
    }
    
    public void clickTransferButton() {
    	transferButton.click();
    }
    
    public void clickConfirmButton() {
    	confirmButton.click();
    }
    public void clickRefreshButton() {
    	refreshButton.click();
    }
}
