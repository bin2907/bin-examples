package com.bin.pdf.itext.sample.utils;

import java.util.ArrayList;
import java.util.Locale.Category;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.List;
import com.itextpdf.text.Phrase;

public class PojoToElementFactory {

	/**
     * Creates a Phrase containing the title of a Movie.
     * @param movie a Movie object
     * @return a Phrase object
     */
    public static final Phrase getMovieTitlePhrase(final Movie movie) {
        return new Phrase(movie.getMovieTitle(), FilmFonts.NORMAL);
    }
 
    /**
     * Creates a Phrase containing the original title of a Movie.
     * @param movie a Movie object
     * @return a Phrase object
     */
    public static final Phrase getOriginalTitlePhrase(final Movie movie) {
        if (movie.getOriginalTitle() == null)
            return new Phrase("", FilmFonts.NORMAL);
        return new Phrase(movie.getOriginalTitle(), FilmFonts.ITALIC);
    }
 
    /**
     * Creates a Phrase containing the name of a Director.
     * @param director a Director object
     * @return a Phrase object
     */
    public static final Phrase getDirectorPhrase(final Director director) {
        Phrase phrase = new Phrase();
        phrase.add(new Chunk(director.getName(), FilmFonts.BOLD));
        phrase.add(new Chunk(", ", FilmFonts.BOLD));
        phrase.add(new Chunk(director.getGivenName(), FilmFonts.NORMAL));
        return phrase;
    }
 
    /**
     * Creates a Phrase containing the name of a Country.
     * @param country a Country object
     * @return a Phrase object
     */
    public static final Phrase getCountryPhrase(final Country country) {
        return new Phrase(country.getCountry(), FilmFonts.NORMAL);
    }
 
    /**
     * Creates a list with directors.
     * @param movie a Movie object
     * @return a List object
     */
    public static final List getDirectorList(Movie movie) {
        List list = new List();
        for (Director director : movie.getDirectors()) {
            list.add(String.format(
               "%s, %s", director.getName(), director.getGivenName()));
        }
        return list;
    }
 
    /**
     * Creates a list with countries.
     * @param movie a Movie object
     * @return a List object
     */
    public static final List getCountryList(Movie movie) {
        List list = new List();
        for (Country country : movie.getCountries()) {
            list.add(country.getCountry());
        }	
        return list;
    }
 
    /**
     * Creates a phrase with the production year of a movie.
     * @param movie a Movie object
     * @return a Phrase object
     */
    public static final Element getYearPhrase(Movie movie) {
        Phrase p = new Phrase();
        p.add(new Chunk("Year: ", FilmFonts.BOLD));
        p.add(new Chunk(String.valueOf(movie.getYear()), FilmFonts.NORMAL));
        return p;
    }
 
    /**
     * Creates a phrase with the run length of a movie.
     * @param movie a Movie object
     * @return a Phrase object
     */
    public static final Element getDurationPhrase(Movie movie) {
        Phrase p = new Phrase();
        p.add(new Chunk("Duration: ", FilmFonts.BOLD));
        p.add(new Chunk(String.valueOf(movie.getDuration()), FilmFonts.NORMAL));
        return p;
    }

	public static java.util.List<Movie> getMovies() {
		java.util.List<Movie> list = new ArrayList<Movie>();
		for(int i = 1; i < 11; i ++){
			Movie movie = new Movie();
			movie.setDuration(10 + i);
			movie.setImdb("Imdb" + i);
			movie.setOriginalTitle("OriginalTitle" + i);
			movie.setTitle("Title");
			movie.setYear(1998 + i);
			
			Entry entry = new Entry();
			entry.setCategory(Category.FORMAT);
			entry.setYear(1998 + i);
			movie.setEntry(entry);
			
			list.add(movie);
		}
		return list;
	}
	
}
