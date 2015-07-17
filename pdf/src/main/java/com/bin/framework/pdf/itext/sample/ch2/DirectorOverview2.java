package com.bin.pdf.itext.sample.ch2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;


public class DirectorOverview2{

	/** The resulting PDF file. */
    public static final String RESULT
        = "director_overview_2.pdf";
 
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
        // step 4
        
        for(Director director : Director.getDirectors()) {
        	// get the director object and use it in a Paragraph
            Paragraph p = new Paragraph(director.getName());
            // add a dotted line separator
            p.add(new Chunk(new DottedLineSeparator()));
            // adds the number of movies of this director
            p.add(String.format("movies: %d", director.getId()));
            document.add(p);
            // Creates a list
            List list = new List(List.ORDERED);
            list.setIndentationLeft(36);
            list.setIndentationRight(36);
            // Gets the movies of the current director
            
            // loops over the movies
            for(Movie movie : Movie.getMovies()) {
            	// creates a list item with a movie title
            	ListItem movieitem = new ListItem(movie.getMovieTitle());
                // adds a vertical position mark as a separator
                movieitem.add(new Chunk(new VerticalPositionMark()));
                // adds the year the movie was produced
                movieitem.add(new Chunk(String.valueOf(movie.getYear())));
                // add an arrow to the right if the movie dates from 2000 or later
                if (movie.getYear() > 1999) {
                    movieitem.add(PositionedArrow.RIGHT);
                }
                // add the list item to the list
                list.add(movieitem);
            }
            // add the list to the document
            document.add(list);
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
        new DirectorOverview2().createPdf(RESULT);
    }
	
}
