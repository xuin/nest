package com.sanying.trust.pay.exception;

public class PayException extends RuntimeException {
	private static final long serialVersionUID = 1125825247688322967L;

	public PayException() {
		super();
	}

	public PayException(String message) {
		super(message);
	}

	public PayException(String message, Throwable cause) {
		super(message, cause);
	}

	public PayException(Throwable cause) {
		super(cause);
	}
}
