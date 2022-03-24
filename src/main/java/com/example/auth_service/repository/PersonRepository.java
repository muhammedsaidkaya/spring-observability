package com.example.auth_service.repository;

import com.example.auth_service.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByIdentificationNumber(String s);
}
