package com.bin.framework.pdf.itext.sample.ch2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;


public class DatabaseTest {

	/** The output of this database test: a text file with a list of countries. */
    public static final String RESULT = "countries.txt";
 
    /**
     * Writes the names of the countries that are in our database
     * @param    args    no arguments needed 
     * @throws FileNotFoundException 
     */
    public static void main(String[] args)
        throws SQLException, UnsupportedEncodingException, FileNotFoundException {
    	// no PDF, just a text file
        PrintStream out = new PrintStream(new FileOutputStream(RESULT));
        // Make the connection to the database
        //DatabaseConnection connection = new HsqldbConnection("filmfestival");
        // create the statement
        //Statement stm = connection.createStatement();
        // execute the query
        //ResultSet rs = stm.executeQuery("SELECT country FROM film_country ORDER BY country");
        // loop over the results
        //while (rs.next()) {
        	// write a country to the text file
            //out.println(rs.getString("country"));
        //}
        // close the statement
        //stm.close();
        // close the database connection	
        //connection.close();
        
        for(Country country : Country.getCountries()){
        	out.println(country.getName().toString());
        }
        
        // flush and close the print stream
        out.flush();
        out.close();
    }
    

}
