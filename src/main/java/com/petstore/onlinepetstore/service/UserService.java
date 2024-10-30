package com.petstore.onlinepetstore.service;

import com.petstore.onlinepetstore.model.User;

public interface UserService {
    User register(User user);
    String verify(User user);
}
