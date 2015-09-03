package com.bin.liferay.spring.firstcontroller;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller("firstController")
@RequestMapping(value = "VIEW")
public class FirstController {
	
	@RenderMapping
	public String viewHomePage(RenderRequest request, RenderResponse response) {

		return "view";

	}

}
