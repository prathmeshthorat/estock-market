package com.estockmarket.company.command;

import com.estockmarket.company.command.api.AddStockPriceCommand;
import com.estockmarket.company.command.api.CommandHandler;
import com.estockmarket.company.command.api.DeleteCompanyCommand;
import com.estockmarket.company.command.api.RegisterComapnyCommand;
import com.estockmarket.cqrscore.infra.CommandDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@SpringBootApplication
public class CommandApplication {

    private final Logger logger = Logger.getLogger(CommandApplication.class.getName());

    @Autowired
    private CommandDispatcher commandDispatcher;

    @Autowired
    private CommandHandler commandHandler;

    public static void main(String[] args) {
        SpringApplication.run(CommandApplication.class, args);
    }

    @PostConstruct
    public void registerhandlers() {
        commandDispatcher.registerHandler(RegisterComapnyCommand.class, commandHandler::handle);
        commandDispatcher.registerHandler(AddStockPriceCommand.class, commandHandler::handle);
        commandDispatcher.registerHandler(DeleteCompanyCommand.class, commandHandler::handle);
    }
}
