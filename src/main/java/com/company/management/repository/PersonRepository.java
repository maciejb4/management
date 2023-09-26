package com.company.management.repository;

import com.company.management.entity.Person;
import com.company.management.entity.PersonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByLastName(String lastName);
    List<Person> findByTypeOrFirstNameOrLastNameOrMobile(PersonType type, String firstName, String lastName, String mobile);
}
