package com.estockmarket.company.command.api;

import com.estockmarket.company.command.domain.CompanyAggregate;
import com.estockmarket.cqrscore.exceptions.AggregateNotFoundException;
import com.estockmarket.cqrscore.exceptions.BusinessException;
import com.estockmarket.cqrscore.exceptions.ErrorCodes;
import com.estockmarket.cqrscore.handlers.EventSourcinghandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

@Service
public class CompanyCommandHandler implements CommandHandler {

    private final Logger logger = Logger.getLogger(CompanyCommandHandler.class.getName());

    @Autowired
    EventSourcinghandler<CompanyAggregate> eventSourcingHandler;

    @Override
    public void handle(RegisterComapnyCommand command) {
        try {
            if (eventSourcingHandler.getById(command.getId()).getId() != null && eventSourcingHandler.getById(command.getId()).isActive()) {
                throw new BusinessException(ErrorCodes.COMPANY_CODE_EXISTS, new ArrayList<>());
            }
        } catch (AggregateNotFoundException e) {
            logger.info("Company code dosen't exist in store, continuing with registering new company.");
        }
        CompanyAggregate aggregate = new CompanyAggregate(command);
        eventSourcingHandler.save(aggregate);
    }

    @Override
    public void handle(AddStockPriceCommand command) {
        CompanyAggregate aggregate = eventSourcingHandler.getById(command.getId());
        aggregate.addStockPrice(command.getCurrentStockPrice());
        // To Do: add validations. Add getByCompanyCode method in eventSourcingHandler.
        eventSourcingHandler.save(aggregate);
    }

    @Override
    public void handle(DeleteCompanyCommand command) {
        CompanyAggregate aggregate = eventSourcingHandler.getById(command.getId());
        aggregate.deleteCompany(false);
        eventSourcingHandler.save(aggregate);
    }

}
