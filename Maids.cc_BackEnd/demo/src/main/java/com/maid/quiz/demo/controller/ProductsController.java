package com.maid.quiz.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maid.quiz.demo.payload.ApiResponse;
import com.maid.quiz.demo.payload.Request.ProductRequest;
import com.maid.quiz.demo.service.ProductsService;


@RestController
@RequestMapping("/api/products")
public class ProductsController {

	@Autowired
    ProductsService productsService ; 
	
	@GetMapping("/all")	
	public ResponseEntity<?> getAllProducts() {
		try {
			return new ResponseEntity<>(new ApiResponse<>().setData(productsService.getAllProducts()), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(new ApiResponse<>().setMsg(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/add")	
	public ResponseEntity<?> saveProduct(@RequestBody ProductRequest request) {
		try {
			return new ResponseEntity<>(new ApiResponse<>().setData(productsService.createProduct(request)), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(new ApiResponse<>().setMsg(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")	
	public ResponseEntity<?> updateProduct(@RequestBody ProductRequest request,@PathVariable int id) {
		try {
			return new ResponseEntity<>(new ApiResponse<>().setData(productsService.updateProduct(request,id)), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(new ApiResponse<>().setMsg(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
