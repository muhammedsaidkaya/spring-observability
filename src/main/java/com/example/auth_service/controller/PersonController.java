package com.example.auth_service.controller;


import com.example.auth_service.dto.RegisterRequest;
import com.example.auth_service.model.Person;
import com.example.auth_service.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1.0/person")
@CrossOrigin
@RequiredArgsConstructor
@Api(value = "Person Api documentation")
public class PersonController {

    private final PersonService personService;
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @CachePut(value = "people")
    @PostMapping("/register")
    @ApiOperation(value = "New Person adding method")
    public Person createUser(@Valid @RequestBody RegisterRequest registerRequest){
        try{
            Person person = personService.register(registerRequest);
            System.out.println(person.getId());
            return person;
        }catch (Exception e){
            return null;
        }
    }

    @Cacheable(value = "people", key = "#id")
    @GetMapping("/{id}")
    @ApiOperation(value = "Get person method")
    public Person getPerson(@PathVariable("id") Long id){
        LOG.info("Getting user with ID {}.", id);
        return personService.getPerson(id);
    }

    @CacheEvict(value = "people", allEntries=true)
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete person method")
    public void deletePersonById(@PathVariable("id") Long id) {
        LOG.info("deleting person with id {}", id);
        personService.delete(id);
    }

}
