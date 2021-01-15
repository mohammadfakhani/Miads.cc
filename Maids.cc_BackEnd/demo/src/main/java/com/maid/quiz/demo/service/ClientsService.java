package com.maid.quiz.demo.service;

import java.util.List;
import com.maid.quiz.demo.payload.Request.ClientRequest;
import com.maid.quiz.demo.payload.Response.ClientResponse;

public interface ClientsService {

	List<ClientResponse> getAllClients(); 
	
	ClientResponse createClient(ClientRequest request) ; 
	
	ClientResponse updateClient(ClientRequest request,int id );
	
	boolean checkClient(int id );
	
}
