package com.bin.framework.pdf.itext;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PageHeaderFooterDemo {
	

	public static void main(String[] args) {
		try {
			
			// Step 1: Init document
			Document document = new Document();
			
			// Step 2: Init pdf file
			String file = "Pdf.pdf"; // Default will 'pdf' project folder
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(file));
			
			// Step 3: Open document
			document.open();
			
			
			// Step 4: Add connent
			
			// set page events
			HeaderFooter headerFooter = new HeaderFooter();
			pdfWriter.setBoxSize("art", new Rectangle(36, 54, 559, 788)); // NOTE: 'art'
			pdfWriter.setPageEvent(headerFooter);
			
			new HeaderFooter().createHeader(pdfWriter, document);
			
			for(int i = 0; i < 1000; i ++){
				Paragraph paragraph = new Paragraph("This is content");
				document.add(paragraph);
			}
			
			//...

			// Step 5: Close document
			document.close();
			
			System.out.println("OK");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	/** Inner class to add a header and a footer. */
    static class HeaderFooter extends PdfPageEventHelper {
        
        int pagenumber = 1;
 
        /**
         * Initialize one of the headers.
         * @see com.itextpdf.text.pdf.PdfPageEventHelper#onOpenDocument(
         *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
         */
        public void onOpenDocument(PdfWriter writer, Document document) {
        	System.out.println("onOpenDocument");
        }
        
        
 
        /**
         * Increase the page number.
         * @see com.itextpdf.text.pdf.PdfPageEventHelper#onStartPage(
         *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
         */
        public void onStartPage(PdfWriter writer, Document document) {
            pagenumber++;
            createHeader(writer, document);
        }
 
        /**
         * Adds the header and the footer.
         * @see com.itextpdf.text.pdf.PdfPageEventHelper#onEndPage(
         *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
         */
        public void onEndPage(PdfWriter writer, Document document) {
        	
        	// Header
        	/*ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase("Header"),
                    document.leftMargin() - 1 , document.top(), 0);*/
        	
        	
        	// Footer
        	ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase(String.format("page %d", pagenumber)),
                    document.right() - 2 , document.bottom() - 20, 0);
        }
        
        private void createHeader(PdfWriter writer, Document document){
            
            PdfPTable table = new PdfPTable(1);
            table.addCell(new PdfPCell(new Phrase("Header")));

            try {
				document.add(table);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
        }
        
    }
}
