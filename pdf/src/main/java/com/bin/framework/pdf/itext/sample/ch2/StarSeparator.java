package com.bin.pdf.itext.sample.ch2;

import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.draw.DrawInterface;

/**
 * Helper class
 */
public class StarSeparator implements DrawInterface {

	/** The font that will be used to draw the arrow. */
    protected BaseFont bf;
 
    public static final StarSeparator LINE = new StarSeparator();
 
    /**
     * Constructs a positioned Arrow mark.
     * @param    left    if true, an arrow will be drawn on the left;
     * otherwise, it will be drawn on the right.
     * @throws IOException 
     * @throws DocumentException 
     */
    public StarSeparator() {
        try {
            bf = BaseFont.createFont();
        } catch (DocumentException e) {
            bf = null;
        } catch (IOException e) {
            bf = null;
        }
    }
 
    /**
     * Draws three stars to separate two paragraphs.
     * @see com.itextpdf.text.pdf.draw.DrawInterface#draw(
     * com.itextpdf.text.pdf.PdfContentByte, float, float, float, float, float)
     */
    public void draw(PdfContentByte canvas,
        float llx, float lly, float urx, float ury, float y) {
        float middle = (llx + urx) / 2;
        canvas.beginText();
        canvas.setFontAndSize(bf, 10);
        canvas.showTextAligned(Element.ALIGN_CENTER, "*", middle, y, 0);
        canvas.showTextAligned(Element.ALIGN_CENTER, "*  *", middle, y -10, 0);
        canvas.endText();
    }

}
