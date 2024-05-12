package script;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Lib;
import generic.WebBase;
import pom.CreateSupplierPage;

public class CreateSupplier extends WebBase {
	int supplierCount=5;
    @DataProvider(name = "supplierData")
    public Object[][] supplierData() throws IOException {
        List<String> randomSupplierNames = generateRandomSupplierNames();
        List<String> randomSupplierGst = generateRandomSupplierGst();
        List<String> randomSupplierPhno = generateRandomSupplierPhno();
        List<String> randomSupplierEmail = generateRandomSupplierEmail();
        int dataSize = Math.min(
            Math.min(randomSupplierNames.size(), randomSupplierGst.size()),
            Math.min(randomSupplierPhno.size(), randomSupplierEmail.size())
        );

        Object[][] data = new Object[dataSize][4];
        for (int i = 0; i < dataSize; i++) {
            data[i][0] = randomSupplierNames.get(i);
            data[i][1] = randomSupplierGst.get(i);
            data[i][2] = randomSupplierPhno.get(i);
            data[i][3] = randomSupplierEmail.get(i);
        }
        return data;
    }

    @Test(dataProvider = "supplierData", description = "Create supplier")
    public void addNewCustomer(String supplierName, String supplierGst, String supplierPhno, String supplierEmail) {
        try {
            CreateSupplierPage createSupplier = new CreateSupplierPage(driver);
            SoftAssert softAssert=new SoftAssert();
            createSupplier.clickSuppliersTab();
            createSupplier.clickSupplierTab();
            createSupplier.clickAddSupplierButton();

            createSupplier.sendKeySupplierName(supplierName);
            createSupplier.sendKeySuppliersGSTNumber(supplierGst);
            createSupplier.clickSupplierType();
            createSupplier.clickManufacturer();
            createSupplier.sendKeySupplierPhno(supplierPhno);
            createSupplier.sendKeySupplierEmail(supplierEmail);
            createSupplier.sendKeySupplierStreet(Lib.getProperty(CreateSupplier_PATH, "SupplierCity")); 
            createSupplier.sendKeySupplierTally(Lib.getProperty(CreateSupplier_PATH, "SupplierTally")); 
            createSupplier.sendKeySupplierState(Lib.getProperty(CreateSupplier_PATH, "SupplierState")); 
            createSupplier.sendKeysupplierCity(Lib.getProperty(CreateSupplier_PATH, "SupplierCity")); 
            createSupplier.sendKeySupplierPinCode(Lib.getProperty(CreateSupplier_PATH, "SupplierPinCode")); 
            createSupplier.sendKeySupplierDistrict(Lib.getProperty(CreateSupplier_PATH, "SupplierDistrict"));          
            createSupplier.clickSuppliersAddButton();
            //Thread.sleep(2000);
            softAssert.assertEquals(createSupplier.getErrorMessage(),Lib.getProperty(CreateSupplier_PATH, "SupplierCreated"));
            createSupplier.clickTheNoRadioButton();
            createSupplier.clickAddSupplierButton();
            createSupplier.sendKeyBankName(Lib.getProperty(CreateSupplier_PATH, "SupplierBank"));
            createSupplier.sendKeyBranchName(Lib.getProperty(CreateSupplier_PATH, "SupplierBranchName"));
            String accountNumber = RandomStringUtils.randomNumeric(11);
            createSupplier.sendKeyAccountNumber(accountNumber);
            createSupplier.clickSaveRadioButton();
            String ifsc = RandomStringUtils.randomNumeric(7);
            //String ifscCode = "SBIN"+ifsc;
            createSupplier.sendKeyifscCode(Lib.getProperty(CreateSupplier_PATH, "SupplierIfscCode"));
            createSupplier.attachButton();
            createSupplier.sendFile(pdfPath);
            createSupplier.openButtonClick();
            createSupplier.clickAddBankButton();
           Thread.sleep(1000);
//            softAssert.assertEquals(createSupplier.getErrorMessage(),Lib.getProperty(CreateSupplier_PATH, "BankDetailsAdded"));
            createSupplier.clickUpdateButton();
            createSupplier.clickUpdateButton();
            //Thread.sleep(1000);
            //softAssert.assertEquals(createSupplier.getErrorMessage(),Lib.getProperty(CreateSupplier_PATH, "SupplierDetailsUpdated"));
            softAssert.assertAll();
        } catch (Exception e) {
            Reporter.log(e.getMessage(), true);
            ITestResult result = Reporter.getCurrentTestResult();
            result.setStatus(ITestResult.FAILURE);
            result.setThrowable(e);
        }
    }

    //Methods to generate random data
    private List<String> generateRandomSupplierNames() throws IOException {
        List<String> randomSupplierNames = new ArrayList<>();
        for (int i = 0; i < supplierCount; i++) {
            String randomName = "QASupplier" + Lib.getRandomNumber(Min, Max);
            randomSupplierNames.add(randomName);
        }
        Lib.writeList("SupplierNames", randomSupplierNames);
        System.out.println("randomSupplierNames :"+randomSupplierNames);
        return randomSupplierNames;
    }

    private List<String> generateRandomSupplierGst() {
        List<String> randomSupplierGst = new ArrayList<>();
        for (int i = 0; i < supplierCount; i++) {
            String randomName = RandomStringUtils.randomAlphabetic(5);
            String randomNumber = RandomStringUtils.randomNumeric(4);
            String randomGst = "22" + randomName + randomNumber + "A1Z5";
            randomSupplierGst.add(randomGst);
        }
        return randomSupplierGst;
    }

    private List<String> generateRandomSupplierPhno() {
        List<String> randomSupplierPhno = new ArrayList<>();
        for (int i = 0; i < supplierCount; i++) {
            String randomNumber = RandomStringUtils.randomNumeric(5);
            String randomPhno = "99885" + randomNumber;
            randomSupplierPhno.add(randomPhno);
        }
        return randomSupplierPhno;
    }

    private List<String> generateRandomSupplierEmail() {
        List<String> randomSupplierEmail = new ArrayList<>();
        for (int i = 0; i < supplierCount; i++) {
            String randomNumber = RandomStringUtils.randomNumeric(5);
            String randomName = "masur" + randomNumber + "@gmail.com";
            randomSupplierEmail.add(randomName);
        }
        return randomSupplierEmail;
    }
}
