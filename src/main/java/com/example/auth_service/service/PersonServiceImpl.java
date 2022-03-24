package com.example.auth_service.service;

import com.example.auth_service.dto.RegisterRequest;
import com.example.auth_service.model.Person;
import com.example.auth_service.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;;
    private final ModelMapper modelMapper;

    @Override
    public void register(RegisterRequest registerRequest){
        Person person = modelMapper.map(registerRequest,Person.class);
        person.setAdmin(false);
        person.setPassword(person.getPassword());
        personRepository.save(person);
    }

    @Override
    public Person getPerson(String identificationNumber) {
        return  personRepository.findByIdentificationNumber(identificationNumber).orElseThrow(RuntimeException::new);
    }
}
