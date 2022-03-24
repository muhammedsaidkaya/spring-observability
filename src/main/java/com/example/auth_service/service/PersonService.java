package com.example.auth_service.service;


import com.example.auth_service.dto.RegisterRequest;
import com.example.auth_service.model.Person;

public interface PersonService {

    void register(RegisterRequest registerRequest);
    Person getPerson(String identificationNumber);
}
