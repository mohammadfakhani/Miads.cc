package com.maid.quiz.demo.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maid.quiz.demo.exception.ServiceException;
import com.maid.quiz.demo.model.sales.Operation;
import com.maid.quiz.demo.payload.Request.OperationRequest;
import com.maid.quiz.demo.payload.Request.OperationUpdateRequest;
import com.maid.quiz.demo.payload.Response.OperationResponse;
import com.maid.quiz.demo.repositories.OperationsRepository;
import com.maid.quiz.demo.service.ClientsService;
import com.maid.quiz.demo.service.OperationsService;

@Service
public class OperationsServiceimpl implements OperationsService{
	
	@Autowired
	OperationsRepository operationsRepository ;

	@Autowired
    ClientsService clientssService ; 
	
	 private static final Logger logger = LoggerFactory.getLogger(OperationsServiceimpl.class);
	
	@Override
	public List<OperationResponse> getAllOperations() {
		List<OperationResponse> response = new ArrayList<OperationResponse>();
		for(Operation operation  : operationsRepository.findByDeletedNot(false)) {
			response.add(createResponseForOperation(operation));
		}
		return response;
	}

	@Override
	@Transactional
	public List<OperationResponse> createOperation(List<OperationRequest> requestsList) {
		List<OperationResponse> resposne = new ArrayList<OperationResponse>();
		for(OperationRequest request : requestsList ) {
			if(!this.clientssService.checkClient(request.getClientId())) {
				throw new ServiceException("client not found ");
			}
			if(!this.clientssService.checkClient(request.getSellerId())) {
				throw new ServiceException("seller not found ");
			}
			Operation operation = new Operation().setCreationDate(new Date(System.currentTimeMillis()))
												 .setClientId(request.getClientId())
												 .setSellerId(request.getSellerId())
												 .setDeleted(false)
												 .setPrice(request.getPrice())
												 .setQuantity(request.getQuantity())
												 .setTotal(request.getPrice() * request.getQuantity()); 
			
			operation = this.operationsRepository.save(operation);
			resposne.add(createResponseForOperation(operation));
		}
		return resposne ; 
	}

	@Override
	@Transactional
	public OperationResponse updateOperation(OperationUpdateRequest request, int id) {
		Optional<Operation> optional = this.operationsRepository.findById(id);
		if(!optional.isPresent() || optional.get().isDeleted()) {
			throw new ServiceException("operation not found");
		}
		Operation operation = optional.get(); 
		logger.info("update operation id : "+operation.getId()+
				" | prev price : "+operation.getPrice() +" | prev quentity :"+operation.getQuantity()
				+" | new price : "+request.getPrice()+" | new quentity : "+request.getQuantity());
		operation.setPrice(request.getPrice())
		          .setQuantity(request.getQuantity())
		          .setTotal(request.getPrice() * request.getQuantity());
		return createResponseForOperation(operation);
	} 
	
	
	private OperationResponse createResponseForOperation(Operation operation) {
		return new OperationResponse().setId(operation.getId())
									  .setClientId(operation.getClientId())
									  .setPrice(operation.getPrice())
									  .setQuantity(operation.getQuantity())
									  .setSellerId(operation.getSellerId())
									  .setTotal(operation.getTotal());
	}
	
	
}
