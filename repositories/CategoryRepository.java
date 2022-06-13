package com.Lucas.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Lucas.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>  {

}
