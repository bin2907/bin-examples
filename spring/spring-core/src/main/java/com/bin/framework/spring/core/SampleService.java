package com.bin.spring.core;

public class SampleService {

	private SampleDao sampleDao;

	public void setSampleDao(SampleDao sampleDao) {
		this.sampleDao = sampleDao;
	}
	
	public int insert(){
		return sampleDao.insert();
	}
		
}
