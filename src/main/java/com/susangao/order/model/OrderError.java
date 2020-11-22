package com.susangao.order.model;


import lombok.Data;

@Data
public class OrderError {
	private String id;
	private String message;
	private String code;
	
	public OrderError(String id, String code, String message) {
		this.id = id;
		this.code = code;
		this.message = message;
	}
	

}