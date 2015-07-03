package com.bin.framework.spring.sample;

import org.springframework.core.io.Resource;

public class SampleResource {
	
	private Resource resource;

	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	public Resource getResource(){
		return resource;
	}

}
