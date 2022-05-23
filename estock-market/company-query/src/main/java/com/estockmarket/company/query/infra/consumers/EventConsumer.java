package com.estockmarket.company.query.infra.consumers;

import com.estockmarket.cqrscore.commands.common.events.CompanyDeletedEvent;
import com.estockmarket.cqrscore.commands.common.events.CompanyRegisteredEvent;
import com.estockmarket.cqrscore.commands.common.events.StockPriceAddedEvent;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

public interface EventConsumer {

    void consume(@Payload CompanyRegisteredEvent event, Acknowledgment ack);

    void consume(@Payload StockPriceAddedEvent event, Acknowledgment ack);

    void consume(@Payload CompanyDeletedEvent event, Acknowledgment ack);
}
