package com.susangao.order.exception;

public class OrderServiceException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public OrderServiceException (String message) {
		super(message);
	}

}
