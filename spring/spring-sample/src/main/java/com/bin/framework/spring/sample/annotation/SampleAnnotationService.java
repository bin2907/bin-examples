package com.bin.framework.spring.sample.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleAnnotationService {

	@Autowired
	private SampleAnnotationDao sampleAnnotationDao;
	
	public int delete(){
		return sampleAnnotationDao.delete();
	}
	
}
