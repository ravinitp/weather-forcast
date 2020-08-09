package com.weatherforcast.restapi.demo.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.weatherforcast.restapi.demo.api.WeatherApi;
import com.weatherforcast.restapi.demo.entity.WeatherReport;

import lombok.extern.slf4j.Slf4j;


@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class TestWeatherService {

	@Mock
	RestTemplate restTemplate;
	
	@InjectMocks
	WeatherApi weatherService;
	
	@Value("${weather-url}")
	private String weatherURL;
	
	@Test
	public void testWeatherReport(){
		log.info("testWeatherReport()=========================");
		when(restTemplate.getForEntity(weatherURL, WeatherReport.class)).thenReturn(new ResponseEntity<WeatherReport>(null));
		assertNotNull(weatherService.getReport().getBody());
	}
}
