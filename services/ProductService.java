package com.Lucas.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lucas.course.entities.Product;
import com.Lucas.course.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> FindAll() {
		List<Product> listaUsers = repository.findAll();
		return listaUsers;
	}
	
	public Product FindById( Long ID) {
		Optional<Product> obj = repository.findById(ID);
		return obj.get();
	}
	
	
}
