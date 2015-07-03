package com.bin.framework.pdf.itext.sample.ch4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class HeaderFooter1{

	/** The resulting PDF file. */
    public static final String RESULT = "header_footer_1.pdf";
 
    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException 
     * @throws    IOException
     * @throws    SQLException
     */
    public void createPdf(String filename)
        throws SQLException, DocumentException, IOException {
        // step 1
        Document document = new Document(PageSize.A4.rotate());
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        for (int i = 0; i < 10; i ++) {
            document.add(getTable());
            document.newPage();
        }
        // step 5
        document.close();
 
    }
 
    /**
     * Creates a table with screenings.
     * @param connection the database connection
     * @param day a film festival day
     * @return a table with screenings
     * @throws SQLException
     * @throws DocumentException
     * @throws IOException
     */
    public PdfPTable getTable()
        throws SQLException, DocumentException, IOException {
    	// Create a table with 7 columns
        PdfPTable table = new PdfPTable(new float[] { 2, 1, 2, 5, 1, 3, 2 });
        table.setWidthPercentage(100f);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);
        // Add the first header row
        Font f = new Font();
        f.setColor(BaseColor.WHITE);
        PdfPCell cell = new PdfPCell(new Phrase("aaaa", f));
        cell.setBackgroundColor(BaseColor.BLACK);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(7);
        table.addCell(cell);
        // Add the second header row twice
        table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
        for (int i = 0; i < 2; i++) {
            table.addCell("Location");
            table.addCell("Time");
            table.addCell("Run Length");
            table.addCell("Title");
            table.addCell("Year");
            table.addCell("Directors");
            table.addCell("Countries");
        }
        table.getDefaultCell().setBackgroundColor(null);
        // There are three special rows
        table.setHeaderRows(3);
        // One of them is a footer
        table.setFooterRows(1);
        for (int i = 0; i <= 10; i ++) {
            table.addCell("aaaa");
            table.addCell("aaaa");
            table.addCell("aaaa");
            table.addCell("aaaa");
            table.addCell("aaaa");
            cell = new PdfPCell();
            cell.setUseAscender(true);
            cell.setUseDescender(true);
            table.addCell("aaaa");
            table.addCell(cell);
            cell = new PdfPCell();
            cell.setUseAscender(true);
            cell.setUseDescender(true);
            table.addCell("aaaa");
            table.addCell(cell);
        }
        return table;
    }
 
    /**
     * Main method.
     * @param args no arguments needed
     * @throws DocumentException 
     * @throws IOException
     * @throws SQLException
     */
    public static void main(String[] args)
        throws SQLException, DocumentException, IOException {
        new HeaderFooter1().createPdf(RESULT);
    }
	
}
