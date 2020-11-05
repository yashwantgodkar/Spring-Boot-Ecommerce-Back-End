package com.ecommerce.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ecommerce.app.entities.Product;
import com.ecommerce.app.service.ProductService;
import com.ecommerce.app.entities.User;

@RestController
//@RequestMapping("/ecomm")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EcommController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping({ "/validateLogin" })
	public User validateLogin() {
		return new User("User successfully authenticated");
	}
	 
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Integer productId) {
		Product product = productService.getProductById(productId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> list = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/product")
	public ResponseEntity<String> addProduct(@RequestBody Product product, UriComponentsBuilder builder) {
        boolean flag = productService.addProduct(product);
        if (flag == false) {
        	return new ResponseEntity<String>("This product already exist", HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/product/{id}").buildAndExpand(product.getProductId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/product")
	public ResponseEntity<Product> updateTopic(@RequestBody Product product) {
		productService.updateProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Void> deleteTopic(@PathVariable("id") Integer productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 


//class test{
//	String hello;
//
//	public String getHello() {
//		return hello;
//	}
//
//	public void setHello(String hello) {
//		this.hello = hello;
//	}
//}
