package com.module.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.module.basic.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
public User findByEmailAndPwd(String email, String pwd);
}