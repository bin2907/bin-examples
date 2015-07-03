package com.bin.framework.pdf.itext.sample.ch2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;


public class DirectorOverview1{

	/** The resulting PDF file. */
    public static final String RESULT
        = "director_overview_1.pdf";
 
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
        
        // creating separators
        LineSeparator line
            = new LineSeparator(1, 100, null, Element.ALIGN_CENTER, -2);
        Paragraph stars = new Paragraph(20);
        stars.add(new Chunk(StarSeparator.LINE));
        stars.setSpacingAfter(30);
        // looping over the directors
        for(Director director : Director.getDirectors()) {
            // get the director object and use it in a Paragraph
            Paragraph p = new Paragraph(director.getName());

            // an arrow is added to the left
            if (director.getId() > 2)
                p.add(PositionedArrow.LEFT);
            p.add(line);
            // add the paragraph with the arrow to the document
            document.add(p);
 
            // loop over the movies
            for(Movie movie : Movie.getMovies()) {
                p = new Paragraph(movie.getMovieTitle());
                p.add(": ");
                p.add(new Chunk(String.valueOf(movie.getYear())));
                if (movie.getYear() > 1999)
                    p.add(PositionedArrow.RIGHT);
                document.add(p);
            }
            // add a star separator after the director info is added
            document.add(stars);
        }
        // step 5
        document.close();
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
        new DirectorOverview1().createPdf(RESULT);
    }
	
}
