package com.person.controller;

import com.person.model.Person;
import com.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @PostMapping()
    public ResponseEntity<String> savePerson(@RequestBody Person person) {
        personService.savePerson(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Optional<Person>> getPerson(Long id){
        Optional<Person> person = personService.getPerson(id);
        if(person.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(person);

    }
}
