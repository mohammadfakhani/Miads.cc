package com.maid.quiz.demo.service;

import java.util.List;
import com.maid.quiz.demo.payload.Request.ProductRequest;
import com.maid.quiz.demo.payload.Response.ProductResponse;

public interface ProductsService {

	List<ProductResponse> getAllProducts(); 
	
	ProductResponse createProduct(ProductRequest request) ; 
	
	ProductResponse updateProduct(ProductRequest request,int id );
	
}
