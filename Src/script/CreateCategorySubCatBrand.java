package script;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Lib;
import generic.WebBase;
import pom.CreateCategorySubCategoryBrandPage;

public class CreateCategorySubCatBrand extends WebBase {
	private static String wrongMessage = "Wrong error message";
	private static String wrongSuccessMessage = "Wrong success message";

	@Test(priority = 1, description = "Create category pop up validation")
	public void createCategoryPopUpValidation() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			createCategory.manageOptionClick();
			createCategory.categoryNavigMenuClick();
			createCategory.addCategoryIconClick();
			soft.assertTrue(createCategory.addCategoryTextIsDisplayed(), "Add category pop up is not displayed");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 2, description = "Category text field error message validation")
	public void categoryTextFieldValidation() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			createCategory.addButtonClick();
			soft.assertEquals(createCategory.getErrorMessage(), Lib.getProperty(SKU_PATH, "CategoryNameErrorMessege"),
					wrongMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 3, description = "Radio button error message validation")
	public void radioButtonErrorValidation() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			createCategory.sendKeyToCategoryTextField(Lib.getProperty(SKU_PATH, "CategoryTextField"));
			createCategory.addButtonClick();
			Thread.sleep(2000);
			soft.assertEquals(createCategory.getErrorMessage(), Lib.getProperty(SKU_PATH, "RadioButtonError"),
					wrongMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 4, description = "Contact admin error message validation")
	public void yesRadioBtnErrorValidation() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			createCategory.yesRadioBtnClick();
			createCategory.addButtonClick();
			Thread.sleep(2000);
			soft.assertEquals(createCategory.getErrorMessage(), Lib.getProperty(SKU_PATH, "ContactAdminErrorMessege"),
					wrongMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 5, description = "Validation of yes radio button")
	public void yesRadioBtnSelectivityValidation() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			soft.assertTrue(createCategory.yesRadioBtnIsSelected(),
					"Yes radio button is not selected even after selecting");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 6, description = "Category creation success message validation")
	public void createCategorySuccessMessageValidation() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			createCategory.noRadioBtnClick();
			createCategory.addButtonClick();
			Thread.sleep(3000);
			// Success message validation
			soft.assertEquals(createCategory.getErrorMessage(), Lib.getProperty(SKU_PATH, "CategoryCreateSuccessMsg"),
					wrongSuccessMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 7, description = "Validation of sub category add icon")
	public void subCategoryAddIconValidation() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			Thread.sleep(3000);
			createCategory.subCategoryNavigMenuClick();
			soft.assertTrue(createCategory.subCategoryAddIconIsDisplayed(), "Sub category add icon is not displayed.");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 8, description = "Validation of sub category Pop up")
	public void subCategoryPopUpValidation() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			createCategory.subCategoryAddIconClick();
			soft.assertTrue(createCategory.subCategoryTextIsDisplayed(), "Sub category pop up is not displayed.");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 9, description = "Validation of sub category add button")
	public void subCategoryAddBtnValidation() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			soft.assertFalse(createCategory.addBtnInSubCatIsEnabled(),
					"Add button is enabled before selecting category");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 10, description = "Validation of sub category add button after selecting category")
	public void subCategoryAddBtnValidationAfterSelection() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			Lib.SelectDropDownOptionByVisibleName(driver, createCategory.getCategoryDropDown(), "AutomationCat3");
			createCategory.sendKeyToSubCategoryTextField(Lib.getProperty(SKU_PATH, "SubCategory1"));
			soft.assertTrue(createCategory.addBtnInSubCatIsEnabled(),
					"Add button is disabled even after selecting category");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 11, description = "Validation of sub category creation success message")
	public void subCategorySuccessMessageValidation() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			createCategory.addBtnInSubCatClick();
			Thread.sleep(2000);
			// Success message
			soft.assertEquals(createCategory.getErrorMessage(),
					Lib.getProperty(SKU_PATH, "SubCategoryCreationSuccessMsg"), wrongSuccessMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 12, description = "Validation of add brand icon")
	public void addBrandIconvalidation() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			createCategory.brandNavigMenuClick();
			createCategory.brandNavigMenuClick();
			soft.assertTrue(createCategory.addBrandIconIsDisplayed(), "Add brand icon is not displayed");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 13, description = "Add brand pop up validation")
	public void addBrandPopUpValidation() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			createCategory.addBrandIconClick();
			soft.assertTrue(createCategory.addBrandPopupTextIsDisplayed(), "Add brand pop up is not displayed");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 14, description = "Add new brand radio button validation")
	public void addNewBrandRadioBtnValidation() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			createCategory.addNewBrandRadioBtnClick();
			soft.assertTrue(createCategory.addNewBrandRadioBtnIsSelected(),
					"Add new brand radio buttonis not selected");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 15, description = "SubCategory text field error message validation")
	public void subCatTextfieldErrorValidation() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			createCategory.addButtonInBrandClick();
			Thread.sleep(2000);
			soft.assertEquals(createCategory.getErrorMessage(),
					Lib.getProperty(SKU_PATH, "AddNewBrandSelectSubCatErrorMsg"), wrongMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 16, description = "Brand name text field error message validation")
	public void brandNameTextfieldErrorValidation() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			Lib.SelectDropDownOptionByVisibleName(driver, createCategory.getSubCategoryDropDown(), "AutomationSubCat3");
			createCategory.addButtonInBrandClick();
			Thread.sleep(2000);
			soft.assertEquals(createCategory.getErrorMessage(), Lib.getProperty(SKU_PATH, "BrandNameErrorMsg"),
					wrongMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 17, description = "Map to sub category radio button validation")
	public void mapSubCatRadioBtnValidation() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			createCategory.mapToSubCatRadioBtnClick();
			soft.assertTrue(createCategory.mapToSubCatRadioBtnIsSelected(),
					"Map sub category radio button is not selected");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 18, description = "Map button validation")
	public void mapButtonValidation() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			soft.assertTrue(createCategory.mapButtonIsDisplayed(), "Map button is not displayed");
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 19, description = "Select brand error message validation")
	public void selectBrandDropDownErrorValidation() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			createCategory.mapButtonClick();
			Thread.sleep(2000);
			soft.assertEquals(createCategory.getErrorMessage(),
					Lib.getProperty(SKU_PATH, "MapToSubCatSelectBrandError"), wrongMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 20, description = "Brand creation success message validation")
	public void brandCreateSuccessMessageValidation() {
		try {
			CreateCategorySubCategoryBrandPage createCategory = new CreateCategorySubCategoryBrandPage(driver);
			SoftAssert soft = new SoftAssert();
			createCategory.addNewBrandRadioBtnClick();
			createCategory.sendKeyToBrandTextField(Lib.getProperty(SKU_PATH, "BrandName"));
			createCategory.addButtonInBrandClick();
			Thread.sleep(2000);
			soft.assertEquals(createCategory.getErrorMessage(), Lib.getProperty(SKU_PATH, "BrandCreatedSuccsessMsg"),
					wrongSuccessMessage);
			soft.assertAll();
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}
}
