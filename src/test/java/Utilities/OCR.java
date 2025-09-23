package Utilities;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class OCR 
{
	public static String extractedTxt;
	public static void extractTxt() 
	{
		try 
		{
            ITesseract tesseract = new Tesseract();

            // Set path to tessdata folder
            tesseract.setDatapath("C:\\Users\\1767\\eclipse-workspace\\slotsAutomationPoC\\src\\main\\resources\\tessdata");
            tesseract.setLanguage("eng");

            extractedTxt = tesseract.doOCR(ScreenshotCapture.subImageFile);
            
            /* implementation of OCR
            double value = Double.parseDouble(extractedOCR.replace(",", ""));
            System.out.println(value);
            System.out.println("OCR Result: " + value);
            */
        } 
		catch (Exception e)
		{
            e.printStackTrace();
        }
	}
}
