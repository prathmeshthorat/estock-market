package com.estockmarket.company.query.infra.consumers;

import com.estockmarket.company.query.infra.handlers.EventHandler;
import com.estockmarket.cqrscore.commands.common.events.CompanyDeletedEvent;
import com.estockmarket.cqrscore.commands.common.events.CompanyRegisteredEvent;
import com.estockmarket.cqrscore.commands.common.events.StockPriceAddedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CompanyEventConsumer implements EventConsumer {

    private final Logger logger = Logger.getLogger(CompanyEventConsumer.class.getName());

    @Autowired
    EventHandler eventHandler;

    @KafkaListener(topics = "CompanyRegisteredEvent", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(CompanyRegisteredEvent event, Acknowledgment ack) {
        logger.info("Consuming CompanyRegisteredEvent: " + event);
        eventHandler.on(event);
        ack.acknowledge();
    }

    @KafkaListener(topics = "StockPriceAddedEvent", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(StockPriceAddedEvent event, Acknowledgment ack) {
        logger.info("Consuming StockPriceAddedEvent: " + event);
        eventHandler.on(event);
        ack.acknowledge();
    }

    @KafkaListener(topics = "CompanyDeletedEvent", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(CompanyDeletedEvent event, Acknowledgment ack) {
        logger.info("Consuming CompanyDeletedEvent: " + event);
        eventHandler.on(event);
        ack.acknowledge();
    }

}
