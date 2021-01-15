package com.maid.quiz.demo.controller;

import java.util.List;

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
import com.maid.quiz.demo.payload.Request.OperationRequest;
import com.maid.quiz.demo.payload.Request.OperationUpdateRequest;
import com.maid.quiz.demo.service.OperationsService;

@RestController
@RequestMapping("/api/sales")
public class OperationsController {
	
	@Autowired
    OperationsService operationsService ; 
	
	@GetMapping("/all")	
	public ResponseEntity<?> getAllOperations() {
		try {
			return new ResponseEntity<>(new ApiResponse<>().setData(operationsService.getAllOperations()), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(new ApiResponse<>().setMsg(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/add")	
	public ResponseEntity<?> saveOperation(@RequestBody List<OperationRequest> requestList) {
		try {
			return new ResponseEntity<>(new ApiResponse<>().setData(operationsService.createOperation(requestList)), HttpStatus.OK);	
		} catch (Exception ex) {
			return new ResponseEntity<>(new ApiResponse<>().setMsg(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")	
	public ResponseEntity<?> updateOpeartion(@RequestBody OperationUpdateRequest request,@PathVariable int id) {
		try {
			return new ResponseEntity<>(new ApiResponse<>().setData(operationsService.updateOperation(request, id)), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(new ApiResponse<>().setMsg(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
