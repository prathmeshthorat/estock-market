package com.estockmarket.company.command.infra;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;

import com.estockmarket.company.command.api.RegisterComapnyCommand;
import com.estockmarket.company.command.domain.EventStoreRepository;
import com.estockmarket.cqrscore.commands.common.dto.StockExchnage;
import com.estockmarket.cqrscore.commands.common.events.CompanyRegisteredEvent;
import com.estockmarket.cqrscore.events.BaseEvent;
import com.estockmarket.cqrscore.events.EventModel;
import com.estockmarket.cqrscore.exceptions.AggregateNotFoundException;
import com.estockmarket.cqrscore.producers.EventProducer;

@RunWith(MockitoJUnitRunner.class)
public class CompanyEventStoreTest {

	@InjectMocks
	CompanyEventStore companyEventStore = new CompanyEventStore();
	
	@Mock
	EventStoreRepository eventStoreRepository;
	
	@Mock
	EventProducer eventProducer;
	

	@Test
	public void saveConcurrentException() {
		EventModel model= EventModel.builder().aggregateIdentifier("test").aggregateType("test").eventType("test").id("1").eventData(getBaseEvent()).version(4).build();
		List<EventModel> listEventModel= new ArrayList<>();
		listEventModel.add(model);
	    Mockito.when(eventStoreRepository.findByAggregateIdentifier("1")).thenReturn(listEventModel);
		List<BaseEvent> list= new ArrayList<>();
		list.add(getBaseEvent());	
		companyEventStore.save("1", list, 3);
		
	}
	
	
	
	@Test
	public void saveException() {
		EventModel model= EventModel.builder().aggregateIdentifier("test").aggregateType("test").eventType("test").id("1").eventData(getBaseEvent()).version(3).build();
		EventModel model1= EventModel.builder().id("test").aggregateIdentifier("1").aggregateType("com.estockmarket.company.command.domain.CompanyAggregate").eventType("com.estockmarket.cqrscore.events.BaseEvent").id("1").eventData(getBaseEvent1()).version(4).build();
	
		List<EventModel> listEventModel= new ArrayList<>();
		listEventModel.add(model);
	    Mockito.when(eventStoreRepository.findByAggregateIdentifier("1")).thenReturn(listEventModel);
		List<BaseEvent> list= new ArrayList<>();
		list.add(getBaseEvent());	
		companyEventStore.save("1", list, 3);
		
	}

	@Test
	public void getEvents() {
		EventModel model= EventModel.builder().aggregateIdentifier("test").aggregateType("test").eventType("test").id("1").eventData(getBaseEvent()).version(3).build();
		List<EventModel> listEventModel= new ArrayList<>();
		listEventModel.add(model);
	    Mockito.when(eventStoreRepository.findByAggregateIdentifier("1")).thenReturn(listEventModel);
		List<BaseEvent> list= new ArrayList<>();
		list.add(getBaseEvent());	
		companyEventStore.getEvents("1");
		
	}
	
	@Test(expected=AggregateNotFoundException.class)
	public void getEventsException() {
		EventModel model= EventModel.builder().aggregateIdentifier("test").aggregateType("test").eventType("test").id("1").eventData(getBaseEvent()).version(3).build();
		List<EventModel> listEventModel= new ArrayList<>();
		listEventModel.add(model);
	    Mockito.when(eventStoreRepository.findByAggregateIdentifier("1")).thenReturn(null);
		List<BaseEvent> list= new ArrayList<>();
		list.add(getBaseEvent());	
		companyEventStore.getEvents("1");
		
	}
	
	public BaseEvent getBaseEvent1() {
	       BaseEvent event= new BaseEvent();
	       event.setVersion(4);
		   return event;
		}
	
	public BaseEvent getBaseEvent() {
       BaseEvent event= new BaseEvent();
       event.setId("test");
       event.setVersion(1);
	   return event;
	}
}
