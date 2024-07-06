package com.client_person.service.impl;

import com.client_person.dto.request.CreatePersonRequestDto;
import com.client_person.dto.response.PersonResponseDto;
import com.client_person.exception.CustomException;
import com.client_person.model.Person;
import com.client_person.repository.PersonRepository;
import com.client_person.service.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonResponseDto createPerson(CreatePersonRequestDto requestDto) {
        try {
            Person person = new Person();
            person.setName(requestDto.getName());
            person.setGender(requestDto.getGender());
            person.setAge(requestDto.getAge());
            person.setAddress(requestDto.getAddress());
            person.setPhone(requestDto.getPhone());
            personRepository.save(person);

            PersonResponseDto responseDto = new PersonResponseDto();
            responseDto.setId(person.getId());
            responseDto.setName(person.getName());
            responseDto.setGender(person.getGender());
            responseDto.setAge(person.getAge());
            responseDto.setAddress(person.getAddress());
            responseDto.setPhone(person.getPhone());
            return responseDto;
        } catch (Exception e) {
            throw new CustomException("Error creating person: " + e.getMessage());
        }
    }


}
