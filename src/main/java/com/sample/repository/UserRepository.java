package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserId(int id);

}
