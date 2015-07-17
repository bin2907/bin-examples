package com.bin.pdf.itext.sample.ch2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class MovieLinks1{

	 /** The resulting PDF file. */
    public static final String RESULT = "movie_links_1.pdf";
 
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
        new MovieLinks1().createPdf(RESULT);
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
    	// step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        // Create database connection and statement
       
        Paragraph p = new Paragraph();
        Anchor top = new Anchor("US");
        top.setName("US");
        p.add(top);
        document.add(p);
        
        Anchor imdb;
        // loop over the countries
        for(Country c : Country.getCountries()){
            Paragraph country = new Paragraph();
            // the name of the country will be a destination
            Anchor dest = new Anchor(c.getName());
            dest.setName(c.getId() + "");
            country.add(dest);
            country.add(String.format(": %d movies", c.getCount()));
            document.add(country);
            // loop over the movies
            for(Movie movie : Movie.getMovies()) {
            	// the movie title will be an external link
                imdb = new Anchor(movie.getMovieTitle());
                imdb.setReference(
                    String.format("http://www.imdb.com/title/tt%s/", movie.getImdb()));
                document.add(imdb);
                document.add(Chunk.NEWLINE);
            }
            document.newPage();
        }
        // Create an internal link to the first page
        Anchor toUS = new Anchor("Go back to the first page.");
        toUS.setReference("#US");
        document.add(toUS);
 
        document.close();
    }
	
}
