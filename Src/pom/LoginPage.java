package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class LoginPage extends WebBase {
	
	@WindowsFindBy(accessibility = "txtLoginUserNameId")
	private WebElement userName;

	@WindowsFindBy(accessibility = "txtLoginUserPasswordId")
	private WebElement password;

	@WindowsFindBy(accessibility = "btnLoginUserId")
	private WebElement loginButton;

	// Initializing the web element
	public LoginPage(WindowsDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void sendUserName(String name) {
		userName.sendKeys(name);
	}

	public void sendPassword(String name) {
		password.sendKeys(name);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
}
