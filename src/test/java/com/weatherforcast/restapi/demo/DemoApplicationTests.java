package com.weatherforcast.restapi.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.weatherforcast.restapi.demo.api.WeatherApi;
import com.weatherforcast.restapi.demo.entity.WeatherReport;
import com.weatherforcast.restapi.demo.service.WeatherService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

	@Mock
	RestTemplate restTemplate;
	
	@InjectMocks
	WeatherApi weatherService = new WeatherService();
	
	@Value("${weather-url}")
	private String weatherURL;
	
	@Test
	void contextLoads() {
		log.info("testWeatherReport()=========================");
		when(restTemplate.getForEntity(weatherURL, WeatherReport.class)).thenReturn(new ResponseEntity<WeatherReport>(null));
		assertNotNull(weatherService.getReport().getBody());
	}

}
