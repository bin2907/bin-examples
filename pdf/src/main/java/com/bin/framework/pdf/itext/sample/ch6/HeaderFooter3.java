package com.bin.framework.pdf.itext.sample.ch6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;


public class HeaderFooter3{

	/** The resulting PDF file. */
    public static final String RESULT
        = "HeaderFooter3.pdf";
 
    /** Inner class to add a header and a footer. */
    class HeaderFooter extends PdfPageEventHelper {
        /** Alternating phrase for the header. */
        Phrase[] header = new Phrase[2];
        /** Current page number (will be reset for every chapter). */
        int pagenumber;
 
        /**
         * Initialize one of the headers.
         * @see com.itextpdf.text.pdf.PdfPageEventHelper#onOpenDocument(
         *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
         */
        public void onOpenDocument(PdfWriter writer, Document document) {
            header[0] = new Phrase("Movie history");
        }
 
        /**
         * Initialize one of the headers, based on the chapter title;
         * reset the page number.
         * @see com.itextpdf.text.pdf.PdfPageEventHelper#onChapter(
         *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document, float,
         *      com.itextpdf.text.Paragraph)
         */
        public void onChapter(PdfWriter writer, Document document,
                float paragraphPosition, Paragraph title) {
            header[1] = new Phrase(title.getContent());
            pagenumber = 1;
        }
 
        /**
         * Increase the page number.
         * @see com.itextpdf.text.pdf.PdfPageEventHelper#onStartPage(
         *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
         */
        public void onStartPage(PdfWriter writer, Document document) {
            pagenumber++;
        }
 
        /**
         * Adds the header and the footer.
         * @see com.itextpdf.text.pdf.PdfPageEventHelper#onEndPage(
         *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
         */
        public void onEndPage(PdfWriter writer, Document document) {
            Rectangle rect = writer.getBoxSize("art");
            rect.setBackgroundColor(BaseColor.RED);// CAN NOT SET <<<<<<<<< WHY
            
            // Add header
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_RIGHT, header[0],
                    rect.getRight(), rect.getTop(), 0);
            
            // Add footer
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase(String.format("page number %d", pagenumber)),
                    (rect.getLeft() + rect.getRight()) / 2, rect.getBottom() - 18, 0);
        }
    }
 
    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException 
     * @throws    IOException
     * @throws    SQLException
     */
    public void createPdf(String filename)
        throws IOException, DocumentException, SQLException {
        
    	Document document = new Document();
    	
    	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
		
		// Header footer
		HeaderFooter event = new HeaderFooter();
		Rectangle rectangle = new Rectangle(36, 54, 559, 788);
		writer.setBoxSize("art", rectangle);
        writer.setPageEvent(event);
		

		// Open PDF Document for adding content to PDF file
		document.open();

		for(int i = 1; i < 5; i ++){
			document.add(new Paragraph("Tesing is successful!"));
			
			// New Page
			document.newPage();
		}
		
		// Close PDF Document
		document.close();
		writer.close();
    	
    }
 
    /**
     * Main method.
     *
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException 
     * @throws SQLException
     */
    public static void main(String[] args)
        throws IOException, DocumentException, SQLException {
        new HeaderFooter3().createPdf(RESULT);
    }
	
}
