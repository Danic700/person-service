package com.person.service;

import com.person.model.Person;
import com.person.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);


    @Autowired
    private PersonRepository personRepository;

    @Override
    public void savePerson(Person person) {
        logger.info("Going to save person to DB " + person);
        personRepository.save(person);
        logger.info(person +" Was saved in DB");
    }

    @Override
    public  Optional<Person> getPerson(Long id) {
        logger.info("Retrieving person by id " + id);
        Optional<Person> person = personRepository.findById(id);
        logger.info(person +" Was retrieved from DB");
        return person;
    }


}
