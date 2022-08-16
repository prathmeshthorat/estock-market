package com.estockmarket.cqrscore.exceptions;

public interface ErrorCodesIF {
	
	String getCode();
	
	String getMessage();
	
	int getHttpCode();
	
}
