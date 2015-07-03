package com.bin.framework.pdf.itext;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPTableEvent;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.events.PdfPTableEventForwarder;

public class TableEventDemo {
	

	public static void main(String[] args) {
		new TableEventDemo().createPDF();
	}
	
	int count = 1;
	public void createPDF(){
		try {
			
			// Step 1: Init document
			Document document = new Document();
			
			// Step 2: Init pdf file
			String file = "Pdf.pdf"; // Default will 'pdf' project folder
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(file));
			//pdfWriter.setPageEvent(new HeaderFooter());
			
			// Step 3: Open document
			document.open();
			
			
			// Step 4: Add connent
			
			document.add(createTable());
			
			//...

			// Step 5: Close document
			document.close();
			
			System.out.println("OK");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	private PdfPTable createTable(){
		
        PdfPTable table = new PdfPTable(3);
        table.setTableEvent(new PdfPTableEventForwarder() {
			
			@Override
			public void tableLayout(PdfPTable table, float[][] widths, float[] heights,
					int headerRows, int rowStart, PdfContentByte[] canvases) {
				// TODO Auto-generated method stub
				count ++;
				System.out.println("getRows: " + table.getRows().size());

				PdfPCell pdfPCell = table.getRow(rowStart).getCells()[0];
				Phrase phrase = pdfPCell.getPhrase();
				phrase.clear();
				phrase.add("Page: " + count);
				
				//.setPhrase(new Phrase("Page: " + count));
				
				/*PdfPCell cell = new PdfPCell(new Phrase("aaaaaa"));
		        cell.setColspan(3);
		        table.addCell(cell);*/
				
				int columns;
		        Rectangle rect;
		        int footer = widths.length - table.getFooterRows();
		        int header = table.getHeaderRows() - table.getFooterRows() + 1;
		        for (int row = header; row < footer; row += 2) {
		            columns = widths[row].length - 1;
		            rect = new Rectangle(widths[row][0], heights[row],
		                        widths[row][columns], heights[row + 1]);
		            rect.setBackgroundColor(BaseColor.YELLOW);
		            rect.setBorder(Rectangle.NO_BORDER);
		            canvases[PdfPTable.BASECANVAS].rectangle(rect);
		        }
				
			}

			@Override
			public void splitTable(PdfPTable table) {
				// TODO Auto-generated method stub
				super.splitTable(table);
				System.out.println("splitTable: " + (table.getRows().size() - table.getHeaderRows()));
			}

		});
        
        
        // Add the first header row 
        PdfPCell cell = new PdfPCell(new Phrase("Page: 1"));
        cell.setColspan(3);
        table.addCell(cell);
        
        // Add the second header row twice
        for (int i = 0; i < 2; i++) {
            table.addCell("Col1");
            table.addCell("Col2");
            table.addCell("Col3");
        }
        
        // There are three special rows
        table.setHeaderRows(1); // NOTE HERE: 1 is first header, 2 is 'header row twice' that added above
        
        // One of them is a footer
        //table.setFooterRows(1);
        
        // Data
        for (int i = 1; i <= 100; i ++) {
            table.addCell(""+i);
            table.addCell("2");
            table.addCell("3");
        }
        return table;
		
	}
	
   /* static class HeaderFooter extends PdfPageEventHelper {
        
        int pagenumber = 1;
 
        
        public void onOpenDocument(PdfWriter writer, Document document) {
        	System.out.println("onOpenDocument");
        }
        
        
        public void onStartPage(PdfWriter writer, Document document) {
        	count ++;
            pagenumber++;
        }
 
        public void onEndPage(PdfWriter writer, Document document) {
        	System.out.println(pagenumber);
        }
        
    }*/
	
}
