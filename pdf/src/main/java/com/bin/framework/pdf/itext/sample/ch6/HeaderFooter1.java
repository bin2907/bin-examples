package com.bin.framework.pdf.itext.sample.ch6;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import com.bin.framework.pdf.itext.sample.utils.FilmFonts;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;


public class HeaderFooter1{

	/** The resulting PDF file. */
    public static final String RESULT
        = "HeaderFooter1.pdf";
 
    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException 
     * @throws SQLException
     * @throws SQLException
     */
    public static void main(String[] args)
        throws SQLException, DocumentException, IOException {
 
    	// FIRST PASS, CREATE THE PDF WITHOUT HEADER
 
    	// Create a database connection
        // step 1
        Document document = new Document(PageSize.A4);
        // step 2
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        // step 3
        document.open();
        // step 4
        for(int i = 0; i < 10; i ++){
            document.add(new Paragraph("AAAAAAA" + i, FilmFonts.BOLD));
            document.add(Chunk.NEWLINE);
            for(int j = 0; j < 100; j ++){
                document.add(new Paragraph("BBBBB" + j));
            }
            document.newPage();
        }
        // step 5
        document.close();
        // Close the database connection
 
        // SECOND PASS, ADD THE HEADER
 
        // Create a reader
        PdfReader reader = new PdfReader(baos.toByteArray());
        // Create a stamper
        PdfStamper stamper
            = new PdfStamper(reader, new FileOutputStream(RESULT));
        // Loop over the pages and add a header to each page
        int numberOfPages = reader.getNumberOfPages();
        for (int page = 1; page <= numberOfPages; page++) {
        	getHeaderTable(page, numberOfPages).writeSelectedRows(0, -1, 34, 834, stamper.getOverContent(page));
        	getFooterTable(page, numberOfPages).writeSelectedRows(0, -1, 34, 34, stamper.getOverContent(page));
        }
        // Close the stamper
        stamper.close();
        reader.close();
    }
 
    /**
     * Create a header table with page X of Y
     * @param x the page number
     * @param y the total number of pages
     * @return a table that can be used as header
     */
    public static PdfPTable getHeaderTable(int page, int total) {
        PdfPTable table = new PdfPTable(2);
        table.setTotalWidth(527);
        table.setLockedWidth(true);
        table.getDefaultCell().setFixedHeight(20);
        table.getDefaultCell().setBorder(Rectangle.BOTTOM);
        table.addCell("FOOBAR FILMFESTIVAL");
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(String.format("Page %d of %d", page, total));
        return table;
    }
    
    /**
     * Create a header table with page X of Y
     * @param x the page number
     * @param y the total number of pages
     * @return a table that can be used as header
     */
    public static PdfPTable getFooterTable(int page, int total) {
        PdfPTable table = new PdfPTable(2);
        table.setTotalWidth(527);
        table.setLockedWidth(true);
        table.getDefaultCell().setFixedHeight(20);
        table.getDefaultCell().setBorder(Rectangle.TOP);
        table.addCell("FOOBAR FILMFESTIVAL");
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(String.format("Page %d of %d", page, total));
        return table;
    }
	
}
