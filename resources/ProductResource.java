package com.Lucas.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Lucas.course.entities.Product;
import com.Lucas.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService service; 
	
	
	
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> lista =  service.FindAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{ID}")
	public ResponseEntity<Product> findById( @PathVariable Long ID){
	    Product obj = service.FindById(ID);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
