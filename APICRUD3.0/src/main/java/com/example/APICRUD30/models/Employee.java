package com.example.APICRUD30.models;



import com.example.APICRUD30.repository.EmployeeDbModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Employee {

    private long id;
    private String name;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;


    public Employee(EmployeeDbModel emp) {
        this.id = emp.getId();
        this.name = emp.getName();
        this.lastName = emp.getLastName();
        this.username = emp.getUsername();
        this.email = emp.getEmail();
        this.phoneNumber = emp.getPhoneNumber();
    }

}
