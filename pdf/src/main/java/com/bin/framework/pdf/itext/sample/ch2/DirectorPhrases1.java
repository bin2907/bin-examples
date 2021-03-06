package com.bin.pdf.itext.sample.ch2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;


public class DirectorPhrases1 {

	/** The resulting PDF file. */
    public static final String RESULT = "director_phrases_1.pdf";
 
    /** A font that will be used in our PDF. */
    public static final Font BOLD_UNDERLINED =
        new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD | Font.UNDERLINE);
    /** A font that will be used in our PDF. */
    public static final Font NORMAL =
        new Font(FontFamily.TIMES_ROMAN, 12);
 
    /**
     * Creates a Phrase with the name and given name of a director using different fonts.
     * @param    rs    the ResultSet containing director records.
     */
    public Phrase createDirectorPhrase(Country country)
        throws UnsupportedEncodingException, SQLException {
        Phrase director = new Phrase();
        director.add(
            new Chunk(new String(country.getName().getBytes(), "UTF-8"), BOLD_UNDERLINED));
        director.add(new Chunk(",", BOLD_UNDERLINED));
        director.add(new Chunk(" ", NORMAL));
        director.add(
            new Chunk(new String(country.getName().getBytes(), "UTF-8"), NORMAL));
        return director;
    }
    
    /**
     * Creates a PDF file with director names.
     * @param    filename    the name of the PDF file that needs to be created.
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
        // create the database connection and statement
        /*DatabaseConnection connection = new HsqldbConnection("filmfestival");
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(
            "SELECT name, given_name FROM film_director ORDER BY name, given_name");*/
        // loop over the results
        for(Country country : Country.getCountries()){
            document.add(createDirectorPhrase(country));
            document.add(Chunk.NEWLINE);
        }
        // close the statement and database connection
        /*stm.close();
        connection.close();*/
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
        new DirectorPhrases1().createPdf(RESULT);
    }

}
