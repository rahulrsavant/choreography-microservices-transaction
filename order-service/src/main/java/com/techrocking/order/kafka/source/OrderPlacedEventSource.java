package com.techrocking.order.kafka.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import com.techrocking.order.kafka.channel.OrderChannel;
import com.techrocking.order.kafka.message.OrderEvent;

@Component
public class OrderPlacedEventSource {

	@Autowired
	private OrderChannel orderChannel;

	public void publishOrderEvent(Long orderId) {

		OrderEvent message = new OrderEvent();
		message.setOrderId(orderId);
		message.setOrderStatus(OrderEvent.OrderStatus.ORDER_PLACED);

		MessageChannel messageChannel = orderChannel.outboundOrder();
		messageChannel.send(MessageBuilder.withPayload(message)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}

}
