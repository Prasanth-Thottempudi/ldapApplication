package com.ldap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Service;

import com.ldap.entity.User;
import com.ldap.repo.UserRepository;
import com.ldap.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LdapTemplate ldapTemplate;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public boolean authenticate(String username, String password) {
		try {
			// Define the LDAP query to search for the user
			LdapQuery query = LdapQueryBuilder.query().base("ou=users") // Define the base where user resides
					.where("uid").is(username); // Search by uid

			// Attempt to authenticate the user with the provided credentials
			ldapTemplate.authenticate(query.base(), "(uid=" + username + ")", password);
			return true; // Authentication successful
		} catch (Exception e) {
			return false;
		}
	}

}
