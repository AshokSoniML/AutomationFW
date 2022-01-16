package de.dimetis.boss.exception;

@SuppressWarnings("serial")
public class ExcelfileException extends CustomException{

	public ExcelfileException(String message) {
		super(message);
	}
	
	public ExcelfileException(String message, Throwable cause) {
		super(message, cause);
	}

}
