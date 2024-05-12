package generic;

public interface AutoConstant {
	String INDENT_PATH = "./data/INDENT.properties";
	String STOCKTRANSFER_PATH = "./data/STOCKTRANSFER.properties";
	String WRITE_PATH = "./data/WRITE.properties";
	String SKU_PATH = "./data/SKU.properties";
	String CONFIG_PATH = "./data/CONFIG.properties";
	String INVENTORY_PATH = "./data/INVENTORY.properties";
	String ADDSALES_PATH = "./data/ADDSALES.properties";
	String DataBase_Properties = "./data/DATABASE.properties";
	String CreateSupplier_PATH = "./data/CreateSupplier.properties";
	String Regression_PATH="./data/REGRESSION.properties";
	String APP_PATH ="C:\\Program Files (x86)\\Suggi\\FalcaPOS.exe";
	String WinDriver_Path = System.getProperty("user.dir") + "\\driver\\WinAppDriver.exe";
	String username = "txtLoginUserNameId";
	String password = "txtLoginUserPasswordId";
	String loginBtn = "btnLoginUserId";
	String xlsPath = "C:\\SuggiTestData\\SBIBulk.xlsx";
	String pdfPath = "C:\\SuggiTestData\\ConsumerFlow.png";
	String batchFilePath = "C:\\SuggiTestData\\batchfile.bat";
	
	// Db Data
	String serverName = "172.26.1.14";
	String dataBaseName = "SuggiQADB";
	String dataBaseUserName = "sa";
	String dataBasePassword = "sql2014$";
	//changes
	String productName = "QueryProduct1";
	String brandName = "AutomationBrand3";
	String categoryName = "AutomationCat3";
	String subCategoryName ="AutomationSubCat3";
	int Min=1;
	int Max=999;
}
