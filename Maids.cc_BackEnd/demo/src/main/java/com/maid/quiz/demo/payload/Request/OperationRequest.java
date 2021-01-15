package com.maid.quiz.demo.payload.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class OperationRequest {
	private int clientId ; 
	private int sellerId ; 
	private int quantity ; 
	private double price ; 
	
}
