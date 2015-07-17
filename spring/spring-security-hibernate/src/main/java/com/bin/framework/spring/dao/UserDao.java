package com.bin.spring.dao;

import com.bin.spring.model.User;

public interface UserDao {
	 
	User findByUserName(String username);
 
}