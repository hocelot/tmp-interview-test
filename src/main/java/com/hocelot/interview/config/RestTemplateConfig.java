package com.hocelot.interview.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@LoadBalanced
	@Bean(name = "ribbonRestemplate")
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean(name = "simpleRestemplate")
	@Primary
	public RestTemplate getSimpleRestTemplate() {
		return new RestTemplate();
	}

}
