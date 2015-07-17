package com.bin.pdf.itext.sample.ch2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class MoviePosters1{

	/** Path to the resulting PDF */
    public static final String RESULT
        = "movie_posters_1.pdf";
 
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
        new MoviePosters1().createPdf(RESULT);
    }
 
    /**
     * Creates a PDF with information about the movies
     * @param    filename the name of the PDF file that will be created.
     * @throws    DocumentException 
     * @throws    IOException 
     * @throws    SQLException
     */
    public void createPdf(String filename)
        throws IOException, DocumentException, SQLException {
 
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        Rectangle rect = new Rectangle(0, 806, 36, 842);
        rect.setBackgroundColor(BaseColor.RED);
        document.add(rect);
        // step 4
        for (int i = 1; i < 3; i ++) {
            document.add(new Paragraph("Title: " + i));
            // Add an image
            document.add(Image.getInstance("src\\main\\resources\\"+i + ".jpg"));
        }
        // step 5
        document.close();
 
    }
	
}
