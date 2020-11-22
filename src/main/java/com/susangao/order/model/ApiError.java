package com.susangao.order.model;

import java.util.Arrays;
import java.util.List;

//import static com.susangao.order.contants.OrderServiceConstants.MORE_INFO;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
	private HttpStatus status;
	private String statusCode;
	private String developerMessage;
	private String userMessage;
	private List<String> errors;
	private String moreInfo;

	public ApiError(HttpStatus status, String developerMessage, String userMessage, String error) {
		//this(status, String.valueOf(status.value()), developerMessage, userMessage, Arrays.asList(error), MORE_INFO);
	}

	public ApiError(HttpStatus status, String developerMessage, String userMessage, List<String> error) {
		//this(status, String.valueOf(status.value()), developerMessage, userMessage, error, MORE_INFO);
	}
}
