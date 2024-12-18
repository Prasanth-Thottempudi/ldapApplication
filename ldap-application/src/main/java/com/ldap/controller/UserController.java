package com.ldap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ldap.entity.User;
import com.ldap.service.UserService;

@RestController
@RequestMapping("/ldap")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        boolean authenticated = userService.authenticate(username, password);
        
        if (authenticated) {
            return "Authentication successful!";
        } else {
            return "Authentication failed!";
        }
    }

	@GetMapping("/demo")
	public List<User> checking() {
		return  userService.getAllUsers();
	}
}
