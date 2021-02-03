package com.techrocking.shipping.kafka.message;

public class PaymentEvent {
	
	private Long orderId;
	private PaymentStatus paymentStatus;
	
	public static enum PaymentStatus {
		PAYMENT_RECEIVED,
		PAYMENT_NOT_RECEIVED
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public PaymentStatus getAction() {
		return paymentStatus;
	}

	public void setAction(PaymentStatus action) {
		this.paymentStatus = action;
	}

}
