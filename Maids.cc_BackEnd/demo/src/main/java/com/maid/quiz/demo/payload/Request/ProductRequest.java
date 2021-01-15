package com.maid.quiz.demo.payload.Request;


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
public class ProductRequest {

	private String name ; 
	
	private String description ; 
	
	private String category ; 
	
	private Date creationDate ;


}
