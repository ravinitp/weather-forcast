package com.weatherforcast.restapi.demo.model;

import java.util.Date;

import lombok.Data;

@Data
public class SuccessResponse {
	
	private String ResponseCode;
	private float temperature;
	private String advise;
	private String description;
	
}
