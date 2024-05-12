package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;

public class CreateCategorySubCategoryBrandPage extends WebBase {
	//Initializing the web element
	public CreateCategorySubCategoryBrandPage(WindowsDriver<WebElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Category
	@FindBy(name = "Manage")
	private WebElement manageOption;
	
	@WindowsFindBy(accessibility = "tiManageCategoryId")
	private WebElement categoryNavigMenu;
	
	@WindowsFindBy(accessibility = "PART_Toggle")
	private WebElement addCatIcon;
	
	@WindowsFindBy(accessibility = "txtManageCategoryAddCategoryId")
	private WebElement categoryTextField;
	
	@WindowsFindBy(accessibility = "rbManageCategoryCertificateCategoryYesId")
	private WebElement yesRadioBtn;
	
	@WindowsFindBy(accessibility = "rbManageCategoryCertificateCategoryNoId")
	private WebElement noRadioBtn;
	
	@WindowsFindBy(accessibility = "btnManageCategoryAddId")
	private WebElement addButtonInCategory;
	
	@WindowsFindBy(accessibility = "Text")
	private WebElement errorMessege;
	
	@FindBy(name = "Add Category")
	private WebElement addCategoryText;
	
	
	
	
	public void manageOptionClick() {
		manageOption.click();
	}
	public void categoryNavigMenuClick() {
		categoryNavigMenu.click();
	}
	public void addCategoryIconClick() {
		addCatIcon.click();
	}
	public boolean addCategoryTextIsDisplayed() {
		return addCategoryText.isDisplayed();
	}
	public void addButtonClick() {
		addButtonInCategory.click();
	}
	public String getErrorMessage() {
		return errorMessege.getAttribute("Name");
	}
	public void sendKeyToCategoryTextField(String name) {
		categoryTextField.sendKeys(name);
	}
	public void yesRadioBtnClick() {
		yesRadioBtn.click();
	}
	public void noRadioBtnClick() {
		noRadioBtn.click();
	}
	public boolean yesRadioBtnIsSelected() {
		return yesRadioBtn.isSelected();
	}
	
	//Sub category
	@WindowsFindBy(accessibility = "tiManageSubCategoryId")
	private WebElement subCatNavigMenu;
	
	@WindowsFindBy(accessibility = "PART_Toggle")
	private WebElement addSubCatIcon;
	
	@FindBy(name = "Add Sub Category")
	private WebElement subCatPopUpText;
	
	@WindowsFindBy(accessibility = "btnManageAddSubCategoryAddId")
	private WebElement addBtnInSubCategory;
	
	@WindowsFindBy(accessibility = "cmbManageAddSubCategorySelectCategoryId")
	private WebElement categoryDropDown;
	
	@WindowsFindBy(accessibility = "txtManageAddSubCategorySubCategoryId")
	private WebElement subCatTextField;
	
	
	public void subCategoryNavigMenuClick() {
		subCatNavigMenu.click();
	}
	public void subCategoryAddIconClick() {
		addSubCatIcon.click();
	}
	public boolean subCategoryAddIconIsDisplayed() {
		return addSubCatIcon.isDisplayed();
	}
	public void addBtnInSubCatClick() {
		addBtnInSubCategory.click();
	}
	public boolean addBtnInSubCatIsEnabled() {
		return addBtnInSubCategory.isEnabled();
	}
	public boolean subCategoryTextIsDisplayed() {
		return subCatPopUpText.isDisplayed();
	}
	public WebElement getCategoryDropDown() {
		return categoryDropDown;
	}
	public void sendKeyToSubCategoryTextField(String name) {
		subCatTextField.sendKeys(name);
	}
	
	// Brand
	@WindowsFindBy(accessibility = "tiManageBrandsId")
	private WebElement brandNavigMenu;
	
	@WindowsFindBy(accessibility = "PART_Toggle")
	private WebElement addBrandIcon;
	
	@FindBy(name = "Add New Brand")
	private WebElement brandPopUpText;
	
	@WindowsFindBy(accessibility = "rbManageBrandsAddNewBrandNameId")
	private WebElement addNewBrandRadioBtn;
	
	@WindowsFindBy(accessibility = "rbManageBrandsMaptoSubCategoryId")
	private WebElement mapSubCatRadioBtn;
	
	@WindowsFindBy(accessibility = "cmbManageBrandsAddBrandSelectSubCategoryId")
	private WebElement subCategoryDropDown;
	
	@WindowsFindBy(accessibility = "txtManageBrandsAddBrandBrandNameId")
	private WebElement brandNameTextField;
	
	@WindowsFindBy(accessibility = "btnManageBrandsAddBrandAddId")
	private WebElement addBtnInBrand;
	
	@WindowsFindBy(xpath = "//Window/ComboBox[2]")
	private WebElement brandDropdown;
	
	@FindBy(name = "Map")
	private WebElement mapButton;
	
	
	public void brandNavigMenuClick() {
		brandNavigMenu.click();
	}
	public boolean addBrandIconIsDisplayed() {
		return addBrandIcon.isDisplayed();
	}
	public void addBrandIconClick() {
		addBrandIcon.click();
	}
	public boolean addBrandPopupTextIsDisplayed() {
		return brandPopUpText.isDisplayed();
	}
	public void addNewBrandRadioBtnClick() {
		addNewBrandRadioBtn.click();
	}
	public void mapToSubCatRadioBtnClick() {
		mapSubCatRadioBtn.click();
	}
	public boolean addNewBrandRadioBtnIsSelected() {
		return addNewBrandRadioBtn.isSelected();
	}
	public boolean mapToSubCatRadioBtnIsSelected() {
		return mapSubCatRadioBtn.isSelected();
	}
	public void addButtonInBrandClick() {
		addBtnInBrand.click();
	}
	public WebElement getSubCategoryDropDown() {
		return subCategoryDropDown;
	}
	public void sendKeyToBrandTextField(String name) {
		brandNameTextField.sendKeys(name);
	}
	public WebElement getBrandDropDown() {
		return brandDropdown;
	}
	public void mapButtonClick() {
		mapButton.click();
	}
	public boolean mapButtonIsDisplayed() {
		return mapButton.isDisplayed();
	}
	

}
