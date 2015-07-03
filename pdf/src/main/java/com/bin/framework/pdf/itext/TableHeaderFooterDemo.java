package com.bin.framework.pdf.itext;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class TableHeaderFooterDemo {
	

	public static void main(String[] args) {
		try {
			
			// Step 1: Init document
			Document document = new Document();
			
			// Step 2: Init pdf file
			String file = "Pdf.pdf"; // Default will 'pdf' project folder
			PdfWriter.getInstance(document, new FileOutputStream(file));
			
			// Step 3: Open document
			document.open();
			
			
			// Step 4: Add connent
			
	        for (int i = 0; i < 4; i ++) {
	            document.add(createTable());
	            document.newPage();
	        }
			
			//...

			// Step 5: Close document
			document.close();
			
			System.out.println("OK");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	private static PdfPTable createTable(){
	
        PdfPTable table = new PdfPTable(3);
        
        // Add the first header row
        PdfPCell cell = new PdfPCell(new Phrase("10.10.10"));
        cell.setColspan(3);
        table.addCell(cell);
        
        // Add the second header row twice
        for (int i = 0; i < 2; i++) {
            table.addCell("Col1");
            table.addCell("Col2");
            table.addCell("Col3");
        }
        
        // There are three special rows
        table.setHeaderRows(3); // NOTE HERE: 1 is first header, 2 is 'header row twice' that added above
        
        // One of them is a footer
        table.setFooterRows(1);
        
        // Data
        for (int i = 0; i < 100; i ++) {
            table.addCell("1");
            table.addCell("2");
            table.addCell("3");
        }
        return table;
		
	}
	
}
