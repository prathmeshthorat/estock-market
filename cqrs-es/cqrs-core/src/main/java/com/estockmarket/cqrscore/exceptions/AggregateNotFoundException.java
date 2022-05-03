package com.estockmarket.cqrscore.exceptions;

public class AggregateNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2424815535894725631L;

	public AggregateNotFoundException(String msg) {
		super(msg);
	}
}
