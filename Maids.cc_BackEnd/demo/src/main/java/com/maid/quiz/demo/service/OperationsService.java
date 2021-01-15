package com.maid.quiz.demo.service;

import java.util.List;

import com.maid.quiz.demo.payload.Request.OperationRequest;
import com.maid.quiz.demo.payload.Request.OperationUpdateRequest;
import com.maid.quiz.demo.payload.Response.OperationResponse;

public interface OperationsService {

	List<OperationResponse> getAllOperations(); 
	
	List<OperationResponse> createOperation(List<OperationRequest> request) ; 
	
	OperationResponse updateOperation(OperationUpdateRequest request,int id );
	
}
