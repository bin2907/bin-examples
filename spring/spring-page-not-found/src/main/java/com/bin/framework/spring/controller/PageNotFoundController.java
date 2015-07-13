package com.bin.framework.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageNotFoundController {

	/**
	 * 404 is also configured in web.xml
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/404"}, method = RequestMethod.GET)
	public ModelAndView pageNotFound() throws Exception {

		ModelAndView mav = new ModelAndView("404");  
		
		return mav;

	}

}