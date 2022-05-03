package com.estockmarket.company.command.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.estockmarket.company.common.exception.BusinessException;

public class Validator {

	public static void validate(RegisterComapnyCommand command) {
		List<String> errors = new ArrayList<>();
		if (isNullOrEmpty(command.getCompanyCode()))
			errors.add("Null or empty companyCode");
		if (isNullOrEmpty(command.getCompanyCEO()))
			errors.add("Null or empty companyCEO");
		if (isNullOrEmpty(command.getCompanyName()))
			errors.add("Null or empty companyName");
		if (isNullOrEmpty(command.getWebsite()))
			errors.add("Null or empty website");
		if (null == command.getStockExng())
			errors.add("Null or empty stockExng");
		if (command.getCompanyTurnover() <= 100000000)
			errors.add("company turnover less than 10Cr");
		if (!errors.isEmpty() && errors.size() > 0)
			throw new BusinessException(errors.stream().collect(Collectors.joining(", ")));
	}

	public static boolean isNullOrEmpty(String value) {
		if (null != value && "".equalsIgnoreCase(value))
			return true;
		return false;
	}

}
