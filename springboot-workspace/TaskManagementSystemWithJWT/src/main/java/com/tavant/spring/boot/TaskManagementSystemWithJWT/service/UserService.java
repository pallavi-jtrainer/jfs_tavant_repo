package com.tavant.spring.boot.TaskManagementSystemWithJWT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tavant.spring.boot.TaskManagementSystemWithJWT.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return repo.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("User Not Found!"));
            }
        };
    }
}
