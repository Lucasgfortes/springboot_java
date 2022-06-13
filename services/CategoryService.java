package com.Lucas.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lucas.course.entities.Category;
import com.Lucas.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> FindAll() {
		List<Category> listaUsers = repository.findAll();
		return listaUsers;
	}
	
	public Category FindById( Long ID) {
		Optional<Category> obj = repository.findById(ID);
		return obj.get();
	}
	
	
}
