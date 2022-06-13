package com.Lucas.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.Lucas.course.entities.enums.OrderStatus;

@Entity
@Table(name = "Tb_order")
public class Order implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	private Instant moment;
	
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private User client;
	
	private OrderStatus orderstatus;
	
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
	
	public Order() {
	}
	
	public Order(Long id, Instant moment, User client, OrderStatus orderstatus) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
		this.orderstatus = orderstatus;
	}
	
	private static final long serialVersionUID = 1L;
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getMoment() {
		return moment;
	}
	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}

	public OrderStatus getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(OrderStatus orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Set<OrderItem> getItems() {
		return items;
	}
	
	public Double getTotal() {
		Double total = 0.0;
		for(OrderItem value: items) {
			total = total + value.subTotal();
		}
		return total;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public String getNome() {
		return "Corno";
	}
	
}
