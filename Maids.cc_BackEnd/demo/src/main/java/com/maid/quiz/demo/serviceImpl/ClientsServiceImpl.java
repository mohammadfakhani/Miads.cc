package com.maid.quiz.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maid.quiz.demo.exception.ServiceException;
import com.maid.quiz.demo.model.Client.Client;
import com.maid.quiz.demo.payload.Request.ClientRequest;
import com.maid.quiz.demo.payload.Response.ClientResponse;
import com.maid.quiz.demo.repositories.ClientsRepository;
import com.maid.quiz.demo.service.ClientsService;

@Service
public class ClientsServiceImpl implements ClientsService{

	@Autowired
    ClientsRepository clientsRepository ; 
	
	
	@Override
	public List<ClientResponse> getAllClients() {
		List<ClientResponse> response = new ArrayList<ClientResponse>();
		for(Client client  : clientsRepository.findByDeletedNot(false)) {
			response.add(createResponseForClient(client));
		}
		return response;
	}

	
	@Override
	public ClientResponse createClient(ClientRequest request) {
		Client client = new Client().setDeleted(false)
									.setName(request.getName())
									.setLastName(request.getLastName())
									.setMobile(request.getMobile());
		client = this.clientsRepository.save(client);
		return createResponseForClient(client);
	}



	@Override
	public ClientResponse updateClient(ClientRequest request, int id) {
		Optional<Client> optional = this.clientsRepository.findById(id);
		if(!optional.isPresent() || optional.get().isDeleted()) {
			throw new ServiceException("client not found");
		}
		
		Client client = optional.get(); 
		client.setName(request.getName())
			  .setLastName(request.getLastName())
			  .setMobile(request.getMobile());

		client = this.clientsRepository.save(client);
		return createResponseForClient(client);
	}
	
	@Override
	public boolean checkClient(int id ) {
		Optional<Client> client = this.clientsRepository.findById(id);
		if(client.isPresent()) {
			return client.get().isDeleted();
		}
		return false ; 
	}
	
	
	private ClientResponse createResponseForClient(Client client) {
		return new ClientResponse().setId(client.getId())
									.setName(client.getName())
									.setLastName(client.getLastName())
									.setMobile(client.getMobile());
	}

}
