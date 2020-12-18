package com.example.demo.MOdelsDb;

import com.example.demo.Models.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "hola")
@Data @AllArgsConstructor @NoArgsConstructor
public class PersonDB {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "edad")
    private int age;
    @Column(name = "estatura")
    private float height;

    public PersonDB(Person person) {
        this.id = person.getId();
        this.name= person.getName();
        this.age=person.getAge();
        this.height=person.getHeight();
    }
}
