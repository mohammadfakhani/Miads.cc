package com.maid.quiz.demo.serviceImpl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maid.quiz.demo.exception.ServiceException;
import com.maid.quiz.demo.model.Products.Product;
import com.maid.quiz.demo.payload.Request.ProductRequest;
import com.maid.quiz.demo.payload.Response.ProductResponse;
import com.maid.quiz.demo.repositories.ProductsRepository;
import com.maid.quiz.demo.service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	private ProductsRepository productsRepository ;
	
	@Override
	public List<ProductResponse> getAllProducts() {
		List<ProductResponse> response = new ArrayList<ProductResponse>();
		for(Product product  : productsRepository.findByDeletedNot(false)) {
			response.add(createResponseForProduct(product));
		}
		return response;
	}

	@Override
	public ProductResponse createProduct(ProductRequest request) {
		Product product = new Product().setName(request.getName())
				  						.setDescription(request.getDescription())
				  						.setCategory(request.getDescription())
				  						.setDeleted(false)
				  						.setCreationDate(new Date(System.currentTimeMillis()));
		product = this.productsRepository.save(product);
		
		return createResponseForProduct(product);
	}

	@Override
	public ProductResponse updateProduct(ProductRequest request , int id ) {
		Optional<Product> optional = this.productsRepository.findById(id);
		if(!optional.isPresent() || optional.get().isDeleted()) {
			throw new ServiceException("product not found");
		}
		
		Product product = optional.get(); 
		product.setName(request.getName())
			.setDescription(request.getDescription())
			.setCategory(request.getDescription());
		product = this.productsRepository.save(product);
		return createResponseForProduct(product);
	}
	
	
	private ProductResponse createResponseForProduct(Product product) {
		return new ProductResponse().setId(product.getId()) 
					.setName(product.getName())
					.setCategory(product.getCategory())
					.setDescription(product.getDescription())
					.setCreationDate(product.getCreationDate());
	}

}
