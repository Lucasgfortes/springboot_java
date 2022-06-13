package com.Lucas.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lucas.course.entities.Order;
import com.Lucas.course.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> FindAll() {
		List<Order> listaOrders = repository.findAll();
		return listaOrders;
	}
	
	public Order FindById( Long ID) {
		Optional<Order> obj = repository.findById(ID);
		return obj.get();
	}
	
	
}
