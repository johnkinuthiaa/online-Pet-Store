package com.petstore.onlinepetstore.service;

import com.petstore.onlinepetstore.model.User;
import com.petstore.onlinepetstore.model.UserPrincipal;
import com.petstore.onlinepetstore.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository repository;

    public MyUserDetailsService(UserRepository repository){
        this.repository=repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =repository.findByUsername(username);
        if(user ==null){
            throw new RuntimeException("user not found");
        }
        return new UserPrincipal(user);
    }
}
