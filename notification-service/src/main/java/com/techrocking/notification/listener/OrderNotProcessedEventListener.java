package com.techrocking.notification.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.techrocking.notification.kafka.channel.NotificationChannel;
import com.techrocking.notification.kafka.message.OrderEvent;

@Component
public class OrderNotProcessedEventListener {

	private static final Logger logger = LoggerFactory.getLogger(OrderNotProcessedEventListener.class);

	@StreamListener(target = NotificationChannel.INPUT_ORDER)
	public void listenOrderNotProcessedEvent(@Payload OrderEvent message) {
		
		if (OrderEvent.OrderStatus.ORDER_NOT_PLACED.equals(message.getOrderStatus())) {
			logger.info("Received an OrderNotProcessedEvent for order id: " + message.getOrderId());
			logger.info("Going to notify user that order place with id :" + 
		    message.getOrderId() + " could not processed");

		}
	}

}
