package com.techrocking.payment.kafka.message;

public class ItemEvent {
	private Long orderId;
	private Long itemId;
	private ItemStatus itemStatus;
	
	public static enum ItemStatus {
		ITEM_FETCHED,
		ITEM_OUT_OF_STOCK
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public ItemStatus getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(ItemStatus itemStatus) {
		this.itemStatus = itemStatus;
	}

}
