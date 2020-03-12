package com.crud.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
public class InterceptorConfigClass implements WebMvcConfigurer {

	@Autowired
	private Productinterceptor prod;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(prod);
		/* WebMvcConfigurer.super.addInterceptors(registry); */	
	}

}
