package com.bin.pdf.itext.sample.ch2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;


public class DirectorOverview3{

	/** The resulting PDF file. */
    public static final String RESULT = "director_overview_3.pdf";
 
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

        // creates line separators
        Chunk CONNECT = new Chunk(
            new LineSeparator(0.5f, 95, BaseColor.BLUE, Element.ALIGN_CENTER, 3.5f));
        LineSeparator UNDERLINE =
            new LineSeparator(1, 100, null, Element.ALIGN_CENTER, -2);
        // creates tabs
        Chunk tab1 = new Chunk(new VerticalPositionMark(), 200, true);
        Chunk tab2 = new Chunk(new VerticalPositionMark(), 350, true);
        Chunk tab3 = new Chunk(new DottedLineSeparator(), 450, true);
        // loops over the directors
        for(Director director : Director.getDirectors()) {
            // creates a paragraph with the director name
        	Paragraph p = new Paragraph(director.getName());
            // adds a separator
            p.add(CONNECT);
            // adds more info about the director
            p.add(String.format("movies: %d", director.getCount()));
            // adds a separator
            p.add(UNDERLINE);
            // adds the paragraph to the document
            document.add(p);
            // loop over the movies
            for(Movie movie : Movie.getMovies()) {
            	// create a Paragraph with the movie title
                p = new Paragraph(movie.getMovieTitle());
                // insert a tab
                p.add(new Chunk(tab1));
                // add the origina title
                if (movie.getOriginalTitle() != null)
                    p.add(new Chunk(movie.getOriginalTitle()));
                // insert a tab
                p.add(new Chunk(tab2));
                // add the run length of the movie
                p.add(new Chunk(String.format("%d minutes", movie.getDuration())));
                // insert a tab
                p.add(new Chunk(tab3));
                // add the production year of the movie
                p.add(new Chunk(String.valueOf(movie.getYear())));
                // add the paragraph to the document
                document.add(p);
            }
            document.add(Chunk.NEWLINE);
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
        new DirectorOverview3().createPdf(RESULT);
    }
	
}
