package script;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import generic.AutoConstant;

public class DeleteSupplier implements AutoConstant{
    private Connection connection;
    private Statement statement;

    public DeleteSupplier() throws SQLException {
        String jdbcUrl = "jdbc:sqlserver://" + serverName + ";databaseName=" + dataBaseName;
        connection = DriverManager.getConnection(jdbcUrl, dataBaseUserName, dataBasePassword);
        statement = connection.createStatement();
    }

    public void deleteSupplier(String supplierName) throws SQLException {
        try {
            // Start a transaction
            connection.setAutoCommit(false);

            // Find the supplier id
            String getProductQuery = "select id from tblsupplier where name='" + supplierName + "'";
            ResultSet results = statement.executeQuery(getProductQuery);
            int supplierId = 0;
            if (results.next()) {
                supplierId = results.getInt("id");
            }

            // Update related tables
            String updatePurchaseorder = "update tblpurchaseorder_supplier_mapping set supplier_ref = 1 where supplier_ref =" + supplierId;
            statement.executeUpdate(updatePurchaseorder);

            String updateBankDetails = "update tblbank_details set supplier_ref = 1 where supplier_ref =" + supplierId;
            statement.executeUpdate(updateBankDetails);

            // Delete the supplier
            String deleteSupplierQuery = "delete from tblsupplier where name='" + supplierName + "'";
            statement.executeUpdate(deleteSupplierQuery);

            // Commit the transaction
            connection.commit();
        } catch (SQLException e) {
            // Rollback the transaction in case of any error
            connection.rollback();
            throw e; // Rethrow the exception
        } finally {
            // Restore auto-commit mode
            connection.setAutoCommit(true);

            // Close statement and connection
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            DeleteSupplier obj = new DeleteSupplier();
            String supplierNameToDelete = "MaSurSupplier62701";
            obj.deleteSupplier(supplierNameToDelete);
            System.out.println("query executed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}






























//package script;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import generic.AutoConstant;
//
//public class DeleteSupplier implements AutoConstant{
//	private Connection connection;
//	private static Statement statement;
//
//	public DeleteSupplier() throws SQLException {
//		String jdbcUrl = "jdbc:sqlserver://" + serverName + ";databaseName=" + dataBaseName;
//		connection = DriverManager.getConnection(jdbcUrl, dataBaseUserName, dataBasePassword);
//		statement = connection.createStatement();
//		
////				select * from tblsupplier where name='MaSurSupplier58028'
////				//take id		
////				select * from tblpurchaseorder_supplier_mapping where supplier_ref = 354
////				update tblpurchaseorder_supplier_mapping set supplier_ref = 1 where supplier_ref = 354
////				
////
////				select * from tblbank_details where supplier_ref = 354
////				//id=290
////				update tblbank_details set supplier_ref = 1 where id = 290
////
////				delete from tblsupplier where name='MaSurSupplier58028'
//	}
//	
//	
//	public static void main(String[] args) throws SQLException { 
//		DeleteSupplier obj = new DeleteSupplier();
//		String getProductQuery = "select * from tblsupplier where name='MaSurSupplier62701'";
//		ResultSet results = statement.executeQuery(getProductQuery);
//		System.out.println(results);
//		
//		int supplier_ref = 0;
//	    while (results.next()) {
//	        // Assuming 'name' is a column in your table
//	        int id = results.getInt("id");
//	        // Print out the retrieved data
//	       // System.out.println("Name: " + id);
//	        supplier_ref=id;
//	        
//	    }
//	    
//	    System.out.println("supplier_ref : "+supplier_ref);
//	    
//	   String updatePurchaseorder="update tblpurchaseorder_supplier_mapping set supplier_ref = 1 where supplier_ref ="+supplier_ref+"";
//   ResultSet results1 = statement.executeUpdate(updatePurchaseorder);
//		
//		String tblbank_details="select * from tblbank_details where supplier_ref = "+supplier_ref+"";
//		ResultSet tblbank_result = statement.executeQuery(tblbank_details);
//		
//		int bankId = 0;
//	    while (tblbank_result.next()) {
//	        // Assuming 'name' is a column in your table
//	        int id = results.getInt("id");
//	        // Print out the retrieved data
//	       // System.out.println("Name: " + id);
//	        bankId=id;
//	        
//	    }
//System.out.println("Bank Id : "+bankId);
//
//
//String updatebank_details="update tblbank_details set supplier_ref = 1 where id = "+bankId+"";
//ResultSet updateBank_Result = statement.executeQuery(updatebank_details);	
//
////delete query
//String deleteSupplier="delete from tblsupplier where name='MaSurSupplier58028'";
//ResultSet deleteBank_Result = statement.executeQuery(deleteSupplier);	
//
//System.out.println("deleteBank_Result : "+deleteBank_Result);
//
//	}
//
//}
