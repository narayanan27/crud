package com.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "com.crud")
public class OnlineCustomerCrudOperation1Application {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCustomerCrudOperation1Application.class, args);
	}
	@Bean
	public RestTemplate getRest() {
		return new RestTemplate();}

}
