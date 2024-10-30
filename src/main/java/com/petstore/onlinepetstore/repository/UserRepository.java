package com.petstore.onlinepetstore.repository;

import com.petstore.onlinepetstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
