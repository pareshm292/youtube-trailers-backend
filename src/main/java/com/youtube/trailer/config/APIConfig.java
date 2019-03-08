package com.youtube.trailer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.youtube.trailer")
public class APIConfig {
	
	@Bean
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
		
	}

}
