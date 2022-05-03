package com.estockmarket.cqrscore.handlers;

import com.estockmarket.cqrscore.domain.AggregateRoot;

public interface EventSourcinghandler<T> {

	void save(AggregateRoot aggregate);

	T getById(String id);

}
