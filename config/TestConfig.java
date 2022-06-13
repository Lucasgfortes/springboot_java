package com.Lucas.course.config;


import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.Lucas.course.entities.Category;
import com.Lucas.course.entities.Order;
import com.Lucas.course.entities.OrderItem;
import com.Lucas.course.entities.Payment;
import com.Lucas.course.entities.Product;
import com.Lucas.course.entities.User;
import com.Lucas.course.entities.enums.OrderStatus;
import com.Lucas.course.repositories.CategoryRepository;
import com.Lucas.course.repositories.OrderItemRepository;
import com.Lucas.course.repositories.OrderRepository;
import com.Lucas.course.repositories.ProductRepository;
import com.Lucas.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userepository;
	
	@Autowired
	private OrderRepository orderepository;
	
	@Autowired
	private CategoryRepository catrepository;
	
	@Autowired
	private ProductRepository prodrepository;

	@Autowired
	private OrderItemRepository oirepository;
	
	
	
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User (null , "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User (null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		User u3 = new User (null, "Jonas Green", "aleex@gmail.com", "922773337", "123886");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.paid); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.waiting_payment); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.paid); 
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		OrderItem oi1 = new OrderItem(p1,o1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(p3, o1, 1, p3.getPrice()); 
		OrderItem oi3 = new OrderItem(p3, o2, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(p5, o3, 2, p5.getPrice());
		
		Payment pay1 = new Payment(null,Instant.parse("2019-06-20T19:53:07Z"), o1 );
		 
	
		userepository.saveAll(Arrays.asList(u1,u2, u3));
		orderepository.saveAll(Arrays.asList(o1, o2, o3));
		catrepository.saveAll(Arrays.asList(cat1, cat2, cat3)); 
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		
	    prodrepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		oirepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
	    o1.setPayment(pay1);
	    orderepository.save(o1);
	    
		
	}
}
