package com.estockmarket.cqrscore.infra;

import com.estockmarket.cqrscore.commands.BaseCommand;
import com.estockmarket.cqrscore.commands.CommandHandlerMethod;

public interface CommandDispatcher {
	<T extends BaseCommand> void registerHandler(Class<T> type, CommandHandlerMethod<T> handler);
	void send(BaseCommand command);
}
