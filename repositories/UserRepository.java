package com.Lucas.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Lucas.course.entities.User;

public interface  UserRepository extends JpaRepository<User, Long> {

}
