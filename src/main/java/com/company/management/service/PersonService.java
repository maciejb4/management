package com.company.management.service;

import com.company.management.entity.Person;
import com.company.management.entity.PersonType;
import com.company.management.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person create(Person person) {
        return repository.save(person);
    }

    public void modify(Person person) {
        repository
                .findById(person.getPersonId())
                .ifPresent(personDb -> {
                    personDb.setFirstName(person.getFirstName());
                    personDb.setLastName(person.getLastName());
                    personDb.setEmail(person.getEmail());
                    personDb.setMobile(person.getMobile());
                    personDb.setPesel(person.getPesel());

                    repository.save(personDb);
                });
    }

    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    public Person getPersonById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Person getPersonByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    public List<Person> getPersonByTypeOrFirstNameOrLastNameOrMobile(PersonType type,
                                                                     String firstName,
                                                                     String lastName,
                                                                     String mobile) {
        return repository.findByTypeOrFirstNameOrLastNameOrMobile(type,firstName,lastName,mobile);
    }

    public void remove(int personId) {
        repository
                .findById(personId)
                .ifPresent(personDb -> {
                    repository.delete(personDb);
                });
    }
}
