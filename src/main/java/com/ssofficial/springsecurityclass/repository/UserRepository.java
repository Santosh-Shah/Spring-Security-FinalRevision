package com.ssofficial.springsecurityclass.repository;

import com.ssofficial.springsecurityclass.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
