package com.bin.framework.pdf.itext.sample.ch2;

import java.util.ArrayList;
import java.util.List;


public class Movie {

	private String movieTitle;
	private String originalTitle;
	private int duration;
	private String imdb;
	
	private List<Director> directors;
	
	private int year;

	public Movie(String movieTitle, String originalTitle, int duration, String imdb) {
		super();
		this.movieTitle = movieTitle;
		this.duration = duration;
		this.imdb = imdb;
	}
	
	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	
	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public static final List<Movie> getMovies(){
		List<Movie> list = new ArrayList<Movie>();
		for(int i = 0; i < 10; i ++){
			Movie movie = new Movie("Title" + i, "originalTitle" + i, 100 + i, "imdb");
			movie.setYear(1998 + i);
			list.add(movie);
			List<Director> directors = new ArrayList<Director>();
			directors.add(new Director(i, "Director", "Given Name", 10 + i));
			list.get(i).setDirectors(directors);
		}
		return list;
	}
}
