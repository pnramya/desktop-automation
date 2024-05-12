package script;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import generic.AutoConstant;

public class DeleteSkuQuery implements AutoConstant {
	private Connection connection;
	private Statement statement;

	public DeleteSkuQuery() throws SQLException {
		String jdbcUrl = "jdbc:sqlserver://" + serverName + ";databaseName=" + dataBaseName;
		connection = DriverManager.getConnection(jdbcUrl, dataBaseUserName, dataBasePassword);
		statement = connection.createStatement();
	}

	public void fetchData() throws SQLException {
		// get data method
	}

	public void deleteData() throws SQLException {
//Commented for SKU creation code

//	    String getProductQuery = "select * from tblproduct where name='" + productName + "'";
//	    ResultSet results = statement.executeQuery(getProductQuery);
//
//	    int globalManufactureRef = 0;
//	    while (results.next()) {
//	        int productManufactureRef = results.getInt(4);
//	        globalManufactureRef = productManufactureRef;
//	    }

//	    String manufactureRefQuery = "select * from tblproducttype_manufacture_mapping where id=" + globalManufactureRef;
//	    results = statement.executeQuery(manufactureRefQuery);
//
//	    int globalProductTypeRef = 0;
//	    while (results.next()) {
//	        int productTypeRef = results.getInt(2);
//	        int manufactureTypeRef = results.getInt(3);
//	        globalProductTypeRef = productTypeRef;
//	    }
		String getProductQuery = "select * from tblmanufacture where name='" + brandName + "'";
		ResultSet results = statement.executeQuery(getProductQuery);

		int manufactureRef = 0;
		while (results.next()) {
			int productManufactureRef = results.getInt(1);
			manufactureRef = productManufactureRef;
		}
		System.out.println("globalManufactureRef :" + manufactureRef);
		String[] deleteQueries = {
//	        "delete  from tblproduct where name='" + productName + "'",
//	        "delete from tblproducttype_manufacture_mapping where id=" + globalManufactureRef,
				"delete from tblproducttype_manufacture_mapping where manufacture_ref=" + manufactureRef,
				"delete from tblmanufacture where name='" + brandName + "'",
				"delete from tblproducttype where name='" + subCategoryName + "'",
				"delete from tblcategory where name='" + categoryName + "'" };

		for (String query : deleteQueries) {
			statement.executeUpdate(query);
		}

		connection.commit();
		System.out.println("Query Executed");
	}

//  For manually checking whether the delete query code working fine or not.	
//	public static void main(String[] args) {
//			try {
//				DeleteSkuQuery obj = new DeleteSkuQuery();
//				// obj.fetch_data();
//				obj.deleteData();
//				obj.connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
	@Test(priority = 1, description = "Delete sku query")
	public void deleteSku() {
		try {
			DeleteSkuQuery obj = new DeleteSkuQuery();
			// obj.fetch_data();
			obj.deleteData();
			System.out.println("qury executed done");
			obj.connection.close();
		} catch (SQLException e) {
			e.getMessage();
		}
	}
}
