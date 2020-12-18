package com.example.APICRUD30.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "employees")
public class EmployeeDbModel {

    @Id
    private long id;
    private String name;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;

}
