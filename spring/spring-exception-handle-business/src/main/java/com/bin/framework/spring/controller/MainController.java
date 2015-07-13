package com.bin.framework.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bin.framework.spring.exception.CustomGenericException;

@Controller
public class MainController {

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		
		throw new CustomGenericException("E888", "This is custom message - ABC");
		
	}
	
	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(CustomGenericException ex) {
 
		// BUSINESS HERE
		
		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("exception", ex);
		return model;
 
	}

}