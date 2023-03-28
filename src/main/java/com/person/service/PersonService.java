package com.person.service;

import com.person.model.Person;

import java.util.Optional;

public interface PersonService {
    void savePerson(Person person);
    Optional<Person> getPerson(Long id);
}
