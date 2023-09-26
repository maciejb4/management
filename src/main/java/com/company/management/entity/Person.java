package com.company.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Person {
    @Id
    @GeneratedValue
    private int personId;
    private PersonType type;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private String pesel;

}
