package com.bin.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRestfulController {
	
	@RequestMapping(value={""}, method=RequestMethod.GET)
    public List<User> getUsers() {
		User user = new User(1, "Binh");
		User user2 = new User(2, "Binh2");
		List<User> users = new ArrayList<User>();
		users.add(user);
		users.add(user2);
        return users;
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUserById(@PathVariable int id) {
		User user = new User(id, "Binh");
        return user;
    }
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.POST)
    public User delete(@PathVariable int id) {
		User user = new User(id, "Binh");
        return user;
    }

	@RequestMapping(value="/saveUser", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public User saveUser(@RequestBody User user) {
        return user;
    }
	
	@RequestMapping(value="/saveUsers", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public List<User> saveUsers(@RequestBody List<User> users) {
        return users;
    }
	
}
