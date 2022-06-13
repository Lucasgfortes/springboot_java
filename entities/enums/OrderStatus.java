package com.Lucas.course.entities.enums;

public enum OrderStatus {
	waiting_payment(1),
	paid(2),
	shipped(3),
	delivered(4),
	canceled(5);

	private int code;
	

	private OrderStatus(int code){
		this.code = code;
	}
	
	public int getcode() {
		return code;
	} 
		
	public static OrderStatus getOrderStatus(int code){
		for(OrderStatus value: OrderStatus.values()) {
			if(value.getcode() == code) {
				return value;
			}
		}
			throw new IllegalArgumentException("Code invalid");
	  }
	
	
}
