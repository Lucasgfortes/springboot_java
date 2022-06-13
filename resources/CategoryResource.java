package com.Lucas.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Lucas.course.entities.Category;
import com.Lucas.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> lista =  service.FindAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{ID}")
	public ResponseEntity<Category> findById( @PathVariable Long ID){
	    Category obj = service.FindById(ID);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
