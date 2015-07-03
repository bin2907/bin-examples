package com.bin.framework.pdf.itext;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PageSizeDemo {
	

	public static void main(String[] args) {
		try {
			
			// Step 1: Init document
			Document document = new Document();
			
			// Set page size
			document.setPageSize(PageSize.A4);
			
			// Step 2: Init pdf file
			String file = "Pdf.pdf"; // Default will 'pdf' project folder
			PdfWriter.getInstance(document, new FileOutputStream(file));
			
			// Step 3: Open document
			document.open();
			
			
			// Step 4: Add connent
			
			Paragraph paragraph = new Paragraph("This is content");
			document.add(paragraph);
			
			//...

			// Step 5: Close document
			document.close();
			
			System.out.println("OK");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
}
