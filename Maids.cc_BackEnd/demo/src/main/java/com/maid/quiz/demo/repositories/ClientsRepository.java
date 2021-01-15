package com.maid.quiz.demo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maid.quiz.demo.model.Client.Client;

@Repository
public interface ClientsRepository extends JpaRepository<Client,Integer> {

	List<Client> findByDeletedNot(boolean deleted); 
	
	
}
