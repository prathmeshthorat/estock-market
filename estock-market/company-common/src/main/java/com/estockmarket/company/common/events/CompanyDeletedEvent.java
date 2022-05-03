package com.estockmarket.company.common.events;

import com.estockmarket.cqrscore.events.BaseEvent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CompanyDeletedEvent extends BaseEvent{
	
	private String companyCode;
	private boolean isActive;

}
