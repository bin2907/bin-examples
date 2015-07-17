package com.bin.pdf.itext;

import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

public class ChunkDemo {
	

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
			
			int count = 0;
			while (count < 10) {
	            document.add(new Chunk("Chunk" + count));
	            document.add(new Chunk(" "));
	            document.add(Chunk.NEWLINE);
	            count ++;
	        }
			
			//...

			// Step 5: Close document
			document.close();
			
			System.out.println("OK");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
}
