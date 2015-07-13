package com.bin.framework.spring.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bin.framework.spring.dto.Customer;

@Controller
public class MainController {

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String addCustomer(@Valid Customer customer, BindingResult result) {
 
		if (result.hasErrors()) {
			return "index";
		} else {
			return "customer";
		}
 
	}
 
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String displayCustomerForm(ModelMap model) {
 
		model.addAttribute("customer", new Customer());
		return "index";
 
	}

}