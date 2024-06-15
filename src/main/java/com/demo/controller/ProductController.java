package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Product;
import com.demo.exception.ProductNotfoundException;
import com.demo.service.ProductService;

@RestController
@RequestMapping("/products") 
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {

		return service.saveProducts(products);
	}

	@GetMapping("/products")
	public List<Product> findAllProducts() {
		/*
		List<Product> products=new ArrayList<>();
		Product p1 = new Product();
		p1.setName("Pen");
		p1.setQuantity(1);
		p1.setPrice(10);
		products.add(p1);
		service.saveProducts(products);
		*/
		return service.getProducts();
	}

	@GetMapping("/productById/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> findProduct(@PathVariable int id) { 
	   throw new ProductNotfoundException();
	}
	
	@GetMapping("/product/{name}")
	public Product findProductByName(@PathVariable String name) {
		return service.getProductByName(name);
	}

	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
}
