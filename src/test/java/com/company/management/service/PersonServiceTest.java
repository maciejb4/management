package com.company.management.service;

import com.company.management.entity.Person;
import com.company.management.entity.PersonType;
import com.company.management.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PersonServiceTest {

    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonService personService;

    private List<Person> personList;
    private Person person1;
    private Person person2;
    private Person person3;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        person1 = new Person(1, PersonType.INTERNAL, "John", "Doe", "1234567890", "john.doe@example.com", "12345678901");
        person2 = new Person(2, PersonType.INTERNAL, "Alice", "Smith", "9876543210", "alice.smith@example.com", "98765432102");
        person3 = new Person(3, PersonType.EXTERNAL, "Bob", "Johnson", "5555555555", "bob.johnson@example.com", "55555555503");

        personList= new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        when(repository.save(person1)).thenReturn(person1);
        when(repository.save(person2)).thenReturn(person2);
        when(repository.save(person3)).thenReturn(person3);
    }

    @Test
    public void testCreatePerson() {

        Person person = new Person();
        person.setType(PersonType.EXTERNAL);
        person.setFirstName("Chuck");
        person.setLastName("Norris");
        person.setMobile("5315331223");
        person.setEmail("chuck.norris@gmail.com");
        person.setPesel("74237485912");
        when(repository.save(person)).thenReturn(person);

        Person savedPerson = personService.create(person);

        assertEquals(person, savedPerson);
    }

    @Test
    public void testModifyPerson() {

        int personId = 1;
        Person existingPerson = person1;
        Person personToUpdate = new Person(1, PersonType.INTERNAL, "John", "Jelen", "1234567890", "john.doe@example.com", "12345678901");
        when(repository.findById(personId)).thenReturn(Optional.of(existingPerson));

        personService.modify(personToUpdate);

        verify(repository, times(1)).save(existingPerson);
    }

    @Test
    public void testGetAllPersons() {

        List<Person> expectedPersons = personList;
        when(repository.findAll()).thenReturn(expectedPersons);

        List<Person> actualPersons = personService.getAllPersons();

        assertEquals(expectedPersons, actualPersons);
    }

    @Test
    public void testRemovePerson() {

        int personId = 1;
        Person existingPerson = person1;
        when(repository.findById(personId)).thenReturn(Optional.of(existingPerson));

        personService.remove(personId);

        verify(repository, times(1)).delete(existingPerson);
    }
}
