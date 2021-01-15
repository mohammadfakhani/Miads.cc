package com.maid.quiz.demo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.maid.quiz.demo.model.sales.Operation;

@Repository
public interface OperationsRepository extends JpaRepository<Operation,Integer> {

	List<Operation> findByDeletedNot(boolean deleted); 
	
	
}
