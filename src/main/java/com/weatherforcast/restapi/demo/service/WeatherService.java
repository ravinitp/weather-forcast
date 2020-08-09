package com.weatherforcast.restapi.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.weatherforcast.restapi.demo.api.WeatherApi;
import com.weatherforcast.restapi.demo.dao.api.WeatherRepository;
import com.weatherforcast.restapi.demo.entity.List;
import com.weatherforcast.restapi.demo.entity.Weather;
import com.weatherforcast.restapi.demo.entity.WeatherReport;
import com.weatherforcast.restapi.demo.model.ErrorResponse;
import com.weatherforcast.restapi.demo.model.SuccessResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WeatherService implements WeatherApi {
	
	@Autowired private WeatherRepository weatherRepository;

	@Override
	public ResponseEntity<?> getReport() {
		
		WeatherReport report=null;
		try {
			report = weatherRepository.getWeatherReports();
		}catch (RestClientException e) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setResponseCode("500");
			errorResponse.setErrorMessage(e.getLocalizedMessage());
		}
		
		
		log.info("report-{}",report.getList().size());
		SuccessResponse response = new SuccessResponse();
		boolean highTemp =false;
		boolean rain = false;
		for(List wList : report.getList()) {

			
			if(wList.getMain().getTempMin()>40  ) {
				highTemp = true;
			}
			for(Weather weather : wList.getWeather()) {
				if("Rain".equalsIgnoreCase(weather.getMain())){
					rain = true;
				}
			}
			
		}
		if(rain) {
			response.setResponseCode("200");
			response.setAdvise("Carry Umbrella");
			return new ResponseEntity<SuccessResponse>(response,HttpStatus.OK);
		}else if(highTemp){
		response.setResponseCode("200");
		response.setAdvise("Use SUn screen lotion");
		return new ResponseEntity<SuccessResponse>(response,HttpStatus.OK);
		}else {
			response.setResponseCode("200");
			response.setAdvise("enjoy");
			return new ResponseEntity<SuccessResponse>(response,HttpStatus.OK);
		}
	}
	


}
