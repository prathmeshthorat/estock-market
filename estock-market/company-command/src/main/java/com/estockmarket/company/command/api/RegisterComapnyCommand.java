package com.estockmarket.company.command.api;

import java.util.Date;

import com.estockmarket.cqrscore.commands.BaseCommand;

import com.estockmarket.cqrscore.commands.common.dto.StockExchnage;
import lombok.Data;

@Data
public class RegisterComapnyCommand extends BaseCommand{
	
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
