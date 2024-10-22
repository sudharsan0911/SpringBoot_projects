package com.ust.security.h2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.security.h2.model.MyUser;


public interface UserRepository extends JpaRepository<MyUser, Long> {

	Optional<MyUser> findByUsername(String username);

}
