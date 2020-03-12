package com.crud.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class Productinterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest servletrequest,HttpServletResponse servletresponse,Object handler) {
		System.out.println("pre handle method is called");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		System.out.println("Post handle method is called");	
	}

	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception {
		System.out.println("Execution has reached the After completion method");
	}

	
	
}
