package com.bin.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserController {
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value={"/getUsers"}, method=RequestMethod.	GET)
    public @ResponseBody List<User> getUsers() {
		
		RestTemplate restTemplate = new RestTemplate();
		List<User> users = new ArrayList<User>();
		users = (List<User>) restTemplate.getForObject("http://localhost:8080/spring-restful/users", Object.class);
        return users;
    }
	
	@RequestMapping(value={"/getUser"}, method=RequestMethod.GET)
    public @ResponseBody User getUser() {
		
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject("http://localhost:8080/spring-restful/users/1", User.class);
		
        return user;
    }
	
	@RequestMapping(value={"/updateUser"}, method=RequestMethod.GET)
    public @ResponseBody User updateUser() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		User userRequest = new User(1, "Binh");
		
		User user = restTemplate.postForObject("http://localhost:8080/spring-restful/users/saveUser", userRequest, User.class);
		
        return user;
    }
	
	@RequestMapping(value={"/getFile"}, method=RequestMethod.GET)
    public ResponseEntity<byte[]> getFile(HttpServletRequest request) throws IOException {
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<byte[]> image = restTemplate.getForEntity("http://localhost:8080/spring-restful/file", byte[].class);
		
	    return image;
    }
	
    
    @RequestMapping(value={"/getFileByteArray"}, method=RequestMethod.GET)
    public @ResponseBody byte[] getImage2(HttpServletRequest request) throws IOException {
		
		RestTemplate restTemplate = new RestTemplate();
		
		byte[] image = restTemplate.getForObject("http://localhost:8080/spring-restful/filebytearray", byte[].class);
		
	    return image;
    }
	
	
}
