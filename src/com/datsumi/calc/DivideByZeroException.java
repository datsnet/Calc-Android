package com.datsumi.calc;

public class DivideByZeroException extends Exception {
	private static final long serialVersionUID = 6404775380225179804L;
	public DivideByZeroException() {
	}
	public DivideByZeroException(String message) {
		super(message);
	}
	public DivideByZeroException(String message, Throwable cause) {
		super(message, cause);
	}
	public DivideByZeroException(Throwable cause) {
		super(cause);
	}
}
