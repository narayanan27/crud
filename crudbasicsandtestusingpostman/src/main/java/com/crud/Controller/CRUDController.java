package com.crud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Domain.Product;
import com.crud.Services.ProductService;

@RestController
public class CRUDController {

	private ProductService prod;
	
	@Autowired
	
	public void setProductService(ProductService prod) {
		this.prod=prod;
	}
	@RequestMapping(value="/product/{Id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable int Id,ProductService prod){
		prod.prodmap.remove(Id);
	return new ResponseEntity<>("Product Deleted Succesfully",HttpStatus.OK);}
	
@RequestMapping(value="/product/{Id}", method=RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable int Id,ProductService prod){
	prod.prodmap.get(Id);
	return new ResponseEntity<>(prod.display(),HttpStatus.OK);
}
@RequestMapping(value="/product",method=RequestMethod.POST)
public ResponseEntity<Object> post(ProductService prod,Product p){
	((Product) prod.loadProd()).p.setId(3);
	((Product) prod.loadProd()).setName("Rangarajan");
	return new ResponseEntity<>("product added succesfully\n"+prod.display(),HttpStatus.CREATED);}


}