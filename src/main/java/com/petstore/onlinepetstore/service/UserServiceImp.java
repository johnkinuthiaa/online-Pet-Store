package com.petstore.onlinepetstore.service;

import com.petstore.onlinepetstore.model.User;
import com.petstore.onlinepetstore.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder(12);
    AuthenticationManager authenticationManager;

    public UserServiceImp(UserRepository repository, AuthenticationManager authenticationManager){
        this.repository=repository;
        this.authenticationManager=authenticationManager;
    }
    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public String verify(User user) {
        Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                user.getPassword()
        ));
        if(authentication.isAuthenticated()){
            return "success";
        }
        return "authentication failed";
    }
}
