package com.Lucas.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Lucas.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>  {

}
