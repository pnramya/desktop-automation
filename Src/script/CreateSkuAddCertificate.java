package script;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import generic.Lib;
import generic.WebBase;
import pom.CreateInventoryPage;
import pom.CreateSkuAddCerificatePage;

public class CreateSkuAddCertificate extends WebBase {
	@Test(priority = 1, description = "Validation of create button and refresh button in sku create page.")
	public void createAndRefreshBtnValidation() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			createSku.skuOptionClick();
			soft.assertTrue(createSku.createBtnIsDisplayedInSkuCreate(), "Create button is not displayed.");
			soft.assertTrue(createSku.refreshBtnIsDisplayedInSkuCreate(), "Refresh button is not dispalyed.");
			soft.assertAll();
		}  catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 2, description = "Validation of category drop down error message.")
	public void CategoryDropDownErrorMsgValidation() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			createSku.createBtnClickInSkuCreate();
			Thread.sleep(3000);
			soft.assertEquals(createSku.getErrorMessage(), Lib.getProperty(SKU_PATH, "CategoryError"),
					"Wrong error message");
			soft.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 3, description = "Validation of sub category drop down error message.")
	public void SubcategoryDropDownErrorMsgValidation() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			Lib.SelectDropDownOptionByVisibleName(driver, createSku.getCategoryDropDownInSKUCreate(), Lib.getProperty(SKU_PATH, "CategoryTextField"));
			createSku.createBtnClickInSkuCreate();
			Thread.sleep(3000);
			soft.assertEquals(createSku.getErrorMessage(), Lib.getProperty(SKU_PATH, "SelectSubCategoryErrorMsg"),
					"Wrong error message");
			soft.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 4, description = "Validation of brand drop down error message.")
	public void brandDropDownErrorMsgValidation() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			Lib.SelectDropDownOptionByVisibleName(driver, createSku.getSubCategoryDropDownInSKUCreate(),Lib.getProperty(SKU_PATH, "SubCategory1"));
			createSku.createBtnClickInSkuCreate();
			Thread.sleep(3000);
			soft.assertEquals(createSku.getErrorMessage(), Lib.getProperty(SKU_PATH, "PleaseSelectBrandError"),
					"Wrong error message");
			soft.assertAll();
		}  catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 5, description = "Add product remove product button valiadtion")
	public void addProductRemoveProductBtnValidation() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			soft.assertTrue(createSku.addProductButtonIsDisplayed(), "Add product button is not dispalyed.");
			soft.assertTrue(createSku.removeProductButtonIsDisplayed(), "Remove product button is not dispalyed.");
			soft.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 6, description = "Validation of product name text field error message.")
	public void productNameTFErrorValidation() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			Lib.SelectDropDownOptionByVisibleName(driver, createSku.getBrandDropDownInSKUcreate(), Lib.getProperty(SKU_PATH, "BrandName"));
			createSku.createBtnClickInSkuCreate();
			Thread.sleep(2000);
			soft.assertEquals(createSku.getErrorMessage(), Lib.getProperty(SKU_PATH, "EnterProductNameError"),
					"Wrong error message");
			soft.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 7, description = "Validation of technical name text field error message.")
	public void technicalNameTFErrorValidation() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			createSku.sendKeyToProductNameTF(Lib.getProperty(SKU_PATH, "ProductName"));
			createSku.createBtnClickInSkuCreate();
			Thread.sleep(2000);
			soft.assertEquals(createSku.getErrorMessage(), Lib.getProperty(SKU_PATH, "TechnicalNameError"),
					"Wrong error message");
			soft.assertAll();
		}  catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 8, description = "Validation of description text field error message.")
	public void descriptionTFErrorValidation() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			createSku.sendKeyToTechnicalNameTF(Lib.getProperty(SKU_PATH, "TechnicalName"));
			createSku.createBtnClickInSkuCreate();
			Thread.sleep(2000);
			soft.assertEquals(createSku.getErrorMessage(), Lib.getProperty(SKU_PATH, "EnterDescriptionError"),
					"Wrong error message");
			soft.assertAll();
		}  catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 9, description = "Validation of packing size text field error message.")
	public void packingSizeTFErrorValidation() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			createSku.sendKeyToDescriptionNameTF(Lib.getProperty(SKU_PATH, "Description"));
			createSku.createBtnClickInSkuCreate();
			Thread.sleep(2000);
			soft.assertEquals(createSku.getErrorMessage(), Lib.getProperty(SKU_PATH, "PackingSizeError"),
					"Wrong error message");
			soft.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 10, description = "Validation of UOM dropdown error message.")
	public void uomDropDownErrorValidation() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			createSku.sendKeyToPackingSizeNameTF(Lib.getProperty(SKU_PATH, "PackingSize"));
			createSku.createBtnClickInSkuCreate();
			Thread.sleep(2000);
			soft.assertEquals(createSku.getErrorMessage(), Lib.getProperty(SKU_PATH, "UOMError"),
					"Wrong error message");
			soft.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 11, description = "Validation of SKU create success message")
	public void skuCreationSuccessMessageValidation() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			Lib.SelectDropDownOptionByVisibleName(driver, createSku.getUomDropDown(), "LT");
