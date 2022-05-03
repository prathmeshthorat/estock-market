package com.estockmarket.cqrscore.producers;

import com.estockmarket.cqrscore.events.BaseEvent;

public interface EventProducer {
	void produce(String topic, BaseEvent event);

}
