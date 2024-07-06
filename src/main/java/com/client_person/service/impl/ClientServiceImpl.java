package com.client_person.service.impl;

import com.client_person.dto.request.CreateClientRequestDto;
import com.client_person.dto.response.ClientResponseDto;
import com.client_person.exception.CustomException;
import com.client_person.model.Client;
import com.client_person.repository.ClientRepository;
import com.client_person.service.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientResponseDto createClient(CreateClientRequestDto requestDto) {
        try {
            Client client = new Client();
            client.setClientId(requestDto.getClientId());
            client.setPassword(requestDto.getPassword());
            client.setStatus(requestDto.isStatus());
            clientRepository.save(client);

            ClientResponseDto responseDto = new ClientResponseDto();
            responseDto.setClientId(client.getClientId());
            responseDto.setStatus(client.isStatus());
            return responseDto;
        } catch (Exception e) {
            throw new CustomException("Error creating client: " + e.getMessage());
        }
    }
}

