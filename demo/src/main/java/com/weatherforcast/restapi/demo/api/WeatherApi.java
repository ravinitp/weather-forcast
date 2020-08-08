package com.weatherforcast.restapi.demo.api;

import java.util.Date;

import org.springframework.http.ResponseEntity;

public interface WeatherApi {

	public ResponseEntity<?> getReport();
}
