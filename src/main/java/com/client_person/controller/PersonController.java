package com.client_person.controller;

import com.client_person.dto.request.CreatePersonRequestDto;
import com.client_person.dto.response.PersonResponseDto;
import com.client_person.exception.CustomException;
import com.client_person.service.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/create")
    public ResponseEntity<PersonResponseDto> createPerson(@RequestBody CreatePersonRequestDto requestDto) {
        try {
            PersonResponseDto responseDto = personService.createPerson(requestDto);
            return ResponseEntity.status(201).body(responseDto);
        } catch (IllegalArgumentException e) {
            throw new CustomException("Bad request: " + e.getMessage());
        } catch (Exception e) {
            throw new CustomException("Internal server error: " + e.getMessage());
        }
    }

}
