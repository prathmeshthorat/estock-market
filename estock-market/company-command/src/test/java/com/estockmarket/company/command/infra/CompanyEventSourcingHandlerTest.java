package com.estockmarket.company.command.infra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.estockmarket.company.command.domain.CompanyAggregate;
import com.estockmarket.cqrscore.domain.AggregateRoot;
import com.estockmarket.cqrscore.events.BaseEvent;
import com.estockmarket.cqrscore.infra.EventStore;

@RunWith(MockitoJUnitRunner.class)
public class CompanyEventSourcingHandlerTest {

	@InjectMocks
	CompanyEventSourcingHandler companyEventSourcingHandler;
	
	@Mock
	EventStore eventStore;
	
	@Test
	public void getByIdTest() {
		List<BaseEvent> list= new ArrayList<>();
		BaseEvent bs= new BaseEvent();
		bs.setId("1");
		bs.setVersion(1);
		list.add(bs);
		Mockito.when(eventStore.getEvents("1")).thenReturn(list);
		companyEventSourcingHandler.getById("1");
	}
	
	@Test
	public void saveTest() {
		List<BaseEvent> list= new ArrayList<>();
		BaseEvent bs= new BaseEvent();
		bs.setId("1");
		bs.setVersion(1);
		list.add(bs);
		companyEventSourcingHandler.save(new CompanyAggregate());
	}
}
