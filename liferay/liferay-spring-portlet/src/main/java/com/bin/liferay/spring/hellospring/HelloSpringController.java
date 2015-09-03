package com.bin.liferay.spring.hellospring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@Controller("helloSpringController")
@RequestMapping(value = "VIEW")
public class HelloSpringController {

	private Log log = LogFactoryUtil.getLog(HelloSpringController.class);

	private static List<User> users = new ArrayList<User>();

	@RenderMapping
	// default (action=list)
	public String viewHomePage(RenderRequest request, RenderResponse response) {

		return "view";

	}

	@RequestMapping(params = "action=createUser")
	// render phase
	public String createUser(Model model) {
		// Used for the initial form as well as for redisplaying with errors.
		if (!model.containsAttribute("user")) {
			model.addAttribute("user", new User(1, "Binh"));
		}

		return "adduser";
	}

	@RequestMapping(params = "action=saveUser")
	// action phase
	public void saveUser(@ModelAttribute("user") User user,
			BindingResult result, SessionStatus status, ActionResponse response) {

		log.info("saveUser");
		log.info("user = " + user);

		users.add(user);
		status.setComplete();
		response.setRenderParameter("action", "list");

	}
	
	
	@ResourceMapping(value="getUserByAjax") 
	public void getUserByAjax(ResourceRequest request, ResourceResponse response) throws IOException { 
		
		log.info("==================================getUserByAjax=====================================");
	
		ObjectMapper objectMapper = new ObjectMapper();
		
		User user = new User(1, "BInh");
		
		response.getWriter().println(objectMapper.writeValueAsString(user));
		
	}
	
	
}
