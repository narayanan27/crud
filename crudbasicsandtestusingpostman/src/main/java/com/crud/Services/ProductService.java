package com.crud.Services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.crud.Domain.Product;
@Service
public class ProductService {
	
	 public Map<Integer,Product> prodmap;
	 ProductService(){
		 loadProd();
	 }
	public Map<Integer, Product> loadProd() {
		
		prodmap=new HashMap<>();
		Product p=new Product();
		p.setId(1);
		p.setName("Narayanan");
		prodmap.put(1, p);
		
		Product q=new Product();
		q.setId(2);
		q.setName("Geetha");
		prodmap.put(2, q);
		return prodmap;
	}
	public Map<Integer, Product> display() {
		System.out.println(prodmap);
		return prodmap;
	}
	

}
