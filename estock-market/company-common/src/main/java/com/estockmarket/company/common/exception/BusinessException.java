package com.estockmarket.company.common.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -3485783523485151837L;

	public BusinessException(String msg) {
		super(msg);
	}

}