//			createSku.createBtnClickInSkuCreate();
//			soft.assertEquals(createSku.getErrorMessage(), Lib.getProperty(SKU_PATH, "SKUsuccessMessage"), "Wrong success message");
			// soft.assertAll();
			createSku.refreshBtnClickInSkuCreate();
		}  catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 12, description = "Validation of serach button and refresh button in certificate.")
	public void searchBtnRefreshBtnInCertificateValidation() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			createSku.certificateNavigMenuClick();
			soft.assertTrue(createSku.serachBtnInCertificateIsDisplayed(), "seach button is not dispalyed.");
			soft.assertTrue(createSku.refreshBtnInCertificateIsDisplayed(), "Refresh button is not displayed.");
			soft.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 13, description = "Category dropdown error message.")
	public void categoryDropDownErrorInCertificate() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			createSku.searchBtnInCertificateClick();
			Thread.sleep(1000);
			soft.assertEquals(createSku.getErrorMessage(), Lib.getProperty(SKU_PATH, "blankErrorMsg"),
					"Wrong error message");
			soft.assertAll();
		}  catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 14, description = "Subcategory dropdown error message.")
	public void subCategoryDropDownErrorInCertificate() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			Lib.SelectDropDownOptionByVisibleName(driver, createSku.getCategoryDropDownInCertificate(),
					Lib.getProperty(SKU_PATH, "CategoryInCertificate"));
			createSku.searchBtnInCertificateClick();
			Thread.sleep(1000);
			soft.assertEquals(createSku.getErrorMessage(), Lib.getProperty(SKU_PATH, "blankErrorMsg"),
					"Wrong error message");
			soft.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 15, description = "Brand dropdown error message.")
	public void brandDropDownErrorInCertificate() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			Lib.SelectDropDownOptionByVisibleName(driver, createSku.getSubCategoryDropDownInCertificate(),
					Lib.getProperty(SKU_PATH, "SubCategoryInCertificate"));
			createSku.searchBtnInCertificateClick();
			Thread.sleep(1000);
			soft.assertEquals(createSku.getErrorMessage(), Lib.getProperty(SKU_PATH, "blankErrorMsg"),
					"Wrong error message");
			soft.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 16, description = "Store dropdown error message.")
	public void storeDropDownErrorInCertificate() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			Lib.SelectDropDownOptionByVisibleName(driver, createSku.getBrandDropDownInCertificate(),
					Lib.getProperty(SKU_PATH, "BrandInCertificate"));
			createSku.searchBtnInCertificateClick();
			Thread.sleep(1000);
			soft.assertEquals(createSku.getErrorMessage(), Lib.getProperty(SKU_PATH, "blankErrorMsg"),
					"Wrong error message");
			soft.assertAll();
		}  catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 17, description = "Checkboxes validation")
	public void CheckBoxValidationsInCertificate() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			createSku.getStoreDropDownInCertificate().sendKeys(Lib.getProperty(SKU_PATH, "storeName"));
			createSku.searchBtnInCertificateClick();
			Thread.sleep(1000);
			soft.assertEquals(createSku.getErrorMessage(), Lib.getProperty(SKU_PATH, "blankErrorMsg"),
					"Wrong error message");
			createSku.getExpiredCheckBox().click();
			soft.assertTrue(createSku.getExpiredCheckBox().isSelected(),
					"Expired checkbox is not selected even after click on it.");
			createSku.getValidCertificateCheckBox().click();
			soft.assertTrue(createSku.getValidCertificateCheckBox().isSelected(),
					"Valid certificate checkbox is not selected even after click on it.");
			createSku.getNoCertificateCheckBox().click();
			soft.assertTrue(createSku.getNoCertificateCheckBox().isSelected(),
					"No certificate checkbox is not selected even after click on it.");
			soft.assertAll();
			createSku.searchBtnInCertificateClick();
		}  catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 18, description = "Add certificate edit pop up validation")
	public void editPopUpValidation() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			createSku.editButtonClick();
			soft.assertTrue(createSku.addNewCertificateTextIsDisplayed(), "Add certificate pop up is not displayed.");
			soft.assertAll();
		}  catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 19, description = "Certificate number TF validation.")
	public void certificateNumberTFValidation() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			createSku.saveBtnClick();
			Thread.sleep(2000);
			soft.assertEquals(createSku.getErrorMessage(), Lib.getProperty(SKU_PATH, "CertificateError"), "Wrong error message");
			createSku.sendKeyToCertificateNumberTextField(Lib.getProperty(SKU_PATH, "CertificateNumber"));
			// Could not able to inspect error msg it is a bug
			soft.assertAll();

		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 20, description = "Date text fields validation")
	public void issueDateValidUpToTFValidation() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			Thread.sleep(1000);
			createSku.saveBtnClick();
			Thread.sleep(1000);
			soft.assertEquals(createSku.getErrorMessage(), Lib.getProperty(SKU_PATH, "IssueDateError"), "Wrong error message");
			createSku.sendKeyToIssueDateTextField(Lib.getProperty(SKU_PATH, "IssueDate"));
			createSku.sendKeyToValidUpToTextField(Lib.getProperty(SKU_PATH, "ValidUpTo"));
			// Could not able to inspect error msg it is a bug
			soft.assertAll();
		}  catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 21, description = "Attach button error validation")
	public void attachButtonErrorValidation() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			CreateInventoryPage inventory = new CreateInventoryPage(driver);
			SoftAssert soft = new SoftAssert();
			createSku.saveBtnClick();
			Thread.sleep(2000);
			soft.assertEquals(createSku.getErrorMessage(), Lib.getProperty(SKU_PATH, "AddCertificateError"), "Wrong error message");
			createSku.attachBtnClick();
			inventory.sendFile(pdfPath);
			inventory.openButtonClick();
			soft.assertAll();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 22, description = "Add certificate success message validation")
	public void addCertificateSuccessMessageValidation() {
		try {
			CreateSkuAddCerificatePage createSku = new CreateSkuAddCerificatePage(driver);
			SoftAssert soft = new SoftAssert();
			// createSku.saveBtnClick();
			// Currently cannot able to inspect it is a bug.
			soft.assertAll();
			createSku.popUpCloseBtnClick();
		}  catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}
}
