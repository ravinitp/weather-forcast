package com.weatherforcast.restapi.demo.model;

import lombok.Data;

@Data
public class ErrorResponse {
	private String ResponseCode;
	private String ErrorMessage;
	private String comments;
}
