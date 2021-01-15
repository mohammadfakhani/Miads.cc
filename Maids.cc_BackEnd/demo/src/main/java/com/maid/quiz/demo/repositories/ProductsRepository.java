package com.maid.quiz.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maid.quiz.demo.model.Products.Product;

@Repository
public interface ProductsRepository extends JpaRepository<Product,Integer>{

	List<Product> findByDeletedNot(boolean deleted); 
	
}
