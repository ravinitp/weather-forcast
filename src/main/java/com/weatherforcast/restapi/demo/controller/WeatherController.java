package com.weatherforcast.restapi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;

import com.weatherforcast.restapi.demo.api.WeatherApi;
import com.weatherforcast.restapi.demo.model.ErrorResponse;
import com.weatherforcast.restapi.demo.model.SuccessResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class WeatherController {

	@Autowired private WeatherApi weatherService;
	
	@GetMapping(value = "/api/waether/v1",produces = "application/json")
	public ResponseEntity<?> getWeatherReport(){
		 SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
		 Date date;
		return weatherService.getReport();
		
		
	}
}
