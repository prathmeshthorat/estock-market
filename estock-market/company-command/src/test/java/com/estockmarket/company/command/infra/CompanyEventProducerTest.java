package com.estockmarket.company.command.infra;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.estockmarket.cqrscore.events.BaseEvent;

@RunWith(MockitoJUnitRunner.class)
public class CompanyEventProducerTest {

	@InjectMocks
	CompanyEventProducer companyEventProducer;
	
	@Mock
	KafkaTemplate<String, Object> kafkaTemplate;
	
	@Test
	public void produceTest() {
		companyEventProducer.produce("test", new BaseEvent());
	}
}
