package com.Lucas.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Lucas.course.entities.Order;
import com.Lucas.course.entities.User;
import com.Lucas.course.services.OrderService;
import com.Lucas.course.services.UserService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService service;
	
	
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> lista =  service.FindAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{ID}")
	public ResponseEntity<Order> findById( @PathVariable Long ID){
	    Order obj = service.FindById(ID);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
