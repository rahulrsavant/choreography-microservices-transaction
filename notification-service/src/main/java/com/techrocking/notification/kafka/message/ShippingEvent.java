package com.techrocking.notification.kafka.message;

public class ShippingEvent {
	
	private Long orderId;
	private ShippingStatus shippingStatus;
	
	public static enum ShippingStatus {
		GOODS_SHIPPED
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public ShippingStatus getShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(ShippingStatus shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

}
