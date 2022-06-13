package com.Lucas.course.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.EnableMBeanExport;

import com.Lucas.course.entities.Order;
import com.Lucas.course.entities.Product;

@Embeddable
public class OrderItem_pk implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public OrderItem_pk() {
	}

	@ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
	
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
