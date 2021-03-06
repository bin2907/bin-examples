package com.bin.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bin.spring.dto.Customer;

@Controller
public class MainController {

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String displayCustomerForm(ModelMap model) {
 
		model.addAttribute("customer", new Customer());
		return "index";
 
	}
 
	@RequestMapping(value="/ajaxSubmit",method=RequestMethod.POST)
	public @ResponseBody Customer processFormAjaxJson(Customer customer ){

		//
		
		return customer;
	}
	

}