package com.bin.framework.pdf.itext.sample.ch2;

import java.util.ArrayList;
import java.util.List;

public class Country {

	private Integer id;
	private String name;
	private Integer count;
	
	public Country(Integer id, String name, Integer count) {
		super();
		this.id = id;
		this.name = name;
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public static final List<Country> getCountries(){
		List<Country> list = new ArrayList<Country>();
		for(int i = 0; i < 10; i ++){
			list.add(new Country(i, "Country " + i, i));
		}
		return list;
	}
	
}
