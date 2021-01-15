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
import com.maid.quiz.demo.payload.Request.ClientRequest;
import com.maid.quiz.demo.service.ClientsService;

@RestController
@RequestMapping("/api/clients")
public class ClientsController {

	@Autowired
    ClientsService clientssService ; 
	
	@GetMapping("/all")	
	public ResponseEntity<?> getAllClients() {
		try {
			return new ResponseEntity<>(new ApiResponse<>().setData(clientssService.getAllClients()), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(new ApiResponse<>().setMsg(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/add")	
	public ResponseEntity<?> saveClient(@RequestBody ClientRequest request) {
		try {
			return new ResponseEntity<>(new ApiResponse<>().setData(clientssService.createClient(request)), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(new ApiResponse<>().setMsg(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")	
	public ResponseEntity<?> updateClient(@RequestBody ClientRequest request,@PathVariable int id) {
		try {
			return new ResponseEntity<>(new ApiResponse<>().setData(clientssService.updateClient(request,id)), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(new ApiResponse<>().setMsg(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
