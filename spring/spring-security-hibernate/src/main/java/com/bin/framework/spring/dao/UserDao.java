package com.bin.framework.spring.dao;

import com.bin.framework.spring.model.User;

public interface UserDao {
	 
	User findByUserName(String username);
 
}