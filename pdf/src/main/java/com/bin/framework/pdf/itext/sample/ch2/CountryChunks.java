package com.bin.framework.pdf.itext.sample.ch2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;


public class CountryChunks {

	/** The resulting PDF file. */
    public static final String RESULT
        = "country_chunks.pdf";
 
    public static void main(String[] args)
            throws IOException, DocumentException, SQLException {
            new CountryChunks().createPdf(RESULT);
        }
    
    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException
     * @throws    IOException
     * @throws    SQLException
     */
    public void createPdf(String filename)
        throws IOException, DocumentException, SQLException{
    	
    	 Document document = new Document();
         // step 2
         PdfWriter.getInstance(document, new FileOutputStream(filename))
             .setInitialLeading(16);
         // step 3
         document.open();
    	
        // add the ID in another font
        Font font = new Font(FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.WHITE);
        for(Country country : Country.getCountries()){
        	// add a country to the document as a Chunk
            document.add(new Chunk(country.getName()));
            document.add(new Chunk(" "));
            Chunk id = new Chunk(country.getId().toString(), font);
            // with a background color
            id.setBackground(BaseColor.BLACK, 1f, 0.5f, 1f, 1.5f);
            // and a text rise
            id.setTextRise(6); //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            document.add(id);
            document.add(Chunk.NEWLINE);
        }
        
        // step 5
        document.close();
    }

}
