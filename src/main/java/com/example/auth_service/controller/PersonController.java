package com.example.auth_service.controller;


import com.example.auth_service.dto.RegisterRequest;
import com.example.auth_service.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1.0/person")
@CrossOrigin
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/register")
    public ResponseEntity createUser(@Valid @RequestBody RegisterRequest registerRequest){
        try{
            personService.register(registerRequest) ;
            return ResponseEntity.ok("The user created");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Something went wrong...");
        }
    }


}
