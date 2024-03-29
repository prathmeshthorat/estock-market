package com.estockmarket.cqrscore.commands.common.events;

import java.util.Date;

import com.estockmarket.cqrscore.events.BaseEvent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class StockPriceAddedEvent extends BaseEvent{
	
	private String companyCode;
	private double currentStockPrice;
	private Date dateCreated;

}
