package com.Lucas.course.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.Lucas.course.entities.pk.OrderItem_pk;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;


@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    
   @EmbeddedId
    private OrderItem_pk id = new OrderItem_pk();
    
    private Integer quantity;
    private Double price;
	
	
	public OrderItem() {
	}
	
	public OrderItem(Product product, Order order, Integer quantity, Double price) {
		id.setProduct(product);
		id.setOrder(order);
		this.quantity = quantity;
		this.price = price;
	}

	public void SetProduct(Product product) {
		id.setProduct(product);
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void SetOrder(Order order) {
		id.setOrder(order);
	}
	
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	
	
	
	
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double subTotal() {
		return quantity * price;
	}
	
	
	

	
	
	
	
	
}
