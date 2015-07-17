package com.bin.pdf.itext.sample.ch2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.GreekList;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.RomanList;
import com.itextpdf.text.ZapfDingbatsNumberList;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Implementation of the SplitCharacter interface.
 * Use an instance of this class with Chunk.setSplitCharacter();
 */
public class MovieLists3 {

	/** The resulting PDF file. */
    public static final String RESULT = "movie_lists_3.pdf";
 
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
        // Create database connection and statement
        
        // Create a list for the countries
        List list = new RomanList();
        // Loop over the countries
        for(Country country : Country.getCountries()){
            // Create a list item for the country
        	ListItem item = new ListItem(String.format("%s: %d movies", country.getName(), country.getCount()));
            // Create a list for the movies
            List movielist = new GreekList();
            movielist.setLowercase(List.LOWERCASE);
            // Loop over the movies
            for(Movie movie : Movie.getMovies()) {
                ListItem movieitem = new ListItem(movie.getMovieTitle());
                // Create a list for the directors
                List directorlist = new ZapfDingbatsNumberList(0);
                // Loop over the directors
                for (Director director : movie.getDirectors()) {
                    directorlist.add(String.format("%s, %s",
                       director.getName(), director.getGivenName()));
                }
                movieitem.add(directorlist);
                movielist.add(movieitem);
            }
            item.add(movielist);
            list.add(item);
        }
        document.add(list);
        // Close the statement and the database connection
        
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
    public static void main(String[] args) throws IOException, DocumentException, SQLException {
        new MovieLists3().createPdf(RESULT);
    }

}
