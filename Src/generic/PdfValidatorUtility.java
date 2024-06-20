package generic;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Reporter;

public class PdfValidatorUtility 
{
	public PdfValidatorUtility() throws MalformedURLException
	{
		
	}
	/**
	 * @implNote It will read the pdf file and and gives entire pdf content as a string.
	 * @param seqnumber
	 * @param storeName
	 * @return pdf content as a String
	 * @throws IOException
	 *@author kyogesh
	 */
	public String pdfTextExtraction(String seqnumber,String storeName) throws IOException  
	{
		String url=localUrlBuilder(seqnumber,"A4");
		InputStream is=null;
		String pdfContent=null;
		try
		{
			URL ur =new URL(url);
			is= ur.openStream();
			BufferedInputStream bis=new BufferedInputStream(is);
			PDDocument doc=PDDocument.load(bis);
			pdfContent=new PDFTextStripper().getText(doc);
		} catch (Exception e) 
		{
			e.printStackTrace();
			url=localUrlBuilder(seqnumber,"4inch");
			URL ur =new URL(url);
			try {
				is= ur.openStream();
			} catch (IOException e1) 
			{
				e1.printStackTrace();
				System.out.println("Invoice number is not matching for ---"+seqnumber);
				Reporter.log("Invoice sequence is not matching for ---"+seqnumber+"  "+storeName);
			}
			BufferedInputStream bis=new BufferedInputStream(is);
			PDDocument doc=PDDocument.load(bis);
			pdfContent=new PDFTextStripper().getText(doc);
		}
		  // System.out.println(pdfContent);
	       return pdfContent;
	}
	/**
	 * 
	 * @param StoreSequence
	 * @param size
	 * @return Loacal pdf file path as a String.
	 * @author kyogesh
	 */
	public String localUrlBuilder(String StoreSequence,String size)
	{
		String[] parts=StoreSequence.split("/");
		//String baseFormat="file:///C:/Users/kyogesh/Downloads/"+parts[0]+"_"+parts[1]+"_"+parts[2]+"__A4_signed.pdf";
		String baseFormat="file:///C:/Users/kyogesh/Downloads/"+parts[0]+"_"+parts[1]+"_"+parts[2]+"__"+size+"_signed.pdf";
		//file:///C:/Users/basavaraj/Downloads/FSHVR2_2425_142__A4_signed.pdf
		return baseFormat;
	}
	/**
	 * 
	 * @param invoiceSeq
	 * @param expectedSeq
	 * @param storeName
	 * @throws IOException
	 * It will validate the invoice number from store sales page and invoice number in the downloaded pdf.
	 */
	public void validate(String invoiceSeq, String expectedSeq, String storeName) throws IOException 
	{
		if(pdfTextExtraction(invoiceSeq,storeName).contains(expectedSeq))
		{
			System.out.println("Invoice sequence is matching");
			Reporter.log("Invoice sequence is matching for--->"+invoiceSeq,true);
		}
		else
		{
			System.out.println("Invoice sequence is not matching for ---"+invoiceSeq);
			Reporter.log("Invoice sequence is not matching for ---"+invoiceSeq+"  "+storeName,true);
		}
	}
}
