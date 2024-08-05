package com.rawi.ecom_Spring_Proj.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.function.EntityResponse;

import com.rawi.ecom_Spring_Proj.model.Product;
import com.rawi.ecom_Spring_Proj.service.ProductService;

@RestController
@CrossOrigin						//Server is running on different port and frontend is running on some other port ,so to connect both
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping("/")
	public String greet() {
		return "Hello!!! World";
	}
	
	@RequestMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<List<Product>>(service.getAllProducts(),HttpStatus.OK);
	}
	
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id) {
		Product product = service.getProductById(id);
		if(product !=null)
			return new ResponseEntity<Product> (product,HttpStatus.OK) ;
		else 
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestPart("product") Product product,
										@RequestPart("imageFile") MultipartFile imageFile){
		
		try {
			System.out.println(product);
			Product product1 = service.addProduct(product,imageFile);
			return new ResponseEntity<>(product1,HttpStatus.CREATED);
		} catch (Exception e) {
			
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	
	@GetMapping("/product/{productId}/image")
	public ResponseEntity<byte[]> getImageByProductId(@PathVariable("productId") Integer productId){
		Product product = service.getProductById(productId);
		byte[] imageFile = product.getImageData();
		
		return ResponseEntity.ok()
							 .contentType(MediaType.valueOf(product.getImageType()))
							 .body(imageFile);
	}
	
	
	@CrossOrigin
	@PutMapping("/product/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable("id") int id,
												@RequestPart("product") Product product,
												@RequestPart("imageFile") MultipartFile imageFile){
		
		Product product2;
		try {
			product2 = service.updateProduct(id,product,imageFile);
		} catch (IOException e) {
			return new ResponseEntity<>("Failed to Update",HttpStatus.BAD_REQUEST);
		}
		
		if (product2 !=null ) {
			return new ResponseEntity<>("Successfully Updated",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Failed to Update",HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int id){
		Product product3 = service.getProductById(id);
		
		if(product3 != null) {
			service.deleteProduct(id);
			return new ResponseEntity<>("Product Deleted Successfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Product Not Found",HttpStatus.NOT_FOUND);
		}
	}
}
