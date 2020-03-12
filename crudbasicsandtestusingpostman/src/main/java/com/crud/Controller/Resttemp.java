package com.crud.Controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.crud.Domain.Product;

@RestController
public class Resttemp {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping("/temlate/product")
	public String get() {
		HttpHeaders header=new HttpHeaders();
		header.get(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<String>(header);
		return restTemplate.exchange("http://localhost:8080/product",HttpMethod.GET,entity,String.class).getBody();
		}
	
	@RequestMapping("/template/product")
	public String post(@RequestBody Product product) {
		HttpHeaders header=new HttpHeaders();
		header.get(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity=new HttpEntity<Product>(product,header);
		return restTemplate.exchange("http://localhost:8080/product", HttpMethod.POST,entity, String.class).getBody();
		}
	@RequestMapping("/template/product/{id}")
	public String put(@RequestBody Product product,@PathVariable("id") int id) {
		HttpHeaders header=new HttpHeaders();
		header.get(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity=new HttpEntity<Product>(product,header);
		return restTemplate.exchange("http://localhost:8080/product/"+id, HttpMethod.PUT, entity, String.class).getBody();
}

}