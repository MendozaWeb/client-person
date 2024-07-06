package com.client_person.controller;

import com.client_person.dto.request.CreateClientRequestDto;
import com.client_person.dto.response.ClientResponseDto;
import com.client_person.exception.CustomException;
import com.client_person.service.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<ClientResponseDto> createClient(@RequestBody CreateClientRequestDto requestDto) {
        try {
            ClientResponseDto responseDto = clientService.createClient(requestDto);
            return ResponseEntity.status(201).body(responseDto);
        } catch (IllegalArgumentException e) {
            throw new CustomException("Bad request: " + e.getMessage());
        } catch (Exception e) {
            throw new CustomException("Internal server error: " + e.getMessage());
        }
    }

}
