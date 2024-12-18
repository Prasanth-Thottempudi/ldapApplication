package com.ldap.service;

import java.util.List;

import com.ldap.entity.User;

public interface UserService {

	List<User> getAllUsers();
	
	boolean authenticate(String username, String password) ;
}
