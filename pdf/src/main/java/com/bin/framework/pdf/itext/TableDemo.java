package com.bin.pdf.itext;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class TableDemo {
	

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
			
			PdfPTable table = createTable();
			document.add(table);
			
			//...

			// Step 5: Close document
			document.close();
			
			System.out.println("OK");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	private static PdfPTable createTable(){
	
		// Create a table with three columns
        PdfPTable table = new PdfPTable(3);
        
        PdfPCell cell;
        
        // Add a cell with colspan 3
        cell = new PdfPCell(new Phrase("Cell with colspan 3"));
        cell.setColspan(3);
        table.addCell(cell);
        
        // Add a cell with colspan 2
        cell = new PdfPCell(new Phrase("Cell with colspan 2"));
        cell.setColspan(2);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Cell"));
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Cell"));
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Cell"));
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Cell"));
        table.addCell(cell);
        
        return table;
		
	}
	
}
