package com.estockmarket.cqrscore.infra;

import java.util.List;

import com.estockmarket.cqrscore.events.BaseEvent;

public interface EventStore {

	void save(String aggregateId, Iterable<BaseEvent> events, int expectedversion);

	List<BaseEvent> getEvents(String aggregateId);

}
