package com.techrocking.inventory.kafka.message;

public class OrderEvent {
	
	private Long orderId;
	private OrderStatus orderStatus;
	
	public static enum OrderStatus {
		ORDER_PLACED,
		ORDER_NOT_PLACED
	}
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public OrderStatus getAction() {
		return orderStatus;
	}
	public void setAction(OrderStatus action) {
		this.orderStatus = action;
	}

}
