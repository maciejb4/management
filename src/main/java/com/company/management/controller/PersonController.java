package com.company.management.controller;

import com.company.management.entity.Person;
import com.company.management.entity.PersonType;
import com.company.management.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person) {
        return service.create(person);
    }

    @GetMapping("/findAll")
    public List<Person> findAllPersons() {
        return service.getAllPersons();
    }

    @GetMapping("/person/{personId}")
    public Person findPersonById(@PathVariable int personId) {
        return service.getPersonById(personId);
    }

    @GetMapping("/personByLastName/{lastName}")
    public Person findPersonByLastName(@PathVariable String lastName) {
        return service.getPersonByLastName(lastName);
    }

    @GetMapping("/persons")
    public List<Person> findPersonsByTypeOrFirstNameOrLastNameOrMobile(@RequestParam(required = false) PersonType type,
                                                                       @RequestParam(required = false) String firstName,
                                                                       @RequestParam(required = false) String lastName,
                                                                       @RequestParam(required = false) String mobile) {
        return service.getPersonByTypeOrFirstNameOrLastNameOrMobile(type, firstName, lastName, mobile);
    }

    @PutMapping("/modify")
    public void modifyPerson(@RequestBody Person person) {
        service.modify(person);
    }

    @DeleteMapping("/remove/{personId}")
    public void removePerson(@PathVariable int personId) {
        service.remove(personId);
    }

}
