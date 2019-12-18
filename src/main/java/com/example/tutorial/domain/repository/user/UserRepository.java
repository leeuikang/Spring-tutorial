package com.example.tutorial.domain.repository.user;

import com.example.tutorial.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}