package com.bin.pdf.itext.sample.ch2;

import java.util.ArrayList;
import java.util.List;



public class Director {

	private Integer id;
	private String name;
	private String givenName;
	private int count;
	
	public Director(Integer id, String name, String givenName, int count) {
		super();
		this.id = id;
		this.name = name;
		this.givenName = givenName;
		this.count = count;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public static final List<Director> getDirectors(){
		List<Director> list = new ArrayList<Director>();
		for(int i = 0; i < 10; i ++){
			Director director = new Director(i , "Name" + i, "GivenName" + i, 10 + i);
			list.add(director);
		}
		return list;
	}

}
