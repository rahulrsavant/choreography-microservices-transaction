package com.techrocking.notification.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.techrocking.notification.kafka.channel.NotificationChannel;
import com.techrocking.notification.kafka.message.ShippingEvent;

@Component
public class GoodsShippedEventListener {

	private static final Logger logger = LoggerFactory.getLogger(GoodsShippedEventListener.class);

	@StreamListener(NotificationChannel.INPUT_SHIPPING)
	public void listenGoodsShipped(@Payload ShippingEvent goodsShippedMessage) {
		
		if (ShippingEvent.ShippingStatus.GOODS_SHIPPED.equals(goodsShippedMessage.getShippingStatus())) {
			logger.info("Received an GoodsShippedEvent for order id: " + goodsShippedMessage.getOrderId());

			if (goodsShippedMessage.getOrderId() != null) {
				logger.info("Going to notify user for shippment reached");

			}
		}

	}

}
