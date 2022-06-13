package com.Lucas.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lucas.course.entities.OrderItem;
import com.Lucas.course.entities.pk.OrderItem_pk;
import com.Lucas.course.repositories.OrderItemRepository;

@Service
public class OrderItemService {
	
	
	@Autowired
	private OrderItemRepository oirepository;
	
	
	public List<OrderItem> FindAll(){
		List<OrderItem> listaOrdersItem = oirepository.findAll();
		return listaOrdersItem;
	}
	
	public OrderItem FindById(OrderItem_pk Id) {
		Optional<OrderItem> value = oirepository.findById(Id);
		return value.get();
	}
	
	
	
	
}
