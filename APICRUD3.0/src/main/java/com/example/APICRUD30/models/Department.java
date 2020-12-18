package com.example.APICRUD30.models;


import com.example.APICRUD30.repository.DepartmentDbModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Department {

    private long id;
    private String name;
    private String description;

    public Department(DepartmentDbModel dep){
        this.id = dep.getId();
        this.name = dep.getName();
        this.description = dep.getDescription();
    }

}
