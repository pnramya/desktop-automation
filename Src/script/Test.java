package script;

import generic.AutoConstant;
import generic.DateAndTime;
import generic.Lib;
import java.util.logging.Level; 
import java.util.logging.Logger; 

public class Test implements AutoConstant {
	private static String salesCustomerPoNumber = "PoNumber";

	public static void main(String[] args) {
        try {
        	DateAndTime date=new DateAndTime();
			System.out.println(date.MinusDays(20));
//        	Logger logger= Logger.getLogger(Test.class.getName());
//        	logger.log(Level.INFO,Lib.getProperty(WRITE_PATH, salesCustomerPoNumber));
//        	logger.log(Level.WARNING,"warning");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
