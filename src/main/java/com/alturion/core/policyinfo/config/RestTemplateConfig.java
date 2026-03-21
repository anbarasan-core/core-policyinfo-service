package com.alturion.core.policyinfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    RestTemplate restTemplate(JwtInterceptor jwtInterceptor) {
    	RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(jwtInterceptor);
		return restTemplate;
	}

}
