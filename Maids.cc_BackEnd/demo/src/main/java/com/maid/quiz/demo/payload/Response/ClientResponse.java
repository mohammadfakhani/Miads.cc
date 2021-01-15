package com.maid.quiz.demo.payload.Response;

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
public class ClientResponse {
	private int id ; 
	private String name ; 
	private String lastName ; 
	private String mobile ;  
	
}
