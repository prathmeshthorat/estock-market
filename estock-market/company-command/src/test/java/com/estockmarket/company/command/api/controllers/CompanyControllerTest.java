package com.estockmarket.company.command.api.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.estockmarket.company.command.api.AddStockPriceCommand;
import com.estockmarket.company.command.api.DeleteCompanyCommand;
import com.estockmarket.company.command.api.RegisterComapnyCommand;
import com.estockmarket.cqrscore.commands.common.dto.StockExchnage;
import com.estockmarket.cqrscore.exceptions.BusinessException;
import com.estockmarket.cqrscore.infra.CommandDispatcher;

@RunWith(MockitoJUnitRunner.class)
public class CompanyControllerTest {

	@InjectMocks
	private CompanyController companyController;
	
	@Mock
	private CommandDispatcher commandDispatcher;
	
	@Test
	public void testRegisterCompany() {
		RegisterComapnyCommand cmd = getRegisterCompanyCommand();
		Mockito.doNothing().when(commandDispatcher).send(cmd);
		ResponseEntity response= companyController.registerCompany(cmd);
		assertEquals(200, response.getStatusCodeValue());
	}
	
	@Test(expected = BusinessException.class)
	public void testRegisterCompanyException() {
		RegisterComapnyCommand cmd = getRegisterCompanyCommandNull();
		//Mockito.doNothing().when(commandDispatcher).send(cmd);
		ResponseEntity response= companyController.registerCompany(cmd);
	}
	
	@Test
	public void testAddNewStockPrice() {
		AddStockPriceCommand cmd = new AddStockPriceCommand();
		cmd.setCompanyCode("test");
		cmd.setCurrentStockPrice(10.00);
		cmd.setDateCreated(new Date());
		Mockito.doNothing().when(commandDispatcher).send(cmd);
		ResponseEntity response= companyController.addNewStockPrice("test",cmd);
		assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	public void testDeleteCompany() {
		DeleteCompanyCommand cmd = new DeleteCompanyCommand("test");
		cmd.setCompanyCode("test");
		//Mockito.doNothing().when(commandDispatcher).send(cmd);
		ResponseEntity response= companyController.deleteCompany("test");
		assertEquals(200, response.getStatusCodeValue());
	}
	
	
	private RegisterComapnyCommand getRegisterCompanyCommandNull() {
		RegisterComapnyCommand cmd = new RegisterComapnyCommand();
		cmd.setActive(true);
		cmd.setCompanyCEO("");
		cmd.setCompanyCode("");
		cmd.setCompanyName("");
		cmd.setCompanyTurnover(1);
		cmd.setCreatedBy("");
		cmd.setCurrentStockPrice(0L);
		cmd.setDateCreated(null);
		cmd.setStockExng(StockExchnage.BSE);
		cmd.setId("1");
		cmd.setWebsite(null);
		return cmd;
	}
	
	private RegisterComapnyCommand getRegisterCompanyCommand() {
		RegisterComapnyCommand cmd = new RegisterComapnyCommand();
		cmd.setActive(true);
		cmd.setCompanyCEO("test");
		cmd.setCompanyCode("test");
		cmd.setCompanyName("test");
		cmd.setCompanyTurnover(100000001);
		cmd.setCreatedBy("test");
		cmd.setCurrentStockPrice(10.00);
		cmd.setDateCreated(new Date());
		cmd.setStockExng(StockExchnage.BSE);
		cmd.setId("1");
		cmd.setWebsite("test");
		return cmd;
	}
}
