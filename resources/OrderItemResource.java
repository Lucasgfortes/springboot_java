package com.Lucas.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Lucas.course.entities.Order;
import com.Lucas.course.entities.OrderItem;
import com.Lucas.course.entities.pk.OrderItem_pk;
import com.Lucas.course.services.OrderItemService;


@RestController
@RequestMapping(value = "/OrderItems")
public class OrderItemResource {

	@Autowired
	private OrderItemService service;
	
	public ResponseEntity<List<OrderItem>> FindAll(){
		List<OrderItem> list = service.FindAll();
		return ResponseEntity.ok().body(list);
	}
	
//	@GetMapping(value = "/{ID}")
//	public ResponseEntity<OrderItem> findById( @PathVariable OrderItem_pk ID){
//	    OrderItem obj = service.FindById(ID);
//		return ResponseEntity.ok().body(obj);
//	}
	
	
}
