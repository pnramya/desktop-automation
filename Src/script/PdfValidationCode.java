package script;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import generic.PdfValidatorUtility;

public class PdfValidationCode 
{
	PdfValidationCode() throws MalformedURLException
	{
		
	}
	public static void main(String[] args) throws IOException 
	{

		PdfValidatorUtility utl=new PdfValidatorUtility();
		utl.validate("FSHVR2/2425/101", "FSHVR2/2425/101","");
	}
	public String pdfTextExtraction() throws IOException 
	{
	String url = new PdfValidatorUtility().localUrlBuilder("FSVJN1/2425/7","A4");
	URL ur =new URL(url);
	InputStream is= ur.openStream();
	BufferedInputStream bis=new BufferedInputStream(is);
	PDDocument doc=PDDocument.load(bis);
	String pdfContent=new PDFTextStripper().getText(doc);
	return pdfContent;
	}
	
}
