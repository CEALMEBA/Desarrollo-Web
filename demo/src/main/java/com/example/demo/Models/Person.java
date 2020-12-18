package com.example.demo.Models;

import com.example.demo.MOdelsDb.PersonDB;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data @NoArgsConstructor @AllArgsConstructor
public class Person {
    private long id;
    private String name;
    private int age;
    private float height;

    public Person(PersonDB person) {
        this.id =person.getId();
        this.name=person.getName();
        this.age=person.getAge();
        this.height=person.getHeight();
    }
}
