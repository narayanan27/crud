package com.crud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Domain.Product;
import com.crud.Exceptions.ProductNotFoundException;
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
	return new ResponseEntity<>("Product Deleted Succesfully"+prod.display(),HttpStatus.OK);}
	
@RequestMapping(value="/product", method=RequestMethod.GET)
	public ResponseEntity<Object> get(ProductService prod){
	return new ResponseEntity<>(""+prod.display(),HttpStatus.OK);
}

@RequestMapping(value="/product",method=RequestMethod.POST)
public ResponseEntity<Object> post(@RequestBody Product product, ProductService prod){
	prod.prodmap.put(product.getId(), product);
	return new ResponseEntity<>("product added succesfully\n"+prod.display(),HttpStatus.CREATED);}


@RequestMapping(value="/product/{id}",method=RequestMethod.PUT)
public ResponseEntity<Object> put(@PathVariable int id,@RequestBody Product product,ProductService prod){
	if(!prod.prodmap.containsKey(id)) throw new ProductNotFoundException();
	prod.prodmap.remove(id);
	product.setId(id);
	//product.setName("Ginger");
	prod.prodmap.put(product.getId(),product);
	return new ResponseEntity<>("Updated"+prod.display(),HttpStatus.OK);
}


}