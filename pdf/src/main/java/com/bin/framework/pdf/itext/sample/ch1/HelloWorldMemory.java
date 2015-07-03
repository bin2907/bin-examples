package com.bin.framework.pdf.itext.sample.ch1;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class HelloWorldMemory {

	/** Path to the resulting PDF file. */
    public static final String RESULT
        = "hello_memory.pdf";
 
    /**
     * Creates a PDF file: hello_memory.pdf
     * @param    args    no arguments needed
     */
    public static void main(String[] args)
        throws DocumentException, IOException {
        // step 1
        Document document = new Document();
        // step 2
        // we'll create the file in memory
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        // step 3
        document.open();
        // step 4
        document.add(new Paragraph("Hello World!"));
        // step 5
        document.close();
 
        // let's write the file in memory to a file anyway
        FileOutputStream fos = new FileOutputStream(RESULT);
        fos.write(baos.toByteArray());
        fos.close();
    }

}
