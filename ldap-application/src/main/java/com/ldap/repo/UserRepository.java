package com.ldap.repo;

import org.springframework.data.ldap.repository.LdapRepository;

import com.ldap.entity.User;

public interface UserRepository extends LdapRepository<User> {
    
    // Custom query methods (if needed)
    User findByUid(String uid);
}