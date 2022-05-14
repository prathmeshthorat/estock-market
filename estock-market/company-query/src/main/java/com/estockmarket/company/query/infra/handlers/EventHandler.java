package com.estockmarket.company.query.infra.handlers;

import com.estockmarket.cqrscore.commands.common.events.CompanyDeletedEvent;
import com.estockmarket.cqrscore.commands.common.events.CompanyRegisteredEvent;
import com.estockmarket.cqrscore.commands.common.events.StockPriceAddedEvent;

public interface EventHandler {

    void on(CompanyRegisteredEvent event);

    void on(StockPriceAddedEvent event);

    void on(CompanyDeletedEvent event);

}
