package com.example.dp_springboot_jwt.repo;

import com.example.dp_springboot_jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
