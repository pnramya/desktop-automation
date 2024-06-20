package script;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.PdfValidatorUtility;

public class FinalReadInvoiceValidate 
{	
	public static boolean previous=true;
	static FileInputStream fis;
	static String invNum;
	@Test
	public void validateInvoices() throws IOException 
	{
		PdfValidatorUtility pfu=new PdfValidatorUtility();
		Properties properties = new Properties();
		if(previous)
		{
			fis=new FileInputStream("./data/previousInv.properties");
		}
		else
		{
			fis=new FileInputStream("./data/WRITE.properties");
		}
		properties.load(fis);
		int count=1;
		int failCount=0;
		for (int i=1;i<=properties.size();i++)
		{
			if(!previous)
			{
				invNum = properties.getProperty(String.valueOf(count)).substring(1);
			}
			else
			{
				invNum = properties.getProperty(String.valueOf(count));
			}
			String[] parts = invNum.split("  ");
			System.out.println(parts[0]);
			System.out.println(parts[1]);
			System.out.println(parts[2]);
			try {
			pfu.validate(parts[0], parts[0],parts[2]);
			count++;
			}
			catch (Exception e) {
				// TODO: handle exception
				failCount++;
				count++;
			}
		}
		if(failCount>0)
		{
			if(!previous)
			{
				Assert.fail("Failed due to sales invoice sequence number mismatch or not invoice generated in some of the stores.");
			}
			else 
			{
				Assert.fail("Failed due to previous invoice number miss match in sales.");
			}
		}
			
	}
}
