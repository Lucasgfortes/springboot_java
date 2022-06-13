package com.Lucas.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Lucas.course.entities.Order;
import com.Lucas.course.entities.OrderItem;
import com.Lucas.course.entities.Product;
import com.Lucas.course.entities.pk.OrderItem_pk;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItem_pk>{

}
