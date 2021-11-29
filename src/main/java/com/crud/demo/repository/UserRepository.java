package com.crud.demo.repository;

import com.crud.demo.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUserCode(String userCode);
}
