package script;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.DateAndTime;
import generic.Lib;
import generic.WebBase;
import pom.IndentFinancePaymentPage;
import pom.IndentPlanByStorePersonPage;

public class IndentFinancePayments extends WebBase {
	private IndentPlanByStorePersonPage indentPlan;
	private String xlPath;

	@Test(priority = 1, description = "Paymentdate and utr should not empty error message validation")
	public void paymentDateAndUTRValidation() {
		try {
			indentPlan = new IndentPlanByStorePersonPage(driver);
			IndentFinancePaymentPage financePayment = new IndentFinancePaymentPage(driver);
			indentPlan.clickIndentTab();
			financePayment.clickIndentPaymentBulkUpdateTab();
			// In payment while uploading blank excel sheet, loading of error pop up is
			// taking more time.
//			financePayment.clickIndentPaymentUploadTab();
//			financePayment.clickIndentPaymentUploadButton();
//			financePayment.sendFile(xlspath);
//			financePayment.clickOpenButton();
			// assertEquals(financePayment.getErrorMessage(), Lib.getProperty(INDENT_PATH,
			// "PaymentDateAndUtrError"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 2, description = "Select store error message validation")
	public void selectStoreValidation() {
		try {
			IndentFinancePaymentPage financePayment = new IndentFinancePaymentPage(driver);
			financePayment.clickIndentPaymentBulkDownloadTab();
			financePayment.clickSearchButton();
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "SelectStore"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 3, description = "Select supplier error message validation")
	public void selectSupplierValidation() {
		try {
			IndentFinancePaymentPage financePayment = new IndentFinancePaymentPage(driver);
			financePayment.sendStoreName(Lib.getProperty(INDENT_PATH, "StoreName"));
			financePayment.clickSearchButton();
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "Selectsupplier"));

		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 4, description = "From date error message validation")
	public void fromDateValidation() {
		try {
			IndentFinancePaymentPage financePayment = new IndentFinancePaymentPage(driver);
			financePayment.clickSupplierDropDown();
//			Actions action = new Actions(driver);
//			action.sendKeys(Keys.PAGE_DOWN).perform();
//			action.sendKeys(Keys.PAGE_DOWN).perform();
//			action.sendKeys(Keys.PAGE_DOWN).perform();
			String supplierName = Lib.getProperty(INDENT_PATH, "SupplierName");
			WebElement supplier = driver.findElementByName(supplierName);
			supplier.click();
			// SupplierName dropdown code commented
			financePayment.clickSearchButton();
			financePayment.clickSearchButton();
			Thread.sleep(1000);
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "EnterFromDate"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}
	
	@Test(priority = 5, description = "To date error message validation")
	public void supplierNameValidation() {
		try {
			IndentFinancePaymentPage financePayment = new IndentFinancePaymentPage(driver);
			DateAndTime date=new DateAndTime();
			financePayment.sendFromDate("01-01-2024");
			financePayment.clickSearchButton();
			Thread.sleep(1000);
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "EnterToDate"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}
	//PART_TextBox
	@Test(priority = 6, description = "Select bank error message validation")
	public void selectBankValidation() {
		try {
			IndentFinancePaymentPage financePayment = new IndentFinancePaymentPage(driver);
			DateAndTime date=new DateAndTime();
			financePayment.sendToDate(date.currentdate());
			financePayment.clickSearchButton();
			financePayment.clickPlusButton();
			// PO/FS/CTA4/13
			String poNumber = Lib.getProperty(WRITE_PATH, "PoNumber");
			WebElement poNo = driver.findElementByName(poNumber);
			poNo.click();
			financePayment.clickDownloadButton();
			Thread.sleep(1000);
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "SelectBankError"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 7, description = "Download and update the bulk payment sheet")
	public void updateTheBulkPayment() {
		try {
			IndentFinancePaymentPage financePayment = new IndentFinancePaymentPage(driver);
			financePayment.clickSbiBankRedioButton();
			Thread.sleep(1000);
			financePayment.clickDownloadButton();
			financePayment.clickDownloadButton();
			Thread.sleep(2000);
			System.out.println("Kill Excel");
			System.out.flush();
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", batchFilePath);
			builder.redirectErrorStream(true);
			Process process = builder.start();
			int exitCode = process.waitFor();
			if (exitCode == 0) {
				System.out.println("Batch file executed successfully.");
			} else {
				System.err.println("Failed to execute the batch file. Exit code: " + exitCode);
			}
			Thread.sleep(1000);
			String path = indentPlan.getErrorMessage() + ".xlsx";
			xlPath = path.replace("File exported to folder ", "");
			Thread.sleep(2000);
			String sheet = Lib.getProperty(INDENT_PATH, "SheetName");
			indentXlsWrite(xlPath, sheet);
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	@Test(priority = 8, description = "Indent payment completed success message validation")
	public void indentPaymentCompleted() {
		try {
			IndentFinancePaymentPage financePayment = new IndentFinancePaymentPage(driver);
			financePayment.clickIndentPaymentUploadTab();
			financePayment.clickIndentPaymentUploadButton();
			financePayment.sendFile(xlPath);
			financePayment.clickOpenButton();
			Thread.sleep(2000);
			financePayment.clickUpdateButton();
			Thread.sleep(2000);
			assertEquals(indentPlan.getErrorMessage(), Lib.getProperty(INDENT_PATH, "IndentPaymentCompleted"));
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}

	public void indentXlsWrite(String xlPath, String sheetName) {
		int utr = Lib.getRandomNumber(1, 9999);
		int rowPosition = 1;
		int utrColPosition = 15;
		int colPosition = 16;
		String excelDateFormat = "dd-MM-yyyy";

		try (FileInputStream fis = new FileInputStream(xlPath)) {
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet targetSheet = workbook.getSheet(sheetName);

			if (targetSheet == null) {
				targetSheet = workbook.createSheet(sheetName);
			}

			// Create a cell style with the desired date format
			CellStyle cellStyle = workbook.createCellStyle();
			DataFormat dateFormat = workbook.createDataFormat();
			cellStyle.setDataFormat(dateFormat.getFormat(excelDateFormat));

			// create the cell at the specified position
			Row row = targetSheet.getRow(rowPosition);
			if (row == null) {
				row = targetSheet.createRow(rowPosition);
			}

			// Write UTR number to cell 13
			Cell utrCell = row.createCell(utrColPosition);
			utrCell.setCellValue(utr);

			// Set the value and apply the date format style
			Cell cell = row.createCell(colPosition);
			cell.setCellValue(new Date());
			cell.setCellStyle(cellStyle);

			// Write the modified workbook to the output file
			try (FileOutputStream fos = new FileOutputStream(xlPath)) {
				workbook.write(fos);
			}

		} catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
			ITestResult result = Reporter.getCurrentTestResult();
			result.setStatus(ITestResult.FAILURE);
			result.setThrowable(e);
		}
	}
}
