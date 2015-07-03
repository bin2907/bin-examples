package com.bin.framework.pdf.itext.sample.ch2;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;

/**
 * Writes a list of directors to a PDF file.
 */
public class DirectorPhrases2  extends DirectorPhrases1{

	/** The resulting PDF file. */
    public static final String RESULT = "director_phrases_2.pdf";
 
    /** A font that will be used in our PDF. */
    public static final Font BOLD;
    /** A font that will be used in our PDF. */
    public static final Font NORMAL;
 
    static {
        BaseFont timesbd = null;
        BaseFont times = null;
        try {
            // create a font that will be embedded
            timesbd = BaseFont.createFont(
                "c:/windows/fonts/timesbd.ttf", BaseFont.WINANSI, BaseFont.EMBEDDED);
            // create a font that will be embedded
            times = BaseFont.createFont(
                "c:/windows/fonts/times.ttf", BaseFont.WINANSI, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        BOLD = new Font(timesbd, 12);
        NORMAL = new Font(times, 12);
    }
 
    /**
     * Creates a Phrase with the name and given name of a director using different fonts.
     * @param    rs    the ResultSet containing director records.
     */
    public Phrase createDirectorPhrase(Country country)
        throws UnsupportedEncodingException, SQLException {
        Phrase director = new Phrase();
        Chunk name = new Chunk(new String(country.getName().getBytes(), "UTF-8"), BOLD);
        name.setUnderline(0.2f, -2f);
        director.add(name);
        director.add(new Chunk(",", BOLD));
        director.add(new Chunk(" ", NORMAL));
        director.add(
            new Chunk(new String(country.getName().getBytes(), "UTF-8"), NORMAL));
        director.setLeading(24);
        return director;
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
        new DirectorPhrases2().createPdf(RESULT);
    }

}
