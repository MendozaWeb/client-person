package com.client_person.service.interfaces;

import com.client_person.dto.request.CreateClientRequestDto;
import com.client_person.dto.response.ClientResponseDto;

public interface ClientService {
    ClientResponseDto createClient(CreateClientRequestDto requestDto);
}
