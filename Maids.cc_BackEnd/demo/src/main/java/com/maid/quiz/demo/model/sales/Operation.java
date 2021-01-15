package com.maid.quiz.demo.model.sales;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ; 
	private Date creationDate ;	
	private int clientId ; 
	private int sellerId ; 
	private int quantity ; 
	private double price ; 
	private double total ;
	private boolean deleted ; 
	
}
