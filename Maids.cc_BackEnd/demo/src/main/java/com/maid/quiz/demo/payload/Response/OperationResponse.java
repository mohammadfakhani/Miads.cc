package com.maid.quiz.demo.payload.Response;

import java.util.Date;
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
public class OperationResponse {

	private int id ; 
	private Date creationDate ;	
	private int clientId ; 
	private int sellerId ; 
	private int quantity ; 
	private double price ; 
	private double total ;
	
}
