package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.windows.WindowsDriver;

public class Lib {
	private Lib() {
		throw new AssertionError("UtilityClass cannot be instantiated");
	}
	public static void writeProperties(String key, String value) throws IOException {

		String path = "./data/write.properties";
		File file = new File(path);
		file.createNewFile();
		Properties pr = new Properties();
		// load existing properties
		pr.load(new FileInputStream(path));
		// check key and value
		if ((key != null) && (value != null)) {
			pr.setProperty(key, value);
		}
		FileOutputStream fis = new FileOutputStream(path);
		pr.store(fis, "Test Data");
		fis.close();
	}
	
	
	public static void writeList(String key, List<String> randomSupplierNames) throws IOException {
        String path = "./data/writelist.properties";
        Properties pr = new Properties();

        // Load existing properties
        try (FileInputStream fis = new FileInputStream(path)) {
            pr.load(fis);
        } catch (FileNotFoundException e) {
            // If the file doesn't exist, create a new one
            pr = new Properties();
        }

        // Convert list to a comma-separated string
        String values = String.join(",", randomSupplierNames);

        // Set the property
        pr.setProperty(key, values);

        // Save the properties to file
        try (FileOutputStream fos = new FileOutputStream(path)) {
            pr.store(fos, "Test Data");
        }
    }

	 public static String getProperty(String path, String key) {
	        String value = "";
	        try {
	            Properties properties = new Properties();
	            properties.load(new FileInputStream(path));
	            value = properties.getProperty(key);
	        } catch (IOException e) {
	        	Reporter.log(e.getMessage(), true);
	        }
	        return value;
	    }

	public static String writeProperty(String path, String key) {
		String value = "";
		try {
			Properties prop = new Properties();
			OutputStream write = new FileOutputStream(path);
			prop.setProperty("ProductID", key);
			prop.store(write, "ProductID is:");
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
		}
		return value;
	}

	public static double readXls(String xlPath, String sheet, int row, int col) {
		double value = 0;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(xlPath));
			value = wb.getSheet(sheet).getRow(row).getCell(col).getNumericCellValue();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
		}
		return value;
	}

	public static int getRowcount(String xlPath, String sheet) {
		int rc = 0;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(xlPath));
			rc = wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
		}
		return rc;
	}

	public static String getNumValue(String xlPath, String sheet, int row, int col) {
		String value = "";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(xlPath));
			value = wb.getSheet(sheet).getRow(row).getCell(col).toString();
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
		}
		return value;
	}

	public static int getRandomNumber(int min, int max) {
		 return (int) (Math.random() * (max - min)) + min;
	}

	public static void writeXls(String xlPath, String sheetName, int row, int col, String value) {
		try {
			FileInputStream fis = new FileInputStream(xlPath);
			Workbook wb = new XSSFWorkbook(fis); // Use XSSFWorkbook for XLSX format

			Sheet sheet = wb.getSheet(sheetName);
			if (sheet == null) {
				sheet = wb.createSheet(sheetName);
			}

			Row excelRow = sheet.getRow(row);
			if (excelRow == null) {
				excelRow = sheet.createRow(row);
			}

			Cell cell = excelRow.getCell(col);
			if (cell == null) {
				cell = excelRow.createCell(col);
			}

			cell.setCellValue(value);

			FileOutputStream fos = new FileOutputStream(xlPath);
			wb.write(fos);

			fos.close();
			fis.close();

		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
		}
	}

	
	public static void SelectDropDownOptionByVisibleName(WindowsDriver<WebElement> driver, WebElement dropDownElement,String Option) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dropDownElement.click();
		dropDownElement.sendKeys(Option);
		driver.findElementByName(Option).click();
		Thread.sleep(1000);
	}
	
	public static void scrollDown(WebElement ele) {
	    WebElement pageDown =ele ;
	    for (int i = 0; i < 4; i++) {
	        pageDown.click();
	    }
	}
	
	public static void assertEqualsIgnoreCase(String actual, String expected) {
        Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase());
    }
   
}