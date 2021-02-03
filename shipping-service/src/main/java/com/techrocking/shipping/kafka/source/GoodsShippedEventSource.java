package com.techrocking.shipping.kafka.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import com.techrocking.shipping.kafka.channel.ShippingChannel;
import com.techrocking.shipping.kafka.message.ShippingEvent;

@Component
public class GoodsShippedEventSource {

	@Autowired
	private ShippingChannel shippingChannel;

	public void publishGoodsShippedEvent(Long orderId) {

		ShippingEvent message = new ShippingEvent();
		message.setOrderId(orderId);
		message.setShippingStatus(ShippingEvent.ShippingStatus.GOODS_SHIPPED);
		
		MessageChannel messageChannel = shippingChannel.outboundShippingt();
		messageChannel.send(MessageBuilder.withPayload(message)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}

}
