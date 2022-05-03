package com.estockmarket.company.common.events;

import java.util.Date;

import com.estockmarket.company.common.dto.StockExchnage;
import com.estockmarket.cqrscore.events.BaseEvent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CompanyRegisteredEvent extends BaseEvent {

	private String companyCode;
	private String companyName;
	private String companyCEO;
	private double companyTurnover;
	private String website;
	private StockExchnage stockExng;
	private String createdBy;
	private Date dateCreated;
	private boolean isActive;
	private double currentStockPrice;

}
