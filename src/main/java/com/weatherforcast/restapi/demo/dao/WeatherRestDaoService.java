
package com.weatherforcast.restapi.demo.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.weatherforcast.restapi.demo.dao.api.WeatherRepository;
import com.weatherforcast.restapi.demo.entity.WeatherReport;


@Service
public class WeatherRestDaoService implements WeatherRepository {

	@Value("${weather-url}")
	private String weatherURL;
	
	@Autowired private RestTemplate restTemplate;
	
	@Override
	public WeatherReport getWeatherReports() throws RestClientException{
		ResponseEntity<WeatherReport> response = restTemplate.getForEntity(weatherURL,WeatherReport.class);
		if(response.hasBody()) {
			return response.getBody();
		}
		return null;
	}

}
