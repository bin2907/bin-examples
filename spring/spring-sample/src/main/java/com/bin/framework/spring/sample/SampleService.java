package com.bin.framework.spring.sample;

public class SampleService {

	private SampleDao sampleDao;

	public void setSampleDao(SampleDao sampleDao) {
		this.sampleDao = sampleDao;
	}
	
	public int insert(){
		return sampleDao.insert();
	}
		
}
