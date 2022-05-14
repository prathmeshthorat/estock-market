package com.estockmarket.cqrscore.exceptions;

public enum ErrorCodes implements ErrorCodesIF{
	
	BAD_REQUEST("100",400,"Bad Request"),
	MANDATORY_HEADERS_MISSING("101",400,"Missing Mandatory Headers"),
	MISSING_MANDATORY_FIELD("102",400,"Missing mandatory field"),
	FIELD_CONSTRAINT_VIOLATION("103",400,"Failing field costraint"),
	MISSING_HTTP_BODY("104",422,"Missing http request body"),

	COMPANY_CODE_EXISTS("105",400,"Company with same company code already exists. Please choose different company code.");

	private String code;
	
	private int httpCode;
	
	private String message;
	
	private ErrorCodes(String code, int httpCode, String message) {
		this.code = code;
		this.httpCode = httpCode;
		this.message = message;
	}

	@Override
	public String getCode() {
		
		return this.code;
	}

	@Override
	public String getMessage() {

		return this.message;
	}

	@Override
	public int getHttpCode() {
		
		return this.httpCode;
	}
    
	public Error getError(String... customMessage) {
		Error error= new Error();
		StringBuilder sb= new StringBuilder(Constants.EMPTY_STRING);
		error.setCode(this.getCode());
		if(customMessage != null && customMessage.length > 0) {
			for(String str : customMessage) {
				sb.append(str);
			}
		}
		error.setMessage(this.getMessage() + sb.toString());
		return error;
	}
}
