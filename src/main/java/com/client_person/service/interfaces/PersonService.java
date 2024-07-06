package com.client_person.service.interfaces;

import com.client_person.dto.request.CreatePersonRequestDto;
import com.client_person.dto.response.PersonResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {
    PersonResponseDto createPerson(CreatePersonRequestDto requestDto);
}
